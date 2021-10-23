package com.enovation.assigment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Nurse extends Staff {

    @NotBlank(message = "licenseCode is mandatory")
    private String licenseCode;

}
