/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities

private void downloadDriver(File file, String path) {
    if (!file.exists()) {
        def ant = new AntBuilder()
        ant.get(src: path, dest: 'driver.zip')
        ant.unzip(src: 'driver.zip', dest: file.parent)
        ant.delete(file: 'driver.zip')
        ant.chmod(file: file, perm: '700')
    }
}

driver = {
    def chromeDriver = new File("test/drivers/chrome/chromedriver${System.properties['os.name'].toLowerCase().contains('windows') ? '.exe' : ''}")

    if (System.properties['os.name'].toLowerCase().contains('windows')) {
        downloadDriver(chromeDriver, "http://chromedriver.storage.googleapis.com/2.20/chromedriver_win32.zip")
    } else if (System.properties['os.name'].toLowerCase().contains('linux')) {
        downloadDriver(chromeDriver, "http://chromedriver.storage.googleapis.com/2.20/chromedriver_linux64.zip")
    } else {
        downloadDriver(chromeDriver, "http://chromedriver.storage.googleapis.com/2.20/chromedriver_mac32.zip")
    }
    System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)

    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    def driverInstance = new ChromeDriver(capabilities)
    driverInstance.manage().window().setSize(new Dimension(1280, 1024))
    driverInstance
}
baseUrl = "${System.getenv("BASE_URL") ?: (System.getProperty("baseUrl") ?: "http://localhost:8006/gravie-sdet-test")}/"
reportsDir = "target/geb-reports"
environments {
    // run as “grails -Dgeb.env=chrome test-app”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = {
            new ChromeDriver()
        }
    }
}

waiting {
    timeout = 10
    retryInterval = 0.5

    presets {
        slow {
            timeout = 20
            retryInterval = 1
        }
        quick {
            timeout = 1
        }
    }
}
