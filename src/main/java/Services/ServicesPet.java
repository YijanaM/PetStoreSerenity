package Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import models.entities.DeleteResponse;
import models.entities.OrderResponse;
import models.entities.PurchaseOrder;
import models.entities.ServiceResponse;
import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;

import static utils.constans.GeneralConstant.*;
import static utils.properties.ServicesProperties.getProperties;

public class ServicesPet {

    private PurchaseOrder order;
    private OrderResponse orderResponse;
    private DeleteResponse deleteResponse;
    ObjectMapper objectMapper = new ObjectMapper();



    public void anOrderForAPet(String requestConsume) throws IOException {
       SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestConsume)
                 .post(getProperties(END_POINT_ORDER));


        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setRequest(requestConsume);
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
        order = objectMapper.readValue(ServiceResponse.getResponse(), PurchaseOrder.class);
    }

    public void findPurchaseOrderById() throws IOException {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("orderId",order.getId())
                .when()
                .get(getProperties(END_POINT_ORDER)+"/{orderId}");

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
        orderResponse = objectMapper.readValue(ServiceResponse.getResponse(), OrderResponse.class);
    }

    public void getPetInventory() throws IOException {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("api_key",API_KEY)
                .when()
                .get(getProperties(END_POINT_STORE));

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public void deletePurchaseById() throws IOException {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("orderId",order.getId())
                .when()
                .delete(getProperties(END_POINT_ORDER)+"/{orderId}");

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
        deleteResponse = objectMapper.readValue(ServiceResponse.getResponse(), DeleteResponse.class);
    }

}
