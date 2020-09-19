@Regression
Feature: Testing Online Fruits and Veggies APP

Background:
Given User lauches the App

@ValidCred 
Scenario: Vlaid crdentials
When User gives right "Online_User" as Username and "Online_User" as Password
Then User should see success message


@ValidCredwithEncryption 
Scenario: Vlaid crdentials
When User will give right "Online_User" as Username and "T25saW5lX1VzZXI=" as Password
Then User should see success message

@ValidCredwithExcel 
Scenario: Vlaid crdentials
When Read data from spreadsheet and perform login
Then User should see success message

@ValidCredwithDB
Scenario: Vlaid crdentials
When Get the Credentials from Database and perform login
Then User should see success message

@InValidCred 
Scenario: Invalid Credentials
When User gives invalid credentials "automate" as Username and "withme" as Password
Then User should see Error message


@ValidCred_withDtatTable 
Scenario: Vlaid crdentials
Given User lauches the App
When User gives right Username and Password
|Online_User|Online_User|
Then User should see success message

@InValidCred_withDtatTable  
Scenario: Invalid Credentials
Given User lauches the App
When User gives invalid credentials Username and Password
|Online_User|Other|
Then User should see Error message

@InvalidTest
Scenario Outline: Invalid Credentials
Given User lauches the App
When User gives invalid credentials <uname> as Username and <pass> as Password
Then User should see Error message

 Examples:
    | uname| pass| 
    | "user1" |   "mypass" |  
    | "user2" |   "mypass2" |  
    | "user3" |   "mypass3" |  




