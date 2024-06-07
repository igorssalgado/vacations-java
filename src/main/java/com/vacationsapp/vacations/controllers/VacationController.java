package com.vacationsapp.vacations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vacationsapp.vacations.models.VacationDTO;
import com.vacationsapp.vacations.models.VacationModel;
import com.vacationsapp.vacations.services.VacationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    VacationService repo;

    @GetMapping
    private String allVacations(Model model) {
        List<VacationModel> vacations = repo.showAllVacations();
        model.addAttribute("vacations", vacations);
        return "vacations/index";
    }

    @GetMapping("/add")
    private String showAddVacation(Model model) {
        VacationDTO vacationDTO = new VacationDTO();
        model.addAttribute("vacationDTO", vacationDTO);
        return "vacations/AddVacations";
    }

    @PostMapping("/add")
    public String createVacation(@Valid @ModelAttribute VacationDTO vacationDTO, BindingResult result) {

        if (result.hasErrors()) {
            return "vacations/AddVacations";
        }

        VacationModel vacation = new VacationModel();
        vacation.setStartDate(vacationDTO.getStartDate());
        vacation.setEndDate(vacationDTO.getEndDate());
        vacation.setVacationDays(vacationDTO.getVacationDays());
        vacation.setBonus(vacationDTO.isBonus());

        repo.save(vacation);

        return "redirect:/vacations";
    }

    @GetMapping("/edit")
    public String editVacation(VacationDTO vacationDTO, @RequestParam String id) {
        return "vacations/EditVacation";
    }

    @GetMapping("/delete")
    public String deleteVacation(@RequestParam String id){
        repo.delete(id);
        return "redirect:/vacations";
    }
}
