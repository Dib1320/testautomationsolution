#Author: dibyendusengupta
Feature: To test the functionality of https://testscriptdemo.com/

  @verifyitemincart
  Scenario Outline: To add products to wishlist and the add lowest price product to cart 
    Given User launches the application "<URL>" in Browser "<Browser>" for testcase "<TestCase>"
    Then User should add products to wishlist
    Then User need to validate the wishlist
    Then User need to add the lowest price product to cart
    Then User need to validate the item in cart

    Examples: 
    | TestCase | URL                           | Browser |
    | Test01   | https://testscriptdemo.com    | Chrome  |      