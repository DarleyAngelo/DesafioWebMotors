package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConverteParaBy {

	public By toByVal(WebElement webElement) {
	    String[] data = webElement.toString().split(" -> ")[1].replace("]", "").split(": ");
	    String locator = data[0];
	    String term = data[1];

	    if (locator.equalsIgnoreCase("xpath")) {
	    	return By.xpath(term);
		} else if (locator.equalsIgnoreCase("css selector")) {
			return By.cssSelector(term);
		} else if (locator.equalsIgnoreCase("id")) {
			return By.id(term);
		} else if (locator.equalsIgnoreCase("tag name")) {
			return By.tagName(term);
		} else if (locator.equalsIgnoreCase("name")) {
			return By.name(term);
		} else if (locator.equalsIgnoreCase("link text")) {
			return By.linkText(term);
		} else if (locator.equalsIgnoreCase("class name")) {
			return By.className(term);
		} else {
			return (By)webElement;
		}
	}
}