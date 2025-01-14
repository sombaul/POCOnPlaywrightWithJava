package com.qa.opencart.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Base64;

public class HomePageTest extends BaseTest {


    @Test
    public void homePageTitleTest() {
      String actualTitle =  homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageURLTest() {
        String actualURL =  homePage.getHomePageURL();
        Assert.assertEquals(actualURL,prop.getProperty("url").trim());
    }

    @DataProvider
    public Object[][] getProductNames()
    {
        return new Object[][] {
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductNames")
    public void searchTest(String productName) {
        String actualSearchHeader =  homePage.doSearch(productName);
        Assert.assertEquals(actualSearchHeader,"Search - "+productName);
    }


}
