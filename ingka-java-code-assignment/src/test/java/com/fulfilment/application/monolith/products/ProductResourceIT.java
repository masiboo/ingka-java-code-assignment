package com.fulfilment.application.monolith.products;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
class ProductResourceIT {

    @Test
    void getAllProducts() {
        given()
                .when().get("/products")
                .then()
                .statusCode(200)
                .body("$.size()", greaterThan(0));
    }

    @Test
    void deleteExistingProduct() {
        given()
                .when().delete("/products/1")
                .then()
                .statusCode(204);
    }

    @Test
    void deleteNonExistingProduct() {
        given()
                .when().delete("/products/9999")
                .then()
                .statusCode(404);
    }
}
