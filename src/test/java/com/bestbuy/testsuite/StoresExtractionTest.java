package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest  {
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
        //1. Extract the limit
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test002() {
        //2. Extract the total
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test003() {
        //3. Extract the name of 5th store
        String name =  response.extract().path(".data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + name );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test004() {
        //4. Extract the names of all the store
        List<String> listOfStore = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store is : " + listOfStore );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test005() {
        //5. Extract the storeId of all the store
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store is : " + allStoreId );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test006() {
        //6. Print the size of the data list
        int size = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + size );
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test007() {
        //7. Get all the value of the store where store name = St Cloud
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name = St Cloud are : " + value );
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test008() {
        //8. Get the address of the store where store name = Rochester
       List<HashMap<String, ?>> storeName = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester is : " + storeName );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test009() {
        //9. Get all the services of 8th store
       List<HashMap<String,?>> storeServices = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store is : " + storeServices );
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test010() {
        //10. Get storeServices of the store where service name = Windows Store
        List<HashMap<String,?>>  serviceName = response.extract().path("data.services.findAll{it.name =='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store where service name = Windows Store is : " + serviceName );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test011() {
        //11. Get all the storeId of all the store
        List<Integer> storeId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store are : " + storeId );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test012() {
        //12. Get id of all the store
        List<Integer> id = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all the store are : " + id );
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test013() {
        //13. Find the store names Where state = ND
        List<String> state = response.extract().path("data.findAll{it.state ='ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state = ND  is : " + state);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test014() {
        //14. Find the Total number of services for the store where store name = Rochester
        List<Object> state = response.extract().path("data.findAll{it.name =='Rochester'}.services.");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  total number of services for the store where store name = Rochester are : " + state);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test015() {
        //15. Find the createdAt for all services whose name = “Windows Store”
        List<String> createdAt = response.extract().path("data.find{}All{it.name =='Windows Store'}.services.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  createdAt for all services whose name = “Windows Store” are: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test016() {
        //16. Find the name of all services Where store name = “Fargo”
        List<String> services = response.extract().path("data.findAll{it.name =='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services Where store name = “Fargo” are : " + services);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test017() {
        //17. Find the zip of all the store
        List<String> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of all the store are: " + zip);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test018() {
        //18. Find the zip of store name = Roseville
        List<String> zipName = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name = Roseville is : " + zipName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test019() {
        //19. Find the store services details of the service name = Magnolia Home Theater
        List<?> storeservicesDetails = response.extract().path("data.services*.findAll{it.name == 'Magnolia Home Theater'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services details of the service name = Magnolia Home Theater is : " + storeservicesDetails);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    public void test020() {
        //20. Find the lat of all the stores

        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the lat of all the stores are : " + lat);
        System.out.println("------------------End of Test---------------------------");
    }

}














