$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Feature/VerifySaveView.feature");
formatter.feature({
  "line": 1,
  "name": "Franciscan Admission",
  "description": "As a user I would like to verify that\r\nThere are no errors on clicking save or view buttons of admission",
  "id": "franciscan-admission",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4594691825,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "user enter \"http://qaerp.franciscanecare.net\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter \"admin\" and \"Admin#franciscan\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "passes school name \"qaerp\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "click signin",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "admission home page is opened",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://qaerp.franciscanecare.net",
      "offset": 12
    }
  ],
  "location": "MyTestDefs.user_enter(String)"
});
formatter.result({
  "duration": 652079272,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 12
    },
    {
      "val": "Admin#franciscan",
      "offset": 24
    }
  ],
  "location": "MyTestDefs.user_enter_and(String,String)"
});
formatter.result({
  "duration": 170332503,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "qaerp",
      "offset": 20
    }
  ],
  "location": "MyTestDefs.passes_school_name(String)"
});
formatter.result({
  "duration": 58356,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.click_signin()"
});
formatter.result({
  "duration": 1401115381,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.admission_home_page_is_opened()"
});
formatter.result({
  "duration": 273450678,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 103,
      "value": "#enquiry"
    }
  ],
  "line": 105,
  "name": "To verify save button on enquiry",
  "description": "",
  "id": "franciscan-admission;to-verify-save-button-on-enquiry",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 104,
      "name": "@scenario15"
    }
  ]
});
formatter.step({
  "line": 106,
  "name": "user open enquiry page",
  "keyword": "When "
});
formatter.step({
  "line": 107,
  "name": "click get last enquiry no on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 108,
  "name": "enter visitor name as \"arush\" on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 109,
  "name": "enter visitor address \"Noida\" on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 110,
  "name": "enter mobile no \"6798643210\" on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 111,
  "name": "enter purpose \"Admission\" on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 112,
  "name": "enter contact person \"Adm dept\" on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 113,
  "name": "enter reference details \"none\" on enquiry page",
  "keyword": "And "
});
formatter.step({
  "line": 114,
  "name": "click save on enquiry page",
  "keyword": "Then "
});
formatter.match({
  "location": "MyTestDefs.user_open_enquiry_page()"
});
formatter.result({
  "duration": 921008723,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.click_get_last_enquiry_no_on_enquiry_page()"
});
formatter.result({
  "duration": 328848468,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "arush",
      "offset": 23
    }
  ],
  "location": "MyTestDefs.enter_visitor_name_as_on_enquiry_page(String)"
});
formatter.result({
  "duration": 83396674,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Noida",
      "offset": 23
    }
  ],
  "location": "MyTestDefs.enter_visitor_address_on_enquiry_page(String)"
});
formatter.result({
  "duration": 68889335,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6798643210",
      "offset": 17
    }
  ],
  "location": "MyTestDefs.enter_mobile_no_on_enquiry_page(String)"
});
formatter.result({
  "duration": 80513798,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Admission",
      "offset": 15
    }
  ],
  "location": "MyTestDefs.enter_purpose_on_enquiry_page(String)"
});
formatter.result({
  "duration": 78332067,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Adm dept",
      "offset": 22
    }
  ],
  "location": "MyTestDefs.enter_contact_person_on_enquiry_page(String)"
});
formatter.result({
  "duration": 70790725,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "none",
      "offset": 25
    }
  ],
  "location": "MyTestDefs.enter_reference_details_on_enquiry_page(String)"
});
formatter.result({
  "duration": 59299102,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.click_save_on_enquiry_page()"
});
formatter.result({
  "duration": 273626330,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat admissionPageObject.Enquiry.clickSave(Enquiry.java:83)\r\n\tat stepDef.MyTestDefs.click_save_on_enquiry_page(MyTestDefs.java:1168)\r\n\tat ✽.Then click save on enquiry page(Feature/VerifySaveView.feature:114)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 4911266002,
  "status": "passed"
});
});