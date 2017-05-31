$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Feature/VerifyPage.feature");
formatter.feature({
  "line": 1,
  "name": "Franciscan Admission",
  "description": "    As a user I would like to verify that \r\n    The page is loaded successfully",
  "id": "franciscan-admission",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5592409564,
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
  "duration": 1045931111,
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
  "duration": 163717444,
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
  "duration": 60995,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.click_signin()"
});
formatter.result({
  "duration": 1556527992,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.admission_home_page_is_opened()"
});
formatter.result({
  "duration": 327936924,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 168,
      "value": "#student registration"
    }
  ],
  "line": 170,
  "name": "To verify student registration page",
  "description": "",
  "id": "franciscan-admission;to-verify-student-registration-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 169,
      "name": "@scenario27"
    }
  ]
});
formatter.step({
  "line": 171,
  "name": "user open student registration page",
  "keyword": "When "
});
formatter.step({
  "line": 172,
  "name": "verify student registration page",
  "keyword": "Then "
});
formatter.match({
  "location": "MyTestDefs.user_open_student_registration_page()"
});
formatter.result({
  "duration": 932525577,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.verify_student_registration_page()"
});
formatter.result({
  "duration": 2337610520,
  "status": "passed"
});
formatter.after({
  "duration": 5264304317,
  "status": "passed"
});
});