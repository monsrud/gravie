gravie-sdet-test
======

### Setup
* Install grails 2.5.6
* Install jdk 8

Open a new console and start up the app using the command below:
```
grails -Dgrails.env=test -Dgrails.test.phase=functional run-app
```

Open a new console and run the test using the command below:
```
grails test-app functional: specs.general.DashboardSpec -echoOut -echoErr
```

### Exercise
The existing test does not pass. 
As part of this exercise, make the necessary changes to get it to pass.
Also add other relevant tests the test the underlying functionality.

The valid username/password that will authenticate properly is a@a.com/Password1

### Helpful links:

http://www.gebish.org/manual/current/ for geb documentation

http://spockframework.org/spock/docs/1.2/index.html for spock documentation

