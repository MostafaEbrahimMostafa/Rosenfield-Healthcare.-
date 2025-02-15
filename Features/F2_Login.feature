Feature: Spotify Login

  Scenario: User login to spotify with valid credentials
    Given the user navigate Spotify "login" page
    When the user enters valid "email" and "password"
    And clicks on the "login" button
    Then the user should be redirected to the Spotify "homepage"
