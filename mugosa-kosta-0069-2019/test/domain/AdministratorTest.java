package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AdministratorTest extends AbstractDomainObjectTest{


	@BeforeEach
	void setUp() throws Exception {
		ado=new Administrator();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado=null;
	}
	@Test
	void testAdministrator() {
		ado = new Administrator(1l, "Kosta", "Mugosa", "kosta", "kosta123");

		assertEquals(1l, ((Administrator) ado).getAdministratorID());
		assertEquals("Kosta", ((Administrator) ado).getIme());
		assertEquals("Mugosa", ((Administrator) ado).getPrezime());
		assertEquals("kosta", ((Administrator) ado).getUsername());
		assertEquals("kosta123", ((Administrator) ado).getPassword());
	}
	@Test
	void testIme() {
		((Administrator) ado).setIme("Kosta");

		assertEquals("Kosta", ((Administrator) ado).getIme());
	}
	@Test
	void testPrezime() {
		((Administrator) ado).setPrezime("Mugosa");

		assertEquals("Mugosa", ((Administrator) ado).getPrezime());
	}
	@Test
	void testUsername() {
		((Administrator) ado).setUsername("kosta");

		assertEquals("kosta", ((Administrator) ado).getUsername());
	}
	@Test
	void testPassword() {
		((Administrator) ado).setPassword("kosta123");

		assertEquals("kosta123", ((Administrator) ado).getPassword());
	}
	@Test
	void testAdministratorID() {
		((Administrator) ado).setAdministratorID(1l);

		assertEquals(1l, ((Administrator) ado).getAdministratorID());
	}
	@Test
	void testToString() {
		ado = new Administrator(1l, "Kosta", "Mugosa", "kosta", "kosta123");
		
		String s = ado.toString();

		assertTrue(s.contains("Kosta"));
		assertTrue(s.contains("Mugosa"));
	}
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("administrator"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("a"));
	}
	
	@Test
	void testJoin() {
		assertEquals("", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals(" (Ime, Prezime, Username, Password) ", ado.koloneZaInsert());
	}
	@Test
	void testPrimarniKljuc() {
		((Administrator) ado).setAdministratorID(1l);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Administrator) ado).setUsername("kosta");
		((Administrator) ado).setPassword("kosta123");
		((Administrator) ado).setIme("Kosta");
		((Administrator) ado).setPrezime("Mugosa");

		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("kosta"));
		assertTrue(s.contains("kosta123"));
		assertTrue(s.contains("Kosta"));	
		assertTrue(s.contains("Mugosa"));
	}
	@Test
	void testVrednostiZaUpdate() {
		((Administrator) ado).setUsername("kosta");
		((Administrator) ado).setPassword("kosta123");
		((Administrator) ado).setIme("Kosta");
		((Administrator) ado).setPrezime("Mugosa");

		String s = ado.vrednostiZaUpdate();
		
		assertTrue(s.contains("kosta"));
		assertTrue(s.contains("kosta123"));
		assertTrue(s.contains("Kosta"));	
		assertTrue(s.contains("Mugosa"));
	}
	
	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}
}
