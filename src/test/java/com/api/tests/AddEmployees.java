package com.api.tests;

import com.api.pojo.Employee;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @Test
    public void addEmployeefromFiletoString() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/test.json"));
        String reqBody = new String(bytes);
        String replaceString = reqBody.replace("4",String.valueOf(new Faker().number().numberBetween(100,1000)));
        Response response = given().header("Content-Type", ContentType.JSON)
                .body(replaceString)
                .log()
                .all()
                .post("http://localhost:3000/employees");

        response.prettyPrint();

    }

    @Test
    public void addemployeeUsingMap(){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("id", new Faker().number().numberBetween(100,1000));
        body.put("fname",new Faker().name().firstName());
        body.put("lname",new Faker().name().lastName());
        body.put("email",body.get("fname")+"@gmail.com");
        body.put("jobs", Arrays.asList("Tester","Trainer"));

        Map<String,Object> foodObj = new LinkedHashMap<>();
        foodObj.put("breakfast","idly");
        foodObj.put("lunch","rice");
        foodObj.put("dinner",Arrays.asList("chapathi","milk"));

        body.put("favfoods",foodObj);

        Response response = given().header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .body(body)
                .post("http://localhost:3000/employees");
        response.prettyPrint();
    }

    @Test
    public void addEmployeesUsingExternalJar(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", new Faker().number().numberBetween(100,1000));
        jsonObject.put("fname",new Faker().name().firstName());
        jsonObject.put("lname",new Faker().name().lastName());
        jsonObject.put("email",jsonObject.get("fname")+"@gmail.com");
        jsonObject.accumulate("email",jsonObject.get("lname")+"@gmail.com");
        jsonObject.append("email",jsonObject.get("fname") +""+ jsonObject.get("lname")+"@gmail.com");
        jsonObject.putOpt("email",null);
        jsonObject.putOnce("email","dummy");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Tester");
        jsonArray.put("Trainer");

        jsonObject.put("jobs",jsonArray);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("breakfast","idly");
        jsonObject1.put("lunch","rice");

        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.put("chapathi");
        jsonArray1.put("milk");

        jsonObject1.put("dinner",jsonArray1);
        jsonObject.put("favfood",jsonObject1);

        Response response = given().header("Content-Type", ContentType.JSON)
                .body(jsonObject.toMap())
                .log()
                .all()
                .post("http://localhost:3000/employees");
        response.prettyPrint();


    }

    @Test
    public void addEmployeeUsingPOJO(){

        Employee employee = new Employee(134,"Thala","Pathy","thala@gmail.com");
        given().header("Content-Type",ContentType.JSON)
                .body(employee)
                .log()
                .all()
                .post("http://localhost:3000/employees");
    }
}
