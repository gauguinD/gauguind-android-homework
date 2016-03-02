package com.naver.main;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Modules {
	
	public final String mainURL = "http://www.naver.com/";
	public final String mainTitle = "NAVER";
	
	public final String CalURL = "http://calendar.naver.com/";
	public final String CalTitle = "일정 : 네이버 캘린더";

	public final String startDateURL = "http://www.convertstring.com/ko/EncodeDecode/UrlDecode";

	public final String StartDate = "2016-02-25";
	public final String EndDate = "2016-02-25";

	public String SubName;

	
	//public final String searchURL = "http://m.search.naver.com/search.naver?query=&where=m.kin&sm=msv_hty";
	//public final String searchTitle = ": 네이버 통합검색";

	//현재시간 구해서 변수로 설정
	//java의 calendar 클래스 이용
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String datetime = sdf1.format(cal.getTime());

	//시스템 타이머 이용
	long systemTime = System.currentTimeMillis();
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String datetime2 = sdf2.format(new Date(systemTime));

	public String contents = "일정 "+datetime;
	
	public final String ID = "nvqa_4tc040";
	public final String PW = "qalab123";
	public CharSequence searchTitle;

	public Modules() {
	}

	public void 로그인(Utilities util, String ID, String Password) throws Exception {

		//if (util.getCapabilities().getVersion().equals("16"))
		//util.type(By.linkText("로그인"), " ");

		util.clickAndWait(By.className("btn_login"));
		util.type(By.id("id"), ID);
		util.type(By.id("pw"), Password);
		util.clickAndWait(By.className("btn_login"));

		/*
		//연락처 입력 화면 노출시 확인 클릭
		if(util.isElementPresent(By.className("spot")).isDisplayed())
		{
			util.clickAndWait(By.className("btn_close"));
			util.switchTo().alert().accept();
		}
		*/
		//assertNotNull (util.waitForIsElementPresent(By.linkText("로그아웃")));
	}

	public void CurrentDate(Utilities util, String Date) throws Exception {
		String a = util.findElement(By.xpath("//*[@id='nav_snb']/div/div[2]/div/div/div/span[1]/span")).toString();
		String b = util.findElement(By.xpath("//*[@id='nav_snb']/div/div[2]/div/div/div/span[1]/span")).toString();
		String c = util.findElement(By.xpath("//*[@id='nav_snb']/div/div[2]/div/div/div/span[1]/span")).toString();
		String d = util.findElement(By.xpath("//*[@id='nav_snb']/div/div[2]/div/div/div/span[1]/span")).toString();
		String e = util.findElement(By.xpath("//*[@id='nav_snb']/div/div[2]/div/div/div/span[1]/span")).toString();
		String F = util.findElement(By.xpath("//*[@id='nav_snb']/div/div[2]/div/div/div/span[1]/span")).toString();
	}
}