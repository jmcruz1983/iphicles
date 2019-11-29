import com.pleo.uitest.Configuration
import org.openqa.selenium.remote.RemoteWebDriver

import static org.openqa.selenium.remote.DesiredCapabilities.chrome

driverUrl = new URL(Configuration.instance.driverURL)

driver = { new RemoteWebDriver(driverUrl, chrome()) }

baseUrl = Configuration.instance.frontEndURL + '/'

waiting {
	timeout = Configuration.instance.waitingTimeout
	retryInterval = 0.5
}

atCheckWaiting = true