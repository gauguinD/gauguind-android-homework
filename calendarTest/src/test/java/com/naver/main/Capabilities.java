package com.naver.main;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class Capabilities {

	public static DesiredCapabilities gridSetUp(String browser)
			throws MalformedURLException {
		DesiredCapabilities capability = null;

		// ****************** firefox Capabilities
		if (browser.equalsIgnoreCase("firefox")) {
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
		}

		// ****************** chrome Capabilities
		if (browser.equalsIgnoreCase("chrome")) {
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
		}

		// ****************** safari Capabilities
		if (browser.equalsIgnoreCase("safari")) {
			capability = DesiredCapabilities.safari();
			capability.setBrowserName("safari");
			capability.setPlatform(Platform.ANY);
		}

		// ****************** IE Capabilities
		if (browser.equalsIgnoreCase("IE11")) {
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("IE11");
			capability.setPlatform(Platform.ANY);
			capability.setVersion("11");
		}

		return capability;
	}
}
