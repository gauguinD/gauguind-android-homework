package com.naver.main.kin.s03_새질문;


import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class suite_01_새질문_하위메뉴_Test {

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
	 * Step :  새질문 > 관심분야 클릭
	 * Result : 새질문 > 관심분야로 이동됨
	 * URL : http://m.kin.naver.com/mobile/qna/directoryQuestionList.nhn
	 */
	@Test
	public void TC_01_새질문__관심탭_전체_Test() throws Exception {

		util.clickAndWait(By.linkText("새질문"));
		util.waitForTitle("관심분야 : 지식iN");
		
		util.clickAndWait(By.linkText("전체"));
		util.waitForIsTextPresent("Q&A 전체");

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("questionList.nhn"));
		//SubTitle = util.waitForIsElementPresent(By.className("u_intr _interestManage")).getText();
		//util.printLog(SubTitle);
	}

	/* 
	 * Step : 새질문 > 관심지역 클릭
	 * Result : 새질문 > 관심지역으로 이동됨
	 * URL : http://m.kin.naver.com/mobile/qna/localQuestionList.nhn
	 */

	@Test
	public void TC_02_새질문_관심탭_관심지역_Test() throws Exception {

		util.clickAndWait(By.linkText("관심지역"));
		//util.waitForIsTextPresent("관심지역 전체");
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("localQuestionList.nhn"));
	}

	/* 
	 * Step : 새질문 > 관심키워드 클릭
	 * Result : 새질문 > 관심키워드로 이동됨
	 * URL : http://m.kin.naver.com/mobile/qna/keywordQuestionList.nhn
	 */

	@Test
	public void TC_03_새질문_관심탭_관심키워드_Test() throws Exception {

		util.clickAndWait(By.linkText("관심키워드"));
		//util.waitForIsTextPresent("관심키워드 전체");

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("keywordQuestionList.nhn"));
	}

	/* 
	 * Step : 새질문 > 전체 클릭
	 * Result : 새질문 > 전체로 이동됨
	 * URL : http://m.kin.naver.com/mobile/qna/questionList.nhn
	 */

	@Test
	public void TC_04_새질문_관심탭_전체_Test() throws Exception {

		util.clickAndWait(By.linkText("관심분야"));
		//util.waitForIsTextPresent("관심분야 전체");

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("directoryQuestionList.nhn"));
	}

	/* 
	 * Step : 관심분야 전체창 클릭
	 * Result : 관심분야 목록이 레이어로 노출 됨
	 * 디렉토리 선택
	 */

	@Test
	public void TC_05_새질문_관심분야_전체_Test() throws Exception {

		//util.selectAndWait(By.id("d1Id"),"byText" ,"관심분야 전체" );
		//util.selectAndWait(By.id("d1Id"),"byIndex" ,"6" );
		util.selectAndWait(By.id("choose_directory_manual"), "byValue", "4");
		util.waitForIsSelected(By.linkText("경제"));
		//util.printLog(SubTitle);
	}

	/* 
	 * Step : 관심분야 설정 버튼 클릭
	 * Result : 관심분야 설정으로 이동
	 * URL : http://m.kin.naver.com/mobile/qna/userInterestDirs.nhn
	 */

	@Test
	public void TC_06_새질문_관심분야_설정_Test() throws Exception {
	
		util.clickAndWait(By.className("set"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("userInterestDirs.nhn"));
		util.goBackAndWait();
		//util.clickAndWait(By.className("btn_pv"));
	}

	/* 
	 * Step : 관심키워드 전체창 클릭
	 * Result : 관심키워드 목록이 레이어로 노출 됨
	 * 디렉토리 선택
	 */

	@Test
	public void TC_07_새질문_관심키워드_전체_Test() throws Exception {


		//util.selectAndWait(By.id("d1Id"),"byText" ,"관심분야 전체" );
		//util.selectAndWait(By.id("d1Id"),"byIndex" ,"6" );
		util.selectAndWait(By.id("choose_directory_manual"), "byValue", "아이폰");
		util.waitForIsSelected(By.linkText("아이폰"));
		//util.printLog(SubTitle);
	}

	/* 
	 * Step : 관심키워드 설정 버튼 클릭
	 * Result : 관심키워드 설정으로 이동
	 * URL : http://m.kin.naver.com/mobile/qna/keywordQuestionList.nhn
	 */

	@Test
	public void TC_08_새질문_관심키워드_설정_Test() throws Exception {

		util.clickAndWait(By.className("set"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("keywordQuestionList.nhn"));
		util.goBackAndWait();
		//util.clickAndWait(By.className("btn_pv"));
	}

	/* 
	 * Step : 관심지역 전체창 클릭
	 * Result : 관심지역 목록이 레이어로 노출 됨
	 * 디렉토리 선택
	 */
	
	@Test
	public void TC_09_새질문_관심지역_전체_Test() throws Exception {


		//util.selectAndWait(By.id("d1Id"),"byText" ,"관심분야 전체" );
		//util.selectAndWait(By.id("d1Id"),"byIndex" ,"6" );
		util.selectAndWait(By.id("choose_directory_manual"), "byValue", "dirId=0&poiId=0");
		util.waitForIsSelected(By.linkText("관심지역 전체"));

		//util.printLog(SubTitle);
	}

	/* 
	 * Step : 관심지역 설정 버튼 클릭
	 * Result : 관심지역 설정으로 이동
	 * URL : http://m.kin.naver.com/mobile/qna/keywordQuestionList.nhn
	 */

	@Test
	public void TC_10_새질문_관심지역_설정_Test() throws Exception {

		util.clickAndWait(By.className("set"));
		
		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("keywordQuestionList.nhn"));
		util.goBackAndWait();
		//util.clickAndWait(By.className("btn_pv"));
	}
	/* 
	 * Step : Footer > 오류신고 클릭
	 * Result : 내소식 > 지난소식 더보기 클릭
	 * 지난 소식이 있을경우 지난소식 더 노출 됨
	 */

	@Test
	public void TC_06_새질문_전체_펼치기_Test() throws Exception {

		//util.clickAndWait(By.className("u_pg_txt"));
		//util.waitForIsVisible(By.xpath("//*[@id='ct']/div/div[2]/div/div[13]/ul/li[1]/a"));
	}

	/* 
	 * Step : 내소식 > TOP 클릭
	 * Result : 내소식 > TOP 클릭
	 * 최상단으로 플리킹 됨
	 */

	@Test
	public void TC_07_내소식_TOP() throws Exception {

		//util.clickAndWait(By.className("u_pg_top more_top"));
		//util.clickAndWait(By.linkText("맨위로"));
		//util.waitForIsVisible(By.className("aff"));
	}
}
