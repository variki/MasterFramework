package com.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class AddEmployees {

    @Test
    public void getEmployee(){
        Response response = given().get("http://localhost:3000/employees");
        response.prettyPrint();
    }

    @Test
    public void addEmployee(){
        Response response = given().header("Content-Type", ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 5,\n" +
                        "    \"first_name\": \"Pramila\",\n" +
                        "    \"last_name\": \"Renganathan\",\n" +
                        "    \"email\": \"pramila@gmail.com\"\n" +
                          "  }")
                .log()
                .all()
                .post("http://localhost:3000/employees");
        response.prettyPrint();
    }

    @Test
    public void addEmloyeefromFile(){
        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .body(new File(System.getProperty("user.dir") + "/test.json"))
                .log()
                .all()
                .post("http://localhost:3000/employees");
        response.prettyPrint();
    }
}
