package first;

//import static org.junit.Assert.*;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.*;
//import java.util.regex.Pattern;



public class script_02_mynext {
		private Selenium selenium;
		//private String keyword[] = {"button","salomon","sims"};
		private String id = "gauguind";
		private String password = "gauguin13";
		private String url;
		
		
		
		@Before
		public void setUp() throws Exception {
			selenium = new DefaultSelenium("localhost", 4444, "firefox", "http://www.naver.com/");
			selenium.start();
			selenium.windowMaximize();
			selenium.selectFrame("relative=up");
			
		}

		@Test
		public void testUntitled() throws Exception {

			selenium.open("/");
			this.waitAndType("id=id", id);
			this.waitAndType("id=pw", password);
			selenium.click("//input[@class='btn_login']");
			
			Thread.sleep(5000);
			selenium.click("//a[@id='svc.kin']");
			
			this.waitForNewWindow();
			url = selenium.getTitle();
			System.out.println("url:"+url);
	
			
			
		}

		
		public boolean waitForNewWindow() throws Exception{
			for(int i=0; i<5; i++){
				String title[] = selenium.getAllWindowTitles();
				if(title.length > 1){
					selenium.selectPopUp(title[1]);
					return true;
				}
				Thread.sleep(3000);
			}
			System.out.println("Not found new window");
			return false;
		}
		
		public boolean waitForElementPresent (String locator) throws Exception{
			
			for(int i=0; i<5; i++){
				if(selenium.isElementPresent(locator))
					return true;
					Thread.sleep(1000);
			}
			System.out.println(locator+"not found");
			return false;
		}
		
		public boolean waitForTextPresent (String text) throws Exception{
			
			for(int i=0; i<5; i++){
				if(selenium.isElementPresent(text))
					return true;
					Thread.sleep(1000);
			}
			System.out.println(text+"not found");
			return false;
		}
		
		public void waitAndType ( String locator, String Char) throws Exception{
			if(this.waitForElementPresent(locator))
			selenium.type(locator, Char);
		}
		
		@After
		public void tearDown() throws Exception {
			selenium.stop();
		}
	}

