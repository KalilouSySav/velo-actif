package com.example.tpfinsessiongestionvelo.service;

import com.example.tpfinsessiongestionvelo.entities.VeloDetail;
import com.example.tpfinsessiongestionvelo.repository.VeloDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class VeloDetailServiceImpl implements VeloDetailService{
    private VeloDetailRepository veloDetailRepository;
    @Autowired
    public VeloDetailServiceImpl(VeloDetailRepository veloDetailRepository) {
        this.veloDetailRepository = veloDetailRepository;
    }

    @Override
    public boolean updateVeloDetail(int id, VeloDetail veloDetail) {
        if (veloDetailRepository.existsById(id) && veloDetail != null) {
            Field[] fields = veloDetail.getClass().getDeclaredFields();
            veloDetail.setId(id);
            VeloDetail veloDetail1 = veloDetailRepository.findById(id).get();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.get(veloDetail) != null) {
                        field.set(veloDetail1, field.get(veloDetail));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            veloDetailRepository.save(veloDetail1);
            return true;
        }
        return false;
    }

    @Override
    public List<VeloDetail> findVeloDetailByPrixLocationBetween(double prixLocation1, double prixLocation2) {
        List<VeloDetail> veloDetails = null;
        if (prixLocation1 > 0 && prixLocation2 > 0 && prixLocation1 < prixLocation2) {
            veloDetails = veloDetailRepository.findVeloDetailByPrixLocationBetween(prixLocation1, prixLocation2);
        }
        return veloDetails;
    }
}
