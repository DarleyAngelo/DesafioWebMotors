package dsl;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import util.Tempo;

public abstract class CampoTexto {

	public static void preencher(WebElement elemento, String object) throws IOException {
	
		elemento.sendKeys(object);
	    Tempo.aguardar(Integer.valueOf(1));
	}
	
	public static void limpar(WebElement elemento) {
		elemento.clear();
	}
}