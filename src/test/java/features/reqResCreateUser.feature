Feature: This feature is to create Users

  Background: Setting up background
    Given Launch the browser

  Scenario: Create user
    Given API endpoint is available
    When I hit the POST request
    Then status code is
      | 201 |

  Scenario: User login with multiple credentials
    Given the following user details
      | Username | Password | Role     |
      | user1    | pass123  | Admin    |
      | user2    | pass456  | Employee |

  @demo @smoke
  Scenario: Testing data tables without column header
    Given below are the users
      | firstname1 | lastname1 | f1.l1@gmail.com |
      | firstname2 | lastname2 | f2.l2@gmail.com |
      | firstname3 | lastname3 | f3.l3@gmail.com |
  @outline
  Scenario Outline: Testing scenario outline
    Given below are the users list "<FName>" and "<LName>" and <code>
    Examples:
      | FName     | LName| code|
      | jacob    | John  | 30  |
      | Sindabad | Sailor| 79  |