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
		Tim t1=new Tim();
		t1.setTimID(1l);
		Tim t2=new Tim();
		t2.setTimID(2l);
		Tim t3=new Tim();
		t3.setTimID(3l);
		Tim t4=new Tim();
		t4.setTimID(4l);
		Tim t6=new Tim();
		t6.setTimID(6l);
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
		Fudbaler f6=new Fudbaler();
		f6.setFudbalerID(6l);
		Fudbaler f7=new Fudbaler();
		f7.setFudbalerID(7l);
		Fudbaler f9=new Fudbaler();
		f9.setFudbalerID(9l);
		Fudbaler f10=new Fudbaler();
		f10.setFudbalerID(10l);
		Fudbaler f11=new Fudbaler();
		f11.setFudbalerID(11l);
		Fudbaler f12=new Fudbaler();
		f12.setFudbalerID(12l);
		Fudbaler f13=new Fudbaler();
		f13.setFudbalerID(13l);
		Fudbaler f14=new Fudbaler();
		f14.setFudbalerID(14l);
		Fudbaler f15=new Fudbaler();
		f15.setFudbalerID(15l);
		Fudbaler f16=new Fudbaler();
		f16.setFudbalerID(16l);
		Fudbaler f17=new Fudbaler();
		f17.setFudbalerID(17l);
		Fudbaler f18=new Fudbaler();
		f18.setFudbalerID(18l);
		Fudbaler f19=new Fudbaler();
		f19.setFudbalerID(19l);
		Fudbaler f20=new Fudbaler();
		f20.setFudbalerID(20l);
		
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
		Igrac i6=new Igrac();
		i6.setTim(t2);
		i6.setFudbaler(f6);
		vraceni.add(i6);
		Igrac i7=new Igrac();
		i7.setTim(t2);
		i7.setFudbaler(f7);
		vraceni.add(i7);
		Igrac i8=new Igrac();
		i8.setTim(t2);
		i8.setFudbaler(f9);
		vraceni.add(i8);
		Igrac i9=new Igrac();
		i9.setTim(t2);
		i9.setFudbaler(f10);
		vraceni.add(i9);
		Igrac i10=new Igrac();
		i10.setTim(t2);
		i10.setFudbaler(f1);
		vraceni.add(i10);
		Igrac i11=new Igrac();
		i11.setTim(t3);
		i11.setFudbaler(f11);
		vraceni.add(i11);
		Igrac i12=new Igrac();
		i12.setTim(t3);
		i12.setFudbaler(f12);
		vraceni.add(i12);
		Igrac i13=new Igrac();
		i13.setTim(t3);
		i13.setFudbaler(f13);
		vraceni.add(i13);
		Igrac i14=new Igrac();
		i14.setTim(t3);
		i14.setFudbaler(f14);
		vraceni.add(i14);
		Igrac i15=new Igrac();
		i15.setTim(t3);
		i15.setFudbaler(f15);
		vraceni.add(i15);
		Igrac i16=new Igrac();
		i16.setTim(t4);
		i16.setFudbaler(f16);
		vraceni.add(i16);
		Igrac i17=new Igrac();
		i17.setTim(t4);
		i17.setFudbaler(f17);
		vraceni.add(i17);
		Igrac i18=new Igrac();
		i18.setTim(t4);
		i18.setFudbaler(f18);
		vraceni.add(i18);
		Igrac i19=new Igrac();
		i19.setTim(t4);
		i19.setFudbaler(f19);
		vraceni.add(i19);
		Igrac i20=new Igrac();
		i20.setTim(t4);
		i20.setFudbaler(f20);
		vraceni.add(i20);
		Igrac i21=new Igrac();
		i21.setTim(t6);
		i21.setFudbaler(f6);
		vraceni.add(i21);
		Igrac i22=new Igrac();
		i22.setTim(t6);
		i22.setFudbaler(f4);
		vraceni.add(i22);
		Igrac i23=new Igrac();
		i23.setTim(t6);
		i23.setFudbaler(f7);
		vraceni.add(i23);
		Igrac i24=new Igrac();
		i24.setTim(t6);
		i14.setFudbaler(f3);
		vraceni.add(i24);
		Igrac i25=new Igrac();
		i25.setTim(t6);
		i25.setFudbaler(f5);
		vraceni.add(i25);
		
		
		assertEquals(25, so.getLista().size());
		
		assertTrue(vraceni.get(0).getTim().equals(so.getLista().get(0).getTim()) && 
				vraceni.get(0).getFudbaler().equals(so.getLista().get(0).getFudbaler()));
		assertTrue(vraceni.get(1).getTim().equals(so.getLista().get(1).getTim()) && 
				vraceni.get(1).getFudbaler().equals(so.getLista().get(1).getFudbaler()));
		assertTrue(vraceni.get(2).getTim().equals(so.getLista().get(2).getTim()) && 
				vraceni.get(2).getFudbaler().equals(so.getLista().get(2).getFudbaler()));
		assertTrue(vraceni.get(3).getTim().equals(so.getLista().get(3).getTim()) && 
				vraceni.get(3).getFudbaler().equals(so.getLista().get(3).getFudbaler()));
		assertTrue(vraceni.get(4).getTim().equals(so.getLista().get(4).getTim()) && 
				vraceni.get(4).getFudbaler().equals(so.getLista().get(4).getFudbaler()));
		assertTrue(vraceni.get(5).getTim().equals(so.getLista().get(5).getTim()) && 
				vraceni.get(5).getFudbaler().equals(so.getLista().get(5).getFudbaler()));
		assertTrue(vraceni.get(6).getTim().equals(so.getLista().get(6).getTim()) && 
				vraceni.get(6).getFudbaler().equals(so.getLista().get(6).getFudbaler()));
		assertTrue(vraceni.get(7).getTim().equals(so.getLista().get(7).getTim()) && 
				vraceni.get(7).getFudbaler().equals(so.getLista().get(7).getFudbaler()));
		assertTrue(vraceni.get(8).getTim().equals(so.getLista().get(8).getTim()) && 
				vraceni.get(8).getFudbaler().equals(so.getLista().get(8).getFudbaler()));
		assertTrue(vraceni.get(9).getTim().equals(so.getLista().get(9).getTim()) && 
				vraceni.get(9).getFudbaler().equals(so.getLista().get(9).getFudbaler()));
		assertTrue(vraceni.get(10).getTim().equals(so.getLista().get(10).getTim()) && 
				vraceni.get(10).getFudbaler().equals(so.getLista().get(10).getFudbaler()));
		assertTrue(vraceni.get(11).getTim().equals(so.getLista().get(11).getTim()) && 
				vraceni.get(11).getFudbaler().equals(so.getLista().get(11).getFudbaler()));
		assertTrue(vraceni.get(12).getTim().equals(so.getLista().get(12).getTim()) && 
				vraceni.get(12).getFudbaler().equals(so.getLista().get(12).getFudbaler()));
		assertTrue(vraceni.get(13).getTim().equals(so.getLista().get(13).getTim()) && 
				vraceni.get(13).getFudbaler().equals(so.getLista().get(13).getFudbaler()));
		assertTrue(vraceni.get(14).getTim().equals(so.getLista().get(14).getTim()) && 
				vraceni.get(14).getFudbaler().equals(so.getLista().get(14).getFudbaler()));
		assertTrue(vraceni.get(15).getTim().equals(so.getLista().get(15).getTim()) && 
				vraceni.get(15).getFudbaler().equals(so.getLista().get(15).getFudbaler()));
		assertTrue(vraceni.get(16).getTim().equals(so.getLista().get(16).getTim()) && 
				vraceni.get(16).getFudbaler().equals(so.getLista().get(16).getFudbaler()));
		assertTrue(vraceni.get(17).getTim().equals(so.getLista().get(17).getTim()) && 
				vraceni.get(17).getFudbaler().equals(so.getLista().get(17).getFudbaler()));
		assertTrue(vraceni.get(18).getTim().equals(so.getLista().get(18).getTim()) && 
				vraceni.get(18).getFudbaler().equals(so.getLista().get(18).getFudbaler()));
		assertTrue(vraceni.get(19).getTim().equals(so.getLista().get(19).getTim()) && 
				vraceni.get(19).getFudbaler().equals(so.getLista().get(19).getFudbaler()));
		assertTrue(vraceni.get(20).getTim().equals(so.getLista().get(20).getTim()) && 
				vraceni.get(20).getFudbaler().equals(so.getLista().get(20).getFudbaler()));
		assertTrue(vraceni.get(21).getTim().equals(so.getLista().get(21).getTim()) && 
				vraceni.get(21).getFudbaler().equals(so.getLista().get(21).getFudbaler()));
		assertTrue(vraceni.get(22).getTim().equals(so.getLista().get(22).getTim()) && 
				vraceni.get(22).getFudbaler().equals(so.getLista().get(22).getFudbaler()));
		assertTrue(vraceni.get(23).getTim().equals(so.getLista().get(23).getTim()) && 
				vraceni.get(23).getFudbaler().equals(so.getLista().get(23).getFudbaler()));
		assertTrue(vraceni.get(24).getTim().equals(so.getLista().get(24).getTim()) && 
				vraceni.get(24).getFudbaler().equals(so.getLista().get(24).getFudbaler()));
	}

}
