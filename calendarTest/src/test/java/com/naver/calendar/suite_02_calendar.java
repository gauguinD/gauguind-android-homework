package com.naver.calendar;

import com.naver.main.TestIds;
import com.naver.main.Testcase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class suite_02_calendar extends Testcase {

    public String Title = null;
    public String URL = null;

    /*
     * Step : GNB > NAVER 클릭
     * Result : 네이버 페이지로 이동됨
     * URL : http://m.naver.com"
     */
    //@Test
    public void TC_01_GNB_NAVER_Test() throws Exception {

        util.clickAndWait(By.className("naver"));

        Title = util.getTitle();
        URL = util.getCurrentUrl();

        util.printLog("[Title] : " + Title);
        util.printLog("[URL] : " + URL);

        assertTrue(Title.contains(module.mainTitle));
        assertTrue(URL.contains(module.mainURL));

    }

    @Test
    public void TC_02_Login_Test() throws Exception{
        module.로그인(util, TestIds.CalUser.getId(),TestIds.CalUser.getPw());

        /*util.clickAndWait(By.className("btn_inner"));
        util.waitForTitle("네이버 : 로그인");
        util.clearAndType(By.id("id"),TestIds.CalUser.getId());
        util.clearAndType(By.id("pw"),TestIds.CalUser.getPw());
        util.clickAndWait(By.className("int_jogin"));
        util.waitForTitle("일정 : 네이버 캘린더");*/

        //Title = util.getTitle();
        //assertTrue(URL.contains(module.CalTitle));
    }

    @Test
    public void TC_03_NewcalendarEvent_Time_Test() throws Exception{
        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        //util.clickAndWait(By.xpath("//a[@class='_set_timezone change_time']"));
        if((util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }

        util.waitForIsElementPresent(By.xpath("//*[@id='holder']/div/div[1]/a[2]"));
        //제목 입력
        util.findElement(By.id("tx0_0")).sendKeys(module.contents);
        //시작 날짜 입력
        util.findElement(By.id("start_date")).clear();
        util.findElement(By.id("start_date")).sendKeys(module.StartDate);
        //종료 날짜 입력
        util.findElement(By.id("end_date")).clear();
        util.findElement(By.id("end_date")).sendKeys(module.EndDate);

        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }

    @Test
    public void TC_04_NewcalendarEvent_Day_Test() throws Exception{
        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));

        if(!(util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }

        util.waitForIsElementPresent(By.xpath("//*[@id='holder']/div/div[1]/a[2]"));
        util.findElement(By.id("tx0_0")).sendKeys(module.contents);

        //util.clickAndWait(By.id("start_date"));

        util.findElement(By.id("start_date")).clear();
        util.findElement(By.id("start_date")).sendKeys(module.StartDate);
        //util.clickAndWait(By.id("end_date"));

        util.findElement(By.id("end_date")).clear();
        util.findElement(By.id("end_date")).sendKeys(module.EndDate);

        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }

    //@Test
    public void TC_04_AssertEvent_Test() throws Exception {
        URL = module.CalURL+"#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\""+module.StartDate+"\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]"));
        util.clickAndWait(By.xpath("//a[contains(text(),'"+module.contents+"')]"));

        util.waitForIsElementPresent(By.className("_modify_text"));
        //System.out.println("End");

    }

}
