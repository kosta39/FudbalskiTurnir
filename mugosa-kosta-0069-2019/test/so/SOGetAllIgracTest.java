package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Administrator;
import domain.Fudbaler;
import domain.Igrac;
import domain.Tim;
import domain.Utakmica;

class SOGetAllIgracTest {
	SOGetAllIgrac so;
	@BeforeEach
	void setUp() throws Exception {
		so=new SOGetAllIgrac();
	}

	@AfterEach
	void tearDown() throws Exception {
		so=null;
	}
	@Test
	void testNeuspesnaValidacijaPogresnaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Administrator()));
	}
	@Test
	void testNeuspesnaValidacijaNullKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}
	@Test
	void testUspesnoVracenaListaIgraca() {
		try {
			Tim t1=new Tim();
			t1.setTimID(1l);
			Fudbaler f1=new Fudbaler();
			f1.setFudbalerID(1l);
			Fudbaler f2=new Fudbaler();
			f2.setFudbalerID(2l);
			Fudbaler f3=new Fudbaler();
			f3.setFudbalerID(3l);
			Fudbaler f4=new Fudbaler();
			f4.setFudbalerID(4l);
			Fudbaler f5=new Fudbaler();
			f5.setFudbalerID(5l);
			
			ArrayList<Igrac> vraceni=new ArrayList<>();
			Igrac i1=new Igrac();
			i1.setTim(t1);
			i1.setFudbaler(f1);
			vraceni.add(i1);
			Igrac i2=new Igrac();
			i2.setTim(t1);
			i2.setFudbaler(f2);
			vraceni.add(i2);
			Igrac i3=new Igrac();
			i3.setTim(t1);
			i3.setFudbaler(f3);
			vraceni.add(i3);
			Igrac i4=new Igrac();
			i4.setTim(t1);
			i4.setFudbaler(f4);
			vraceni.add(i4);
			Igrac i5=new Igrac();
			i5.setTim(t1);
			i5.setFudbaler(f5);
			vraceni.add(i5);
			so.templateExecute(i1);
			
			assertEquals(5, so.getLista().size());
			
			assertTrue(vraceni.get(0).getTim().getTimID().equals(so.getLista().get(0).getTim().getTimID()) && 
					vraceni.get(0).getFudbaler().getFudbalerID().equals(so.getLista().get(0).getFudbaler().getFudbalerID()));
			assertTrue(vraceni.get(1).getTim().getTimID().equals(so.getLista().get(1).getTim().getTimID()) && 
					vraceni.get(1).getFudbaler().getFudbalerID().equals(so.getLista().get(1).getFudbaler().getFudbalerID()));
			assertTrue(vraceni.get(2).getTim().getTimID().equals(so.getLista().get(2).getTim().getTimID()) && 
					vraceni.get(2).getFudbaler().getFudbalerID().equals(so.getLista().get(2).getFudbaler().getFudbalerID()));
			assertTrue(vraceni.get(3).getTim().getTimID().equals(so.getLista().get(3).getTim().getTimID()) && 
					vraceni.get(3).getFudbaler().getFudbalerID().equals(so.getLista().get(3).getFudbaler().getFudbalerID()));
			assertTrue(vraceni.get(4).getTim().getTimID().equals(so.getLista().get(4).getTim().getTimID()) && 
					vraceni.get(4).getFudbaler().getFudbalerID().equals(so.getLista().get(4).getFudbaler().getFudbalerID()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
