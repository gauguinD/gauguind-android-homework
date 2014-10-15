package com.naver.main.kin.s01_지식iN홈;


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
import com.naver.main.Testcase;
import com.naver.main.Utilities;

public class suite_03_지식iN홈_Footer_Test extends Testcase{

	public Utilities util = null;
	public DesiredCapabilities capability = null;
	public static final Modules module = new Modules();
	
	public String Title = null;
	public String URL = null;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setupClass (String browser) throws Exception {
 
		capability = Capabilities.gridSetUp(browser);
		util = new Utilities(capability);
		util.get(module.mkinURL);
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
	 * Step : Footer > 로그아웃 클릭	
	 * Result : 확인 창이 노출되고, 확인창에서 확인 클릭시 새질문 > 전체로 이동
	 * URL : http://m.kin.naver.com/mobile/qna/questionList.nhn
	 */
	@Test
	public void TC_01_Footer_로그아웃_Test() throws Exception {
		
		util.chooseCancelOnNextConfirmation();
		util.clickAndWait(By.linkText("로그아웃"));
		
		//assertNotNull (util.waitForIsElementPresent(By.linkText("로그인")));
		}

	/* 
	 * Step : Footer > PC버전 클릭
	 * Result : PC버전 지식iN 화면으로 이동됨
	 * URL : http://kin.naver.com/qna/list.nhn?mobile
	 */

	@Test
	public void TC_02_Footer_PC버전_Test() throws Exception {

		util.clickAndWait(By.linkText("PC버전"));
		util.waitForIsVisible(By.id("snb_wrap"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (Title.contains(module.kinTitle));
		assertTrue (URL.contains(module.kinURL));

		util.goBackAndWait();
	}

	/* 
	 * Step : Footer > 전체앱 클릭
	 * Result : 전체서비스 > 모바일앱 페이지로 이동됨
	 * URL : http://m.naver.com/services.html?t=app
	 */

	@Test
	public void TC_03_Footer_전체앱_Test() throws Exception {

		util.clickAndWait(By.linkText("전체 앱"));
		util.waitForIsVisible(By.className("hdg_t"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("services.html?t=app"));

		util.goBackAndWait();
	}

	/* 
	 * Step : Footer > 전체서비스 클릭
	 * Result : 전체서비스 > 모바일웹 페이지로 이동됨
	 * URL : http://m.naver.com/services.html?f=svc.kin
	 */

	@Test
	public void TC_04_Footer_전체서비스_Test() throws Exception {

		util.clickAndWait(By.linkText("전체서비스"));
		util.waitForIsVisible(By.className("hdg_t"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("services.html?f=svc.kin"));

		util.goBackAndWait();
	}
	
	/* 
	 * Step : Footer > 지식iN고객센터 클릭
	 * Result : 고객센터 > 지식iN 고객센터로 이동됨
	 * URL : https://m.help.naver.com/support/service/main.nhn?serviceNo=5638
	 */

	@Test
	public void TC_05_Footer_지식iN고객센터_Test() throws Exception {

		util.clickAndWait(By.xpath("//*[@id='footer']/p[2]/span[1]/a"));
		//util.clickAndWait(By.linkText("지식iN 고객센터"));
		util.waitForIsVisible(By.className("lst_tit243"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("service/main.nhn?serviceNo=5638"));

		util.goBackAndWait();
	}
	
	/* 
	 * Step : Footer > 오류신고 클릭
	 * Result : 고객센터 > 오류신고 화면으로 이동됨
	 * URL : https://m.help.naver.com/support/issue/report.nhn?serviceNo=5638
	 */

	@Test
	public void TC_06_Footer_오류신고_Test() throws Exception {

		//util.clickAndWait(By.linkText("오류신고"));
		util.clickAndWait(By.xpath("//*[@id='footer']/p[2]/span[2]/a"));
		util.waitForIsVisible(By.className("btn_help_go"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("issue/report.nhn?serviceNo=5638"));

		util.goBackAndWait();
	}
	
	/* 
	 * Step : Footer > NHN Corp. 클릭
	 * Result : nhn 회사 홈페이지로 이동됨
	 * URL : http://www.nhncorp.com/nhn/index.nhn
	 */

	@Test
	public void TC_07_Footer_NHN_Test() throws Exception {

		//util.clickAndWait(By.linkText("NAVER Corp."));
		util.clickAndWait(By.xpath("//*[@id='footer']/p[3]/span/a"));
		util.waitForIsVisible(By.className("aff"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("http://www.navercorp.com/ko/index.nhn"));

		util.goBackAndWait();
	}
	
	/* 
	 * Step : Footer > 네이버앱의 지식iN홈화면에 바로가기 추가 클릭
	 * Result : 지식iN 단축메뉴 생성
	 * 홈 화면에 바로가기가 생성됩니다. 토스트 메시지 노출
	 */

	/*
	@Test
	public void TC_08_Footer_바로가기_Test() throws Exception {

		util.clickAndWait(By.linkText("새질문"));
		util.waitForIsVisible(By.className("hdn hdn_v2"));

		Title = util.getTitle();
		URL = util.getCurrentUrl();

		util.printLog("[Title] : " + Title);
		util.printLog("[URL] : " + URL);

		assertTrue (URL.contains("questionList.nhn"));

		util.goBackAndWait();
	}
	*/
}
