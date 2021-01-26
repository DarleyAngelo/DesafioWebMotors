package core;

public class Propriedades {
	public static final boolean HEADLESS = false;	
	public static boolean LOGADO = false;
	public static final String URL = "https://www.webmotors.com.br/";
	public static final Browsers browser = Browsers.CHROME;	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}