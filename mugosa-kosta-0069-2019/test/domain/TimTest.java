package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import so.SOGetAllTim;

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
		((Tim) ado).setNazivTima("Inter");

		assertEquals("Inter", ((Tim) ado).getNazivTima());
	}
	@Test
	void testNazivVecPostoji() {
		SOGetAllTim pom=new SOGetAllTim();
		try {
			pom.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Tim> timovi=pom.getLista();
		Tim t=timovi.get(0);
		assertThrows(IllegalArgumentException.class,
				() ->  ((Tim)ado).setNazivTima(t.getNazivTima()) );
	}
	@Test
	void testIgraci() {
		ArrayList<Igrac> igraci=new ArrayList<>();
		Igrac i=new Igrac();
		Igrac i1=new Igrac();
		Igrac i2=new Igrac();
		Igrac i3=new Igrac();
		Igrac i4=new Igrac();
		igraci.add(i);
		igraci.add(i1);
		igraci.add(i2);
		igraci.add(i3);
		igraci.add(i4);
		((Tim) ado).setIgraci(igraci);

		assertEquals(igraci, ((Tim) ado).getIgraci());
	}
	@Test
	void testBrojIgracaManjeOdPet() {
		ArrayList<Igrac> igraci=new ArrayList<>();
		Igrac i1=new Igrac();
		Igrac i2=new Igrac();
		Igrac i3=new Igrac();
		Igrac i4=new Igrac();
		igraci.add(i1);
		igraci.add(i2);
		igraci.add(i3);
		igraci.add(i4);
		assertThrows(IllegalArgumentException.class,
				() ->  ((Tim)ado).setIgraci(igraci) );
	}
	@Test
	void testBrojIgracaViseOd10() {
		ArrayList<Igrac> igraci=new ArrayList<>();
		Igrac i1=new Igrac();
		Igrac i2=new Igrac();
		Igrac i3=new Igrac();
		Igrac i4=new Igrac();
		Igrac i5=new Igrac();
		Igrac i6=new Igrac();
		Igrac i7=new Igrac();
		Igrac i8=new Igrac();
		Igrac i9=new Igrac();
		Igrac i10=new Igrac();
		Igrac i11=new Igrac();
		igraci.add(i1);
		igraci.add(i2);
		igraci.add(i3);
		igraci.add(i4);
		igraci.add(i5);
		igraci.add(i6);
		igraci.add(i7);
		igraci.add(i8);
		igraci.add(i9);
		igraci.add(i10);
		igraci.add(i11);
		assertThrows(IllegalArgumentException.class,
				() ->  ((Tim)ado).setIgraci(igraci) );
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
		
		assertTrue(s.toLowerCase().contains(" tim "));
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
		((Tim) ado).setNazivTima("Inter");

		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("Inter"));
	}
	@Test
	void testVrednostiZaUpdate() {
		((Tim) ado).setNazivTima("Inter");

		String s = ado.vrednostiZaUpdate();
		
		assertTrue(s.contains("Inter"));
	}
	
	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}
	@ParameterizedTest
	@CsvSource({
		"Ime, Ime, true",
		"Ime, Prezime, false"
	})
	void testEqualsIsti(String ime1,String ime2,boolean isti) {
		Turnir t1=new Turnir();
		t1.setNazivTurnira(ime1);
		Turnir t2=new Turnir();
		t2.setNazivTurnira(ime2);
		assertEquals(isti, t1.equals(t2));
	}
	@Test
	void testEqualsNull() {
		assertFalse(ado.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(ado.equals(ado));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(ado.equals(new Exception()));
	}
}
