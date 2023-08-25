package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Fudbaler;
import domain.Igrac;
import domain.Tim;

class SOAddTimTest {
	SOAddTim so;
	@BeforeEach
	void setUp() throws Exception {
		so=new SOAddTim();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	
	@Test
	void testUspesnoDodatTim() {
		SOGetAllTim pom=new SOGetAllTim();
		try {
			pom.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Tim> timovi=pom.getLista();
		int brojTimovaPre=timovi.size();
		
		Tim t=new Tim();
		t.setNazivTima("Rudar");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Fudbaler f3=new Fudbaler(39l, "Pablo", "Gavi", 19);
		Fudbaler f4=new Fudbaler(38l, "Simon", "Mrvaljevic", 26);
		Fudbaler f5=new Fudbaler(37l, "Daniele", "Rugani", 26);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		Igrac i3=new Igrac(t, 3, "Bek", f3);
		Igrac i4=new Igrac(t, 4, "Krilo", f4);
		Igrac i5=new Igrac(t, 5, "Spic", f5);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		igraci.add(i2);
		igraci.add(i3);
		igraci.add(i4);
		igraci.add(i5);
		t.setIgraci(igraci);
		try {
			so.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SOGetAllTim pom1=new SOGetAllTim();
		try {
			pom1.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timovi=pom1.getLista();
		SOGetAllIgrac pom2=new SOGetAllIgrac();
		try {
			pom2.templateExecute(i1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Igrac> igraciIzBaze=pom2.getLista();
		assertEquals(brojTimovaPre+1, timovi.size());
		assertTrue(timovi.contains(t));
		assertEquals(5, igraciIzBaze.size());
		assertTrue(i1.getTim().equals(igraciIzBaze.get(0).getTim()));
		assertTrue(i2.getTim().equals(igraciIzBaze.get(1).getTim()));
		assertTrue(i3.getTim().equals(igraciIzBaze.get(2).getTim()));
		assertTrue(i4.getTim().equals(igraciIzBaze.get(3).getTim()));
		assertTrue(i5.getTim().equals(igraciIzBaze.get(4).getTim()));
		
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void testNeuspesnaValidacijaPogresnaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Igrac()));
	}
	@Test
	void testNeuspesnaValidacijaNullKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}
	void testNedozvoljenBrojIgracaNula() {
		Tim t=new Tim();
		t.setNazivTima("Sutjeska");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		t.setIgraci(igraci);
		assertThrows(Exception.class, ()->so.templateExecute(t));
	}
	void testNedozvoljenBrojIgracaJedan() {
		Tim t=new Tim();
		t.setNazivTima("Sutjeska");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		t.setIgraci(igraci);
		assertThrows(Exception.class, ()->so.templateExecute(t));
	}
	/*
	@Test
	void testNedozvoljenBrojIgracaCetiri() {
		Tim t=new Tim();
		t.setNazivTima("Sutjeska");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Fudbaler f3=new Fudbaler(39l, "Pablo", "Gavi", 19);
		Fudbaler f4=new Fudbaler(38l, "Simon", "Mrvaljevic", 26);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		Igrac i3=new Igrac(t, 3, "Bek", f3);
		Igrac i4=new Igrac(t, 4, "Krilo", f4);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		igraci.add(i2);
		igraci.add(i3);
		igraci.add(i4);
		t.setIgraci(igraci);
		assertThrows(Exception.class, ()->so.templateExecute(t));
	}
	@Test
	void testNedozvoljenBrojIgracaJedanaest() {
		Tim t=new Tim();
		t.setNazivTima("Sutjeska");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Fudbaler f3=new Fudbaler(39l, "Pablo", "Gavi", 19);
		Fudbaler f4=new Fudbaler(38l, "Simon", "Mrvaljevic", 26);
		Fudbaler f5=new Fudbaler(27l, "Darwin", "Nunez", 24);
		Fudbaler f6=new Fudbaler(28l, "Marcelo", "Bielsa", 50);
		Fudbaler f7=new Fudbaler(29l, "Sergej", "Milinkovic-Savic", 28);
		Fudbaler f8=new Fudbaler(30l, "Mislav", "Orsic", 30);
		Fudbaler f9=new Fudbaler(31l, "Stevan", "Jovetic", 33);
		Fudbaler f10=new Fudbaler(32l, "Stefan", "Savic", 32);
		Fudbaler f11=new Fudbaler(33l, "Danilo", "Pereira", 30);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		Igrac i3=new Igrac(t, 3, "Bek", f3);
		Igrac i4=new Igrac(t, 4, "Krilo", f4);
		Igrac i5=new Igrac(t, 5, "Golman", f5);
		Igrac i6=new Igrac(t, 6, "Stoper", f6);
		Igrac i7=new Igrac(t, 7, "Bek", f7);
		Igrac i8=new Igrac(t, 8, "Krilo", f8);
		Igrac i9=new Igrac(t, 9, "Golman", f9);
		Igrac i10=new Igrac(t, 10, "Stoper", f10);
		Igrac i11=new Igrac(t, 11, "Bek", f11);
		ArrayList<Igrac> igraci=new ArrayList<>();
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
		t.setIgraci(igraci);
		assertThrows(Exception.class, ()->so.templateExecute(t));
	}
	
	@Test
	void nedozvoljenaDvaIstaImena() {
		Tim t=new Tim();
		t.setNazivTima("Grbalj");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Fudbaler f3=new Fudbaler(39l, "Pablo", "Gavi", 19);
		Fudbaler f4=new Fudbaler(38l, "Simon", "Mrvaljevic", 26);
		Fudbaler f5=new Fudbaler(37l, "Daniele", "Rugani", 26);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		Igrac i3=new Igrac(t, 3, "Bek", f3);
		Igrac i4=new Igrac(t, 4, "Krilo", f4);
		Igrac i5=new Igrac(t, 5, "Spic", f5);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		igraci.add(i2);
		igraci.add(i3);
		igraci.add(i4);
		igraci.add(i5);
		t.setIgraci(igraci);
		String prvoIme=t.getNazivTima();
		try {
			so.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.setNazivTima("Sutjeska");
		assertThrows(Exception.class, ()->so.templateExecute(t));
		t.setNazivTima(prvoIme);
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
