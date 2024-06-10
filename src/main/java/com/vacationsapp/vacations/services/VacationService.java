package com.vacationsapp.vacations.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        // format start date
        String startDate[] = vacationModel.getStartDate().split("-");        
        Calendar c_startDate = Calendar.getInstance();
        c_startDate.set(Calendar.YEAR, Integer.parseInt(startDate[0]));
        c_startDate.set(Calendar.MONTH, Integer.parseInt(startDate[1]) - 1);
        c_startDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(startDate[2]));
        SimpleDateFormat sdf_startDate = new SimpleDateFormat("MMM d, yyyy");
        
        // calculate and format end date
        String endDate[] = vacationModel.getStartDate().split("-");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(endDate[0]));
        c.set(Calendar.MONTH, Integer.parseInt(endDate[1]) - 1);
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(endDate[2]));
        c.add(Calendar.DATE, vacationModel.getVacationDays() - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");

        vacationModel.setEndDate(sdf.format(c.getTime()));
        vacationModel.setStartDate(sdf_startDate.format(c_startDate.getTime()));


        return vacationRepository.save(vacationModel);
    }

    public VacationModel update(String id, VacationModel vacationModel) {
        VacationModel updatedModel = new VacationModel();
        updatedModel = vacationModel;
        updatedModel.setId(id);
        return vacationRepository.save(updatedModel);
    }

    public VacationModel findById(String id) {
        return vacationRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        vacationRepository.deleteById(id);
    }

}
