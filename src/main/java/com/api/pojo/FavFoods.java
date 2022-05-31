package com.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class FavFoods {
    private String breakfast;
    private String lunch;
    private List<String> dinner;

    public FavFoods(){}

}
