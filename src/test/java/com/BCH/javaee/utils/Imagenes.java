package com.BCH.javaee.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Imagenes {

	private static final Logger LOGGER = Logger.getLogger(Imagenes.class);
	private static final String EXTENSION_IMAGEN = ".png";

	public static void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {
		LOGGER.info("Captura de pantalla URL: " + driver.getCurrentUrl() + " - Nombre imagen: " + nombreImagen
				+ EXTENSION_IMAGEN);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
	}
}
