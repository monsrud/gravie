gravie-sdet-test
======

Repo for the Gravie Admin Application

## Production Environment for reference

* [Grails 2.5.3](http://grails.org/)

* [OpenJDK 7](http://openjdk.java.net/)


Open a new console and start up the app using the command below:
grails -Dgrails.env=test -Dgrails.test.phase=functional run-app

Open a new console and run the test using the command below:
test-app functional: specs.general.DashboardSpec -echoOut -echoErr

The valid username/password that will authenticate properly is a@a.com/Password1

The executed test will not pass.  As part of this exercise, get the existing test to pass.
Also add any missing tests.

