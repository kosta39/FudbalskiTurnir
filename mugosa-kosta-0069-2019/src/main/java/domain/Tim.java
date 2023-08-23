package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Predstavlja tim koji ucestvuje na turniru. Ima identifikator, naziv i listu svojih igraca.
 * 
 * Tim nasledjuje AbstractDomainObject klasu i samim tim implementira njene
 * metode
 * 
 * @author Kosta
 */
public class Tim extends AbstractDomainObject {
    /**
     * Identifikator tima kao Long
     */
    private Long timID;
    /**
     * Naziv tima kao String
     */
    private String nazivTima;
    /**
     * Igraci tima kao lista
     */
    private ArrayList<Igrac> igraci;
    /**
     * Vraca String sa nazivom tima.
     * @return naziv tima kao String.
     */
    @Override
    public String toString() {
        return nazivTima;
    }
    /**
     * Parametrizovani konstruktor koji postavlja vrijednost atributa tima na
     * one koji su dati kao parametri.
     * @param timID vrijednost koja predstavlja id tima
     * @param nazivTima vrijednost koja predstavlja naziv
     * @param igraci vrijednost za igrace tima
     */
    public Tim(Long timID, String nazivTima, ArrayList<Igrac> igraci) {
        this.timID = timID;
        this.nazivTima = nazivTima;
        this.igraci = igraci;
    }
    /**
     * Prazan konstruktor koji postavlja vrijednosti atributa tima na pocetne
     * koje se odnose na njihov tip podatka.
     */
    public Tim() {
    }
    /**
     * Vraca String koji sadrzi naziv tabele za klasu Tim.
     * @return naziv tabele kao String za klasu Tim.
     */
    @Override
    public String nazivTabele() {
        return " Tim ";
    }
    /**
     * Vraca String koji sadrzi alijas tabele Tim.
     * @return alijas tabele kao String za klasu Tim koji je karakter t.
     */

    @Override
    public String alijas() {
        return " t ";
    }
    /**
     * Vraca String koji sadrzi JOIN klauzulu. Za klasu Tim ne radimo
     * povezivanje sa drugim tabelama pa je String prazan.
     * @return prazan String
     */
    @Override
    public String join() {
        return "";
    }
    /**
     * Vraca listu sa elementima klase Tim.
     * @param rs skup rezultata koje vraca SELECT upit.
     * @return lista sa elementima klase Tim
     * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
     */

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Tim t = new Tim(rs.getLong("TimID"), rs.getString("NazivTima"), null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }
    /**
     * Vraca String sa imenima kolona za INSERT upit. U ovom slucaju je to naziv tima.
     * @return imena kolona za INSERT upit kao String
     */

    @Override
    public String koloneZaInsert() {
        return " (NazivTima) ";
    }
    /**
     * Vraca String koji sadrzi vrijednost za primarni kljuc klase Tim. U ovom
     * slucaju je to identifikator tima.
     * @return id tima kao String.
     */
    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TimID = " + timID;
    }
    /**
     * Vraca String sa vrijednostima kolona za INSERT upit. Za tim to je njegov naziv.
     * @return String popunjen atributom nazivTima.
     */
    @Override
    public String vrednostiZaInsert() {
        return " '" + nazivTima + "' ";
    }
    /**
     * Vraca String sa vrijednostima kolona za UPDATE upit. Na tabelu Tim samo se
     * mijenja atribut naziv.
     * @return String sa novim nazivom tima.
     */

    @Override
    public String vrednostiZaUpdate() {
        return " nazivTima = '" + nazivTima + "' ";
    }
    /**
     * Vraca String sa WHERE klauzulom. S obzirom da se za tabelu Tim nikada
     * ne radi WHERE String je prazan.
     * @return prazan String.
     */
    @Override
    public String uslov() {
        return "";
    }
    /**
     * Vraca id tima.
     * @return id tima kao Long
     */
    public Long getTimID() {
        return timID;
    }
    /**
     * Postavlja vrijednost za id tima.
     * @param timID nova vrijednost za id tima.
     */
    public void setTimID(Long timID) {
        this.timID = timID;
    }
    /**
     * Vraca naziv tima.
     * @return naziv tima kao String
     */
    public String getNazivTima() {
        return nazivTima;
    }
    /**
     * Postavlja vrijednost za naziv tima.
     * @param nazivTima nova vrijednost za naziv tima.
     */
    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }
    /**
     * Vraca listu sa igracima tima.
     * @return lista sa igracima tima.
     */
    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }
    /**
     * Postavlja listu igraca tima.
     * @param igraci nova vrijednost za listu igraca tima.
     */
    public void setIgraci(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }
    
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Tim other=(Tim) obj;
		return Objects.equals(nazivTima, other.nazivTima);
	}
    
}
