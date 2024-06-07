package com.vacationsapp.vacations.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VacationDTO {

    // @NotEmpty(message = "Start date is required")
    private String startDate;

    private String endDate;

    // @NotEmpty(message = "Vacation days # area required")
    private Integer vacationDays;

    private boolean bonus;
}
