package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Fudbaler;
import domain.Igrac;
import domain.Tim;

class SOUpdateTimTest {
	SOUpdateTim so;
	@BeforeEach
	void setUp() throws Exception {
		so=new SOUpdateTim();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	
	@Test
	void testTimUspesnoIzmenjen() {
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
		Fudbaler f6=new Fudbaler(28l, "Marcelo", "Bielsa", 50);
		Igrac i6=new Igrac(t, 6, "Stoper", f6);
		igraci.add(i6);
		t.setIgraci(igraci);
		t.setNazivTima("AC Milan");
		try {
			so.templateExecute(t);
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
		t.setTimID(timovi.get(timovi.size()-1).getTimID());
		SOGetAllIgrac pom2=new SOGetAllIgrac();
		try {
			pom2.templateExecute(i6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Igrac> igraciTima=pom2.getLista();
		for(Tim tim:timovi) {
			if(t.getTimID()==tim.getTimID()) {
				assertEquals(t.getNazivTima(), tim.getNazivTima());
				assertEquals(6, igraciTima.size());
			}
		}
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
	@Test
	void testNedozvoljenBrojIgracaJedanaest() {
		Tim t=new Tim();
		t.setNazivTima("Rudar");
		Fudbaler f1=new Fudbaler(8l, "Raul", "Entrerrios", 21);
		Fudbaler f2=new Fudbaler(40l, "Andres", "Iniesta", 41);
		Fudbaler f3=new Fudbaler(39l, "Pablo", "Gavi", 19);
		Fudbaler f4=new Fudbaler(38l, "Simon", "Mrvaljevic", 26);
		Fudbaler f5=new Fudbaler(37l, "Daniele", "Rugani", 26);
		Fudbaler f6=new Fudbaler(28l, "Marcelo", "Bielsa", 50);
		Fudbaler f7=new Fudbaler(29l, "Sergej", "Milinkovic-Savic", 28);
		Fudbaler f8=new Fudbaler(30l, "Mislav", "Orsic", 30);
		Fudbaler f9=new Fudbaler(31l, "Stevan", "Jovetic", 33);
		Fudbaler f10=new Fudbaler(32l, "Stefan", "Savic", 32);
		Igrac i1=new Igrac(t, 1, "Golman", f1);
		Igrac i2=new Igrac(t, 2, "Stoper", f2);
		Igrac i3=new Igrac(t, 3, "Bek", f3);
		Igrac i4=new Igrac(t, 4, "Krilo", f4);
		Igrac i5=new Igrac(t, 5, "Spic", f5);
		Igrac i6=new Igrac(t, 6, "Stoper", f6);
		Igrac i7=new Igrac(t, 7, "Bek", f7);
		Igrac i8=new Igrac(t, 8, "Krilo", f8);
		Igrac i9=new Igrac(t, 9, "Golman", f9);
		Igrac i10=new Igrac(t, 10, "Stoper", f10);
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
		t.setIgraci(igraci);
		SOAddTim dodaj=new SOAddTim();
		try {
			dodaj.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Fudbaler f11=new Fudbaler(33l, "Danilo", "Pereira", 30);
		Igrac i11=new Igrac(t, 11, "Stoper", f11);
		igraci.add(i11);
		t.setIgraci(igraci);
		t.setNazivTima("AC Milan");
		assertThrows(Exception.class, ()->so.templateExecute(t));
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void testNedozvoljenBrojIgracaCetiri() {
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
		igraci.remove(4);
		t.setIgraci(igraci);
		t.setNazivTima("AC Milan");
		assertThrows(Exception.class, ()->so.templateExecute(t));
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void testPostojiTimSaTimImenom() {
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
		SOAddTim dodaj=new SOAddTim();
		try {
			dodaj.templateExecute(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SOGetAllTim timovi=new SOGetAllTim();
		try {
			timovi.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Tim> timoviBaze=timovi.getLista();
		t.setNazivTima(timoviBaze.get(0).getNazivTima());
		assertThrows(Exception.class, ()->so.templateExecute(t));
		SODeleteTim delete=new SODeleteTim();
		try {
			delete.templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
