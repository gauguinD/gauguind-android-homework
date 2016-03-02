package com.naver.calendar;

import com.naver.main.TestIds;
import com.naver.main.Testcase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class suite_03_calendar extends Testcase {

    public String Title = null;
    public String URL = null;
    public String Subname = null;
    public String dataValue = null;

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
    public void TC_03_New_calendar_public_Test() throws Exception{
        util.clickAndWait(By.className("btn_makecal"));
        util.clickAndWait(By.partialLinkText("내 캘린더 만들기"));

        Subname = util.findElement(By.id("$$_calendar_name")).getAttribute("value").toString();
        util.printLog(Subname);

        util.clickAndWait(By.xpath("//button[@class ='_save normal']"));

        //캘린더 목록의 캘린더 갯수 가져오기
        int NumberOfCalender = util.waitAndGetXpathCount(By.className("cal_name"));
        System.out.print("캘린더 목록의 갯수 가져오기 :" + NumberOfCalender);

        //생성한 캘린더의 이름과 dataValue를 가져오기
        //dataValue = util.findElement(By.xpath("//a[contains(text(),'"+Subname+"')]")).getAttribute("data-value").toString();
        //util.printLog("dataValue 값 입니다"+dataValue);

        //dataValue = util.findElement(By.xpath("//a[@class='_calendar_name' and contains(text(),'"+Subname+"')]")).getAttribute("data-value");
        //util.printLog("dataValue 값 입니다"+dataValue);


        //생성된 캘린더가 있는지 캘린더 목록에서 확인한다
        for(int i=1; i <= NumberOfCalender; i++)
        {
            String SubTemp;
            SubTemp = util.findElement(By.xpath("//*[@id='calendar_list_container']/div[2]/ul/li["+i+"]/a[2]")).getAttribute("title").toString();

            if(SubTemp.contentEquals(Subname))
            {
                util.printLog("True");
                dataValue = util.findElement(By.xpath("//*[@id='calendar_list_container']/div[2]/ul/li["+i+"]")).getAttribute("calendarid");
                util.printLog(dataValue);
            }
            else
            {
                util.printLog("Fail");
            }
            //*[@id="calendar_list_container"]/div[2]/ul/li[1]
            //*[@id="calendar_list_container"]/div[2]/ul/li[5]
        }
    }

    @Test
    public void TC_04_Delete_calendar_Test() throws Exception{
        util.clickAndWait(By.className("btn_settingcal"));
        util.printLog(util.findElement(By.xpath("//div[@class='_calendar_name' and contains(data-value, '"+dataValue+"']")).toString());

        //*[@id="holder"]/div/div[2]/div[1]/div/div[2]/table[2]/tbody/tr[4]
        //*[@id="holder"]/div/div[2]/div[1]/div/div[2]/table[2]/tbody/tr[4]/td[5]/div/a

       /* util.clickAndWait(By.xpath("//button[@class ='_save normal']"));

        for(int i=1; i<9; i++)
        {
            String SubTemp;
            SubTemp = util.findElement(By.xpath("//*[@id='calendar_list_container']/div[2]/ul/li["+i+"]/a[2]")).getAttribute("title").toString();
            util.printLog(SubTemp);
            util.printLog(Subname);
            if(SubTemp.contentEquals(Subname))
            {
                util.printLog("True");
            }
            else
            {
                util.printLog("Fail");
            }
            //*[@id="calendar_list_container"]/div[2]/ul/li[1]
            //*[@id="calendar_list_container"]/div[2]/ul/li[5]
        }
        */
    }


    //@Test
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
