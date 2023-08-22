package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Igrac;
import domain.Tim;
import domain.Turnir;

class SOGetAllTurnirTest {
	SOGetAllTurnir so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SOGetAllTurnir();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	@Test
	void testNeuspesnaValidacijaPogresnaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Igrac()));
	}
	@Test
	void testNeuspesnaValidacijaNullKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}
	@Test
	void testUspesnoVracenaListaTurnira() {
		try {
			so.templateExecute(new Turnir());
			ArrayList<Turnir> vraceni = so.getLista();

			assertEquals(3, vraceni.size());
			assertTrue(vraceni.get(0).getNazivTurnira().equalsIgnoreCase("Letnji turnir"));
			assertTrue(vraceni.get(1).getNazivTurnira().equalsIgnoreCase("Turnir 4"));
			assertTrue(vraceni.get(2).getNazivTurnira().equalsIgnoreCase("Kakice"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
