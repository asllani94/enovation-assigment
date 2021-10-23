package com.enovation.assigment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @Email
    @NotNull
    private String email;

    @PastOrPresent
    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date joined;
}
