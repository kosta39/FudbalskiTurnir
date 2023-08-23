package so;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Administrator;
import domain.Igrac;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;

class SODeleteTurnirTest {
	SODeleteTurnir so;
	@BeforeEach
	void setUp() throws Exception {
		so=new SODeleteTurnir();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	@Test
	void testTurnirUspesnoObrisan() {
		Turnir tur=new Turnir();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d1=null;
		Date d2=null;
		try {
			d1=sdf.parse("12.08.2012");
			d2=sdf.parse("23.08.2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Administrator a=new Administrator();
		a.setAdministratorID(1l);
		SOGetAllTim tims=new SOGetAllTim();
		try {
			tims.templateExecute(new Tim());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Tim> timovi=tims.getLista();
		Tim t3=timovi.get(0);
		Tim t4=timovi.get(1);
		ArrayList<Utakmica> utakmice=new ArrayList<>();
		Utakmica u1=new Utakmica(tur, 1, 3, 1, "Zvezda", t3, t4);
		Utakmica u2=new Utakmica(tur, 2, 4, 0, "Partizan", t4, t3);
		utakmice.add(u1);
		utakmice.add(u2);
		tur.setAdministrator(a);
		tur.setDatumDo(d2);
		tur.setDatumOd(d1);
		tur.setGrad("Uzice");
		tur.setNazivTurnira("Vocni turnir");
		tur.setUtakmice(utakmice);
		
		SOAddTurnir dodaj=new SOAddTurnir();
		try {
			dodaj.templateExecute(tur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SOGetAllTurnir pom=new SOGetAllTurnir();
		try {
			pom.templateExecute(new Turnir());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Turnir> turniri=pom.getLista();
		int brojTurniraPrije=turniri.size();
		try {
			so.templateExecute(tur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SOGetAllTurnir trenutni=new SOGetAllTurnir();
		try {
			trenutni.templateExecute(new Turnir());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		turniri=trenutni.getLista();
		SOGetAllUtakmica pom2=new SOGetAllUtakmica();
		try {
			pom2.templateExecute(u1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Utakmica> utakmiceTurnira=pom2.getLista();
		
		assertEquals(brojTurniraPrije-1, turniri.size());
		assertFalse(turniri.contains(tur));
		assertEquals(0, utakmiceTurnira.size());
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
