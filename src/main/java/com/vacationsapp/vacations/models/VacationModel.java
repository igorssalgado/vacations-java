package com.vacationsapp.vacations.models;

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

    private String startDate;
    private String endDate;
    private Integer vacationDays;
    private boolean bonus;
}
