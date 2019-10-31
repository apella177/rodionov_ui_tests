package com.andersen.rodionov.uilearning.yandexPages;

import com.andersen.rodionov.uilearning.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YandexStoreTest extends BaseTest {
    private StorePage storePage;

    @BeforeClass
    public void setInit() {
        driver.get("https://market.yandex.by/catalog/54726/list?local-offers-first=0&deliveryincluded=0&onstock=1");
        storePage = PageFactory.initElements(driver, StorePage.class);
    }

    @Test
    public void testCheckProductsDisplay() {
        storePage.selectGoodsNumberDropDown();
        Assert.assertEquals(12, storePage.getGoodsListSize(), "Количестсво товаров не совпадает с выбранным количеством");
    }

    @Test
    public void testInCheckBoxBrandName() {
        storePage.clickBrand();
        storePage.checkExpectedBrandNames();
    }

    @Test
    public void testInCheckDiscountedButton() {
        storePage.clickDiscountedRadioButton();
        storePage.checkDiscountedBrandNames();
    }

    @Test
    public void testValueInputLine() {
        String productName = storePage.getFirstModelName();
        storePage.setInputLine(productName);
        Assert.assertEquals(storePage.getFirstModelName(), productName, "Название модели неидентичны");
        Assert.assertEquals(storePage.getInputLineText(), productName, "Товар не соответствует");
    }

    @Test
    void testAction() {
        storePage.inputTextByAction();
        storePage.scrollToElementByAction();
        storePage.clickElementByAction();
    }

    @Test
    void testJsExecutor() {
        storePage.inputTextByJs();
        storePage.scrollToElementByJs();
        storePage.clickElementByJs();
    }
}
