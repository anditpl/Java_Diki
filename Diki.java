package com.lukasz.diki;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class Diki {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Wpisz hasło do wyszukania: ");
        String s = scan.next();

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);


        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://www.diki.pl");

        System.out.println(driver.getTitle());

        driver.findElementByCssSelector("#contentWrapper > div.dikiBackgroundBannerPlaceholder > div.dikiLogoAndSearchFormWrapperMobile > div.dikiHeaderAndInputSearchContainer > div > form > div.clear_input_div > input").sendKeys(s);
        driver.findElementByCssSelector("#contentWrapper > div.dikiBackgroundBannerPlaceholder > div.dikiLogoAndSearchFormWrapperMobile > div.dikiHeaderAndInputSearchContainer > div > form > button").click();


        System.out.println(driver.findElementByClassName("dictionaryEntity").getText());

//        driver.close();



    }
}
