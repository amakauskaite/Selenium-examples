package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumOnLSK {

	private static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		// Preparing the environment for work
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Opens lsk main page
		driver.get("http://www.lsk.flf.vu.lt/lt/");

		// Clicks on "Lietuviø kalbos kursai"
		driver.findElement(By.xpath("//ul[@class='level1']/li[3]")).click();

		// Clicks on "Anketa"
		driver.findElement(By.linkText("Anketa")).click();

		fillTheForm();

		// driver.quit(); // Uncomment this line when executing if you want to
		// close the browser after execution

	}

	public static void fillTheForm() {

		// Fills surname
		driver.findElement(By.id("lib_php_form_standard_1__field_field_1_input_field")).sendKeys("Pavardenis");

		// Fills name
		driver.findElement(By.name("field_2")).sendKeys("Vardenis");

		// Fills birth date (in bad format)
		driver.findElement(By.id("lib_php_form_standard_1__field_field_3_input_field")).sendKeys("2017-09-13");

		// Fills nationality
		driver.findElement(By.id("lib_php_form_standard_1__field_field_4_input_field")).sendKeys("Lietuvis");

		// Selects gender (Male)
		Select genderSelect = new Select(driver.findElement(By.name("field_5")));
		genderSelect.selectByValue("Vyras");

		// Fills home address
		driver.findElement(By.id("lib_php_form_standard_1__field_field_6_input_field")).sendKeys("Naugarduko g. 24");

		// Fills telephone number
		driver.findElement(By.name("field_7")).sendKeys("+37061111111");

		// Fills fax
		driver.findElement(By.id("lib_php_form_standard_1__field_field_8_input_field")).sendKeys("Fakso numeris");

		// Fills email
		driver.findElement(By.id("lib_php_form_standard_1__field_field_9_input_field"))
				.sendKeys("vardenis.pavardenis@pastas.lt");

		// Fills current activity
		driver.findElement(By.name("field_10")).sendKeys("Formos pildymas");

		// Fills language
		driver.findElement(By.name("field_11")).sendKeys("Visas kalbas lietuviðkai");

		// Selects "Yes" in "Do you know Lithuanian?"
		Select ltSelect = new Select(driver.findElement(By.name("field_12")));
		ltSelect.selectByValue("Taip");

		// Selects "Gerai" in "If yes, then how well"
		Select levelSelect = new Select(
				driver.findElement(By.id("lib_php_form_standard_1__field_field_13_input_field")));
		levelSelect.selectByValue("Gerai");

		// Selects some course
		Select courseSelect = new Select(driver.findElement(By.name("field_14")));
		courseSelect.selectByIndex(2);
		
		// Selects place to stay
		Select placeSelect = new Select(driver.findElement(By.name("field_15")));
		placeSelect.selectByVisibleText("Bendrabutyje");
		
		// Fills fields about connections
		driver.findElement(By.name("field_16")).sendKeys("Su mano þmona");
		
		// Fills text box about the course
		driver.findElement(By.name("field_17")).sendKeys("Ieðkojau per google bet kokios anketos");
		
		// Fills text box about the reason of wanting to do this course
		driver.findElement(By.id("lib_php_form_standard_1__field_field_18_input_field")).sendKeys("Jei praëjo ði anketa, siûlau patikrinti ar teisingai tikrinamas datos formatas");
		
		try {
			Thread.sleep(30000);
			
			// Clicks submit button
			driver.findElement(By.className("libPhpFormSubmit")).click();
			
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}