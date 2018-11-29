package com.bcopstein.ExercicioRefatoracaoBanco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ContaTest {
	
	private Conta c;
	
	

	@Test
	void instanceTest() {
		
		c = new Conta(100,"thalles");
		
		assertEquals(true,c.getStatus() instanceof ContaSilver);
	}
	
	@ParameterizedTest
	@CsvSource({"100,100,0","50,50.5,1","20,20.5,2"})
	void depositoGoldenTest(int x, double resp,int state) {
		
		c = new Conta(100,"thalles",0, FactoryState.createInstance(state));
		
	
		
		assertEquals(resp, c.deposito(x));
	}
	
	
}
