package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IgracTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado=new Igrac();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado=null;
	}
	@Test
	void testIgrac() {
		Tim t=new Tim(1l, "Zvezda", null);
		Fudbaler f=new Fudbaler(1l, "Filip", "Gavranovic", 24);
		ado = new Igrac(t, 1, "Golman", f);

		assertEquals(t, ((Igrac) ado).getTim());
		assertEquals(1, ((Igrac) ado).getBrojNaDresu());
		assertEquals("Golman", ((Igrac) ado).getPozicija());
		assertEquals(f, ((Igrac) ado).getFudbaler());
	}
	@Test
	void testTim() {
		Tim t=new Tim(1l, "Zvezda", null);
		((Igrac) ado).setTim(t);

		assertEquals(t, ((Igrac) ado).getTim());
	}
	@Test
	void testBrojNaDresu() {
		((Igrac) ado).setBrojNaDresu(1);;

		assertEquals(1, ((Igrac) ado).getBrojNaDresu());
	}
	@Test
	void testPozicija() {
		((Igrac) ado).setPozicija("Golman");;

		assertEquals("Golman", ((Igrac) ado).getPozicija());
	}
	@Test
	void testFudbaler() {
		Fudbaler f=new Fudbaler(1l, "Filip", "Gavranovic", 24);
		((Igrac) ado).setFudbaler(f);;

		assertEquals(f, ((Igrac) ado).getFudbaler());
	}
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains(" Igrac "));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("i"));
	}
	
	@Test
	void testJoin() {
		assertEquals("JOIN TIM T ON (T.TIMID = I.TIMID) "
                + "JOIN FUDBALER F ON (F.FUDBALERID = I.FUDBALERID)", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals(" (TimID, brojNaDresu, pozicija, FudbalerID) ", ado.koloneZaInsert());
	}
	@Test
	void testPrimarniKljuc() {
		Tim t=new Tim();
		t.setTimID(1l);
		((Igrac) ado).setTim(t);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Igrac) ado).setBrojNaDresu(1);
		((Igrac) ado).setPozicija("Golman");
		Tim t=new Tim();
		t.setTimID(2l);
		Fudbaler f=new Fudbaler();
		f.setFudbalerID(3l);
		((Igrac) ado).setTim(t);
		((Igrac) ado).setFudbaler(f);

		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("1"));
		assertTrue(s.contains("Golman"));
		assertTrue(s.contains("2"));	
		assertTrue(s.contains("3"));
	}
	@Test
	void testVrednostiZaUpdate() {
		assertEquals("", ado.vrednostiZaUpdate());
	}
	
	@Test
	void testUslov() {
		Tim t=new Tim();
		t.setTimID(1l);
		((Igrac) ado).setTim(t);
		String s=ado.uslov();
		assertTrue(s.contains("1"));
		
	}

}
