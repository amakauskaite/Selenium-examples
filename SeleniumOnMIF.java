package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOnMIF {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Preparing the environment for work
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Opens valaitis.net
		driver.get("http://valaitis.net");

		// Prints out the current url
		System.out.println("The URL of this page is " + driver.getCurrentUrl());

		// Clicks on "Wiki"
		driver.findElement(By.linkText("wiki")).click();

		// Prints out the title of new page
		System.out.println("The title of this page: " + driver.getTitle());

		// Clicks on the fifth date in the table of contents
		driver.findElement(By.xpath("//div[@id='toc']/ul/li[5]/a/span[2]")).click();

		// Goes back
		driver.navigate().back();

		// When you need to do multiple tasks on the same element
		// Sometimes it's easier to create a WebElement

		// Locates the search box
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		// Sends some text
		searchBox.sendKeys("some text that is very very long so you could see");
		// Submits the text to the input element (search box)
		searchBox.submit();
		// Let's change the search box from the top box to the center one
		searchBox = driver.findElement(By.id("searchText"));
		// Clears the text
		searchBox.clear();
		// Sends another string
		searchBox.sendKeys("PST");
		// Submits it
		searchBox.submit();

		// Clicks on the link to PST page
		driver.findElement(By.linkText("PST")).click();

		// The end
		driver.navigate()
				.to("https://68.media.tumblr.com/b78591e31108e9071b2731bec3a5074f/tumblr_omi4cfcR261shgs1po1_500.gif");

		// driver.quit(); // Uncomment this line when executing if you want to
		// close the browser after execution

	}
}