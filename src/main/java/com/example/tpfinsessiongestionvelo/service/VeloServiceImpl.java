package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.Accessoire;
import com.example.tpfinsessiongestionvelo.entities.Velo;
import com.example.tpfinsessiongestionvelo.repository.VeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
@Service
public class VeloServiceImpl implements VeloService{
    private VeloRepository veloRepository;
    @Autowired
    public VeloServiceImpl(VeloRepository veloRepository) {
        this.veloRepository = veloRepository;
    }


    @Override
    public boolean updateVelo(int id, Velo velo) {
       if (id > 0 && veloRepository.existsById(id)) {
                Velo velo1 = veloRepository.findById(id).get();
                Field[] fields = velo.getClass().getDeclaredFields();
                velo.setId(id);
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        if (field.get(velo) != null && velo.getAnnee()!=0) {
                            field.set(velo1, field.get(velo));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                veloRepository.save(velo1);
                return true;
            }
            return false;
        }

    @Override
    public boolean deleteVelo(int id) {
        if (id > 0 && veloRepository.existsById(id)) {
            Velo velo = veloRepository.findById(id).get();
            velo.setSupprimer(true);
            velo.getVeloDetail().setSupprimer(true);
            veloRepository.save(velo);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveVelo(Velo velo) {
        if (velo != null && velo.getVeloDetail() != null) {
            veloRepository.save(velo);
            return true;
        }
        return false;
    }

    @Override
    public List<Velo> findAllOrderByNameAsc() {
        return veloRepository.findAllByOrderByNomAsc();
    }

    @Override
    public List<Velo> findByIdGreaterThanOrderByTailleAsc(int id) {
        List<Velo> velos = null;
        if (id > 0 && veloRepository.existsById(id)) {
            velos = veloRepository.findByIdGreaterThanOrderByTailleAsc(id);
        }
        return velos;
    }

    @Override
    public List<Velo> findByNameStartingWith(String pattern) {
        return veloRepository.findByNomStartingWith(pattern);
    }
}
