package util;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Espera {

	static ConverteParaBy converte = new ConverteParaBy();
	
	public static void aguardaElementoSerVisivelEClicavel(WebElement locator) {
		
		WebElement elemento = getDriver().findElement(converte.toByVal(locator));
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	public static void aguardaElementoEstarPresente(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(converte.toByVal(locator)));
	}
}