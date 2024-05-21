package stepdefinitions;

import Services.ServicesPet;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import java.io.IOException;

public class PetStoreStepDefinition {

    ServicesPet place;

    @Before
    public void initialize(){
         place = new ServicesPet();
    }

    @Given("^Place an order for a pet$")
    public void placeAnOrderAPet(String orderData) throws IOException {
         place.anOrderForAPet(orderData);
    }

    @When("^user finds a purchase order by id$")
    public void userFindsAPurchaseOrderById() throws IOException {
        place.findPurchaseOrderById();
    }

    @Given("^user gets pet inventory$")
    public void userGetsPetInventory() throws IOException {
        place.getPetInventory();
    }

    @Given("^user obtains pet inventory$")
    public void userObtainsPetInventory() {
        System.out.println("eyy");
    }

    @Then("^verify status (.*)$")
    public void verifyStatus(String statusCode) {
        Assert.assertTrue(statusCode.equalsIgnoreCase(String.valueOf(SerenityRest.lastResponse().getStatusCode())));
    }

    @When("user deletes a purchase order by id")
    public void userDeletesAPurchaseOrderById() throws IOException {
        place.deletePurchaseById();
    }

/*    @Then("^verify status \"([^\"]*)\"$")
    public void verifyStatus(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/
}