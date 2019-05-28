package com.BCH.selenium.pruebas;

//import java.io.IOException;

import org.junit.Test;


import org.apache.log4j.Logger;
import com.BCH.selenium.abs.AbsTest;
import com.BCH.selenium.abs.Login;
import com.BCH.selenium.abs.Seleccion_DAP_Vista360;
import com.BCH.selenium.abs.Toma_DAP;

public class Test_01_DAP_CLP extends AbsTest {
	private static final Logger LOGGER = Logger.getLogger(Test_01_DAP_CLP.class);

	@Test
	public void DAP_CLP() throws Exception {
		
		Login login = new Login();
		login.Ingreso();
		LOGGER.info("Ingresaremos el usuario y sus datos");
		login.IngresarUsuario();
		LOGGER.info("Ingresaremos a buscar RUT");
		login.BusquedaRut();
		scroll();
		Seleccion_DAP_Vista360 V360 = new Seleccion_DAP_Vista360();
		V360.DAP();
		Toma_DAP TDAP = new Toma_DAP();
		TDAP.Seleccion();
		TDAP.DPF();
		//TDAP.DPIR();
		
		/*
		
		DAP();
		LOGGER.info("Toma DPF");
		DPF();
		LOGGER.info("Seleccionamos Pesos");
		pesos();
		scroll();
		LOGGER.info("Nos vamos  Simular");
		SImularDAP();
		LOGGER.info("segunda emulacion");
		siguienteEmul();
		LOGGER.info("TomDApCTACTE");
		TomDApCTACTE();
		popa();
		LOGGER.info("BtnToma");
		BtnToma();
		LOGGER.info("creamos archivo ");
		Documento("DAP_CLP","Pruebas");
		eliminarFichero();
			*/	
	}
	
}