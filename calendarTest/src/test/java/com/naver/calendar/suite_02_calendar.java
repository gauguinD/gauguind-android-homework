package com.naver.calendar;

import main.TestIds;
import main.Testcase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class suite_02_calendar extends Testcase {

    public String Title = null;
    public String URL = null;
    public String LunarDate = null;

    /*
    * Step : 로그인 > 해당 계정으로 로그인
    * Result : 해당하는 계정으로 로그인 됨
     */
    @Test
    public void TC_00_일정_로그인_Test() throws Exception {
        module.로그인(util, TestIds.CalUser.getId(), TestIds.CalUser.getPw());
    }

    /*
     * Step : 일정 > 일정,약속쓰기 클릭
     * Result : 일정쓰기 페이지로 이동됨
     */
    //@Test
    public void TC_01_일정_일정쓰기_Test() throws Exception {
        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());
    }


    /*
     * Step : 일정쓰기 > 시간일정 생성
     * Result : 해당하는 날짜에 시간 일정 생성 됨
     * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
     */
    //@Test
    public void TC_01_일정_일정쓰기_시간일정_Test() throws Exception{

        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        //시간 일정쓰기 설정 되어 있는지 확인
        if((util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }

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


    /*
    * Step : 일정쓰기 > 시간 종일 일정 생성
    * Result : 해당하는 날짜에 시간 종일 일정 생성 됨
    * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
    */
   // @Test
    public void TC_02_일정_일정쓰기_시간종일일정_Test() throws Exception{

        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        //종일 일정쓰기 설정 되어 있는지 확인
        if((util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }
        //제목 입력
        util.findElement(By.id("tx0_0")).sendKeys(module.contents);
        //시작 날짜 입력
        util.findElement(By.id("start_date")).clear();
        util.findElement(By.id("start_date")).sendKeys(module.StartDate);
        //종료 날짜 입력
        util.findElement(By.id("end_date")).clear();
        util.findElement(By.id("end_date")).sendKeys(module.EndTimeDate);

        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }

    //@Test
    public void TC_03_일정_일정쓰기_시간일정_Assert_Test() throws Exception {
        URL = module.calURL+"#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\""+module.StartDate+"\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]"));


        if(util.isElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]")).isDisplayed())
        {
            util.clickAndWait(By.xpath("//a[contains(text(),'"+module.contents+"')]"));
            util.printLog("해당하는 날짜에 시간일정 \n 제목:" + module.contents+" 일정이 존재합니다");
            util.waitForIsElementPresent(By.className("_modify_text"));
        }
        else
            System.out.print("해당하는 날짜에 해당하는 일정이 존재하지 않습니다");
    }

    /*
     * Step : 일정쓰기 > 종일일정 생성
     * Result : 해당하는 날짜에 종일 일정 생성 됨
     * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
     */
    //@Test
    public void TC_04_일정_일정쓰기_종일일정_Test() throws Exception{

        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        //종일 일정쓰기 설정 되어 있는지 확인
        if(!(util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
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

        //저장하기
        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }

    //@Test
    public void TC_05_일정_일정쓰기_종일일정_Assert_Test() throws Exception {
        URL = module.calURL+"#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\""+module.StartDate+"\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]"));


        if(util.isElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]")).isDisplayed())
        {
            util.clickAndWait(By.xpath("//a[contains(text(),'"+module.contents+"')]"));
            util.printLog("해당하는 날짜에 종일일정 \n 제목:" + module.contents+" 일정이 존재합니다");
            util.waitForIsElementPresent(By.className("_modify_text"));
        }
        else
            System.out.print("해당하는 날짜에 해당하는 일정이 존재하지 않습니다");
    }


    /*
    * Step : 일정쓰기 > 음력일정 생성
    * Result : 해당하는 날짜에 음력 일정 생성 됨
    * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
    */
    //@Test
    public void TC_06_일정_일정쓰기_음력일정_Test() throws Exception{
        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        //종일 일정쓰기 인지 확인
        if(!(util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }

        //음력으로 설정 되어 있는지 확인
        if(util.findElement(By.xpath("//p[@class='_converted_solar_date time_default no_view']")).isDisplayed())
        {
            System.out.print("음력입니다");
        }
        else
        {
            util.findElement(By.xpath("//div[@class='selectbox-label']")).click();
            util.findElement(By.xpath("//li[contains(text(),'음력')]")).click();
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

        //음력 날짜 저장
        //지정한 양력날짜가 아닌 새로운 양력날짜로 저장 되기 때문에 LunarDate로 새로 저장
        //나중에 Assert할때도 해당 정보 전달
        String str;
        str = util.findElement(By.xpath("//p[@class='_converted_solar_date time_default no_view']")).getText();
        LunarDate = str.substring(5).replace(".","-");

        //저장하기
        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }

    //@Test
    public void TC_07_일정_일정쓰기_음력일정_Assert_Test() throws Exception {
        URL = module.calURL+"#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\""+LunarDate+"\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]"));


        if(util.isElementPresent(By.xpath("//a[contains(text(),'"+module.contents+"')]")).isDisplayed())
        {
            util.clickAndWait(By.xpath("//a[contains(text(),'"+module.contents+"')]"));
            util.printLog("해당하는 날짜에 음력일정 \n 제목:" + module.contents+" 일정이 존재합니다");
            util.waitForIsElementPresent(By.className("_modify_text"));
        }
        else
            System.out.print("해당하는 날짜에 해당하는 일정이 존재하지 않습니다");
    }

    /*
    * Step : 일정쓰기 > 약속일정 생성
    * Result : 해당하는 날짜에 선택한 참가자 추가 되어 약속 일정생성 됨
    * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
    */
    //@Test
    public void TC_08_일정_일정쓰기_약속일정_Test() throws Exception{

        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        //제목 입력
        util.findElement(By.id("tx0_0")).sendKeys(module.contents);

        //시작 날짜 입력
        util.findElement(By.id("start_date")).clear();
        util.findElement(By.id("start_date")).sendKeys(module.StartDate);

        //종료 날짜 입력
        util.findElement(By.id("end_date")).clear();
        util.findElement(By.id("end_date")).sendKeys(module.EndDate);

        //참석자 초대
        util.findElement(By.id("nhn_cp_entry")).sendKeys(module.Attendee);
        util.findElement(By.className("add_btn")).click();
        assertTrue(util.findElement(By.xpath("//span[@class='mail _open_popup']")).getAttribute("title").contains(module.Attendee));

        //저장하기
        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }


    //@Test
    public void TC_09_일정_일정쓰기_약속일정_Assert_Test() throws Exception {
        URL = module.calURL + "#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\"" + module.StartDate + "\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'" + module.contents + "')]"));

        if (util.isElementPresent(By.xpath("//a[contains(text(),'" + module.contents + "')]")).isDisplayed()) {
            util.clickAndWait(By.xpath("//a[contains(text(),'" + module.contents + "')]"));
            util.printLog("해당하는 날짜에 제목:" + module.contents + " 일정이 존재합니다");
            util.waitForIsElementPresent(By.className("_modify_text"));
        } else
            System.out.print("해당하는 날짜에 해당하는 일정이 존재하지 않습니다");

        //참가자 보기 클릭
        util.findElement(By.xpath("//a[@class='btn_sy _view_attendee']")).click();

        //해당하는 참가자 있는지 확인
        if (util.waitForIsElementPresent(By.xpath("//span[@class='txt_member ellipsis' and contains(text(),'"+module.Attendee+"')]")).isDisplayed())
        {
            util.printLog("해당하는 날짜의 약속에 참가자:" + module.Attendee + " 가 있습니다.");
        } else
            System.out.print("해당하는 날짜의 약속에 참가자가 존재하지 않습니다");
    }


    /*
    * Step : 일정쓰기 > 음력약속일정 생성
    * Result : 해당하는 날짜에 선택한 참가자 추가 되어 약속 일정생성 됨
    * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
    */
    //@Test
    public void TC_10_일정_일정쓰기_음력약속일정_Test() throws Exception{

        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        //종일 일정쓰기 설정 되어 있는지 확인
        if(!(util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }
        //음력으로 설정 되어 있는지 확인
        if(util.findElement(By.xpath("//p[@class='_converted_solar_date time_default no_view']")).isDisplayed())
        {
            System.out.print("음력입니다");
        }
        else
        {
            util.findElement(By.xpath("//div[@class='selectbox-label']")).click();
            util.findElement(By.xpath("//li[contains(text(),'음력')]")).click();
        }
        //제목 입력
        util.findElement(By.id("tx0_0")).sendKeys(module.contents);
        //시작 날짜 입력
        util.findElement(By.id("start_date")).clear();
        util.findElement(By.id("start_date")).sendKeys(module.StartDate);
        //종료 날짜 입력
        util.findElement(By.id("end_date")).clear();
        util.findElement(By.id("end_date")).sendKeys(module.EndDate);
        //참석자 초대
        util.findElement(By.id("nhn_cp_entry")).sendKeys(module.Attendee);
        util.findElement(By.className("add_btn")).click();
        assertTrue(util.findElement(By.xpath("//span[@class='mail _open_popup']")).getAttribute("title").contains(module.Attendee));

        //음력 날짜 저장
        //지정한 양력날짜가 아닌 새로운 양력날짜로 저장 되기 때문에 LunarDate로 새로 저장
        //나중에 Assert할때도 해당 정보 전달
        String str;
        str = util.findElement(By.xpath("//p[@class='_converted_solar_date time_default no_view']")).getText();
        LunarDate = str.substring(5).replace(".","-");

        //저장하기
        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }


    //@Test
    public void TC_11_일정_일정쓰기_음력약속일정_Assert_Test() throws Exception {
        URL = module.calURL + "#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\"" + LunarDate + "\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'" + module.contents + "')]"));

        if (util.isElementPresent(By.xpath("//a[contains(text(),'" + module.contents + "')]")).isDisplayed()) {
            util.clickAndWait(By.xpath("//a[contains(text(),'" + module.contents + "')]"));
            util.printLog("해당하는 날짜에 음력약속 \n 제목:" + module.contents+" 일정이 존재합니다");
            util.waitForIsElementPresent(By.className("_modify_text"));
        } else
            System.out.print("해당하는 날짜에 해당하는 일정이 존재하지 않습니다");

        //참가자 보기 클릭
        util.findElement(By.xpath("//a[@class='btn_sy _view_attendee']")).click();

        //해당하는 참가자 있는지 확인
        if (util.waitForIsElementPresent(By.xpath("//span[@class='txt_member ellipsis' and contains(text(),'"+module.Attendee+"')]")).isDisplayed())
        {
            util.printLog("해당하는 날짜의 약속에 참가자:" + module.Attendee + " 가 있습니다.");
        } else
            System.out.print("해당하는 날짜의 약속에 참가자가 존재하지 않습니다");
    }

    /*
    * Step : 일정쓰기 > 반복일정 생성
    * Result : 해당하는 날짜에 선택한 반복 옵션으로 일정생성 됨
    * URL : http://calendar.naver.com/#{"sSection":"scheduleMain","oParameter":{"sViewType":"month","sDate":""+module.StartDate+"\"}}";
    */
    @Test
    public void TC_12_일정_일정쓰기_반복일정_Test() throws Exception{

        util.clickAndWait(By.xpath("//span[contains(text(),'약속쓰기')]"));
        assertTrue(util.findElement(By.linkText("캘린더로 돌아가기")).isDisplayed());

        /*
        //종일 일정쓰기 설정 되어 있는지 확인
        if(!(util.isElementPresent(By.xpath("//a[@class='_set_timezone change_time']")).isDisplayed())){}
        else
        {
            util.findElement(By.id("ch1_1")).click();
        }
        //음력으로 설정 되어 있는지 확인
        if(util.findElement(By.xpath("//p[@class='_converted_solar_date time_default no_view']")).isDisplayed())
        {
            System.out.print("음력입니다");
        }
        else
        {
            util.findElement(By.xpath("//div[@class='selectbox-label']")).click();
            util.findElement(By.xpath("//li[contains(text(),'음력')]")).click();
        }
        */

        //제목 입력
        util.findElement(By.id("tx0_0")).sendKeys(module.contents);
        //시작 날짜 입력
        util.findElement(By.id("start_date")).clear();
        util.findElement(By.id("start_date")).sendKeys(module.StartDate);
        //종료 날짜 입력
        util.findElement(By.id("end_date")).clear();
        util.findElement(By.id("end_date")).sendKeys(module.EndDate);

        //반복설정 옵션 클릭
        util.clickAndWait(By.xpath("//a[@class='_repeat_btn btn_sy repeat img_ri']"));
        //빈도 설정
        util.clickAndWait(By.xpath("//div[@class='_frequency_select  selectbox13']"));
        util.findElement(By.xpath("//li[contains(text(),'매일')]")).click();
        util.clickAndWait(By.xpath("//button[@class='_save normal']"));

        /*
        //참석자 초대
        util.findElement(By.id("nhn_cp_entry")).sendKeys(module.Attendee);
        util.findElement(By.className("add_btn")).click();
        assertTrue(util.findElement(By.xpath("//span[@class='mail _open_popup']")).getAttribute("title").contains(module.Attendee));

        //음력 날짜 저장
        //지정한 양력날짜가 아닌 새로운 양력날짜로 저장 되기 때문에 LunarDate로 새로 저장
        //나중에 Assert할때도 해당 정보 전달
        String str;
        str = util.findElement(By.xpath("//p[@class='_converted_solar_date time_default no_view']")).getText();
        LunarDate = str.substring(5).replace(".","-");
        */
        //저장하기
        util.clickAndWait(By.xpath("//button[@class ='btn_sys pos_save']"));
        util.waitForIsElementPresent(By.xpath("//button[contains(@class,'_go_task type_schedule todo')]"));
    }


    @Test
    public void TC_13_일정_일정쓰기_반복일정_Assert_Test() throws Exception {
        URL = module.calURL + "#{\"sSection\":\"scheduleMain\",\"oParameter\":{\"sViewType\":\"month\",\"sDate\":\"" + module.StartDate + "\"}}";
        util.get(URL);

        util.waitForIsElementPresent(By.xpath("//a[contains(text(),'" + module.contents + "')]"));

        if (util.isElementPresent(By.xpath("//a[contains(text(),'" + module.contents + "')]")).isDisplayed()) {
            util.clickAndWait(By.xpath("//a[contains(text(),'" + module.contents + "')]"));
            util.printLog("해당하는 날짜에 음력약속 \n 제목:" + module.contents+" 일정이 존재합니다");
            util.waitForIsElementPresent(By.className("_modify_text"));
        } else
            System.out.print("해당하는 날짜에 해당하는 일정이 존재하지 않습니다");

        //참가자 보기 클릭
        util.findElement(By.xpath("//a[@class='btn_sy _view_attendee']")).click();

        //해당하는 참가자 있는지 확인
        if (util.waitForIsElementPresent(By.xpath("//span[@class='txt_member ellipsis' and contains(text(),'"+module.Attendee+"')]")).isDisplayed())
        {
            util.printLog("해당하는 날짜의 약속에 참가자:" + module.Attendee + " 가 있습니다.");
        } else
            System.out.print("해당하는 날짜의 약속에 참가자가 존재하지 않습니다");
    }



}
