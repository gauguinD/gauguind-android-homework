package first;

import static org.junit.Assert.*;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.*;
//import java.util.regex.Pattern;



public class script_01_defaultSelenium {
		private Selenium selenium;
		String keyword[] = {"button","salomon","sims"};
		
		@Before
		public void setUp() throws Exception {
			selenium = new DefaultSelenium("localhost", 4444, "firefox", "http://www.naver.com/");
			selenium.start();
			selenium.windowMaximize();
			selenium.selectFrame("relative=top");
		}

		@Test
		public void testUntitled() throws Exception {
			selenium.open("/");
			/*selenium.open("/");
			Thread.sleep(3000);
			selenium.type("id=query","button");
			Thread.sleep(3000);
			selenium.click("id=search_btn");
			Thread.sleep(3000);
			*/

			for(int i=0; i < keyword.length; i++){
				
				waitAndType("id=query",keyword[i]);
				selenium.click("id=search_btn");
				
				String title = selenium.getTitle();
				String url = selenium.getLocation();
				
				System.out.println("title = " + title);
				System.out.println("url = " + url);
			
				waitForTextPresent(keyword[i]+" : 네이버 통합검색");
				assertTrue(url.contains("search.naver"));
			}
			
			selenium.goBack();
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

