package test.functional.specs.general


import test.functional.pages.DashboardPage
import test.functional.specs.BaseGebSpec


class DashboardSpec extends BaseGebSpec {

    //add @spock.lang.IgnoreRest
    //if you want to run just a single test
    //remove it and it will run all the tests in here

    def "Verify signing in correctly will display dashboard page with success message"() {
        given:
        to DashboardPage

        expect:
        waitFor { at DashboardPage }

        when:
        
        username = "a@a.com"
        password = "Password1"
        signInButton.click()

        then:
        waitFor { at DashboardPage }

        and:
        DashboardModule.success == "success"
        print(driver.currentUrl)

    }

    def "Verify error if user does not a provide username and password"() {
        given:
        to DashboardPage

        expect:
        waitFor { at DashboardPage }

        when:
        username = ""
        password = ""
        signInButton.click()

        then:
        waitFor { at DashboardPage }

        and:
        DashboardModule.success != "success"
        DashboardModule.usernameRequired.contains('required')
        DashboardModule.passwordRequired.contains('required')

    }

    def "Verify error if user provides a username but no password"() {
        given:
        to DashboardPage

        expect:
        waitFor { at DashboardPage }

        when:
        username = "a@a.com"
        password = ""
        signInButton.click()

        then:
        waitFor { at DashboardPage }

        and:
        DashboardModule.success != "success"
        DashboardModule.passwordRequired.contains('required')

    }

    def "Verify error if user provides a username that is not an email address"() {
        given:
        to DashboardPage

        expect:
        waitFor { at DashboardPage }

        when:
        username = "foo"
        password = "bar"
        signInButton.click()

        then:
        waitFor { at DashboardPage }

        and:
        DashboardModule.success != "success"
        DashboardModule.loginError == "Not a valid e-mail address"

    }

    def "Verify error if user provides email address as username and fake password"() {
        given:
        to DashboardPage

        expect:
        waitFor { at DashboardPage }

        when:
        username = "foo@foo.com"
        password = "foo"
        signInButton.click()

        then:
        waitFor { at DashboardPage }

        and:
        DashboardModule.success != "success"
        DashboardModule.invalidLogin == "error"

    }

    def "Verify error if username longer than 60 characters"() {
        given:
        to DashboardPage

        expect:
        waitFor { at DashboardPage }

        when:
        username = "marshall@abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.com"
        password = "foo"
        signInButton.click()

        then:
        waitFor { at DashboardPage }

        and:
        DashboardModule.userNameMax =~ "exceeds the maximum"
        
    }


    
}
