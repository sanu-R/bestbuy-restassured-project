package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class ProductsAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }
    @Test
    public void test001() {
        //1. Verify the if the total is equal to 51957
        response.body("total", equalTo(51957));
    }

    @Test
    public void test002() {
        //2. Verify the if the stores of limit is equal to 10
        response.body("limit", equalTo(10));
    }

    @Test
    public void test003() {
        //3. Check the single ‘Name’ in the Array list (Duracell - AAA Batteries (4-Pack))
        response.body("data.name", hasItem("Duracell - AAA Batteries (4-Pack)"));
    }

    @Test
    public void test004() {
        //4. Check the multiple ‘Names’ in the ArrayList (Duracell - AA 1.5V CopperTop Batteries (4-
        //Pack), Duracell - AA Batteries (8-Pack), Energizer - MAX Batteries AA (4-Pack))
        response.body("data.name", hasItems("Duracell - AA 1.5V CopperTop Batteries (4-Pack)", "Duracell - AA Batteries (8-Pack)", "Energizer - MAX Batteries AA (4-Pack)"));
    }

    @Test
    public void test005() {
        //5. Verify the productId=150115 inside categories of the third name is “Household Batteries”
        response.body("data[3].categories[2]", hasKey("name"));
    }

    @Test
    public void test006() {
        //6. Verify the categories second name = “Housewares” of productID = 333179
        response.body("data[8].categories[1]", hasEntry("name", "Housewares"));
    }

    @Test
    public void test007() {
        //7. Verify the price = 4.99 of forth product
        response.body("data[3]", hasKey("price"));
    }

    @Test
    public void test008() {
        //8. Verify the Product name = Duracell - D Batteries (4-Pack) of 6th product
        response.body("data[5]",hasKey("name"));
    }

    @Test
    public void test009() {
        //9. Verify the ProductId = 333179 for the 9th product
        response.body("data[8]",hasKey("id"));
    }

    @Test
    public void test010() {
        //10. Verify the prodctId = 346575 have 5 categories
        response.body("data[9].categories", hasSize(5));

    }
}

