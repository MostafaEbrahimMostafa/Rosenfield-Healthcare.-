Feature: Add a song to a playlist and play it on Spotify

  Scenario: User adds a song to an existing playlist and plays it
    Given the user is already logged into "Spotify"
    When the user searches for a song "song_name"
    And selects "Add to Playlist"
    Then the song should be added successfully
    And clicks "Play" button
    Then the song should "start playing successfully"
