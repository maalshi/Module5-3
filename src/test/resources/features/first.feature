Feature: verify User can see Flight Results page
Background:
  Given I open Aerlingus Homepage


@smokeTest
Scenario Outline: User performs a Flight search

When I enter origin
And I enter <destinaton>
And press Find Flights button
Then I see Flight Results page

Examples:
|destination|
|paris      |
|vienna     |