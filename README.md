gravie-sdet-test
======

Install grails 2.5.3
Install jdk 8

Open a new console and start up the app using the command below:
grails -Dgrails.env=test -Dgrails.test.phase=functional run-app

Open a new console and run the test using the command below:
grails test-app functional: specs.general.DashboardSpec -echoOut -echoErr

The valid username/password that will authenticate properly is a@a.com/Password1

The executed test will not pass.  As part of this exercise, get the existing test to pass.
Also add any missing tests.

Helpful links:

http://www.gebish.org/manual/current/ for geb documentation

http://spockframework.org/spock/docs/1.2/index.html for spock documentation

