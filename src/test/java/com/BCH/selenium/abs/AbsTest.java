package com.BCH.selenium.abs;


import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BCH.javaee.propiedades.DatosSistema;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.File;   
import java.io.FileOutputStream;   
import org.apache.poi.xwpf.usermodel.XWPFDocument;   
import org.apache.poi.xwpf.usermodel.XWPFParagraph;   
import org.apache.poi.xwpf.usermodel.XWPFRun;   
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;



import org.apache.poi.util.Units;

//import javax.sound.midi.MidiDevice.Info;
//import javax.swing.JOptionPane;

public class AbsTest {
	static File dir = new File("./screenshots");
	static String[] ficheros = dir.list();

	private static final Logger LOGGER = Logger.getLogger(AbsTest.class);
	private static final String EXTENSION_IMAGEN = ".png";

	protected static WebDriver driver;
	protected String url = DatosSistema.getDatoProperties("UrlBF");
	protected String urlDes;
	protected String usuario = DatosSistema.getDatoProperties("User");
	protected String LoginName = DatosSistema.getDatoProperties("LoginName");
	protected String LoginPass = DatosSistema.getDatoProperties("LoginPass");
	protected String LoginBoton = DatosSistema.getDatoProperties("LoginBoton");
	protected String Clave =  DatosSistema.getDatoProperties("Pass");;
	protected String SDap = DatosSistema.getDatoProperties("SDap");
	protected String V360 = DatosSistema.getDatoProperties("V360");
	protected String TDap = DatosSistema.getDatoProperties("TDAP");
	protected String Seleccion = DatosSistema.getDatoProperties("Seleccion");
	protected String DPF = DatosSistema.getDatoProperties("DPF");
	protected String DPIR = DatosSistema.getDatoProperties("DPIR");
	protected String DPRA = DatosSistema.getDatoProperties("DPRA");
	
	public static int aux=1;
	//public static x=0;
	protected String rutCli = DatosSistema.getDatoProperties("rutCLiente");
	protected boolean acceptNextAlert = true;
	protected StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		LOGGER.info("INICIANDO @BEFORE setUp():" + this.getClass().getName());
		String operationSystem = System.getProperty("os.name").toLowerCase();
		
			LOGGER.info("setUp():ES WINDOWS");
		//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver72.exe");
		//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver73.exe");
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver74.exe");
		//	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Runners/chromedriver75.exe");
		//	ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--start-maximized");
		//	driver = new ChromeDriver(options);

			//			Codigo que maximiza la pantalla y emula un dispositivo celular
		//	ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--start-maximized");
		//	Map<String, String> mobileEmulation = new HashMap<String, String>();
		//	mobileEmulation.put("deviceName", "Nexus 5");
		//	options.setExperimentalOption("mobileEmulation", mobileEmulation);
		//	driver = new ChromeDriver(options);
			
			//chrome Headless
			LOGGER.info("Abrimos chrome headless");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("--disable-features=VizDisplayCompositor");//para sacar fotos con jenkins
			options.addArguments("window-size=1280x1024");
			driver = new ChromeDriver(options);
			//*/


			driver.manage().window().maximize();
			
			
		
		
	}

	/*-------------------------------------------Seleccion de Tipo Deposito-----------------------------------------*/
	
/*-----------------------------------------------------------------------Moneda--------------------------------------------------------------------------*/
	
/*------------------------------------------------Monto--------------------------------------------------------------*/
	public void SImularDAP() throws IOException{
		LOGGER.info("Vamos a simular");
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[3]/div/input"))
		.sendKeys("55000");
		capturarPantalla(driver, "07");
		LOGGER.info("Presionams plazo");
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[4]/div/input")).click();
		LOGGER.info("");
		waitSleep(2);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[7]/button")).click();
		}
	/*------------------------------------------------------------Flujo-----------------------------------------------------------------------*/
	public void siguienteEmul() throws IOException {
		waitSleep(2);
		LOGGER.info("Estamos esperando el Boton Siguiente");
		Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[9]/button[2]");
		waitSleep(2);
		capturarPantalla(driver, "08");
		LOGGER.info("Estamos esperando el boton simular");
		Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[2]/button[2]");
		capturarPantalla(driver, "09");
		LOGGER.info("Seleccionaremos el tipo de cuenta ");
	}
	/*---------------------------------------------------Dap Siguiente Flujo-----------------------------------------------------*/
	public void TomDApCTACTE() throws IOException {
		Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span");
		capturarPantalla(driver, "10");
		Espera("//a[contains(span,'Corriente')]");
		capturarPantalla(driver, "11");
		Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[6]/div/div/span");
		capturarPantalla(driver, "12");
		Espera("//a[contains(span,'004070093100')]");
		capturarPantalla(driver, "13");
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[10]/input"))
		.sendKeys("55000");
		capturarPantalla(driver, "14");
		Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/button");
		capturarPantalla(driver, "15");
		WebElement sobrecupo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/button[1]"));
		
	}
	public void TomaDAPChequeMismoBanco() {
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-23-0\"]/a")).click();//Cehequera
	}
	public void TomaDAPChequeOtroBanco() {
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-23-1\"]/a/span")).click();//documento otro banco
	}
	public void TomaDAPefectivo() {
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/ng-condiciones-dap-ingreso/div/section/fieldset/div/dap-formas-pago/div/div[1]/div[1]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-23-3\"]/a")).click();//Efectivo
	}
	
	
	public void BtnToma() throws IOException {
		LOGGER.info("Esperamos Boton ");
		capturarPantalla(driver, "16");
		Espera("/html/body/div[4]/div/div/div/div[4]/div[2]/button[3]");
		capturarPantalla(driver, "17");
		waitSleep(5);
		capturarPantalla(driver, "18");
		Espera("//button[@class='btn default simulation-cards-edit focus-rut-cliente mr-15']");
		waitSleep(5);
		capturarPantalla(driver, "19");
	}
	
	/**
	 * Verificacion de popat
	 * @throws IOException 
	 * 
	 * **/
	public void popa() throws IOException {
		waitSleep(2);
		if (driver.findElement(By.xpath("//button[@class='confirm']")).isSelected()) {
			LOGGER.info("Se encontro ellemnto");
			Espera("/html/body/div[2]/div[2]/button[1]");
			waitSleep(1);
			//driver.findElement(By.xpath("")).click();
		}else {
			LOGGER.info("No se encontro ellemnto");
		}
		
	}
	
	/*
	public void ingresoClave() {
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		ClavePRO=DatosSistema.getDatoProperties("Clave");
		//LOGGER.info("clave: " + ClavePRO);
		password.sendKeys(ClavePRO);
	}
	public void botonIngresar() {
		WebElement botonIngreso = driver.findElement(By.id("btn__ingresar"));
		botonIngreso.click();
	}
	public void Transferencias() {
		WebElement botonTransferencias = driver.findElement(By.xpath("//*[@id=\"btn__transfer\"]"));
		botonTransferencias.click();
	}
	public void botonVolver() {
		driver.findElement(By.xpath("//*[@id=\"atras\"]")).click();
	}
	/*---- distintas cuentas -----*/	
	public void CuentaCorriente() {
		WebElement CTACTE = driver.findElement(By.id("cta_cte"));
		CTACTE.click();
		waitSleep(5);
	}
	public void CuentaVista() {
		WebElement CTACTE = driver.findElement(By.id("cta_vista"));
		CTACTE.click();
		waitSleep(5);
	}
	public void caja_vecina() {
		WebElement CTACTE = driver.findElement(By.id("caja_vecina"));
		CTACTE.click();
		waitSleep(5);
	}
	public void lin_cre() {
		WebElement lin_cre = driver.findElement(By.id("lin_cre"));
		lin_cre.click();
		waitSleep(5);
	}
	public void tar_cre() {
		WebElement tar_cre = driver.findElement(By.id("tar_cre"));
		tar_cre.click();
		waitSleep(5);
	}
	

	
	@After
	public void tearDown() throws Exception {

		LOGGER.info("INICIANDO @AFTER tearDown():" + this.getClass().getName());
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
			/*prueba*/
		}
	}
	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	protected void waitSleep(int second) {
		LOGGER.info("INICIO -----> ESPERA:" + second + " / SEGUNDOS");
		long millis = second * 1000;
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOGGER.info("FIN    -----> ESPERA:" + second + " / SEGUNDOS");
	}
	protected void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {
		//LOGGER.info("Captura de pantalla URL: " + driver.getCurrentUrl() + " - Nombre imagen: " + nombreImagen
			//	+ EXTENSION_IMAGEN);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
	}/*PCR*/
	protected void cerrarSecion() {
		waitSleep(10);
		WebElement cerrarSecion = driver.findElement(By.id("logout"));
		cerrarSecion.click();
		LOGGER.info("Se dio Click En Logout");
		waitSleep(2);
		WebElement botonAceptar = driver.findElement(By.id("btn__aceptar"));
		LOGGER.info("Encontramos el boton Aceptar");
		botonAceptar.click();
		LOGGER.info("Se dio Click En Aceptar");
		waitSleep(3);
	}
	
	public void Documento(String filename, String fileContent)   
	         throws Exception {   
	       XWPFDocument document = new XWPFDocument();   
	       XWPFParagraph tmpParagraph = document.createParagraph();   
	       XWPFRun tmpRun = tmpParagraph.createRun();   
	       tmpRun.setText(fileContent);   
	       tmpRun.setFontSize(18);   
	       FileOutputStream fos = new FileOutputStream(new File("./Documento/"+filename + ".doc"));   
		    if (ficheros == null)
			{
				System.out.println("No hay ficheros en el directorio especificado");
			}
			else
			{
				for (int x=0;x<ficheros.length;x++) 
				{					
					tmpRun.setFontSize(20);
					InputStream pic = new FileInputStream("./screenshots/"+ ficheros[x]);
					tmpRun.addPicture(pic, Document.PICTURE_TYPE_JPEG, "1", Units.toEMU(450), Units.toEMU(250));
				}
			}
	       document.write(fos);   
	       fos.close();   
	    }   
	public void Disabled(String xpath) {
		WebElement yourButton = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", yourButton);
		js.executeScript("arguments[0].removeAttribute('disabled','disabled')", yourButton);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(yourButton));
		yourButton.click();
	}
	public void radio(String xpath) {
		WebElement yourButton = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('checked','checked')", yourButton);
		js.executeScript("arguments[0].setAttribute('display','block')", yourButton);
		js.executeScript("arguments[0].setAttribute('disabled','true')", yourButton);
		js.executeScript("arguments[0].setAttribute('checked','true')", yourButton);
		js.executeScript("arguments[0].setAttribute('checked', 'checked')", yourButton);
	}
	public void button(String xpath) {
		driver.switchTo().activeElement();
		WebElement yourButton = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('type','submit')", yourButton);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(yourButton));
		yourButton.click();
	}
	public void scroll() throws IOException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Calendar calendario = new GregorianCalendar();
		//int hora = calendario.get(Calendar.HOUR_OF_DAY);
		//capturarPantalla(driver, "sroll " + hora);
	}
	public static void ScreenShot() throws IOException{
		DateFormat horaFecha = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date fecha = new Date();
		String nombreFoto = "Imagen"+horaFecha.format(fecha)+".JPG";
		String rutaFoto = "./screenshots/fotosdirectas/";
		
		File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File(rutaFoto + nombreFoto));
	}
	
	public static void Espera(String nombre) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Siguiente = 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.
						xpath(nombre)));
		Siguiente.click();
	}
	public static void EsperaSendKeys(String nombre, String Keys) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Siguiente = 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.
						xpath(nombre)));
		Siguiente.sendKeys(Keys);
	}
	public static void EsperaSinClick(String nombre) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nombre)));
		
	}
	public static void EsperaIDSinClick(String nombre) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(nombre)));
	}
	public static void eliminarFichero() {
		
		if (ficheros == null)
			  System.out.println("No hay ficheros en el directorio especificado");
			else { 
			  for (int x=0;x<ficheros.length;x++) {
				  LOGGER.info(ficheros[x]);
				  
			  }
			  
			  }
		}
}