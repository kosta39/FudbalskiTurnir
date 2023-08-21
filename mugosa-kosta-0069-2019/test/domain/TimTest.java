package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado=new Tim();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado=null;
	}
	@Test
	void testTim() {
		ArrayList<Igrac> igraci=new ArrayList<>();
		Igrac i=new Igrac();
		igraci.add(i);
		ado=new Tim(1l, "Zvezda", igraci);

		assertEquals(1l, ((Tim) ado).getTimID());
		assertEquals("Zvezda", ((Tim) ado).getNazivTima());
		assertEquals(igraci, ((Tim) ado).getIgraci());
	}
	@Test
	void testNaziv() {
		((Tim) ado).setNazivTima("Zvezda");;

		assertEquals("Zvezda", ((Tim) ado).getNazivTima());
	}
	@Test
	void testIgraci() {
		ArrayList<Igrac> igraci=new ArrayList<>();
		Igrac i=new Igrac();
		igraci.add(i);
		((Tim) ado).setIgraci(igraci);

		assertEquals(igraci, ((Tim) ado).getIgraci());
	}
	@Test
	void testTimID() {
		((Tim) ado).setTimID(1l);

		assertEquals(1l, ((Tim) ado).getTimID());
	}
	@Test
	void testToString() {
		ArrayList<Igrac> igraci=new ArrayList<>();
		Igrac i=new Igrac();
		igraci.add(i);
		ado=new Tim(1l, "Zvezda", igraci);
		
		String s = ado.toString();

		assertTrue(s.contains("Zvezda"));
	}
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("Tim"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("t"));
	}
	
	@Test
	void testJoin() {
		assertEquals("", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals(" (NazivTima) ", ado.koloneZaInsert());
	}
	@Test
	void testPrimarniKljuc() {
		((Tim) ado).setTimID(1l);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Tim) ado).setNazivTima("Zvezda");

		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("Zvezda"));
	}
	@Test
	void testVrednostiZaUpdate() {
		((Tim) ado).setNazivTima("Zvezda");

		String s = ado.vrednostiZaUpdate();
		
		assertTrue(s.contains("Zvezda"));
	}
	
	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}

}
