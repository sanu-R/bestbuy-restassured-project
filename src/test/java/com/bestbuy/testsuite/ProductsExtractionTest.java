package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
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
        //21. Extract the limit
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        //22. Extract the total
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003() {
        //23. Extract the name of 5th product
        String productName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th product is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test004() {
        //24. Extract the names of all the products
        List<String> listOfName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the products are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test005() {
        //25. Extract the productId of all the products
        List<Integer> productId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products are : " + productId);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test006() {
        //26. Print the size of the data list
        int size = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + size);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test007() {
        //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
        //Pack)
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the product where product name = Energizer - MAX Batteries AA (4- Pack) is : " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test008() {
        //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the product where product name = Energizer - MAX Batteries AA (4- Pack) is : " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test009() {
        //29. Get all the categories of 8th products
        List<HashMap<String, ?>> categoies = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of 8th products are : " + categoies);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test010() {
        //30. Get categories of the store where product id = 150115
        List<HashMap<String, ?>> categories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of the store where product id = 150115 are : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test011() {
        //31. Get all the descriptions of all the products
        List<String> descriptions = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all the products are : " + descriptions);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test012() {
        //32. Get id of all the all categories of all the products
        List<String> allId = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all the all categories of all the products are : " + allId);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test013() {
        //33. Find the product names Where type = HardGood
        List<HashMap<String, ?>> type = response.extract().path("data.findAll{it.type =='HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product names Where type = HardGood are : " + type);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test014() {
        //34. Find the total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
        List<Integer> type = response.extract().path("data.findAll{it.name =='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack) are : " + type);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test015() {
        //35. Find the createdAt for all products whose price < 5.49
        List<String> created= response.extract().path("data.findAll{it.price < 5.49 }.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  createdAt for all products whose price < 5.49 : " + created);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test016() {
        //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)
        List<String> allCategories= response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)' }.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack) : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test017() {
    //37. Find the manufacturer of all the products
        List<String> manufacturer= response.extract().path("data.findAll{it.name }.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  manufacturer of all the products is: " + manufacturer);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test018() {
        //38. Find the image of products whose manufacturer is = Energizer
        List<HashMap<String, ?>> theImage = response.extract().path("data.findAll{it.manufacturer =='Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products whose manufacturer is = Energizer : " + theImage);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test019() {
        //39. Find the createdAt for all categories products whose price > 5.99
        List<HashMap<String, ?>> allCreatedAt = response.extract().path("data.findAll{it.price > 5.99 }.categories.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all categories products whose price > 5.99 : " + allCreatedAt);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test020() {
        //40. Find the uri of all the products
        List<String> theUri= response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  uri of all the products are : " + theUri);
        System.out.println("------------------End of Test---------------------------");


    }








}
