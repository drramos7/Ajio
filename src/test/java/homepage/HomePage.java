package homepage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	@Test
	private void printActualPriceDiscountedPriceDiscountAndProductWithHigherDiscount() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		String HomeWindow = driver.getWindowHandle();

		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		// driver.findElement(By.cssSelector("div.modal-content>div")).click();
		driver.findElement(By.cssSelector("input.react-autosuggest__input--open")).sendKeys("Jeans");
		driver.findElement(By.cssSelector("span.ic-search")).click();
		List<WebElement> alloptions = driver.findElements(By.cssSelector("img.rilrtl-lazy-img-loaded"));

		for (int i = 0; i < 6; i++) {
			alloptions.get(i).click();
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				if (!window.equals(HomeWindow)) {
					driver.switchTo().window(window);
				}
			}
			driver.findElement(By.xpath("(//div[@class='circle size-variant-item size-instock '])[2]")).click();
			driver.findElement(By.cssSelector("div.pdp-addtocart-button>div")).click();

			// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
			// driver.close();
			//for (String window : windows) {
			//	if (!window.equals(HomeWindow)) {
			//		driver.switchTo().window(window);
			//		driver.close();
			//}
			//}
			driver.switchTo().window(HomeWindow);
		}
		
		driver.findElement(By.cssSelector("div.popup-blk.cart-blk")).click();
		System.out.println("***&&&&&");
		System.out.println("***&&&&fgesg&");
	}

}
