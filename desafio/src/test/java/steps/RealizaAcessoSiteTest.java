package steps;
import static core.DriverFactory.getDriver;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import page.SitePage;
import util.Generator;
import util.Screenshot;

public class RealizaAcessoSiteTest extends SitePage {	


	@Dado("^que estou no site$")
	public void acessandoSite() throws Throwable {
		queEstouNoSite();
		aceitoCookies();
	}
	@E("^seleciono o comando compra$")
	public void acionoMenuComprar() throws Throwable {
		clicoMenuComprar();
	}
	@Quando("^seleciono o comando carros novos ou semi novos$")
	public void acionoMenuCarrosNovosUsados() throws Throwable {
		clicoMenuCarrosNovosUsados();
	}
	@Entao("^visualizo a pagina$")
	public void carregaPaginadeBusca() throws Throwable {
		visualizoPaginadeCarrosUsadosESemiNovos();
	}
//	@After 
//	public void screenshots(){
//		String Evidencia = System.getProperty("user.dir")+"\\target\\relatorios\\evidencias\\" + Generator.dataHoraParaArquivo() +".png";
//		Screenshot.tirar(getDriver(), Evidencia);
//	}
//	@After
//	public void fechaBrowser() throws InterruptedException {
//		Thread.sleep(2000);
//		getDriver().quit();
//	}


}
