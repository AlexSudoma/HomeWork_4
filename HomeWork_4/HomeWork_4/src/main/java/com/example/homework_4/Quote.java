package com.example.homework_4;

import lombok.Data;

import javax.validation.constraints.Size;
@Data
public class Quote {

    @Size(max = 40, message = "Text cannot be longer than 40 characters")
    private String quote;
    private int id;


}
