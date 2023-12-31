package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Prestavlja administratora sistema koji ima svoj id, ime, prezime, username
 * i password.
 * 
 * Administrator nasledjuje AbstractDomainObject klasu i samim tim implementira njene
 * metode
 * @author Kosta
 */
public class Administrator extends AbstractDomainObject {
	/**
	 * Identifikator adiminstratora kao Long
	 */
    private Long administratorID;
    /**
     * Ime administratora kao String
     */
    private String ime;
    /**
     * Prezime administratora kao String
     */
    private String prezime;
    /**
     * Username administratora dat preko String-a
     */
    private String username;
    /**
     * Password administratora dat preko String-a
     */
    private String password;
    /**
     * Prazan konstruktor koji postavlja vrijednosti atributa adiministratora na pocetne
     * koje se odnose na njihov tip podatka.
     */
    public Administrator() {
    }
    /**
     * Parametrizovani konstruktor koji postavlja vrijednost atributa administratora na
     * one koji su dati kao parametri.
     * @param administratorID vrijednost koja predstavlja id administratora
     * @param ime vrijednost koja predstavlja ime administratora
     * @param prezime vrijednost koja predstavlja prezime administratora
     * @param username vrijednost koja predstavlja username administratora
     * @param password vrijednost koja predstavlja password administratora
     */
    public Administrator(Long administratorID, String ime, String prezime, String username, String password) {
        this.administratorID = administratorID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }
    /**
     * Vraca id administratora.
     * @return id administratora kao Long
     */
    public Long getAdministratorID() {
        return administratorID;
    }
    /**
     * Postavlja vrijednost za id administratora.
     * @param administratorID nova vrijednost za id administratora.
     */
    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }
    /**
     * Vraca username administratora.
     * @return username administratora kao String
     */
    public String getUsername() {
        return username;
    }
    /**
     * Postavlja vrijednost za username administratora.
     * @param username nova vrijednost za username administratora
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Vraca password administratora.
     * @return password administratora kao String 
     */
    public String getPassword() {
        return password;
    }
    /**
     * Postavlja vrijednost za password administratora.
     * @param password nova vrijednost za password administratora
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Vraca ime administratora.
     * @return ime administratora kao String 
     */
    public String getIme() {
        return ime;
    }
    /**
     * Postavlja vrijednost za ime administratora.
     * @param ime nova vrijednost za ime administratora
     */
    public void setIme(String ime) {
        this.ime = ime;
    }
    /**
     * Vraca prezime administratora.
     * @return prezime administratora kao String 
     */
    public String getPrezime() {
        return prezime;
    }
    /**
     * Postavlja vrijednost za prezime administratora.
     * @param prezime nova vrijednost za prezime administratora
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    /**
     * Vraca String sa imenom i prezimenom administratora.
     * @return ime i prezime administratora dati kao String.
     */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    /**
     * Vraca String koji sadrzi naziv tabele za klasu Administrator.
     * @return naziv tabele kao String za klasu Administrator.
     */

    @Override
    public String nazivTabele() {
        return " administrator ";
    }
    /**
     * Vraca String koji sadrzi alijas tabele Administrator.
     * @return alijas tabele kao String za klasu Administrator koji je karakter a.
     */

    @Override
    public String alijas() {
        return " a ";
    }
    /**
     * Vraca String koji sadrzi JOIN klauzulu. Za klasu Administrator ne radimo
     * povezivanje sa drugim tabelama pa je String prazan.
     * @return prazan String
     */
    @Override
    public String join() {
        return "";
    }
    /**
     * Vraca listu sa elementima klase Administrator.
     * @param rs skup rezultata koje vraca SELECT upit.
     * @return lista sa elementima klase Administrator
     * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
     */

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            lista.add(a);
        }

        rs.close();
        return lista;
    }
    /**
     * Vraca String sa imenima kolona za INSERT upit. U ovom slucaju su to kolone
     * koje odgovaraju svim atributima ime, prezime, username i password.
     * @return imena kolona za INSERT upit kao String
     */
    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Username, Password) ";
    }
    /**
     * Vraca String koji sadrzi vrijednost za primarni kljuc klase Igrac. U ovom
     * slucaju je to identifikator administratora.
     * @return id administratora kao String.
     */
    @Override
    public String vrednostZaPrimarniKljuc() {
        return " AdministratorID = " + administratorID;
    }
    /**
     * Vraca String sa vrijednostima kolona za INSERT upit. Za administratora to su 
     * svi njegovi atributi osim identifikatora.
     * @return String popunjen svim atributima administratora osim id-ja.
     */
    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + username + "', '" + password + "'";
    }
    /**
     * Vraca String sa vrijednostima kolona za UPDATE upit. Za administratora to su 
     * svi njegovi atributi osim identifikatora.
     * @return String popunjen svim atributima administratora osim id-ja.
     */

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "Username = '" + username + "', Password = '" + password + "' ";
    }
    /**
     * Vraca String sa WHERE klauzulom. S obzirom da se za tabelu Administrator nikada
     * ne radi WHERE String je prazan.
     * @return prazan String.
     */

    @Override
    public String uslov() {
        return "";
    }

}
