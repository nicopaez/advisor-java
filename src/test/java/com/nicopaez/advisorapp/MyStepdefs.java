package com.nicopaez.advisorapp;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs extends AbstractSteps{

    final static String semanticVersionRegEx = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-(" +
            "(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$";

    @When("root endpoint is requested")
    public void rootEndpointIsRequested() {
        testContext().reset();
        this.executeGet("/");
    }

    @Then("the app semantic version is returned")
    public void theAppVersionIsReturned() {
        Response response = testContext().getResponse();
        assertThat(response.statusCode()).isIn(200, 201);
        String semanticVersion = response.jsonPath().getString("version");
        assertThat(semanticVersion).matches(semanticVersionRegEx);
    }
}
