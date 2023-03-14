Feature: authentication
  Scenario: go to website, add random book to cart and check cart   //isim degisebilir
    Given go to website
    And click best seller
    And click on best seller literature books
    And select a random book
    And add book to cart
    When go to cart
    Then check if the book is added to cart


  Scenario Outline: test login page
    Given navigate to website
    And click login
    And enter email "<email>"
    And enter password "<password>"
    When click login button
    Then check if login is successful
    Examples:
      | email | password |
      | sevval@gmail.com    | 321sa   |
      | sevvalakilli00@gmail.com | 654321sa |
