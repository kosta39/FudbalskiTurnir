package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Predstavlja turnir koji se igra. Ima id, nativ, datum pocetka i kraja, grad
 * u kojem se odrzava, administratora turnira i listu utakmica.
 * 
 * Turnir nasledjuje AbstractDomainObject klasu i samim tim implementira njene
 * metode
 * @author Kosta
 */
public class Turnir extends AbstractDomainObject {
	/**
	 * Identifikator turnira kao Long
	 */
    private Long turnirID;
    /**
     * Naziv turnira kao String.
     */
    @SerializedName("Turnir")
    private String nazivTurnira;
    /**
     * Datum pocetka turnira kao Date.
     */
    @SerializedName("Datum pocetka")
    private Date datumOd;
    /**
     * Datum zavrsetka turnira kao Date.
     */
    @SerializedName("Datum zavrsetka")
    private Date datumDo;
    /**
     * Grad u kome se odrzava turnir kao String.
     */
    @SerializedName("Grad odrzavanja")
    private String grad;
    /**
     * Administrator koji je zaduzen za turnir kao instanca klase Administrator
     */
    private transient Administrator administrator;
    /**
     * Lista utakmica koje se odrzavaju na turniru.
     */
    private transient ArrayList<Utakmica> utakmice;
    /**
     * Parametrizovani konstruktor koji postavlja vrijednost atributa turnira na
     * one koji su dati kao parametri.
     * @param turnirID vrijednost koja predstavlja id turnira
     * @param nazivTurnira vrijednost koja predstavlja naziv turnira
     * @param datumOd vrijednost koja predstavlja datum pocetka odrzavanja turnira
     * @param datumDo vrijednost koja predstavlja datum zavrsetka turnira
     * @param grad vrijednost koja predstavlja grad u kome se turnir odrzava
     * @param administrator vrijednost koja predstavlja administratora turnira
     * @param utakmice vrijednost koja predstavlja utakmice koje su odigrane na turniru
     */
    public Turnir(Long turnirID, String nazivTurnira, Date datumOd, Date datumDo, String grad, Administrator administrator, ArrayList<Utakmica> utakmice) {
        this.turnirID = turnirID;
        this.nazivTurnira = nazivTurnira;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.grad = grad;
        this.administrator = administrator;
        this.utakmice = utakmice;
    }/**
     * Prazan konstruktor koji postavlja vrijednosti atributa turnira na pocetne
     * koje se odnose na njihov tip podatka.
     */
    
    public Turnir() {
    }
    /**
     * Vraca String koji sadrzi naziv tabele za klasu Turnir.
     * @return naziv tabele kao String za klasu Turnir.
     */

    @Override
    public String nazivTabele() {
        return " Turnir ";
    }
    /**
     * Vraca String koji sadrzi alijas tabele Turnir.
     * @return alijas tabele kao String za klasu Turnir koji je niz karaktera "tur".
     */

    @Override
    public String alijas() {
        return " tur ";
    }
    /**
     * Vraca String koji sadrzi JOIN klauzulu.
     * Tabela Turnir se join-uje preko spoljnog kljuca administratorID
     * @return JOIN klauzula kao String specificna za klasu Turnir kao gore spomenuto.
     */
    @Override
    public String join() {
        return " JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = TUR.ADMINISTRATORID) ";
    }
    /**
     * Vraca listu sa elementima klase Turnir.
     * @param rs skup rezultata koje vraca SELECT upit.
     * @return lista sa elementima klase Turnir
     * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
     */

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Turnir t = new Turnir(rs.getLong("turnirID"), rs.getString("nazivTurnira"),
                    rs.getDate("datumOd"), rs.getDate("datumDo"), rs.getString("grad"), a, null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }
    /**
     * Vraca String sa imenima kolona za INSERT upit. U ovom slucaju su to kolone koj
     * odgovaraju atributima nazivTurnira, datumOd, datumDo, grad i administratorID.
     * @return imena kolona za INSERT upit kao String
     */
    @Override
    public String koloneZaInsert() {
        return " (nazivTurnira, datumOd, datumDo, grad, administratorID) ";
    }
    /**
     * Vraca String koji sadrzi vrijednost za primarni kljuc klase Igrac. U ovom
     * slucaju je to identifikator turnira.
     * @return id turnira kao String.
     */

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnirID;
    }
    /**
     * Vraca String sa vrijednostima kolona za INSERT upit. Za turnir to su 
     * nazivTurnira, datumOd, datummDo, grad i administratorID.
     * @return String popunjen gore navedenim atributima.
     */

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivTurnira + "', '" + new java.sql.Date(datumOd.getTime()) + "', "
                + "'" + new java.sql.Date(datumDo.getTime()) + "', '" + grad + "', "
                + administrator.getAdministratorID();
    }
    /**
     * Vraca String sa vrijednostima kolona za UPDATE upit. S obzirom da se ne vrsi izmjena
     * date tabele nikad vrijednost je uvijek prazan String.
     * @return prazan String.
     */

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }
    /**
     * Vraca String sa WHERE klauzulom. S obzirom da se za tabelu Turnir nikada
     * ne radi WHERE String je prazan.
     * @return prazan String.
     */
    @Override
    public String uslov() {
        return "";
    }
    /**
     * Vraca id turnira.
     * @return id turnira kao Long
     */
    public Long getTurnirID() {
        return turnirID;
    }
    /**
     * Postavlja vrijednost za id turnira.
     * @param turnirID nova vrijednost za id turnira.
     */
    public void setTurnirID(Long turnirID) {
        this.turnirID = turnirID;
    }
    /**
     * Vraca naziv turnira.
     * @return naziv turnira kao String
     */
    public String getNazivTurnira() {
        return nazivTurnira;
    }
    /**
     * Postavlja vrijednost za naziv turnira.
     * @param nazivTurnira nova vrijednost za naziv turnira.
     */
    public void setNazivTurnira(String nazivTurnira) {
        this.nazivTurnira = nazivTurnira;
    }
    /**
     * Vraca datum pocetka turnira.
     * @return datum pocetka turnira kao Date
     */
    public Date getDatumOd() {
        return datumOd;
    }
    /**
     * Postavlja vrijednost za datum pocetka turnira.
     * @param datumOd nova vrijednost za datum pocetka turnira.
     */
    public void setDatumOd(Date datumOd) {
    	Date date=new Date();
    	if(datumOd.compareTo(date)>0) throw new IllegalArgumentException("Datum od mora biti pre danasnjeg datuma!");
        this.datumOd = datumOd;
    }
    /**
     * Vraca datum zavrsetka turnira.
     * @return datum zavrsetka turnira kao Date
     */
    public Date getDatumDo() {
        return datumDo;
    }
    /**
     * Postavlja vrijednost za datum zavrsetka turnira.
     * @param datumDo nova vrijednost za datum zavrsetka turnira.
     */
    public void setDatumDo(Date datumDo) {
    	Date date=new Date();
    	if(datumDo.compareTo(date)>0) throw new IllegalArgumentException("Datum do mora biti pre danasnjeg datuma!");
        this.datumDo = datumDo;
    }
    /**
     * Vraca naziv grada u kome se turnir odrzava.
     * @return naziv grada u kome se turnir odrzava kao String
     */
    public String getGrad() {
        return grad;
    }
    /**
     * Postavlja vrijednost za naziv grad u kome se turnir odrzava.
     * @param grad nova vrijednost za naziv grada u kome se turnir odrzava.
     */
    public void setGrad(String grad) {
        this.grad = grad;
    }
    /**
     * Vraca administratora turnira.
     * @return administrator turnira kao instanca klase Administrator
     */
    public Administrator getAdministrator() {
        return administrator;
    }
    /**
     * Postavlja vrijednost za administratora turnira.
     * @param administrator nova vrijednost za administratora turnira.
     */
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    /**
     * Vraca listu utakmica odigranih na turniru.
     * @return listu utakmica odigranih na turniru kao ArrayList
     */
    public ArrayList<Utakmica> getUtakmice() {
        return utakmice;
    }
    /**
     * Postavlja vrijednost za listu utakmica odigranih na turniru.
     * @param utakmice nova vrijednost za listu utakmica odigranih na turniru.
     * @throws IllegalArgumentException ako lista utakmica koja se unosi ima manje od 2 ili vise od 10 utakmica.
     */
    public void setUtakmice(ArrayList<Utakmica> utakmice) {
    	if(utakmice.size()<2 || utakmice.size()>10) throw new IllegalArgumentException("Turnir mora imati izmedju 2 i 10 utakmica!");
        this.utakmice = utakmice;
    }
    /**
     * Koristi se za poredjenje dva turnira na osnovu njihovih imena.
     * @param obj drugi turnir
     * @return true ako su imena turnira ista, false ako se imena turnira razlikuju
     */
    @Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Turnir other=(Turnir) obj;
		return Objects.equals(nazivTurnira, other.nazivTurnira);
	}

}
