package com.BCH.selenium.abs;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;




public class Toma_DAP extends AbsTest{
	private static final Logger LOGGER = Logger.getLogger(Toma_DAP.class);
	
	public void Seleccion() throws IOException {
		LOGGER.info("Presionamos tipo de documento ");
		Espera(Seleccion);
		capturarPantalla(driver, "09");
	}
	public void DPF() throws IOException {

		waitSleep(1);
		LOGGER.info("Vamos a seleccionar el tipo del DAP - DPF");
		Espera(DPF);
		capturarPantalla(driver, "10");
	}
	public void DPIR() throws IOException {
		waitSleep(1);
		LOGGER.info("Vamos a seleccionar el tipo del DAP - DPRI");
		Espera(DPIR);
		capturarPantalla(driver, "10");
	}
	public void DPRA() throws IOException {
		waitSleep(1);
		LOGGER.info("Vamos a seleccionar el tipo del DAP - DPRA");
		Espera(DPRA);
		capturarPantalla(driver, "10");
	}	
	
	public void pesos() {
		Espera("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[2]/div/div/span");
		Espera("//*[@id=\"ui-select-choices-row-3-0\"]/a");
	}
	public void dolar() {
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[2]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-2-1\"]/a")).click();
	}
	public void UF() {
		driver.findElement(By.xpath("//*[@id=\"vmInit\"]/div/ng-simulacion-dap-ingreso/section[1]/form/div/div/div[1]/div[1]/div/div[2]/div/div/span")).click();
		waitSleep(1);
		driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-2-2\"]/a")).click();
	}
	
	public Toma_DAP() {
		
	}
}
