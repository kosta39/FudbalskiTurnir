package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnirTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado=new Turnir();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado=null;
	}
	@Test
	void testTurnir() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d1=null;
		Date d2=null;
		try {
			d1 = sdf.parse("25.06.2023");
			d2 = sdf.parse("30.06.2023");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		Administrator a=new Administrator(1l, "Kosta", "Mugosa", "kosta", "kosta123");
		ArrayList<Utakmica> utakmice=new ArrayList<>();
		Utakmica u=new Utakmica();
		utakmice.add(u);
		ado=new Turnir(1l, "Letnji turnir", d1, d2, "Beograd", a, utakmice);
		
		assertEquals(1l, ((Turnir) ado).getTurnirID());
		assertEquals("Letnji turnir", ((Turnir) ado).getNazivTurnira());
		assertEquals(d1, ((Turnir) ado).getDatumOd());
		assertEquals(d2, ((Turnir) ado).getDatumDo());
		assertEquals("Beograd", ((Turnir) ado).getGrad());
		assertEquals(a, ((Turnir) ado).getAdministrator());
		assertEquals(utakmice, ((Turnir) ado).getUtakmice());
	}
	@Test
	void testNaziv() {
		((Turnir) ado).setNazivTurnira("Letnji turnir");

		assertEquals("Letnji turnir", ((Turnir) ado).getNazivTurnira());
	}
	@Test
	void testDatumOd() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d=null;
		try {
			d = sdf.parse("25.06.2023");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		((Turnir) ado).setDatumOd(d);

		assertEquals(d, ((Turnir) ado).getDatumOd());
	}
	@Test
	void testDatumDo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d=null;
		try {
			d = sdf.parse("30.06.2023");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		((Turnir) ado).setDatumDo(d);

		assertEquals(d, ((Turnir) ado).getDatumDo());
	}
	@Test
	void testGrad() {
		((Turnir) ado).setGrad("Beograd");

		assertEquals("Beograd", ((Turnir) ado).getGrad());
	}
	@Test
	void testTurnirID() {
		((Turnir) ado).setTurnirID(1l);

		assertEquals(1l, ((Turnir) ado).getTurnirID());
	}
	@Test
	void testAdministrator() {
		Administrator a=new Administrator(1l, "Kosta", "Mugosa", "kosta", "kosta123");
		((Turnir) ado).setAdministrator(a);

		assertEquals(a, ((Turnir) ado).getAdministrator());
	}
	@Test
	void testUtakmice() {
		ArrayList<Utakmica> utakmice=new ArrayList<>();
		Utakmica u=new Utakmica();
		utakmice.add(u);
		((Turnir) ado).setUtakmice(utakmice);

		assertEquals(utakmice, ((Turnir) ado).getUtakmice());
	}
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains(" turnir "));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("tur"));
	}
	
	@Test
	void testJoin() {
		assertEquals(" JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = TUR.ADMINISTRATORID) ", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals(" (nazivTurnira, datumOd, datumDo, grad, administratorID) ", ado.koloneZaInsert());
	}
	@Test
	void testPrimarniKljuc() {
		((Turnir) ado).setTurnirID(1l);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Turnir) ado).setGrad("Beograd");
		((Turnir) ado).setNazivTurnira("Letnji turnir");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d1=null;
		Date d2=null;
		try {
			d1 = sdf.parse("25.06.2023");
			d2 = sdf.parse("30.06.2023");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		Administrator a=new Administrator(1l, "Kosta", "Mugosa", "kosta", "kosta123");
		((Turnir) ado).setAdministrator(a);
		((Turnir) ado).setDatumOd(d1);
		((Turnir) ado).setDatumDo(d2);
		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("Beograd"));
		assertTrue(s.contains("Letnji turnir"));
		assertTrue(s.contains("2023-06-25"));	
		assertTrue(s.contains("2023-06-30"));
		assertTrue(s.contains("1"));
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
