package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja utakmicu koja se igra na turniru. Ima turnir na koji se odnosi,
 * svoj redni broj, broj golova oba tima, informaciju o tome ko je pobjednik,
 * kao i to ko su prvi i drugi tim
 * 
 * Utakmica nasledjuje AbstractDomainObject klasu i samim tim implementira njene
 * metode
 * @author Kosta
 */
public class Utakmica extends AbstractDomainObject {
	/**
	 * Turnir na koji se utakmica odnosi kao instanca klase Turnir
	 */
    private Turnir turnir;
    /**
     * Redni broj utakmice kao Integer
     */
    private int rbUtakmice;
    /**
     * Broj golova prvog tima kao Integer
     */
    private int brojGolovaPrvi;
    /**
     * Broj golova drugog tima kao Integer
     */
    private int brojGolovaDrugi;
    /**
     * Informaciju o tome ko je pobjednik utakmice datu kao String
     */
    private String pobednik;
    /**
     * Informaciju o tome ko je prvi tim datu kao instanca klase Tim
     */
    private Tim prviTim;
    /**
     * Informaciju o tome ko je drugi tim datu kao instanca klase Tim
     */
    private Tim drugiTim;
    /**
     * Parametrizovani konstruktor koji postavlja vrijednost atributa utakmica na
     * one koji su dati kao parametri.
     * @param turnir vrijednost koja predstavlja turnir na koji se utakmica odnosi
     * @param rbUtakmice vrijednost koja predstavlja redni broj utakmice na turniru
     * @param brojGolovaPrvi vrijednost koja predstavlja broj golova prvog tima na utakmici
     * @param brojGolovaDrugi vrijednost koja predstavlja broj golova drugog tima na utakmici
     * @param pobednik vrijednost koja predstavlja informaciju o tome ko je pobjednik utakmice
     * @param prviTim vrijednost koja predstavlja informaciju o tome ko je domacin na utakmici
     * @param drugiTim vrijednost koja predstavlja informaciju o tome ko je gost na utakmici
     */
    public Utakmica(Turnir turnir, int rbUtakmice, int brojGolovaPrvi, int brojGolovaDrugi, String pobednik, Tim prviTim, Tim drugiTim) {
        this.turnir = turnir;
        this.rbUtakmice = rbUtakmice;
        this.brojGolovaPrvi = brojGolovaPrvi;
        this.brojGolovaDrugi = brojGolovaDrugi;
        this.pobednik = pobednik;
        this.prviTim = prviTim;
        this.drugiTim = drugiTim;
    }
    /**
     * Prazan konstruktor koji postavlja vrijednosti atributa utakmica na pocetne
     * koje se odnose na njihov tip podatka.
     */
    public Utakmica() {
    }
    /**
     * Vraca String koji sadrzi naziv tabele za klasu Utakmica.
     * @return naziv tabele kao String za klasu Utakmica.
     */

    @Override
    public String nazivTabele() {
        return " Utakmica ";
    }
    /**
     * Vraca String koji sadrzi alijas tabele Utakmica.
     * @return alijas tabele kao String za klasu Utakmica koji je karakter u.
     */

    @Override
    public String alijas() {
        return " u ";
    }
    /**
     * Vraca String koji sadrzi JOIN klauzulu.
     * Tabel Utakmica se join-uje preko primarnog kljuca turnirID, spoljnih kljuceva
     * prviTimID i drugiTimID i preko administratorID
     * @return JOIN klauzula kao String specificna za klasu Utakmica kao gore spomenuto.
     */

    @Override
    public String join() {
        return " JOIN TURNIR TUR USING (TURNIRID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = TUR.ADMINISTRATORID) "
                + "JOIN TIM PRVITIM ON (PRVITIM.TIMID = U.PRVITIMID) "
                + "JOIN TIM DRUGITIM ON (DRUGITIM.TIMID = U.DRUGITIMID)";
    }
    /**
     * Vraca listu sa elementima klase Utakmica.
     * @param rs skup rezultata koje vraca SELECT upit.
     * @return lista sa elementima klase Utakmica
     * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
     */

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Turnir t = new Turnir(rs.getLong("TurnirID"), rs.getString("nazivTurnira"),
                    rs.getDate("datumOd"), rs.getDate("datumDo"), rs.getString("grad"), a, null);

            Tim prviTim = new Tim(rs.getLong("prviTim.TimID"), rs.getString("prviTim.NazivTima"), null);

            Tim drugiTim = new Tim(rs.getLong("drugiTim.TimID"), rs.getString("drugiTim.NazivTima"), null);

            Utakmica u = new Utakmica(t, rs.getInt("rbUtakmice"),
                    rs.getInt("brojGolovaPrvi"), rs.getInt("brojGolovaDrugi"),
                    rs.getString("pobednik"), prviTim, drugiTim);

            lista.add(u);
        }

        rs.close();
        return lista;
    }
    /**
     * Vraca String sa imenima kolona za INSERT upit. U ovom slucaju su to kolone
     * koje odgovaraju svim atributima klase Utakmica.
     * @return imena kolona za INSERT upit kao String
     */

    @Override
    public String koloneZaInsert() {
        return " (turnirID, rbUtakmice, brojGolovaPrvi, brojGolovaDrugi, pobednik, "
                + "prviTimID, drugiTimID) ";
    }
    /**
     * Vraca String koji sadrzi vrijednost za primarni kljuc klase Igrac. U ovom
     * slucaju je to identifikator turnira.
     * @return id turnira na koji se utakmica odnosi kao String.
     */

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnir.getTurnirID();
    }
    /**
     * Vraca String sa vrijednostima kolona za INSERT upit. Za utakmicu to su 
     * svi njegovi atributi(id turnira, id prvog tima, id drugog tima).
     * @return String popunjen svim atributima utakmice(id turnira, id prvog tima, id drugog tima).
     */

    @Override
    public String vrednostiZaInsert() {
        return " " + turnir.getTurnirID() + ", " + rbUtakmice + ", "
                + brojGolovaPrvi + ", " + brojGolovaDrugi + ", '" + pobednik
                + "', " + prviTim.getTimID() + ", " + drugiTim.getTimID();
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
     * Vraca String sa WHERE klauzulom. S obzirom da je za tabelu Utakmica primarni kljuc
     * turnir na koji se utakmica odnosi to je ujedno i njegov WHERE uslov.
     * @return id turnira kao String
     */

    @Override
    public String uslov() {
        return " WHERE TUR.TURNIRID = " + turnir.getTurnirID();
    }
    /**
     * Vraca turnir na kojem se utakmica odigrava.
     * @return turnir na kojem se utakmica odigrava kao instanca klase Turnir
     */
    public Turnir getTurnir() {
        return turnir;
    }
    /**
     * Postavlja vrijednost za turnir na kojem se utakmica odigrava.
     * @param turnir nova vrijednost za turnir na kome se utakmica odigrava.
     */
    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }
    /**
     * Vraca redni broj utakmice.
     * @return redni broj utakmice kao Integer
     */
    public int getRbUtakmice() {
        return rbUtakmice;
    }
    /**
     * Postavlja vrijednost za redni broj utakmice.
     * @param rbUtakmice nova vrijednost za redni broj utakmice.
     */
    public void setRbUtakmice(int rbUtakmice) {
        this.rbUtakmice = rbUtakmice;
    }
    /**
     * Vraca broj golova domacina.
     * @return broj golova domacina kao Integer
     */
    public int getBrojGolovaPrvi() {
        return brojGolovaPrvi;
    }
    /**
     * Postavlja vrijednost za broj golova domacina.
     * @param brojGolovaPrvi nova vrijednost za broj golova domacina.
     */
    public void setBrojGolovaPrvi(int brojGolovaPrvi) {
        this.brojGolovaPrvi = brojGolovaPrvi;
    }
    /**
     * Vraca broj golova gosta.
     * @return broj golova gosta kao Integer
     */
    public int getBrojGolovaDrugi() {
        return brojGolovaDrugi;
    }
    /**
     * Postavlja vrijednost za broj golova gosta.
     * @param brojGolovaDrugi nova vrijednost za broj golova gosta.
     */
    public void setBrojGolovaDrugi(int brojGolovaDrugi) {
        this.brojGolovaDrugi = brojGolovaDrugi;
    }
    /**
     * Vraca informaciju o tome ko je pobjednik utakmice.
     * @return informacija o tome ko je pobjednik utakmice datu kao String
     */
    public String getPobednik() {
        return pobednik;
    }
    /**
     * Postavlja vrijednost za pobjednika utakmice.
     * @param pobednik nova vrijednost za pobjednika utakmice.
     */
    public void setPobednik(String pobednik) {
        this.pobednik = pobednik;
    }
    /**
     * Vraca domacina utakmice.
     * @return domacin utakmice kao instanca klase Tim
     */
    public Tim getPrviTim() {
        return prviTim;
    }
    /**
     * Postavlja vrijednost za domacina utakmice.
     * @param prviTim nova vrijednost za domacina utakmice.
     */
    public void setPrviTim(Tim prviTim) {
        this.prviTim = prviTim;
    }
    /**
     * Vraca gosta utakmice.
     * @return gost utakmice kao instanca klase Tim
     */
    public Tim getDrugiTim() {
        return drugiTim;
    }
    /**
     * Postavlja vrijednost za gosta utakmice.
     * @param drugiTim nova vrijednost za gosta utakmice.
     */
    public void setDrugiTim(Tim drugiTim) {
        this.drugiTim = drugiTim;
    }

}
