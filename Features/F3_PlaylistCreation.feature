Feature: Add a Playlist on Spotify

  Scenario: User adds a new playlist on "Spotify"
    Given the user is logged into "Spotify"
    When the user clicks at "Create Playlist" button
    And enters playlist name "My Favorite Songs"
    And clicks at "Save" button
    Then the "playlist" should be created successfully
