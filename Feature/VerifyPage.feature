Feature: Franciscan Admission
      As a user I would like to verify that 
      The page is loaded successfully

  Background: 
    Given user enter "http://qaerp.franciscanecare.net"
    When user enter "admin" and "Admin#franciscan"
    And passes school name "qaerp"
    And click signin
    Then admission home page is opened

  #change academic
  @scenario1
  Scenario: To verify change academic page
    When user open change academic page
    Then verify change academic page

  #prospectus & registration no setting
  @scenario2
  Scenario: To verify prospectus & registration no setting page
    When user open prospectus & registration no setting page
    Then verify prospectus & registration no setting page

  #admission class group relation
  @scenario3
  Scenario: To verify admission class group relation page
    When user open admission class group relation page
    Then verify admission class group relation page

  #student class section transfer
  @scenario4
  Scenario: To verify student class section transfer page
    When user open student class section transfer page
    Then verify student class section transfer page

  #change active inactive status
  @scenario5
  Scenario: To verify change active inactive status page
    When user open change active inactive status page
    Then verify change active inactive status page

  #update address and blood
  @scenario6
  Scenario: To verify update address and blood page
    When user open update address and blood page
    Then verify update address and blood page

  #update student details
  @scenario7
  Scenario: To verify update student details page
    When user open update student details page
    Then verify update student details page

  #define document type
  @scenario8
  Scenario: To verify define document type page
    When user open define document type page
    Then verify define document type page

  #student class promotion
  @scenario9
  Scenario: To verify student class promotion page
    When user open student class promotion page
    Then verify student class promotion page

  #student image download
  @scenario10
  Scenario: To verify student image download page
    When user open student image download page
    Then verify student image download page

  #admission form settings
  @scenario11
  Scenario: To verify admission form settings page
    When user open admission form settings page
    Then verify admission form settings page

  #possible siblings
  @scenario12
  Scenario: To verify possible siblings page
    When user open possible siblings page
    Then verify possible siblings page

  #stationary details
  @scenario13
  Scenario: To verify stationary details page
    When user open stationary details page
    Then verify stationary details page

  #define academic year
  @scenario14
  Scenario: To verify define academic year page
    When user open define academic year page
    Then verify define academic year page

  #define financial year
  @scenario15
  Scenario: To verify define financial year page
    When user open define financial year page
    Then verify define financial year page

  #define periods to class
  @scenario16
  Scenario: To verify define periods to class page
    When user open define periods to class page
    Then verify define periods to class page

  #define house
  @scenario17
  Scenario: To verify define house page
    When user open define house page
    Then verify define house page

  #define stream
  @scenario18
  Scenario: To verify define stream page
    When user open define stream page
    Then verify define stream page

  #define optional subject
  @scenario19
  Scenario: To verify define optional subject page
    When user open define optional subject page
    Then verify define optional subject page

  #define sms template
  @scenario20
  Scenario: To verify define sms template page
    When user open define sms template page
    Then verify define sms template page

  #define parent status
  @scenario21
  Scenario: To verify define parent status page
    When user open define parent status page
    Then verify define parent status page

  #slot creation
  @scenario22
  Scenario: To verify slot creation page
    When user open slot creation page
    Then verify slot creation page

  #enquiry
  @scenario23
  Scenario: To verify enquiry page
    When user open enquiry page
    Then verify enquiry page

  #prospectus entry
  @scenario24
  Scenario: To verify prospectus entry page
    When user open prospectus entry page
    Then verify prospectus entry page

  #admission form registration
  @scenario25
  Scenario: To verify admission form registration page
    When user open admission form registration page
    Then verify admission form registration page

  #student registration
  @scenario26
  Scenario: To verify student registration page
    When user open student registration page
    Then verify student registration page

  #define merit criteria
  @scenario27
  Scenario: To verify define merit criteria page
    When user open define merit criteria page
    Then verify define merit criteria page

  #merit criteria entry
  @scenario28
  Scenario: To verify merit criteria entry page
    When user open merit criteria entry page
    Then verify merit criteria entry page

  #merit list generation
  @scenario29
  Scenario: To verify merit list generation page
    When user open merit list generation page
    Then verify merit list generation page

  #admission entry
  @scenario30
  Scenario: To verify admission entry page
    When user open admission entry page
    Then verify admission entry page

  #import student
  @scenario31
  Scenario: To verify import student page
    When user open import student page
    Then verify import student page

  #add remove group heads
  @scenario32
  Scenario: To verify add remove group heads page
    When user open add remove group heads page
    Then verify add remove group heads page

  #manual list generation
  @scenario33
  Scenario: To verify manual list generation page
    When user open manual list generation page
    Then verify manual list generation page

  #create id card
  @scenario34
  Scenario: To verify create id card page
    When user open create id card page
    Then verify create id card page

  #admission entry amount structure
  @scenario35
  Scenario: To verify admission entry amount structure page
    When user open admission entry amount structure page
    Then verify admission entry amount structure page

  #slot wise point entry
  @scenario36
  Scenario: To verify slot wise point entry page
    When user open slot wise point entry page
    Then verify slot wise point entry page

  #challan amount
  @scenario37
  Scenario: To verify challan amount page
    When user open challan amount page
    Then verify challan amount page

  #re slotting
  @scenario38
  Scenario: To verify re slotting page
    When user open re slotting page
    Then verify re slotting page
