@java.lang.SuppressWarnings(['Println', 'ClosureAsLastMethodParameter'])
import grails.util.Environment

grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.reload.enabled = true

def port = 8005
if (Environment.TEST == Environment.currentEnvironment) {
    port = 8006
}

grails.server.port.http = port


grails.project.dependency.resolver = "maven"

grails.project.dependency.resolution = {
    def seleniumVersion = "3.141.59"
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false
    // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        grailsCentral()

        mavenLocal()
        mavenCentral()

        //for grails export 1.6 plugin
        mavenRepo "http://repo.grails.org/grails/core"
    }

    dependencies {
        test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion") {}
        test("org.seleniumhq.selenium:selenium-support:$seleniumVersion")
        test("org.gebish:geb-spock:2.3.1")
    }

    plugins {
        build ":tomcat:8.0.33"
        test ":geb:1.0"
        test ":remote-control:2.0"
    }

}
