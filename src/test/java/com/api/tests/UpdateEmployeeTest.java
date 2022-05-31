package com.api.tests;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateEmployeeTest {
    @Test
    public void updateEmployee(){
        JSONObject object = new JSONObject();
        object.put("id",200);
        object.put("fname",new Faker().name().firstName());
        given().header("Content-Type", ContentType.JSON)
                .body(object.toMap())
                .log()
                .all()
                .put("http://localhost:3000/employees/182")
                .prettyPrint();
    }

    @Test
    public void updateEmployeeUsingPathParam(){
        JSONObject object = new JSONObject();
        object.put("fname",new Faker().name().firstName());
        object.put("lname",new Faker().name().lastName());

        given().header("Content-Type",ContentType.JSON)
                .pathParams("id",182)
                .body(object.toMap())
                .log()
                .all()
                .put("http://localhost:3000/employees/{id}")
                .prettyPrint();
    }

    @Test
    public void getEmployeeUsingQueryParam(){

        given()
                .queryParam("lunch","rice")
                .log()
                .all()
                .get("http://localhost:3000/employees")
                .prettyPrint();
    }

}
