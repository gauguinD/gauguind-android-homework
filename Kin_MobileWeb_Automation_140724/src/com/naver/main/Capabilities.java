package com.naver.main;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

	public static DesiredCapabilities gridSetUp(String browser)
			throws MalformedURLException {
		DesiredCapabilities capability = null;

		// ****************** iPhone Capabilities
		if (browser.equalsIgnoreCase("iPhone")) {
			capability = DesiredCapabilities.iphone();
			capability.setBrowserName("iPhone");
			capability.setPlatform(Platform.ANY);
			// capability.setVersion("6.1");
			capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		}

		// ****************** iPad Capabilities
		if (browser.equalsIgnoreCase("iPad")) {
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("iPad");
			capability.setPlatform(Platform.ANY);
			capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		}

		// ****************** GalaxyS4 Capabilities
		if (browser.equalsIgnoreCase("galaxy_s4")) {
			capability = DesiredCapabilities.android();
			capability.setBrowserName("galaxy_s4");
			capability.setPlatform(Platform.ANDROID);
			capability.setVersion("19");
		}

		// ****************** GalaxyS4 Capabilities
		if (browser.equalsIgnoreCase("Nexus5")) {
			capability = DesiredCapabilities.android();
			capability.setBrowserName("Nexus5");
			capability.setPlatform(Platform.ANDROID);
			capability.setVersion("19");
		}

		// ****************** GalaxyS4 Capabilities
		if (browser.equalsIgnoreCase("galaxy_note2")) {
			capability = DesiredCapabilities.android();
			capability.setBrowserName("galaxy_note2");
			capability.setPlatform(Platform.ANDROID);
			capability.setVersion("18");
		}

		// ****************** GalaxyS4 Capabilities
		if (browser.equalsIgnoreCase("galaxy_s3")) {
			capability = DesiredCapabilities.android();
			capability.setBrowserName("galaxy_s3");
			capability.setPlatform(Platform.ANDROID);
			capability.setVersion("17");
		}

		return capability;
	}
}
