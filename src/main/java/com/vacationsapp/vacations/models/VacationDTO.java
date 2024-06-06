package com.vacationsapp.vacations.models;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VacationDTO {

    // @NotEmpty(message = "Start date is required")
    private Date startDate;

    private Date endDate;

    // @NotEmpty(message = "Vacation days # area required")
    private Integer vacationDays;

    private boolean bonus;
}
