$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Feature/Reports.feature");
formatter.feature({
  "line": 1,
  "name": "Admission reports",
  "description": "   As a user I would like to open all the admission reports\n   So that I can verify that there is no problem in report loading",
  "id": "admission-reports",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 302,
      "value": "#sibling report"
    }
  ],
  "line": 304,
  "name": "To test sibling report",
  "description": "",
  "id": "admission-reports;to-test-sibling-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 303,
      "name": "@scenario21"
    }
  ]
});
formatter.step({
  "line": 305,
  "name": "sibling report page is opened",
  "keyword": "And "
});
formatter.step({
  "line": 306,
  "name": "user select session \"\u003csession\u003e\" on sibling report page",
  "keyword": "When "
});
formatter.step({
  "line": 307,
  "name": "select school \"\u003cschool\u003e\" on sibling report page",
  "keyword": "And "
});
formatter.step({
  "line": 308,
  "name": "select class \"\u003cclass\u003e\" on sibling report page",
  "keyword": "And "
});
formatter.step({
  "line": 309,
  "name": "select show details for \"Elder\" on sibling report page",
  "keyword": "And "
});
formatter.step({
  "line": 310,
  "name": "user click show to open sibling report",
  "keyword": "Then "
});
formatter.examples({
  "line": 312,
  "name": "",
  "description": "",
  "id": "admission-reports;to-test-sibling-report;",
  "rows": [
    {
      "cells": [
        "url",
        "uname",
        "password",
        "class",
        "session",
        "school"
      ],
      "line": 313,
      "id": "admission-reports;to-test-sibling-report;;1"
    },
    {
      "cells": [
        "http://qaerp.franciscanecare.net",
        "admin",
        "Admin@987",
        "1-A",
        "2017-2018",
        "All"
      ],
      "line": 314,
      "id": "admission-reports;to-test-sibling-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4021349233,
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
  "duration": 1088414983,
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
  "duration": 176421186,
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
  "duration": 74483,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.click_signin()"
});
formatter.result({
  "duration": 2000821959,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.admission_home_page_is_opened()"
});
formatter.result({
  "duration": 300564258,
  "status": "passed"
});
formatter.scenario({
  "line": 314,
  "name": "To test sibling report",
  "description": "",
  "id": "admission-reports;to-test-sibling-report;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 303,
      "name": "@scenario21"
    }
  ]
});
formatter.step({
  "line": 305,
  "name": "sibling report page is opened",
  "keyword": "And "
});
formatter.step({
  "line": 306,
  "name": "user select session \"2017-2018\" on sibling report page",
  "matchedColumns": [
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 307,
  "name": "select school \"All\" on sibling report page",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 308,
  "name": "select class \"1-A\" on sibling report page",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 309,
  "name": "select show details for \"Elder\" on sibling report page",
  "keyword": "And "
});
formatter.step({
  "line": 310,
  "name": "user click show to open sibling report",
  "keyword": "Then "
});
formatter.match({
  "location": "MyTestDefs.sibling_report_page_is_opened()"
});
formatter.result({
  "duration": 639623641,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2017-2018",
      "offset": 21
    }
  ],
  "location": "MyTestDefs.user_select_session_on_sibling_report_page(String)"
});
formatter.result({
  "duration": 1278321515,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "All",
      "offset": 15
    }
  ],
  "location": "MyTestDefs.select_school_on_sibling_report_page(String)"
});
formatter.result({
  "duration": 266874498,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1-A",
      "offset": 14
    }
  ],
  "location": "MyTestDefs.select_class_on_sibling_report_page(String)"
});
formatter.result({
  "duration": 1922200398,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Elder",
      "offset": 25
    }
  ],
  "location": "MyTestDefs.select_show_details_for_on_sibling_report_page(String)"
});
formatter.result({
  "duration": 88405599,
  "status": "passed"
});
formatter.match({
  "location": "MyTestDefs.user_click_show_to_open_sibling_report()"
});
formatter.result({
  "duration": 7186092912,
  "status": "passed"
});
formatter.after({
  "duration": 4816562693,
  "status": "passed"
});
});