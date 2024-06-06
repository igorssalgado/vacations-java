package com.vacationsapp.vacations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vacationsapp.vacations.models.VacationDTO;
import com.vacationsapp.vacations.models.VacationModel;
import com.vacationsapp.vacations.services.VacationRepository;

@Controller
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    VacationRepository repo;

    @GetMapping
    private String allVacations(Model model) {
        List<VacationModel> vacations = repo.findAll();
        model.addAttribute("vacations", vacations);
        return "vacations/index";
    }

    @GetMapping("/add")
    private String addVacation(Model model){
        VacationDTO vacationDTO = new VacationDTO();
        model.addAttribute("vacationDTO", vacationDTO);
        return "vacations/AddVacations";
    }
    
}
