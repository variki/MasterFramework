package com.api.tests.Builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Builder(setterPrefix = "set",builderMethodName = "create")
public class StudentWithLombak {

    private int  id;
    private String fname;
    private String lname;
    private String email;

}
