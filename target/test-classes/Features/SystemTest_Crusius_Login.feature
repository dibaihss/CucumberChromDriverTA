Feature: Systemtest_Crusius_Login

  @Release_1 @AllRegions @Automated @NotReady
  Scenario: SystemTest__Crusius_Login__Login_Is_Successful_With_Valid_Credentials
    Given open Google Chrome browser
    And navigate to the Sapiens IDIT Suite home page
    When the user enters a valid <username>
    And user enters a valid <password>
    And the user clicks the button Login
    Then the login is <status>
    
    Examples:
    | username | password | status |
    | aourjuba1 | A4next! | success|
    | aourjuba1 |  A4next | fail |

    
    
#
  #@Release_1 
  #@AllRegions 
  #@Automated 
  #@NotReady
  #Scenario: SystemTest__Crusius_Login__Login_Is_Successful_With_Valid_Credentials
    #Given open Google Chrome browser
    #And navigate to the Sapiens IDIT Suite home page
    #When the user enters a valid username 
    #And the user enters a valid password
    #And the user clicks the button Login
    #Then the login is successful 
    #
  #@Release_1 
#  @AllRegions    
#  @Automated   
#  @NotReady 
#  Scenario: SystemTest__Crusius_Login__Login_Is_Unsuccessful_With_Invalid_Credentials
#    Given open Google Chrome browser
#    And navigate to the Sapiens IDIT Suite home page
#    When the user enters a valid username
#    And the user enters an incorrect password
#    And the user clicks the button Login
#    Then the login is unsuccessful