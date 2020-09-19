$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/automate/withme/Features/FirstFeature.feature");
formatter.feature({
  "name": "Testing Online Fruits and Veggies APP",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "User lauches the App",
  "keyword": "Given "
});
formatter.match({
  "location": "com.automate.withme.stepdefs.FirstFeature_Stepdefs.User_lauches_the_App()"
});
formatter.embedding("image/png", "embedded0.png", "Vlaid crdentials");
formatter.write("Success Login");
formatter.result({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.scenario({
  "name": "Vlaid crdentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@ValidCredwithExcel"
    }
  ]
});
formatter.step({
  "name": "Read data from spreadsheet and perform login",
  "keyword": "When "
});
formatter.match({
  "location": "com.automate.withme.stepdefs.FirstFeature_Stepdefs.Excel_sheet()"
});
formatter.result({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "User should see success message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.automate.withme.stepdefs.FirstFeature_Stepdefs.User_should_see_success_message()"
});
formatter.result({
  "status": "passed"
});
});