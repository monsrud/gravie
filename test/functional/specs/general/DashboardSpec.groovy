package specs.general

import pages.DashboardPage
import specs.BaseGebSpec

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
        message.success == "success"
    }

    //add more test for error handling
}
