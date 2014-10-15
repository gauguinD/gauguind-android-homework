package com.naver.main;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;

import com.naver.main.Utilities;
import com.naver.main.*;

public class Modules {
	
	public final String mainURL = "http://m.naver.com/";
	public final String mainTitle = "NAVER";
	
	public final String mkinURL = "http://qa.m.kin.naver.com/";
	public final String mkinTitle = "네이버 지식iN";
	
	public final String kinURL = "http://kin.naver.com/";
	public final String kinTitle = "네이버 지식iN";
	
	//public final String searchURL = "http://m.search.naver.com/search.naver?query=&where=m.kin&sm=msv_hty";
	//public final String searchTitle = ": 네이버 통합검색";

	
	public final String ID = "nvqa_kin20";
	public final String PW = "!23wltlrdls";
	public CharSequence searchTitle;	
	
	public void 로그인(Utilities util, String ID, String Password) throws Exception {

		//if (util.getCapabilities().getVersion().equals("16"))
		//util.type(By.linkText("로그인"), " ");
		util.clickAndWait(By.linkText("로그인"));
		
		//util.findElement(By.id("id")).sendKeys(ID);
		//util.findElement(By.id("pw")).sendKeys(Password);		
		
		util.type(By.id("id"), ID);
		util.type(By.id("pw"), Password);
		util.waitAndClick(By.className("int_jogin"));
		
		assertNotNull (util.waitForIsElementPresent(By.linkText("로그아웃")));
	}	
}