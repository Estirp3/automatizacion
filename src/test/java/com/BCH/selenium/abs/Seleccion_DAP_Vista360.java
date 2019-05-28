package com.BCH.selenium.abs;

import org.apache.log4j.Logger;



public class Seleccion_DAP_Vista360 extends AbsTest{
	private static final Logger LOGGER = Logger.getLogger(Seleccion_DAP_Vista360.class);

	
	
	public void DAP() throws Exception{
		LOGGER.info("Esperamos que aparesca Vista 360");
		EsperaSinClick(V360);
		capturarPantalla(driver, "05");
		EsperaSinClick(SDap);
		LOGGER.info("Seleccionamos la Opcion Dap de Vista 360");
		capturarPantalla(driver, "06");
		Espera(SDap);
		LOGGER.info("Espera");
		EsperaSinClick(TDap);
		capturarPantalla(driver, "07");
		Espera(TDap);
	}
	
	public Seleccion_DAP_Vista360() {}
}
