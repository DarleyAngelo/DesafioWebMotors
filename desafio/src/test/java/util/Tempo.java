package util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

public abstract class Tempo {

	public static void aguardar(Integer segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos.intValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String recuperaTexto(WebElement elemento) throws IOException {
		
		String texto = null;
		Espera.aguardaElementoEstarPresente(elemento);		
		texto = elemento.getText();		
		return texto;		
	}

}


