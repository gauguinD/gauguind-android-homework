package com.naver.main.kin.s01_지식iN홈;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.naver.main.Modules;
import com.naver.main.Utilities;
import com.naver.main.Testcase;

public class suite_02_지식iN홈_LNB_Test extends Testcase{
	
	public String Title = null;
	public String URL = null;
	
	/* 
	 * Step : LNB > 홈 탭 클릭	
	 * Result : 지식iN > 지식iN 홈으로 이동됨
	 * URL : http://m.kin.naver.com/mobile/index.nhn
	 */

	@Test
	public void TC_01_LNB_홈_Test() throws Exception {
		
		util.clickAndWait(By.linkText("홈"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		assertTrue (Title.contains(module.mkinTitle));
		assertTrue (URL.contains(module.mkinURL));
	}
	
	/* 
	 * Step : LNB > 내소식 탭 클릭	
	 * Result : 지식iN > 지식iN 홈으로 이동됨
	 * URL :http://m.kin.naver.com/mobile/mykin/messageList.nhn
	 */

	@Test
	public void TC_02_LNB_내소식_Test() throws Exception {
		
		util.clickAndWait(By.linkText("내소식"));
		util.waitForIsVisible(By.className("int_jogin"));
		
		module.로그인(util, module.ID, module.PW);
		
		//util.findElement(By.id("id")).sendKeys(module.ID);
		//util.findElement(By.id("pw")).sendKeys(module.PW);		
		//util.waitAndClick(By.className("int_jogin"));		
		util.clickAndWait(By.linkText("홈"));
	}
	
	/* 
	 * Step : LNB > 새질문 탭 클릭
	 * Result : 관심분야 / 관심지역 / 관심키워드 / 전체 탭이 노출 됨 
	 * URL : http://m.kin.naver.com/mobile/qna/directoryQuestionList.nhn
	 */
	
	@Test
	public void TC_03_LNB_새질문_Test() throws Exception {
		
		util.clickAndWait(By.linkText("새질문"));
		util.waitForTitle("관심분야 : 지식iN");
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		assertTrue (URL.contains("directoryQuestionList.nhn"));
		
		util.goBackAndWait();
	}
	
	/* 
	 * Step : LNB > 나의Q&A 탭 클릭
	 * Result : 질문/답변/임시저장 탭이 노출 됨
	 * URL : http://m.kin.naver.com/mobile/mykin/myQnaList.nhn
	 */
	
	@Test
	public void TC_04_LNB_나의QA_Test() throws Exception {
		
		util.clickAndWait(By.linkText("나의Q&A"));
		util.waitForTitle("나의 Q&A : 지식iN");
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		assertTrue (URL.contains("myQnaList.nhn"));
		
		util.goBackAndWait();
	}
	
}
