
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class Diki {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Wpisz hasło do wyszukania: ");
        String word = scan.next();

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);


        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://www.diki.pl");

        System.out.println(driver.getTitle());



        driver.findElementByCssSelector("input[type='search']").sendKeys(s);
        driver.findElementByCssSelector("button[type='submit']").click();

        try
        {
            System.out.println(driver.findElementByClassName("dictionaryEntity").getText());
        }
        catch(Exception e)
        {
            System.out.println("Brak hasła w słowniku");
            System.out.println(driver.findElementByCssSelector("#contentWrapper > div.dikiBackgroundBannerPlaceholder > div.dictionarySuggestions").getText());
        }


        driver.close();



    }
}
