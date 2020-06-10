Feature: Version

  Scenario: version is shown in root path
    When root endpoint is requested
    Then the app semantic version is returned