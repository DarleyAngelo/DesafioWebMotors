package steps;
import static core.DriverFactory.getDriver;
import java.io.IOException;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import page.SitePage;
import util.Generator;
import util.Screenshot;

public class BuscarPorMarcaModeloVersaoTest extends SitePage {	

	@Dado("^que estou no site busca carro novos ou semi novos$")
	public void queEstouNoSiteNovoESemiNovos() throws IOException {
		queEstouNoSite();
		aceitoCookies();
		clicoMenuComprar();
		clicoMenuCarrosNovosUsados();
		validaSeEstounaPaginaNovoESeminovos();
	}
	@Quando("^seleciono a marca, modelo e versao desejada$")
	public void preenchoNomeMarcas() throws IOException {
		escolhoMarcaHonda();
		validaSeCarregouAMarcaHonda();
		escolhoModeloCity();
		validaSeCarregouAModeloCity();
		escolhoVersao();
		validaSeCarregouAVersao();		
	}
	@Entao("^carrega a paina com os veiculos da marca, modelo e versao selecionada$")
	public void pagainaCarregada() throws IOException {
		validaSeRetornouMarcaModeloVersao();
	}

	@After 
	public void screenshots(){
		String Evidencia = System.getProperty("user.dir")+"\\target\\relatorios\\evidencias\\" + Generator.dataHoraParaArquivo() +".png";
		Screenshot.tirar(getDriver(), Evidencia);
	}
	@After
	public void fechaBrowser() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().quit();
	}


}
