package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String emailIdTextBox = "//input[@id='input-email']";
    private String passwordTextBox = "//*[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//a[contains(@href,'forgotten')]";
    private String logoutLink = "(//a[text()='Logout'])[2]";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExist() {
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("App creds: "+ appUserName + ":" + appPassword);
        page.fill(emailIdTextBox,appUserName);
        page.fill(passwordTextBox,appPassword);
        page.click(loginBtn);
        if(page.isVisible(logoutLink)){
            System.out.println("User logged in successfully....");
            return true;
        }
        return false;
    }
}
