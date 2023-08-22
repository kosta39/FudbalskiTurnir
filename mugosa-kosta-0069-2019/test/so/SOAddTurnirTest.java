package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Turnir;

class SOAddTurnirTest {
	SOAddTurnir so;
	
	@BeforeEach
	void setUp() throws Exception {
		so=new SOAddTurnir();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	
	@Test
	void testUspesnoDodatTurnir() {
		SOGetAllTurnir pom=new SOGetAllTurnir();
		pom.templateExecute(new Turnir());
		ArrayList<Turnir> turniri=pom.getLista();
	}
}
