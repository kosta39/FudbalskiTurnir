package so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Fudbaler;
import domain.Igrac;

class SOGetAllFudbalerTest {
	SOGetAllFudbaler so;

	@BeforeEach
	void setUp() throws Exception {
		so=new SOGetAllFudbaler();
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
	void testUspesnoVracenaListaFudbalera() {
		try {
			so.templateExecute(new Fudbaler());
			ArrayList<Fudbaler> vraceni = so.getLista();

			assertEquals(40, vraceni.size());
			assertTrue(vraceni.get(0).getImeFudbalera().equalsIgnoreCase("Filip")
					&& vraceni.get(0).getPrezimeFudbalera().equalsIgnoreCase("Gavranovic"));
			assertTrue(vraceni.get(1).getImeFudbalera().equalsIgnoreCase("Jovan")
					&& vraceni.get(1).getPrezimeFudbalera().equalsIgnoreCase("Colic"));
			assertTrue(vraceni.get(2).getImeFudbalera().equalsIgnoreCase("Uros")
					&& vraceni.get(2).getPrezimeFudbalera().equalsIgnoreCase("Lekic"));
			assertTrue(vraceni.get(3).getImeFudbalera().equalsIgnoreCase("Marko")
					&& vraceni.get(3).getPrezimeFudbalera().equalsIgnoreCase("Vujin"));
			assertTrue(vraceni.get(4).getImeFudbalera().equalsIgnoreCase("Momir")
					&& vraceni.get(4).getPrezimeFudbalera().equalsIgnoreCase("Ilic"));
			assertTrue(vraceni.get(5).getImeFudbalera().equalsIgnoreCase("Ruben")
					&& vraceni.get(5).getPrezimeFudbalera().equalsIgnoreCase("Marchain"));
			assertTrue(vraceni.get(6).getImeFudbalera().equalsIgnoreCase("Gonzalo")
					&& vraceni.get(6).getPrezimeFudbalera().equalsIgnoreCase("Vargas"));
			assertTrue(vraceni.get(7).getImeFudbalera().equalsIgnoreCase("Raul")
					&& vraceni.get(7).getPrezimeFudbalera().equalsIgnoreCase("Entrerrios"));
			assertTrue(vraceni.get(8).getImeFudbalera().equalsIgnoreCase("Stefano")
					&& vraceni.get(8).getPrezimeFudbalera().equalsIgnoreCase("Arcieri"));
			assertTrue(vraceni.get(9).getImeFudbalera().equalsIgnoreCase("Andrea")
					&& vraceni.get(9).getPrezimeFudbalera().equalsIgnoreCase("Parisini"));
			assertTrue(vraceni.get(10).getImeFudbalera().equalsIgnoreCase("Nicolo")
					&& vraceni.get(10).getPrezimeFudbalera().equalsIgnoreCase("Dantino"));
			assertTrue(vraceni.get(11).getImeFudbalera().equalsIgnoreCase("Andreas")
					&& vraceni.get(11).getPrezimeFudbalera().equalsIgnoreCase("Wolff"));
			assertTrue(vraceni.get(12).getImeFudbalera().equalsIgnoreCase("Simon")
					&& vraceni.get(12).getPrezimeFudbalera().equalsIgnoreCase("Ernst"));
			assertTrue(vraceni.get(13).getImeFudbalera().equalsIgnoreCase("Philipp")
					&& vraceni.get(13).getPrezimeFudbalera().equalsIgnoreCase("Weber"));
			assertTrue(vraceni.get(14).getImeFudbalera().equalsIgnoreCase("Nikola")
					&& vraceni.get(14).getPrezimeFudbalera().equalsIgnoreCase("Karabatic"));
			assertTrue(vraceni.get(15).getImeFudbalera().equalsIgnoreCase("Luka")
					&& vraceni.get(15).getPrezimeFudbalera().equalsIgnoreCase("Karabatic"));
			assertTrue(vraceni.get(16).getImeFudbalera().equalsIgnoreCase("Dika")
					&& vraceni.get(16).getPrezimeFudbalera().equalsIgnoreCase("Hansen"));
			assertTrue(vraceni.get(17).getImeFudbalera().equalsIgnoreCase("Mikel")
					&& vraceni.get(17).getPrezimeFudbalera().equalsIgnoreCase("Hansen"));
			assertTrue(vraceni.get(18).getImeFudbalera().equalsIgnoreCase("Niklas")
					&& vraceni.get(18).getPrezimeFudbalera().equalsIgnoreCase("Landin"));
			assertTrue(vraceni.get(19).getImeFudbalera().equalsIgnoreCase("Lasse")
					&& vraceni.get(19).getPrezimeFudbalera().equalsIgnoreCase("Svan"));
			assertTrue(vraceni.get(20).getImeFudbalera().equalsIgnoreCase("Lionel")
					&& vraceni.get(20).getPrezimeFudbalera().equalsIgnoreCase("Messi"));
			assertTrue(vraceni.get(21).getImeFudbalera().equalsIgnoreCase("Stefan")
					&& vraceni.get(21).getPrezimeFudbalera().equalsIgnoreCase("Mugosa"));
			assertTrue(vraceni.get(22).getImeFudbalera().equalsIgnoreCase("Andrea")
					&& vraceni.get(22).getPrezimeFudbalera().equalsIgnoreCase("Pirlo"));
			assertTrue(vraceni.get(23).getImeFudbalera().equalsIgnoreCase("Aleksandar")
					&& vraceni.get(23).getPrezimeFudbalera().equalsIgnoreCase("Mitrovic"));
			assertTrue(vraceni.get(24).getImeFudbalera().equalsIgnoreCase("Cristiano")
					&& vraceni.get(24).getPrezimeFudbalera().equalsIgnoreCase("Ronaldo"));
			assertTrue(vraceni.get(25).getImeFudbalera().equalsIgnoreCase("Diego")
					&& vraceni.get(25).getPrezimeFudbalera().equalsIgnoreCase("Simeone"));
			assertTrue(vraceni.get(26).getImeFudbalera().equalsIgnoreCase("Darwin")
					&& vraceni.get(26).getPrezimeFudbalera().equalsIgnoreCase("Nunez"));
			assertTrue(vraceni.get(27).getImeFudbalera().equalsIgnoreCase("Marcelo")
					&& vraceni.get(27).getPrezimeFudbalera().equalsIgnoreCase("Bielsa"));
			assertTrue(vraceni.get(28).getImeFudbalera().equalsIgnoreCase("Sergej")
					&& vraceni.get(28).getPrezimeFudbalera().equalsIgnoreCase("Milinkovic-Savic"));
			assertTrue(vraceni.get(29).getImeFudbalera().equalsIgnoreCase("Mislav")
					&& vraceni.get(29).getPrezimeFudbalera().equalsIgnoreCase("Orsic"));
			assertTrue(vraceni.get(30).getImeFudbalera().equalsIgnoreCase("Stevan")
					&& vraceni.get(30).getPrezimeFudbalera().equalsIgnoreCase("Jovetic"));
			assertTrue(vraceni.get(31).getImeFudbalera().equalsIgnoreCase("Stefan")
					&& vraceni.get(31).getPrezimeFudbalera().equalsIgnoreCase("Savic"));
			assertTrue(vraceni.get(32).getImeFudbalera().equalsIgnoreCase("Danilo")
					&& vraceni.get(32).getPrezimeFudbalera().equalsIgnoreCase("Pereira"));
			assertTrue(vraceni.get(33).getImeFudbalera().equalsIgnoreCase("Jose")
					&& vraceni.get(33).getPrezimeFudbalera().equalsIgnoreCase("Sa"));
			assertTrue(vraceni.get(34).getImeFudbalera().equalsIgnoreCase("Didier")
					&& vraceni.get(34).getPrezimeFudbalera().equalsIgnoreCase("Drogba"));
			assertTrue(vraceni.get(35).getImeFudbalera().equalsIgnoreCase("Hakim")
					&& vraceni.get(35).getPrezimeFudbalera().equalsIgnoreCase("Ziyech"));
			assertTrue(vraceni.get(36).getImeFudbalera().equalsIgnoreCase("Daniele")
					&& vraceni.get(36).getPrezimeFudbalera().equalsIgnoreCase("Rugani"));
			assertTrue(vraceni.get(37).getImeFudbalera().equalsIgnoreCase("Simon")
					&& vraceni.get(37).getPrezimeFudbalera().equalsIgnoreCase("Mrvaljevic"));
			assertTrue(vraceni.get(38).getImeFudbalera().equalsIgnoreCase("Pablo")
					&& vraceni.get(38).getPrezimeFudbalera().equalsIgnoreCase("Gavi"));
			assertTrue(vraceni.get(39).getImeFudbalera().equalsIgnoreCase("Andres")
					&& vraceni.get(39).getPrezimeFudbalera().equalsIgnoreCase("Iniesta"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
