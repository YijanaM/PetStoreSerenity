Feature: Pet Store Api testing - Technical Test

  @findPurchase
  Scenario: Find purchase order by ID
    Given Place an order for a pet
          """
      {
          "id": 9965874,
          "petId": 17588387,
          "quantity": 17220492,
          "shipDate": "1968-02-05T07:01:04.430Z",
          "status": "approved",
          "complete": true
      }
          """
    When  user finds a purchase order by id
    Then  verify status 200

    @GetInventory
  Scenario: Returns pet inventory by status
    Given user gets pet inventory
    Then  verify status 200

   @DeletePurchase
  Scenario: Delete purchase order by ID
     Given Place an order for a pet
          """
      {
          "id": 14,
          "petId": 17588387,
          "quantity": 17220492,
          "shipDate": "1968-02-05T07:01:04.430Z",
          "status": "approved",
          "complete": true
      }
          """
     When  user deletes a purchase order by id
     Then  verify status 200

