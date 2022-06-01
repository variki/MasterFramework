package com.api.tests.Builder;

import org.testng.annotations.Test;

public class BuilderCheck {

    @Test
    public void buliderCheck(){

        Student student = StudentBuilder.builder()
                .setId(234)
                .setFname("Muthu")
                .setLname("kumar")
                .build();
        System.out.println(student);

        Student student1 = Student.StudentBuild.builder()
                .setId(39)
                .setFname("Yuvan")
                .setLname("Raja")
                .setEmail("u1@gmail.com")
                .build();
        System.out.println(student1);

        
    }
}
