package so;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Administrator;
import domain.Fudbaler;
import domain.Igrac;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;

class SOAddTurnirTest {
	SOAddTurnir so;
	
	@BeforeEach
	void setUp() throws Exception {
		so=new SOAddTurnir();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	
	@Test
	void testUspesnoDodatTurnir() {
		SOGetAllTurnir pom=new SOGetAllTurnir();
		try {
			pom.templateExecute(new Turnir());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Turnir> turniri=pom.getLista();
		int brojTurniraPrije=turniri.size();
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
		
		try {
			so.templateExecute(tur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SOGetAllTurnir pom1=new SOGetAllTurnir();
		try {
			pom1.templateExecute(new Turnir());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Turnir> trenutni=pom1.getLista();
		
		SOGetAllUtakmica pom2=new SOGetAllUtakmica();
		try {
			pom2.templateExecute(u1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Utakmica> utakmiceIzBaze=pom2.getLista();
		
		assertEquals(brojTurniraPrije+1, trenutni.size());
		assertTrue(trenutni.contains(tur));
		assertEquals(2, utakmiceIzBaze.size());
		assertTrue(u1.getTurnir().equals(utakmiceIzBaze.get(0).getTurnir()));
		assertTrue(u2.getTurnir().equals(utakmiceIzBaze.get(1).getTurnir()));
		
		SODeleteTurnir delete=new SODeleteTurnir();
		try {
			delete.templateExecute(tur);
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
	/*
	@Test
	void testNedozvoljenBrojUtakmicaNula() {
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
		tur.setAdministrator(a);
		tur.setDatumDo(d2);
		tur.setDatumOd(d1);
		tur.setGrad("Uzice");
		tur.setNazivTurnira("Vocni turnir");
		tur.setUtakmice(utakmice);
		assertThrows(Exception.class, ()->so.templateExecute(tur));
	}
	@Test
	void testNedozvoljenBrojUtakmicaJedna() {
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
		utakmice.add(u1);
		tur.setAdministrator(a);
		tur.setDatumDo(d2);
		tur.setDatumOd(d1);
		tur.setGrad("Uzice");
		tur.setNazivTurnira("Vocni turnir");
		tur.setUtakmice(utakmice);
		assertThrows(Exception.class, ()->so.templateExecute(tur));
	}
	@Test
	void testNedozvoljenBrojUtakmicaJedanaest() {
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
		Utakmica u3=new Utakmica(tur, 3, 3, 1, "Zvezda", t3, t4);
		Utakmica u4=new Utakmica(tur, 4, 4, 0, "Partizan", t4, t3);
		Utakmica u5=new Utakmica(tur, 5, 3, 1, "Zvezda", t3, t4);
		Utakmica u6=new Utakmica(tur, 6, 4, 0, "Partizan", t4, t3);
		Utakmica u7=new Utakmica(tur, 7, 3, 1, "Zvezda", t3, t4);
		Utakmica u8=new Utakmica(tur, 8, 4, 0, "Partizan", t4, t3);
		Utakmica u9=new Utakmica(tur, 9, 3, 1, "Zvezda", t3, t4);
		Utakmica u10=new Utakmica(tur, 10, 4, 0, "Partizan", t4, t3);
		Utakmica u11=new Utakmica(tur, 11, 3, 1, "Zvezda", t3, t4);
		utakmice.add(u1);
		utakmice.add(u2);
		utakmice.add(u3);
		utakmice.add(u4);
		utakmice.add(u5);
		utakmice.add(u6);
		utakmice.add(u7);
		utakmice.add(u8);
		utakmice.add(u9);
		utakmice.add(u10);
		utakmice.add(u11);
		tur.setAdministrator(a);
		tur.setDatumDo(d2);
		tur.setDatumOd(d1);
		tur.setGrad("Uzice");
		tur.setNazivTurnira("Vocni turnir");
		tur.setUtakmice(utakmice);
		assertThrows(Exception.class, ()->so.templateExecute(tur));
	}
	@Test
	void testDatumOdPosleDanasnjegDatuma() {
		Turnir tur=new Turnir();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d1=null;
		Date d2=null;
		try {
			d1=sdf.parse("12.08.2032");
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
		assertThrows(Exception.class, ()->so.templateExecute(tur));
	}
	*/
	@Test
	void testDatumOdPosleDatumaDo() {
		Turnir tur=new Turnir();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d1=null;
		Date d2=null;
		try {
			d1=sdf.parse("12.08.2022");
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
		assertThrows(Exception.class, ()->so.templateExecute(tur));
	}
	/*
	@Test
	void testDatumDoPosleDanasnjegDatuma() {
		Turnir tur=new Turnir();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d1=null;
		Date d2=null;
		try {
			d1=sdf.parse("12.08.2012");
			d2=sdf.parse("23.08.2032");
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
		assertThrows(Exception.class, ()->so.templateExecute(tur));
	}
	*/
	@Test
	void testUspesnoIzvrsenaSerijalizacija() {
		Turnir tur=new Turnir();
		tur.setTurnirID(100l);
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
		String s="{\"turnirID\":100,\"Turnir\":\"Vocni turnir\",\"Datum pocetka\":\"Aug 12, 2012, 12:00:00 AM\",\"Datum zavrsetka\":\"Aug 23, 2012, 12:00:00 AM\",\"Grad odrzavanja\":\"Uzice\"}";
		System.out.println(s);
		assertEquals(s,so.serijalizujJSON(tur));
	}
}
