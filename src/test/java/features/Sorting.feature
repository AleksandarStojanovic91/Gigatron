Feature: Sorting

  #Sorting options: score, rastuci, opadajuci, rejting, naziv
  Scenario Outline: Sort by "<sortingMethod>"

    Given I am on products page
    When I click sort by "<sortingMethod>"
    Then I should see products sorted "<sortingMethod>"

    Examples:
      | sortingMethod |
      | rastuci       |
#      | opadajuci     |
#      | naziv         |
#      | score         |
#      | rejting       |
