package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FudbalerTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado=new Fudbaler();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado=null;
	}
	@Test
	void testAdministrator() {
		ado=new Fudbaler(1l, "Filip", "Gavranovic", 24);

		assertEquals(1l, ((Fudbaler) ado).getFudbalerID());
		assertEquals("Filip", ((Fudbaler) ado).getImeFudbalera());
		assertEquals("Gavranovic", ((Fudbaler) ado).getPrezimeFudbalera());
		assertEquals(24, ((Fudbaler) ado).getGodine());
	}
	@Test
	void testIme() {
		((Fudbaler) ado).setImeFudbalera("Filip");

		assertEquals("Filip", ((Fudbaler) ado).getImeFudbalera());
	}
	@Test
	void testPrezime() {
		((Fudbaler) ado).setPrezimeFudbalera("Gavranovic");

		assertEquals("Gavranovic", ((Fudbaler) ado).getPrezimeFudbalera());
	}
	@Test
	void testGodine() {
		((Fudbaler) ado).setGodine(24);

		assertEquals(24, ((Fudbaler) ado).getGodine());
	}
	@Test
	void testAdministratorID() {
		((Fudbaler) ado).setFudbalerID(1l);

		assertEquals(1l, ((Fudbaler) ado).getFudbalerID());
	}
	@Test
	void testToString() {
		ado=new Fudbaler(1l, "Filip", "Gavranovic", 24);
		
		String s = ado.toString();

		assertTrue(s.contains("Filip"));
		assertTrue(s.contains("Gavranovic"));
	}
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("Fudbaler"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("f"));
	}
	
	@Test
	void testJoin() {
		assertEquals("", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals("  ", ado.koloneZaInsert());
	}
	@Test
	void testPrimarniKljuc() {
		((Fudbaler) ado).setFudbalerID(1l);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		assertEquals("", ado.vrednostiZaInsert());
	}
	@Test
	void testVrednostiZaUpdate() {
		assertEquals("", ado.vrednostiZaUpdate());
	}
	
	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}

}
