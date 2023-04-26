Feature: Systemtest_Crusius_Login

  @Release_1 @AllRegions @Automated @NotReady
   Scenario: SystemTest__Crusius__Login_Is_Successful_With_Valid_Credentials
    Given open Google Chrome browser
    And navigate to the Sapiens IDIT Suite home page
    When the user enters a valid <username>
    And user enters a valid <password>
    And the user clicks the button Login
    Then the login is <status>
    
    Examples:
    | username | password | status |
    #| aourjuba1 | A4next! | success|
    | aourjuba1 |  A4next | fail |

