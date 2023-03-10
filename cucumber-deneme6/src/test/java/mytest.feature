Feature: kitapyurdu random book test
  Scenario: go to website, add random book to cart ve check cart
    Given go to website
    And click best seller
    And click on best seller literature books
    And select a random book
    And add book to cart
    When go to cart
    Then check if the book is added to cart