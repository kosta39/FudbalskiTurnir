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
		ArrayList<Tim> timovi=pom.getLista();
		int brojTimovaPre=timovi.size();
		
		Tim t=new Tim();
		t.setTimID(8l);
		t.setNazivTima("Sutjeska");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		igraci.add(i2);
		t.setIgraci(igraci);
		try {
			so.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SOGetAllTim pom1=new SOGetAllTim();
		timovi=pom1.getLista();
		
		assertEquals(brojTimovaPre+1, timovi.size());
		assertTrue(timovi.contains(t));
		assertEquals(2, timovi.get(timovi.size()-1).getIgraci().size());
		assertTrue(i1.getTim().equals(timovi.get(timovi.size()-1).getIgraci().get(0).getTim()));
		assertTrue(i2.getTim().equals(timovi.get(timovi.size()-1).getIgraci().get(1).getTim()));
		
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		t.setTimID(8l);
		t.setNazivTima("Sutjeska");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		igraci.add(i2);
		t.setIgraci(igraci);
		assertThrows(Exception.class, ()->t.setDozvoljenBrojIgraca(brojClanova));
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void nedozvoljenaDvaIstaImena() {
		Tim t=new Tim();
		t.setTimID(8l);
		t.setNazivTima("Buducnost");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		ArrayList<Igrac> igraci=new ArrayList<>();
		igraci.add(i1);
		igraci.add(i2);
		t.setIgraci(igraci);
		
		SOGetAllTim pom=new SOGetAllTim();
		ArrayList<Tim> timovi=pom.getLista();
		boolean isti=false;
		for(Tim tim:timovi) {
			if(t.getNazivTima().equals(tim.getNazivTima())) isti=true;
		}
		if(isti) assertThrows(Exception.class, ()->t.setNazivTima("Buducnost"));
	}
}
