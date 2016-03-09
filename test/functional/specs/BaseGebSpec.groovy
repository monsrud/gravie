package specs

import geb.spock.GebSpec
import io.remotecontrol.groovy.client.RemoteControl
import io.remotecontrol.transport.http.HttpTransport
import spock.lang.Shared

abstract class BaseGebSpec extends GebSpec {
    @Shared
    RemoteControl remoteControl

    def setupSpec() {
        remoteControl = newRemoteControl()
    }

    RemoteControl newRemoteControl() {
        remoteControl = new RemoteControl(new HttpTransport("${browser.config.baseUrl}grails-remote-control"))
    }

    def setup() {}

    def cleanupSpec() {}
}
