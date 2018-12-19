import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class Diki {

    static Scanner scan = new Scanner(System.in);
    static String userInput = null;

    public static void main(String args[]) {
        CheckWord();
        while (true) {
            System.out.print("Czy chcesz wyszukać następne hasło (T/N) ? ");
            userInput = scan.next();
            if (userInput.equalsIgnoreCase("T"))
                CheckWord();
            else if (userInput.equalsIgnoreCase("N")) {
                System.out.print("Dziękuję i miłego dnia życzę !! ");
                System.out.println("Łukasz Krause - http://www.and-it.pl");
                break;
            } else {
                System.out.print("Wprowadż T albo N (Y/N) ! ");
            }

        }

    }

    public static void CheckWord() {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Wpisz hasło do wyszukania: ");
        String word = scan.next();

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://www.diki.pl");

        System.out.println(driver.getTitle());

        driver.findElementByCssSelector("input[type='search']").sendKeys(word);
        driver.findElementByCssSelector("button[type='submit']").click();

        try {
            System.out.println(driver.findElementByClassName("dictionaryEntity").getText());
        } catch (Exception e) {
            System.out.println("Brak hasła w słowniku");
            System.out.println(driver.findElementByCssSelector("div[class='dictionarySuggestions']").getText());
        }


        driver.close();
    }
}
