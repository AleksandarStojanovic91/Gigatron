package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.PublicKey;

public class ProductsPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public ProductsPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='sort']")
    WebElement sortBy;

    String productPriceXpath = "//div[contains(@class,'product-items-main')]/div[$]//span[@class='ppra_price-number']";

    public void sortBy(String sortingMethod) throws InterruptedException {
        selectByValue(sortBy, sortingMethod);
        Thread.sleep(5000);
    }

    public void assertPriceAppending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().replace(".", ""));

        Assert.assertTrue(cena1 <= cena2);
    }

    public void assertPricedDescending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().replace(".", ""));

        Assert.assertTrue(cena1 >= cena2);
    }

    public void verifyItemsAreSorted(String sortingMethod) throws Exception {
        switch (sortingMethod) {
            case "rastuci": {
                assertPriceAppending();
            }
            break;
            case "opadajuci": {
                assertPricedDescending();
            }
            break;
            case "naziv": {

            }
            break;
            case "rejting": {

            }
            break;
            case "score": {

            }
            break;
            default: throw new Exception("Sorting method not supported");
        }
    }
}