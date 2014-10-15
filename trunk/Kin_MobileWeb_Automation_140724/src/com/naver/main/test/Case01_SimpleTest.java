package com.naver.main.test;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.naver.main.Testcase;

public class Case01_SimpleTest extends Testcase{
	
	@Test
	public void simpletest01() throws Exception {
		
				
		util.type(By.name("query"), "Test");
		util.clickAndWait(By.className("sch_submit"));
		System.out.println(util.getCapabilities().getPlatform());
		
	}

}
