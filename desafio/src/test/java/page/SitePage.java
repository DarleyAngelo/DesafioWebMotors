package page;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import core.Propriedades;

public class SitePage {


	public SitePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void queEstouNoSite() throws IOException {
		getDriver().get(Propriedades.URL);				
	}		

	public void clicoMenuComprar() throws IOException {		
		WebDriverWait espera = new WebDriverWait(getDriver(), 20);
		WebElement menuComprar = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Comprar')]")));
		menuComprar.click();
	}
	public void verTodasMarcas() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));	
		WebDriverWait espera = new WebDriverWait(getDriver(), 20);
		WebElement opcaoVerMarcas = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Ver todas as marcas')]")));
		opcaoVerMarcas.click();
	}
	
	public void escolhoMarcaHonda() throws IOException {		
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));						
		WebDriverWait espera = new WebDriverWait(getDriver(), 60);
		WebElement campoMarca = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[contains(text(),'honda')]")));
		campoMarca.click();
	}
	
	public void escolhoModeloCity() throws IOException {		
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));						
		WebDriverWait espera = new WebDriverWait(getDriver(), 30);
		WebElement opcaoModelo = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Filters__line Filters__line--gray Filters__line--icon Filters__line--icon--right')]")));
		opcaoModelo.click();

		WebElement modeloCity = espera.until(ExpectedConditions.elementToBeClickable(By.linkText("CITY")));
		modeloCity.click();	
		
	}
	
	public void escolhoVersao() throws IOException {		
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));						
		WebDriverWait espera = new WebDriverWait(getDriver(), 10);
		WebElement opcaoVersao = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Filters__line Filters__line--icon Filters__line--icon Filters__line--icon--right Filters__line--gray')]")));
		opcaoVersao.click();	
		
		WebElement versao15 = espera.until(ExpectedConditions.elementToBeClickable(By.linkText("1.5 DX 16V FLEX 4P MANUAL")));
		versao15.click();			
	}
	
	public void clicoMenuCarrosNovosUsados() throws IOException {		
		WebDriverWait espera = new WebDriverWait(getDriver(), 30);
		WebElement menuCarroNovosUsados = espera.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Carros usados ou seminovos")));
		menuCarroNovosUsados.click();
	}
		
	public void aceitoCookies() throws IOException {
		WebDriverWait espera = new WebDriverWait(getDriver(), 30);
		WebElement cookies = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='sc-htoDjs gtMZoW']")));
		cookies.click();	
	}
	
	public void visualizoPaginadeCarrosUsadosESemiNovos() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));		
		String URL = getDriver().getCurrentUrl();
		Assert.assertEquals(URL, "https://www.webmotors.com.br/carros-usados/estoque?inst=header:webmotors:header-deslogado::carros-usados-ou-seminovos" );	
	}
		
	public void validaSeCarregouAMarcaHonda() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));
		String PaginaMarcaDesejada = "Honda Usados e Seminovos";
		WebDriverWait espera = new WebDriverWait(getDriver(), 60);
		WebElement PaginaMarcaCarregada = espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='title-search']")));
		PaginaMarcaCarregada.getText();
		Assert.assertEquals(PaginaMarcaDesejada, PaginaMarcaCarregada.getText());
	}
	
	public void validaSeCarregouAModeloCity() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));
		String PaginaModeloDesejada = "Honda City Usados e Seminovos";
		WebDriverWait espera = new WebDriverWait(getDriver(), 80);
		WebElement PaginaModeloCarregada = espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'title-search')]")));
		PaginaModeloCarregada.getText();
		Assert.assertEquals(PaginaModeloDesejada, PaginaModeloCarregada.getText());
	}
	
	public void validaSeCarregouAVersao() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));
		String PaginaVersao = "Honda City 1.5 Dx 16v Flex 4p Manual Usados e Seminovos";
		WebDriverWait espera = new WebDriverWait(getDriver(), 60);
		WebElement PaginaVersaoCarregada = espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title-search']")));
		Assert.assertEquals(PaginaVersao, PaginaVersaoCarregada.getText());
	}
		
	public void validaSeEstounaPaginaNovoESeminovos() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));	
		String PaginSeminoNovosDesejada = "Carros Usados e Seminovos em Todo o Brasil";
		WebDriverWait espera = new WebDriverWait(getDriver(), 60);
		WebElement PaginaSemiNovoCarregada= espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='title-search']")));
		Assert.assertEquals(PaginSeminoNovosDesejada, PaginaSemiNovoCarregada.getText());
	}
	
	public void validaSeRetornouMarcaModeloVersao() throws IOException {
		List<String> abas = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(abas.get(1));
		String PaginaVersao = "Honda City 1.5 Dx 16v Flex 4p Manual Usados e Seminovos";
		WebDriverWait espera = new WebDriverWait(getDriver(), 60);
		WebElement PaginaVersaoCarregada = espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='title-search']")));
		Assert.assertEquals(PaginaVersao, PaginaVersaoCarregada.getText());
	}

}
