package com.enovation.assigment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Nurse extends Staff {
    private String license;

}
