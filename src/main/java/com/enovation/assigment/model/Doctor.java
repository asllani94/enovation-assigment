package com.enovation.assigment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Doctor extends Staff {

    @NotBlank(message = "Role is mandatory")
    public String role;
}
