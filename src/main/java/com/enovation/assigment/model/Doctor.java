package com.enovation.assigment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
public class Doctor extends Staff {

    @NotBlank(message = "speciality is mandatory")
    public String speciality;

    @Positive
    public int numberOfSurgeries;
}
