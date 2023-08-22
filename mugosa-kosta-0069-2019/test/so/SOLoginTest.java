package so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Administrator;
import domain.Igrac;

class SOLoginTest {
	SOLogin so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SOLogin();
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
	void testLoginNemaAdministratoraSaDatimKredencijalima() {
		Administrator a = new Administrator();
		a.setUsername("mirko");
		a.setPassword("mirko123");
	
		assertThrows(Exception.class, () -> so.templateExecute(a));
	}
	@Test
	void testLoginRegistracijaUspela() {
		Administrator admin = new Administrator();
		admin.setUsername("kosta");
		admin.setPassword("kosta123");
		
		try {
			so.templateExecute(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(admin.getUsername(), so.getUlogovani().getUsername());
		assertEquals(admin.getPassword(), so.getUlogovani().getPassword());
	}
}
