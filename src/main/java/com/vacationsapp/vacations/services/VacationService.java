package com.vacationsapp.vacations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacationsapp.vacations.models.VacationModel;

@Service
public class VacationService {

    @Autowired
    VacationRepository vacationRepository;

    public List<VacationModel> showAllVacations() {
        return vacationRepository.findAll();
    }

    public VacationModel save(VacationModel vacationModel) {
        return vacationRepository.save(vacationModel);
    }

    public VacationModel update(String id, VacationModel vacationModel) {
        VacationModel updatedModel = new VacationModel();
        updatedModel = vacationModel;
        updatedModel.setId(id);
        return vacationRepository.save(updatedModel);
    }

    public VacationModel findById(String id){
        return vacationRepository.findById(id).orElse(null);
    }

    public void delete(String id){
        vacationRepository.deleteById(id);
    }

}
