package com.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(value = {"id","favFoods"})
public class Employee {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private List<String> jobs;
    private FavFoods favfood;

    public Employee(){}

}
