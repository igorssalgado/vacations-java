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
        // calculate end date
        String endDate[] = vacationModel.getStartDate().split("/");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(endDate[0]));
        c.set(Calendar.MONTH, Integer.parseInt(endDate[1]) - 1);
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(endDate[2]));
        c.add(Calendar.DATE, vacationModel.getVacationDays() - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");

        vacationModel.setEndDate(sdf.format(c.getTime()));

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
