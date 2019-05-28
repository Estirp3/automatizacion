package com.BCH.selenium.abs;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class Login extends AbsTest{
	private static final Logger LOGGER = Logger.getLogger(Login.class);
	
	public void Ingreso() throws IOException {
		LOGGER.info("Ingresamos a la URL " + url);
		driver.get(url);
		capturarPantalla(driver, "01");
	}
	public void IngresarUsuario() throws IOException {
		LOGGER.info("Estamos poniendo el usuario");
		if (driver.findElement(By.xpath(LoginName)).isDisplayed()) 
		{
			LOGGER.info("Se encontro el name");
			EsperaSendKeys(LoginName, usuario);
			capturarPantalla(driver,"02");
			EsperaSendKeys(LoginPass,Clave);
			capturarPantalla(driver,"03");
			Espera(LoginBoton);
		}else {
			LOGGER.info("No se encontro el elementpo ");
		}

	}
	public void BusquedaRut() throws IOException {
	
		String URLActual = driver.getCurrentUrl();
		waitSleep(2);
		if (URLActual != url) {
			LOGGER.info("Estamos poniendo la clave");
			IngresarUsuario();
			
		}else {
					
		}
		LOGGER.info("Espera a que salga el cuadro pa ingresar rut");
		Espera("/html/body/div[1]/header/div/div[3]/div/ng-buscar-cliente-escritorio/form/a");
		LOGGER.info(" Verificar - rut cliente");
		EsperaIDSinClick("rut");
		WebElement rut = driver.findElement(By.id("rut"));
		rut.sendKeys(rutCli);
		capturarPantalla(driver, "04");
		Espera("/html/body/div[1]/header/div/div[3]/div/ng-buscar-cliente-escritorio/form/a");
	}
	public Login(){
		
	}

}
