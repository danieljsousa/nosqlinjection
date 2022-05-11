package com.nosqlinjection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import insted.ValidaLogin;



public class ValidaLoginTest{


	@Test
	public void testLogin1(){
		ValidaLogin auxValida = new ValidaLogin("myDB.db");
		boolean sevalidou = auxValida.processaLogin("daniel","teste123");
		assertEquals(sevalidou, false);
	}

	@Test
	public void testLogin2(){
		ValidaLogin auxValida = new ValidaLogin("myDB.db");
		boolean sevalidou = auxValida.processaLogin("admin","admin123");
		assertEquals(sevalidou, true);
	}

	/*@Test
	public void testLoginInject1(){
		ValidaLogin auxValida = new ValidaLogin("myDB.db");
		boolean sevalidou = auxValida.processaLogin("' or true --","qualquersenha");
		assertEquals(sevalidou, false);
	}*/
}


