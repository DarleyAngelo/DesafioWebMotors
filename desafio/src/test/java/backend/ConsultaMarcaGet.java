package backend;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ConsultaMarcaGet {
	
	@Test
	public void buscarTodasAsMarca () {
		given()
		.log().all()
		.when()
		.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Make")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)
		.body("Name", hasSize(3))
	    .body("Name", hasItems("Chevrolet", "Honda", "Ford"))
		;
	}
	
	@Test
	public void buscarVeiculosdaMarcaHonda () {
		given()
		.log().all()
		.when()
		.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Model?MakeID=2")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)
		.body("MakeID[1]", is(2))
		.body("MakeID[2]", is(2))
		.body("Name", hasSize(3))
	    .body("Name", hasItems("City", "CRV", "Fit"))
		;
	}
	
	@Test
	public void validarMarcaInexistente () {
		given()
		.log().all()
		.when()
		.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Model?MakeID=10")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)	
		;
	}
	
	@Test
	public void buscarVersaoMarcaHonda () {
		given()
		.log().all()
		.when()
		.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Version?ModelID=2")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)
		.body("Name", containsInAnyOrder("1.5 LX 16V FLEX 4P MANUAL", "2.0 EXL 4X4 16V GASOLINA 4P AUTOM햀ICO","1.8 16V EVO FLEX FREEDOM OPEN EDITION AUTOM햀ICO", "1.0 MPI EL 8V FLEX 4P MANUAL"))
		;
	}
	
	@Test
	public void buscarVeiculosHondaCityPorPage () {
		given()
		.log().all()
		.when()
		.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Vehicles?Page=2")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)
		.body("Make", hasItem("Honda"))
		.body("Model", hasItem("City"))
		.body("Version", hasItem("2.0 EXL 4X4 16V GASOLINA 4P AUTOM햀ICO"))
		.body("Image", is(nullValue()))
		.body("Price", is(nullValue()))
		.body("YearModel", is(nullValue()))
		.body("YearFab", is(nullValue()))
		.body("Color", is(nullValue()))
		;	
	}
	
	@Test
	public void buscarVeiculosHondaPorPage () {
		given()
		.log().all()
		.when()
		.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Vehicles?Page=2")
		.then()
		.body(is(not(nullValue())))
		.statusCode(200)
		//.body("Vehicle", hasSize(10))
		.body("Make", hasItem("Honda"))
		.body("Model", hasItem("City"))
		.body("Model", hasItem("Fit"))
		.body("Version", hasItem("1.4 LXL 16V FLEX 4P AUTOM햀ICO"))
		.body("Version", hasItem("2.0 EXL 4X4 16V GASOLINA 4P AUTOM햀ICO"))
		.body("Image", is(nullValue()))
		.body("YearModel", is(nullValue()))
		.body("YearFab", is(nullValue()))
		.body("Color", is(nullValue()))
		;	
	}
}
