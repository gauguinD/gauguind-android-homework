package com.naver.main.kin.s01_지식iN홈;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.naver.main.Modules;
import com.naver.main.Utilities;
import com.naver.main.Testcase;

public class suite_01_지식iN홈_GNB_Test extends Testcase{
	
	public String Title = null;
	public String URL = null;
	
	/* 
	 * Step : GNB > NAVER 클릭	
	 * Result : 네이버 페이지로 이동됨
	 * URL : http://m.naver.com"
	 */
	@Test
	public void TC_01_GNB_NAVER_Test() throws Exception {
		
		util.clickAndWait(By.className("u_ts_a"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		assertTrue (Title.contains(module.mainTitle));
		assertTrue (URL.contains(module.mainURL));
		
		util.goBackAndWait();
	}
	
	/* 
	 * Step : GNB > 지식iN 클릭
	 * Result : 지식iN > 지식iN 홈으로 이동됨
	 * URL : http://m.kin.naver.com/mobile/index.nhn
	 */
	
	@Test
	public void TC_02_GNB_지식iN_Test() throws Exception {
		
		util.clickAndWait(By.className("u_ts_a2"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		assertTrue (Title.contains(module.kinTitle));
		assertTrue (URL.contains(module.kinURL));
	}
	
	/* 
	 * Step : GNB > 검색버튼 클릭
	 * Result : 지식iN > 지식iN 검색 창 노출 됨
	 * URL : http://m.kin.naver.com/
	 */
	
	@Test
	public void TC_03_GNB_검색_Test() throws Exception {
		
		util.clickAndWait(By.id("u_hsbt"));
		//util.waitForIsVisible(By.linkText("통합검색"));
		//util.clickAndWait(By.linkText("통합검색"));
		util.waitForIsVisible(By.className("u_hsw"));
		util.clickAndWait(By.xpath("//*[@id='u_hs']/div/button[2]"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		//assertTrue (Title.contains(module.searchTitle));
		//assertTrue (URL.contains(module.searchURL));
		
		util.goBackAndWait();
	}
	
}
