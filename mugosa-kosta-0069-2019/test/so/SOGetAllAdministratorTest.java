package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Administrator;
import domain.Igrac;

class SOGetAllAdministratorTest {
	SOGetAllAdministrator so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SOGetAllAdministrator();
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
	void testUspesnoVracenaListaAdministratora() {
		try {
			so.templateExecute(new Administrator());
			ArrayList<Administrator> vraceni = so.getLista();

			assertEquals(2, vraceni.size());
			assertTrue(vraceni.get(0).getUsername().equalsIgnoreCase("kosta") && 
					vraceni.get(0).getPassword().equalsIgnoreCase("kosta123"));
			assertTrue(vraceni.get(1).getUsername().equalsIgnoreCase("aleksandar") && 
					vraceni.get(1).getPassword().equalsIgnoreCase("aleksandar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
