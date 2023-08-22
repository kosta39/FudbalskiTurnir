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
	void testUspesnoVracenaListaUtakmica() {
		try {
			Turnir t1=new Turnir();
			t1.setTurnirID(1l);
			ArrayList<Utakmica> utakmice=new ArrayList<>();
			Utakmica u1=new Utakmica();
			u1.setTurnir(t1);
			u1.setRbUtakmice(1);
			utakmice.add(u1);
			Utakmica u2=new Utakmica();
			u2.setTurnir(t1);
			u2.setRbUtakmice(2);
			utakmice.add(u2);
			so.templateExecute(u1);
			
			assertEquals(2, so.getLista().size());
			assertTrue(utakmice.get(0).getRbUtakmice()==1 && 
					utakmice.get(0).getTurnir().getTurnirID().equals(so.getLista().get(0).getTurnir().getTurnirID()));
			assertTrue(utakmice.get(1).getRbUtakmice()==2 && 
					utakmice.get(1).getTurnir().getTurnirID().equals(so.getLista().get(1).getTurnir().getTurnirID()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
