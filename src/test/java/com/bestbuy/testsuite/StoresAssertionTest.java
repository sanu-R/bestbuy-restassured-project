package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;

public class StoresAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }
    @Test
    public void test001() {
        //1. Verify the if the total is equal to 1561
        response.body("total", equalTo(1561));
    }
    @Test
    public void test002() {
        //2. Verify the if the stores of limit is equal to 10
        response.body("limit", equalTo(10));
    }
    @Test
    public void test003() {
        //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
        response.body("data.name", hasItem("Inver Grove Heights"));
    }
    @Test
    public void test004() {
        //4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
        response.body("data.name", hasItems("Roseville, Burnsville, Maplewood"));
    }
    @Test
    public void test005() {
        //5. Verify the storied=7 inside storeservices of the third store of second services
        response.body("data[2].services[2]", hasKey("storeservices"));
    }
    @Test
    public void test006() {
        //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
        response.body("data.findAll{it.name == 'Roseville'}", hasKey("createdAt"));
    }
    @Test
    public void test007() {
        //7. Verify the state = MN of forth store
        response.body("data[3]", hasKey("state"));

    }
    @Test
    public void test008() {
        //8. Verify the store name = Rochester of 9th store
        response.body("data[8]", hasKey("name" ));
    }
    @Test
    public void test009() {
        //9. Verify the storeId = 11 for the 6th store
        response.body("data[5].services[0].storeservices", hasKey("storeId"));
    }
    @Test
    public void test010() {
        //10. Verify the serviceId = 4 for the 7th store of forth service
        response.body("data[6].services[3].storeservices", hasKey("serviceId"));
    }
}
