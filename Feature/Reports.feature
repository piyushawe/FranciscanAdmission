Feature: Admission reports
     As a user I would like to open all the admission reports
     So that I can verify that there is no problem in report loading

  Background: 
    Given user enter "http://qaerp.franciscanecare.net"
    When user enter "admin" and "Admin#franciscan"
    And passes school name "qaerp"
    And click signin
    Then admission home page is opened

  #class wise admission report
  @scenario1
  Scenario Outline: To open class wise admission report with all the filters
    And class wise admission report is opened
    When user select session "<session>" on class wise admission report
    And select school "<school>" on class wise admission report
    And select class "<class>" on class wise admission report
    And select stream "All Stream" on class wise admission report
    And select subject "All Subject" on class wise admission report
    And select from date as month "April" year "2017" and day "1" on class wise admission report
    And select to date as month "April" year "2017" and day "1" on class wise admission report
    Then click show to open class wise admission report

    Examples: 
      | url                              | uname | password  | session   | school                    | class |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 | Inspiration public school |     1 |

  #search and import online registration
  @scenario2
  Scenario Outline: To open search and import online registration report with all the filters
    And search and import online registration report is opened
    When user select session "<session>" on search and import online registration report page
    And select class "<class>" on search and import online registration report page
    And select from date as month "April" year "2017" and day "1" on search and import online registration report page
    And select to date as month "April" year "2017" and day "1" on search and import online registration report page
    Then user click show to open search and import online registration report

    Examples: 
      | url                              | uname | password  | session   | class |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 |

  @scenario3
  Scenario Outline: To test import data on search and import online registration report
    And search and import online registration report is opened
    When user select session "<session>" on search and import online registration report page
    And select class "<class>" on search and import online registration report page
    And select from date as month "April" year "2017" and day "1" on search and import online registration report page
    And select to date as month "April" year "2017" and day "30" on search and import online registration report page
    Then user click import data to import data on search and import online registration report

    Examples: 
      | url                              | uname | password  | session   | class |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 |

  @scenario4
  Scenario Outline: To test update data to erp on search and import online registration report
    And search and import online registration report is opened
    When user select session "<session>" on search and import online registration report page
    And select class "<class>" on search and import online registration report page
    And select from date as month "April" year "2017" and day "1" on search and import online registration report page
    And select to date as month "April" year "2017" and day "1" on search and import online registration report page
    Then user click update data to erp on search and import online registration report

    Examples: 
      | url                              | uname | password  | session   | class |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 |

  #slot report
  @scenario5
  Scenario Outline: To test slot report with all filters
    And slot report is opened
    When user select session "<session>" on slot report
    And select class "<class>" on slot report
    And select slot "<slot>" on slot report
    Then user click show to open slot report

    Examples: 
      | url                              | uname | password  | session   | class | slot |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 | s1   |

  #admission withdrawal register
  @scenario6
  Scenario Outline: To test admission withdrawal register report
    And admission withdrawal register report page is opened
    When user select session "<session>" on admission withdrawal register report
    Then user click show to open admission withdrawal register report

    Examples: 
      | url                              | uname | password  | session   |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |

  #verification admission form
  @scenario7
  Scenario Outline: To test verification admission form with all filters
    And verification admission form is opened
    When user select class "<class>" on verification admission form
    And select section "<section>" on verification admission form
    And select date as month "April" year "2017" and day "10" on verification admission form
    Then user click show to open verification admission form

    Examples: 
      | url                              | uname | password  | class | section |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | A       |

  #student repeater list
  @scenario8
  Scenario Outline: To test student repeater list
    And student repeater list page is opened
    When user select class "<class>" on student repeater list page
    And select section "<section>" on student repeater list page
    Then user click show to open student repeater list page

    Examples: 
      | url                              | uname | password  | class | section |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | A       |

  #merit generation list
  @scenario9
  Scenario Outline: To test merit generation list
    And merit generation list page is opened
    When user select session "<session>" on merit generation list
    And user select class "<class>" on merit generation list
    And user select merit list "<merit list>" on merit generation list
    Then user click show to open merit generation list

    Examples: 
      | url                              | uname | password  | session   | class | merit list     |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 | All Merit List |

  #student document details
  @scenario10
  Scenario Outline: To test student document details page
    And student document details page is opened
    When user select class "<class>" on student document details page
    And select section "<section>" on student document details page
    Then user click show to open student document details page

    Examples: 
      | url                              | uname | password  | class | section |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | A       |

  #merit list report
  @scenario11
  Scenario Outline: To test merit list report
    And merit list report page is opened
    When user select session "<session>" on merit list report page
    And user select class "<class>" on merit list report page
    And user select merit list "<merit list>" on merit list report page
    Then user click show to open merit list report page

    Examples: 
      | url                              | uname | password  | session   | class | merit list |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 | All        |

  #prospectus charges report
  @scenario12
  Scenario Outline: To test prospectus charges report
    And prospectus charges report page is opened
    When user select session "<session>" on prospectus charges report page
    And select from date as month "April" year "2017" and day "10" on prospectus charges report page
    And select to date as month "April" year "2017" and day "10" on prospectus charges report page
    And user select class "<class>" on prospectus charges report page
    And select user "<user>" on prospectus charges report page
    And select mode "<mode>" on prospectus charges report page
    Then user click show to open prospectus charges report page

    Examples: 
      | url                              | uname | password  | session   | class | user        | mode    |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 | eCare Admin | Offline |

  #merit criteria print
  @scenario13
  Scenario Outline: To test merit criteria print report criteria wise
    And merit criteria print report page is opened
    When user select session "<session>" on merit criteria print report page
    And user select class "<class>" on merit criteria print report page
    And click criteria wise on merit criteria print report page
    And select criteria name "<criteria name>" on merit criteria print report page
    And enter criteria point "10" on merit criteria print report page
    Then user click show to open merit criteria print report page

    Examples: 
      | url                              | uname | password  | session   | class | criteria name |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 | Ten           |

  @scenario14
  Scenario Outline: To test merit criteria print report point wise
    And merit criteria print report page is opened
    When user select session "<session>" on merit criteria print report page
    And user select class "<class>" on merit criteria print report page
    And click point wise on merit criteria print report page
    And enter total point "10" on merit criteria print report page
    Then user click show to open merit criteria print report page

    Examples: 
      | url                              | uname | password  | session   | class | criteria name |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 2017-2018 |     1 | Ten           |

  #print student label
  @scenario15
  Scenario Outline: To test print student label page
    And print student label page is opened
    And user select class "<class>" on  print student label page
    When user select section "<section>" on  print student label page
    And enter search text "<name>" on merit criteria print report page
    Then user click show to open print student label page

    Examples: 
      | url                              | uname | password  | section | class | name   |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | A       |     1 | sonia1 |

  @scenario16
  Scenario Outline: To test print student label page when transport is clicked
    And print student label page is opened
    And user select class "<class>" on  print student label page
    When user select section "<section>" on  print student label page
    And click transport on print student label page
    Then user click show to open print student label page

    Examples: 
      | url                              | uname | password  | section | class |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | A       |     1 |

  #collection report admission
  @scenario17
  Scenario Outline: To test collection report admission page prospectus wise
    And collection report admission page is opened
    And select prospectus wise on collection report admission page
    And select from date as month "April" year "2017" and day "1" on collection report admission page
    And select to date as month "April" year "2017" and day "30" on collection report admission page
    And user select class "<class>" on collection report admission page
    When user select session "<session>" on collection report admission page
    And select board "<board>" on collection report admission page
    And select pay mode "Cash" on collection report admission page
    And select entry mode "Both" on collection report admission page
    And select order by "Name" on collection report admission page
    And select group by "Class" on collection report admission page
    Then user click show to open collection report admission page

    Examples: 
      | url                              | uname | password  | class | session   | board |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | 2017-2018 | ICSE  |

  @scenario18
  Scenario Outline: To test collection report admission page admission form wise
    And collection report admission page is opened
    And select admission form wise on collection report admission page
    And select from date as month "April" year "2017" and day "1" on collection report admission page
    And select to date as month "April" year "2017" and day "30" on collection report admission page
    And user select class "<class>" on collection report admission page
    When user select session "<session>" on collection report admission page
    And select board "<board>" on collection report admission page
    And select pay mode "Cash" on collection report admission page
    And select entry mode "Both" on collection report admission page
    And select order by "Name" on collection report admission page
    And select group by "Class" on collection report admission page
    Then user click show to open collection report admission page

    Examples: 
      | url                              | uname | password  | class | session   | board |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | 2017-2018 | ICSE  |

  @scenario19
  Scenario Outline: To test collection report admission page admission entry wise
    And collection report admission page is opened
    And select admission entry wise on collection report admission page
    And select from date as month "April" year "2017" and day "1" on collection report admission page
    And select to date as month "April" year "2017" and day "30" on collection report admission page
    And user select class "<class>" on collection report admission page
    When user select session "<session>" on collection report admission page
    And select board "<board>" on collection report admission page
    And select pay mode "Cheque" on collection report admission page
    And select entry mode "Both" on collection report admission page
    And select order by "RegNo" on collection report admission page
    And select group by "Date" on collection report admission page
    Then user click show to open collection report admission page

    Examples: 
      | url                              | uname | password  | class | session   | board     |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | 2017-2018 | All Board |

  @scenario20
  Scenario Outline: To test collection report admission page reslot wise
    And collection report admission page is opened
    And select reslot wise on collection report admission page
    And select from date as month "April" year "2017" and day "1" on collection report admission page
    And select to date as month "April" year "2017" and day "30" on collection report admission page
    And user select class "<class>" on collection report admission page
    When user select session "<session>" on collection report admission page
    And select board "<board>" on collection report admission page
    And select pay mode "All" on collection report admission page
    And select entry mode "Both" on collection report admission page
    And select order by "RegNo" on collection report admission page
    And select group by "No" on collection report admission page
    Then user click show to open collection report admission page

    Examples: 
      | url                              | uname | password  | class | session   | board     |
      | http://qaerp.franciscanecare.net | admin | Admin@987 |     1 | 2017-2018 | All Board |

  #sibling report
  @scenario21
  Scenario Outline: To test sibling report
    And sibling report page is opened
    When user select session "<session>" on sibling report page
    And select school "<school>" on sibling report page
    And select class "<class>" on sibling report page
    And select show details for "Elder" on sibling report page
    Then user click show to open sibling report

    Examples: 
      | url                              | uname | password  | class | session   | school |
      | http://qaerp.franciscanecare.net | admin | Admin@987 | 1-A   | 2017-2018 | All    |
