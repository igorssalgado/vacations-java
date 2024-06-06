package com.vacationsapp.vacations.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacationsapp.vacations.models.VacationModel;

public interface VacationRepository extends JpaRepository<VacationModel, String>{
    
}
