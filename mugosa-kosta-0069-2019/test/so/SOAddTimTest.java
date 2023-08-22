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
	@ParameterizedTest
	@CsvSource({"-1","0","1","11"})
	void testNedozvoljenBrojIgraca(int brojClanova) {
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
		t.setDozvoljenBrojIgraca(brojClanova);
		assertThrows(Exception.class, ()->so.templateExecute(t));
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
