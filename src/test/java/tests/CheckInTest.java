package tests;

import helpMethods.ElementMethods;
import net.bytebuddy.description.type.TypeDescription;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.time.Duration;

public class CheckInTest extends ShareData {

    ElementMethods element = new ElementMethods(driver);

    @Test
    public void checkInMethod() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        By clickCookie = By.cssSelector("._148dgdpk");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(clickCookie));

        WebElement clickOk = driver.findElement(clickCookie);
        element.clickElement(clickOk);

        By clickLocator = By.xpath("//div[@data-testid='little-search']/button[1]/div");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(clickLocator));

        WebElement clickSearch = driver.findElement(clickLocator);
        element.clickElement(clickSearch);

        WebElement selectLocation = driver.findElement(By.id("bigsearch-query-location-input"));
        String locationValue = "Rome, Italy";
        element.fillElement(selectLocation,locationValue);

        WebElement checkIn = driver.findElement(By.cssSelector("div[data-testid='structured-search-input-field-split-dates-0']"));
        element.clickElement(checkIn);

        WebElement selectDateIn = driver.findElement(By.cssSelector("div[data-testid='calendar-day-13.09.2022']"));
        element.clickElement(selectDateIn);

//        WebElement checkOut = driver.findElement(By.cssSelector("div[data-testid='structured-search-input-field-split-dates-1']"));
//        element.clickElement(checkOut);

        WebElement selectDateOut = driver.findElement(By.cssSelector("div[data-testid='calendar-day-20.09.2022']"));
        element.clickElement(selectDateOut);

        WebElement addGuests = driver.findElement(By.cssSelector("div[data-testid='structured-search-input-field-guests-button']"));
        element.clickElement(addGuests);

        Integer count = 0;
        WebElement addAdults = driver.findElement(By.cssSelector("button[data-testid='stepper-adults-increase-button']"));
        element.clickElement(addAdults);
        count++;
        element.clickElement(addAdults);
        count++;
        WebElement addChildren = driver.findElement(By.cssSelector("button[data-testid='stepper-children-increase-button']"));
        element.clickElement(addChildren);
        count++;
        WebElement searchButton = driver.findElement(By.cssSelector("button[data-testid='structured-search-input-search-button']"));
        element.clickElement(searchButton);

        WebElement verifyLocation = driver.findElement(By.xpath("//button[@data-index='0']/div"));
        String actualResults = verifyLocation.getText();
        String expectedResults = "Rome";
        Assert.assertEquals(actualResults,expectedResults,"nu merge");

        WebElement verifyDateIn = driver.findElement(By.cssSelector("button[data-index='1']"));
        String actualResults1 = verifyDateIn.getText();
        String expectedResults1 = "13–20 sept.";
        Assert.assertEquals(actualResults1,expectedResults1);

        WebElement verifyGuests = driver.findElement(By.cssSelector("button[data-index='2']"));
        String actualResults2 = verifyGuests.getText();
        String expectedResults2 = "3 oaspeți";
        Assert.assertEquals(actualResults2,expectedResults2);


        By validateText = By.xpath("//div[@data-section-id='EXPLORE_STRUCTURED_PAGE_TITLE']");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(validateText));


        By filterLocator = By.cssSelector(".b1a88q73");
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(filterLocator));

        WebElement filterButton = driver.findElement(filterLocator);
        element.clickElement(filterButton);

//        WebElement roomNumber = driver.findElement(By.xpath("//div[@aria-label='Dormitoare']/div[2]//div[@id='menuItemButton-5']/button"));
//        element.clickElement(roomNumber);






    }


}
