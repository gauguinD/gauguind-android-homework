package com.naver.main.kin.s02_내소식;


import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naver.main.Capabilities;
import com.naver.main.Modules;
import com.naver.main.TestIds;
import com.naver.main.Utilities;

public class suite_01_내소식_프로필_Test {

	public Utilities util = null;
	public DesiredCapabilities capability = null;
	public static final Modules module = new Modules();
	
	public String Title = null;
	public String URL = null;
	
	public String SubTitle = null;
	
	public String Nickname = null;
	public String ID = null;
	public String Grade = null;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setupClass (String browser) throws Exception {
 
		capability = Capabilities.gridSetUp(browser);
		util = new Utilities(capability);
		//util.get(module.mkinURL);
		util.openAndWait(module.mkinURL);

		module.로그인(util, module.ID, module.PW);
		}
	/*
	@AfterClass
	public void tearDownClass(){
		
		//util.close();
		util.quit();
	}
	
	@AfterMethod (alwaysRun=true)
	 public void afterScreenShot(ITestResult result) throws Exception {
		
		util.captureScreen(result);
	}
	
	@BeforeMethod (alwaysRun=true)
	 public void beforeScreenShot() throws Exception {
		
		util.captureScreen();
	}
	*/
	
	/* 
	 * Step : 내소식 > 프로필 정보 확인
	 * Result : 확인 창이 노출되고, 확인창에서 확인 클릭시 새질문 > 전체로 이동
	 * URL : http://m.kin.naver.com/mobile/qna/questionList.nhn
	 */
	@Test
	public void TC_01_내소식_프로필정보_Test() throws Exception {
		
		util.clickAndWait(By.linkText("내소식"));
		
		ID = util.findElementByClassName("prfl_id").getText();
		Nickname = util.findElementByClassName("name").getText();
		Grade = util.findElementByClassName("sum").getText();
		
		util.printLog("ID : "+ID);
		util.printLog("Nickname : "+Nickname);
		util.printLog("Grade : "+Grade);
		
		assertTrue(ID.contains(module.ID));
	}

	/* 
	 * Step : 내소식 > 사용자 정보 펼치기
	 * Result : 사용자 정보 펼쳐짐
	 * 			 펼치기(∨) 아이콘으로 변경
	 */

	@Test
	public void TC_02_내소식_사용자정보펼치기_Test() throws Exception {

//		util.clickAndWait(By.className("ic"));
		util.clickAndWait(By.xpath("//*[@id='ct']/div/div[1]/div/div/div[1]/button"));
		util.waitForIsVisible(By.className("guide"));
	}

	/* 
	 * Step : 프로필 > 사용자 정보 접기
	 * Result : 사용자 정보 접힘
	 * 			 접기(∧) 아이콘으로 변경
	 */

	@Test
	public void TC_03_내소식_사용자정보접기_Test() throws Exception {

		//util.clickAndWait(By.className("ic"));
		//util.clickAndWait(By.linkText("등급업 가이드"));
		util.clickAndWait(By.xpath("//*[@id='ct']/div/div[1]/div/div/div[1]/button"));
		util.waitForIsVisible(By.className("guide"));
	}

	/* 
	 * Step : 내소식_내소식_Test
	 * Result : 내소식 > 내소식 클릭하면 해당 엔드로 이동됨
	 */

	@Test
	public void TC_04_내소식_내소식_Test() throws Exception {

		//SubTitle = util.findElement(By.xpath("//*[@id='ct']/div/div[2]/div/div[1]/ul/li[1]/a/strong/text()")).getText();
		//SubTitle = util.findElementByClassName("lst _messageList _params('1,1')").findElement(By.className("lnk_lst")).findElement(By.className("tit")).getText();		
		//SubTitle = util.findElement(By.className("lst _messageList _params('1,1')")).toString();
		
		util.clickAndWait(By.xpath("//*[@id='ct']/div/div[2]/div/div[1]/ul/li[1]/a/strong"));
		//util.waitForIsVisible(By.className("btn3 btn_q _ros _writeQuestion"));
			
		Title = util.getTitle();
		URL = util.getCurrentUrl();
		
		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);
		
		//util.clickAndWait(By.className("btn_pv _prev"));
		util.goBackAndWait();
	}
	
	/* 
	 * Step : 내소식 > X 버튼 클릭
	 * Result : 내소식 > X버튼 클릭하면 해당 소식 삭제됨
	 */

	@Test
	public void TC_05_내소식_X버튼_Test() throws Exception {

		//util.printLog(SubTitle);
		util.waitForIsVisible(By.xpath("//*[@id='ct']/div/div[2]/div/div[1]/ul/li/button"));
	}
	
	/* 
	 * Step : Footer > 오류신고 클릭
	 * Result : 내소식 > 지난소식 더보기 클릭
	 * 지난 소식이 있을경우 지난소식 더 노출 됨
	 */

	@Test
	public void TC_06_내소식_지난소식더보기_Test() throws Exception {

		util.clickAndWait(By.className("u_pg_txt"));
		util.waitForIsVisible(By.xpath("//*[@id='ct']/div/div[2]/div/div[13]/ul/li[1]/a"));
	}
	
	/* 
	 * Step : 내소식 > TOP 클릭
	 * Result : 내소식 > TOP 클릭
	 * 최상단으로 플리킹 됨
	 */

	@Test
	public void TC_07_내소식_TOP() throws Exception {

		//util.clickAndWait(By.className("u_pg_top more_top"));
		util.clickAndWait(By.linkText("맨위로"));
		//util.waitForIsVisible(By.className("aff"));
	}
}
