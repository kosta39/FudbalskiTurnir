package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Igrac;
import domain.Turnir;
import domain.Utakmica;

class SOGetAllUtakmicaTest {
	SOGetAllUtakmica so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SOGetAllUtakmica();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
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
	void testUspesnoVracenaListaAdministratora() {
		try {
			Turnir t1=new Turnir();
			t1.setTurnirID(1l);
			Turnir t2=new Turnir();
			t1.setTurnirID(2l);
			Turnir t3=new Turnir();
			t1.setTurnirID(3l);
			ArrayList<Utakmica> utakmice=new ArrayList<>();
			Utakmica u1=new Utakmica();
			u1.setTurnir(t1);
			u1.setRbUtakmice(1);
			utakmice.add(u1);
			Utakmica u2=new Utakmica();
			u1.setTurnir(t1);
			u1.setRbUtakmice(2);
			utakmice.add(u2);
			Utakmica u3=new Utakmica();
			u1.setTurnir(t2);
			u1.setRbUtakmice(1);
			utakmice.add(u3);
			Utakmica u4=new Utakmica();
			u1.setTurnir(t2);
			u1.setRbUtakmice(2);
			utakmice.add(u4);
			Utakmica u5=new Utakmica();
			u1.setTurnir(t3);
			u1.setRbUtakmice(1);
			utakmice.add(u5);
			Utakmica u6=new Utakmica();
			u1.setTurnir(t3);
			u1.setRbUtakmice(2);
			utakmice.add(u6);

			assertEquals(6, so.getLista().size());
			assertTrue(utakmice.get(0).getRbUtakmice()==1 && 
					utakmice.get(0).getTurnir().equals(so.getLista().get(0).getTurnir()));
			assertTrue(utakmice.get(1).getRbUtakmice()==2 && 
					utakmice.get(1).getTurnir().equals(so.getLista().get(1).getTurnir()));
			assertTrue(utakmice.get(2).getRbUtakmice()==1 && 
					utakmice.get(2).getTurnir().equals(so.getLista().get(2).getTurnir()));
			assertTrue(utakmice.get(3).getRbUtakmice()==2 && 
					utakmice.get(3).getTurnir().equals(so.getLista().get(3).getTurnir()));
			assertTrue(utakmice.get(4).getRbUtakmice()==1 && 
					utakmice.get(4).getTurnir().equals(so.getLista().get(4).getTurnir()));
			assertTrue(utakmice.get(5).getRbUtakmice()==2 && 
					utakmice.get(5).getTurnir().equals(so.getLista().get(5).getTurnir()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
