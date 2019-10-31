package com.andersen.rodionov.uilearning.yandexPages;

import com.andersen.rodionov.uilearning.BasePage;
import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class StorePage extends BasePage {
    @FindBy(css = ".button.button_theme_normal")
    private WebElement buttonCheckDisplay;

    @FindBy(css = ".n-snippet-cell2")
    private List<WebElement> productsList;

    @FindBy(css = "._2y67xS5HuR li:nth-child(2) a")
    private WebElement inputBrandCheckBox;

    @FindBy(css = ".n-snippet-cell2__brand-name")
    private List<WebElement> brandNameList;

    @FindBy(xpath = "//h1[contains(@title,'iPhone')]")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@class='select__text'][text()='Показывать по 12']")
    private WebElement selectCheckDisplay;

    @FindBy(xpath = "//*[text()='Уценённый']")
    private WebElement inputDiscountedRadioButton;

    @FindBy(css = "#header-search")
    private WebElement inputSearchLine;

    @FindBy(css = ".n-link_theme_blue")
    private List<WebElement> productName;


    public void selectGoodsNumberDropDown() {
        new WebDriverWait(DriverChrome.getInstance(), 3).until(ExpectedConditions.elementToBeClickable(buttonCheckDisplay));
        scrollToElement(buttonCheckDisplay);

        new WebDriverWait(DriverChrome.getInstance(), 3).until(ExpectedConditions.elementToBeClickable(buttonCheckDisplay));
        scrollToElement(buttonCheckDisplay);

        buttonCheckDisplay.click();
        selectCheckDisplay.click();
        waitJQuery();
    }

    public int getGoodsListSize() {
        return productsList.size();
    }

    public void clickBrand() {
        scrollToElement(inputBrandCheckBox);
        if (!inputBrandCheckBox.isSelected()) {
            inputBrandCheckBox.click();
        }
        waitJQuery();
    }

    public void checkExpectedBrandNames() {
        new WebDriverWait(DriverChrome.getInstance(), 3).until(ExpectedConditions.visibilityOf(productTitle));

        List<WebElement> actualBrandNames = DriverChrome.getInstance().findElements(By.cssSelector(".n-snippet-cell2__brand-name"));
        for (WebElement actualBrandName : actualBrandNames) {
            Assert.assertEquals(actualBrandName.getText(), "APPLE", "Бренд не совпадает");
        }
    }

    public void clickDiscountedRadioButton() {
        scrollToElement(inputDiscountedRadioButton);
        if (!inputDiscountedRadioButton.isSelected()) {
            inputDiscountedRadioButton.click();
        }
        waitJQuery();
    }

    public void checkDiscountedBrandNames() {
        List<WebElement> discountedNames = DriverChrome.getInstance().findElements(By.cssSelector(".n-snippet-cell2__cutprice-label"));
        for (WebElement discountedName : discountedNames) {
            Assert.assertEquals(discountedName.getText(), "Уценённый", "Товар не соответствует");
        }
    }

    public String getFirstModelName() {
        return productName.get(0).getText();
    }

    public void setInputLine(String productName) {
        inputSearchLine.click();
        inputSearchLine.clear();
        inputSearchLine.sendKeys(productName);
        inputSearchLine.sendKeys(Keys.ENTER);
    }

    public String getInputLineText() {
        return inputSearchLine.getAttribute("value");
    }

    public void inputTextByAction() {
        new WebDriverWait(DriverChrome.getInstance(), 2).until(ExpectedConditions.visibilityOf(inputSearchLine));
        Actions action = new Actions(DriverChrome.getInstance());
        action.sendKeys(inputSearchLine, "Iphone X").perform();
    }

    public void scrollToElementByAction() {
        new WebDriverWait(DriverChrome.getInstance(), 3).until(ExpectedConditions.elementToBeClickable(inputDiscountedRadioButton));
        Actions action = new Actions(DriverChrome.getInstance());
        action.moveToElement(inputDiscountedRadioButton).perform();
    }

    public void clickElementByAction() {
        Actions action = new Actions(DriverChrome.getInstance());
        if (!inputDiscountedRadioButton.isSelected()) {
            action.click(inputDiscountedRadioButton).perform();
        }
    }

    public void inputTextByJs() {
        new WebDriverWait(DriverChrome.getInstance(), 2).until(ExpectedConditions.visibilityOf(inputSearchLine));
        ((JavascriptExecutor) DriverChrome.getInstance()).executeScript("arguments[0].value='Iphone X';", inputSearchLine);
    }

    public void scrollToElementByJs() {
        new WebDriverWait(DriverChrome.getInstance(), 3).until(ExpectedConditions.elementToBeClickable(inputDiscountedRadioButton));
        ((JavascriptExecutor) DriverChrome.getInstance()).executeScript("document.scrollIntoView(true);", inputDiscountedRadioButton);
    }

    public void clickElementByJs() {
        if (!inputDiscountedRadioButton.isSelected()) {
            ((JavascriptExecutor) DriverChrome.getInstance()).executeScript("document.click();", inputDiscountedRadioButton);
        }
    }
}
