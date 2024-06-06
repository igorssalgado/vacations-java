package com.vacationsapp.vacations.models;


import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vacations")
public class VacationModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Date startDate;
    private Date endDate;
    private Integer vacationDays;
    private boolean bonus;
}
