package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Fudbaler;
import domain.Igrac;
import domain.Tim;

class SODeleteTimTest {
	SODeleteTim so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SODeleteTim();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	@Test
	void testTimUspesnoObrisan() {
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
		SOAddTim dodaj=new SOAddTim();
		try {
			dodaj.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SOGetAllTim pom=new SOGetAllTim();
		try {
			pom.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Tim> timovi=pom.getLista();
		int brojTimovaPre=timovi.size();
		try {
			so.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SOGetAllTim trenutni=new SOGetAllTim();
		try {
			trenutni.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timovi=trenutni.getLista();
		SOGetAllIgrac pom2=new SOGetAllIgrac();
		try {
			pom2.templateExecute(i1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Igrac> igraciTima=pom2.getLista();
		
		assertEquals(brojTimovaPre-1, timovi.size());
		assertFalse(timovi.contains(t));
		assertEquals(0, igraciTima.size());
	}
	@Test
	void testNeuspesnaValidacijaPogresnaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Igrac()));
	}
	@Test
	void testNeuspesnaValidacijaNullKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}

}
