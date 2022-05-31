package com.api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteEmloyeeTest {

    @Test
    public void deleteEmployee(){
        Response response = given()
                .pathParams("id", 863)
                .log()
                .all()
                .delete("http://localhost:3000/employees/{id}");
        System.out.println(response.getStatusCode());


    }
}
