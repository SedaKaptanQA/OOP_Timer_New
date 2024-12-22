package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimerPage {
    WebDriver driver;

    // Constructor
    public TimerPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By startButton = By.xpath("//p[text()='Start']");
    private By stopButton = By.xpath("//p[text()='Stop']");
    private By timerDisplay = By.className("time-display");
    private By resetButton = By.xpath("//p[text()='Reset']");

    // Methods to return WebElements
    public WebElement getStartButton() {
        return driver.findElement(startButton);
    }

    public WebElement getStopButton() {
        return driver.findElement(stopButton);
    }

    public WebElement getTimerDisplay() {
        return driver.findElement(timerDisplay);
    }

    public WebElement getResetButton() {
        return driver.findElement(resetButton);
    }
}