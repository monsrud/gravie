/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

private void downloadDriver(File file, String path) {
    if (!file.exists()) {
        def ant = new AntBuilder()
        ant.get(src: path, dest: 'driver.zip')
        ant.unzip(src: 'driver.zip', dest: file.parent)
        ant.delete(file: 'driver.zip')
        ant.chmod(file: file, perm: '700')
    }
}

private static File downloadChromeDriver() {
    final VERSION = '81.0.4044.69'
    final OS = System.properties['os.name'].toLowerCase()
    final EXTENSION = OS.contains('windows') ? '.exe' : ''
    File chromeDriver = new File("test/drivers/chrome/chromedriver${VERSION.replaceAll('\\.', '')}${EXTENSION}")

    if (!chromeDriver.exists()) {
        String path
        if (OS.contains('windows')) {
            path = "http://chromedriver.storage.googleapis.com/${VERSION}/chromedriver_win32.zip"
        } else if (OS.contains('linux')) {
            path = "http://chromedriver.storage.googleapis.com/${VERSION}/chromedriver_linux64.zip"
        } else {
            path = "http://chromedriver.storage.googleapis.com/${VERSION}/chromedriver_mac64.zip"
        }
        AntBuilder ant = new AntBuilder()
        ant.get(src: path, dest: 'driver.zip')
        ant.unzip(src: 'driver.zip', dest: chromeDriver.parent)
        ant.delete(file: 'driver.zip')
        ant.move(file: new File(chromeDriver.parent + "/chromedriver${EXTENSION}"), toFile: chromeDriver)
        ant.chmod(file: chromeDriver, perm: '700')
    }

    return chromeDriver
}

driver = {
    File chromeDriver = downloadChromeDriver()
    System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)

    ChromeOptions options = new ChromeOptions()
    def driverInstance = new ChromeDriver(options)
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
