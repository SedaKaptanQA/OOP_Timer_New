package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TimerPage;

import java.time.Duration;

public class TimerTest extends BaseTest {
    private TimerPage timerPage;

    @Test
    public void startButtonTest() throws InterruptedException {
        timerPage = new TimerPage(driver);
        // 1)Sayacın Görünürlüğünü doğrula
        boolean isTimerVisible = timerPage.getTimerDisplay().isDisplayed();
        Assert.assertTrue("Sayaç görünür değil", isTimerVisible);

        // 2)Başlangıç zamanını kontrol et (25:00).
        Assert.assertEquals("25:00",timerPage.getTimerDisplay().getText());
        Thread.sleep(2000);
        // 3)Start butonuna basıldığında zamanlayıcı çalışmaya başlamalı.
        timerPage.getStartButton().click();
        Thread.sleep(3000);
        // 4)Start butonuna tıklanıldığında zamanlayıcının ilerlediğini test et.

        Assert.assertNotEquals("25:00",timerPage.getTimerDisplay().getText(),"sayaç çalışmıyor");
        Thread.sleep(3000);

        timerPage.getStopButton().click();
    }


     @Test
    public void testResetButton() throws InterruptedException {
         timerPage = new TimerPage(driver);

              // 1)Reset butonuna basıldığında zamanlayıcı başlangıç değerine "25:00" dönmeli.
               timerPage.getStartButton().click();
               Thread.sleep(3000);
               timerPage.getResetButton().click();
              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
              wait.until(ExpectedConditions.textToBe(By.className("time-display"), "25:00"));
              Assert.assertNotEquals("25:00", timerPage.getTimerDisplay().getText(), "Sayaç resetlenmedi!");

            }

       @Test
       public void testStopButton() throws InterruptedException {
           timerPage = new TimerPage(driver);


           //1)Stop butonuna basıldığında zamanlayıcı durmalı.
           //2)Stop butonuna tıklandıktan sonra zamanlayıcının durduğunu doğrula.


           timerPage.getStartButton().click();
           Thread.sleep(3000);
           timerPage.getStopButton().click();
           String timeBeforeStop = timerPage.getTimerDisplay().getText();
           Thread.sleep(2000);
           String timeAfterWait = timerPage.getTimerDisplay().getText();
           Assert.assertNotEquals(timeBeforeStop, timeAfterWait, "Zamanlayıcı ilerlemiyor");
           timerPage.getStopButton().click();
           String timeAfterStop = timerPage.getTimerDisplay().getText();
           Thread.sleep(2000);
           String timeAfterStopWait = timerPage.getTimerDisplay().getText();

           Assert.assertNotEquals(timeAfterStop, timeAfterStopWait, "Zamanlayıcı durmadı");
       }


    }


