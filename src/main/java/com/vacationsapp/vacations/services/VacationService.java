package com.vacationsapp.vacations.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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

}
