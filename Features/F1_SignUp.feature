Feature: User Signup on Spotify

  Scenario: User successfully signs up on Spotify
    Given the user navigate url "https://open.spotify.com/"
    When the user clicks on the "Sign Up" link
    And the user enters "a valid email address"
    And the user clicks "next" button
    And the user creates "a strong password"
    And the user clicks on "next" button
    Then the user should be redirected to the "tell about yourself page"
    When the user enter "name"
    And the user selects "date of birth"
    And the user select "gender"
    And the user click on "next" button
    Then the user should be redirected to "Terms & Conditions page"
    When the user approve "Terms & Conditions" by clicking on "checkboxes"
    And the user clicks on the "Sign Up" button
    Then the user should be "registered successfully" and redirected to "home page"
