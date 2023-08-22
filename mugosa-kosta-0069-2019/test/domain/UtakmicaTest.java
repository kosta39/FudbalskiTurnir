package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtakmicaTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado=new Utakmica();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado=null;
	}
	@Test
	void testUtakmica() {
		Turnir t=new Turnir();
		t.setTurnirID(1l);
		Tim t1=new Tim();
		t1.setTimID(2l);
		t1.setNazivTima("Zvezda");
		Tim t2=new Tim();
		t2.setTimID(3l);
		t2.setNazivTima("Partizan");
		ado = new Utakmica(t, 1, 3, 0, "Zvezda", t1, t2);

		assertEquals(t, ((Utakmica) ado).getTurnir());
		assertEquals(1, ((Utakmica) ado).getRbUtakmice());
		assertEquals(3, ((Utakmica) ado).getBrojGolovaPrvi());
		assertEquals(0, ((Utakmica) ado).getBrojGolovaDrugi());
		assertEquals("Zvezda", ((Utakmica) ado).getPobednik());
		assertEquals(t1, ((Utakmica) ado).getPrviTim());
		assertEquals(t2, ((Utakmica) ado).getDrugiTim());
	}
	@Test
	void testTurnir() {
		Turnir t=new Turnir();
		t.setTurnirID(1l);
		((Utakmica) ado).setTurnir(t);

		assertEquals(t, ((Utakmica) ado).getTurnir());
	}
	@Test
	void testRedniBroj() {
		((Utakmica) ado).setRbUtakmice(1);

		assertEquals(1, ((Utakmica) ado).getRbUtakmice());
	}
	@Test
	void testBrojGolovaPrviTim() {
		((Utakmica) ado).setBrojGolovaPrvi(3);

		assertEquals(3, ((Utakmica) ado).getBrojGolovaPrvi());
	}
	@Test
	void testBrojGolovaDrugiTim() {
		((Utakmica) ado).setBrojGolovaDrugi(0);

		assertEquals(0, ((Utakmica) ado).getBrojGolovaDrugi());
	}
	@Test
	void testPobednik() {
		((Utakmica) ado).setPobednik("Zvezda");

		assertEquals("Zvezda", ((Utakmica) ado).getPobednik());
	}
	@Test
	void testPrviTim() {
		Tim t1=new Tim();
		t1.setTimID(2l);
		t1.setNazivTima("Zvezda");
		((Utakmica) ado).setPrviTim(t1);

		assertEquals(t1, ((Utakmica) ado).getPrviTim());
	}
	@Test
	void testDrugiTim() {
		Tim t2=new Tim();
		t2.setTimID(3l);
		t2.setNazivTima("Partizan");
		((Utakmica) ado).setDrugiTim(t2);

		assertEquals(t2, ((Utakmica) ado).getDrugiTim());
	}
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("Utakmica"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("u"));
	}
	
	@Test
	void testJoin() {
		assertEquals(" JOIN TURNIR TUR USING (TURNIRID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = TUR.ADMINISTRATORID) "
                + "JOIN TIM PRVITIM ON (PRVITIM.TIMID = U.PRVITIMID) "
                + "JOIN TIM DRUGITIM ON (DRUGITIM.TIMID = U.DRUGITIMID)", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals(" (turnirID, rbUtakmice, brojGolovaPrvi, brojGolovaDrugi, pobednik, "
                + "prviTimID, drugiTimID) ", ado.koloneZaInsert());
	}
	@Test
	void testPrimarniKljuc() {
		Turnir t=new Turnir();
		t.setTurnirID(1l);
		((Utakmica) ado).setTurnir(t);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Utakmica) ado).setRbUtakmice(4);
		((Utakmica) ado).setBrojGolovaPrvi(5);
		((Utakmica) ado).setBrojGolovaDrugi(0);
		((Utakmica) ado).setPobednik("Zvezda");
		Turnir t=new Turnir();
		t.setTurnirID(1l);
		Tim t1=new Tim();
		t1.setTimID(2l);
		t1.setNazivTima("Zvezda");
		Tim t2=new Tim();
		t2.setTimID(3l);
		t2.setNazivTima("Partizan");
		((Utakmica) ado).setTurnir(t);
		((Utakmica) ado).setPrviTim(t1);
		((Utakmica) ado).setDrugiTim(t2);

		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("1"));
		assertTrue(s.contains("2"));
		assertTrue(s.contains("3"));	
		assertTrue(s.contains("4"));
		assertTrue(s.contains("5"));
		assertTrue(s.contains("0"));
		assertTrue(s.contains("Zvezda"));
	}
	@Test
	void testVrednostiZaUpdate() {
		assertEquals("", ado.vrednostiZaUpdate());
	}
	
	@Test
	void testUslov() {
		Turnir t=new Turnir();
		t.setTurnirID(1l);
		((Utakmica) ado).setTurnir(t);
		String s=ado.uslov();
		assertTrue(s.contains("1"));
	}

}
