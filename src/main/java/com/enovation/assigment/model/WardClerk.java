package com.enovation.assigment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class WardClerk extends Staff {

    @NotBlank(message = "location is mandatory")
    private String location;
}
