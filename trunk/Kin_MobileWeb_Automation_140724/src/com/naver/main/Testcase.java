
package com.naver.main;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.naver.main.Capabilities;
import com.naver.main.Modules;
import com.naver.main.Utilities;

public class Testcase {
	
	public Utilities util;
	public DesiredCapabilities capability;
	public static final Modules module = new Modules();
	
	@Parameters({"browser"})
	@BeforeClass
	public void setupClass (String browser) throws Exception {

		try {
			capability = Capabilities.gridSetUp(browser);		
			util = new Utilities(capability);

			util.openAndWait(module.mkinURL);
			
		}
		catch (UnreachableBrowserException ue){
			System.out.println(" ** setupClass catch UnreachableBrowserException");
			//ue.printStackTrace();
			tearDownClass();
		}
		catch (WebDriverException we) {
			System.out.println(" ** setupClass catch WebDriverException");
			//we.printStackTrace();
			tearDownClass();
		}

		//util.windowMaximize();
		util.printLog("Start Suite : " + util.printClassName(this));
	}
	
	//@AfterMethod
	 public void afterScreenShot(ITestResult result) throws Exception {
		
		util.captureScreen(result);
	} 
	
	//@BeforeMethod (alwaysRun=true)
	 public void beforeScreenShot() throws Exception {
		
		util.captureScreen();
	}
	
	@AfterClass
	public void tearDownClass(){
		
		try {
			util.quit();
		}
		catch (WebDriverException we) {
			System.out.println(" ** tearDownClass catch WebDriverException");
		}
		util.printLog("Quit Suite : " + util.printClassName(this));
		//util.close();
	}
}
