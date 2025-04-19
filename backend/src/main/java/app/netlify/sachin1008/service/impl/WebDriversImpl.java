package app.netlify.sachin1008.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.stereotype.Service;

import app.netlify.sachin1008.service.WebDrivers;
import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class WebDriversImpl implements WebDrivers{

	@Override
	public WebDriver getChromeDriver() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless"); // Run in headless mode
		options.addArguments("--disable-gpu"); // Optional: disables GPU usage
		options.addArguments("--window-size=1920,1080"); // Optional: sets window size

		WebDriver driver = new EdgeDriver(options);
		return driver;
	}

}
