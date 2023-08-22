package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Administrator;
import domain.Igrac;
import domain.Tim;

class SOGetAllTimTest {
	SOGetAllTim so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SOGetAllTim();
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
	void testUspesnoVracenaListaTimova() {
		try {
			so.templateExecute(new Tim());
			ArrayList<Tim> vraceni = so.getLista();

			assertEquals(5, vraceni.size());
			assertTrue(vraceni.get(0).getNazivTima().equalsIgnoreCase("Zvezda"));
			assertTrue(vraceni.get(1).getNazivTima().equalsIgnoreCase("Partizan"));
			assertTrue(vraceni.get(2).getNazivTima().equalsIgnoreCase("Radnicki Nis"));
			assertTrue(vraceni.get(3).getNazivTima().equalsIgnoreCase("Balkan Mirjevo"));
			assertTrue(vraceni.get(4).getNazivTima().equalsIgnoreCase("Buducnost"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
