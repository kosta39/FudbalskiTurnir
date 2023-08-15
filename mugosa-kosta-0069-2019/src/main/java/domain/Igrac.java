package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Predstavlja igraca koji se odnosi na nekog fudbalera i pripada nekom timu.
 *Ima svoju poziciju i broj na dresu.
 *Igrac nasledjuje AbstractDomainObject klasu i samim tim implementira njene
 * metode
 * @author Kosta
 */
public class Igrac extends AbstractDomainObject {
	/**
	 * Tim kome pripada Igrac dat kao istanca klase Tim.
	 */
    private Tim tim;
    /**
     * Broj na dresu igraca kao cijeli broj
     */
    private int brojNaDresu;
    /**
     * Pozicija igraca kao String.
     */
    private String pozicija;
    /**
     * Konkretan Fudbaler na koga se odnose informacije o igracu dat kao instanca
     * klase Fudbaler.
     */
    private Fudbaler fudbaler;
    /**
     * Parametrizovani konstruktor koji postavlja vrijednost atributa igraca na
     * one koji su dati kao parametri.
     * @param tim vrijednost koja predstavlja tim kome igrac pripada
     * @param brojNaDresu vrijednost koja predstavlja broj na dresu igraca
     * @param pozicija vrijednost koja predstavlja poziciju igraca na terenu
     * @param fudbaler vrijednost koja predstavlja konkretnog fudbalera na koga se odnose informacije o igracu
     */
    public Igrac(Tim tim, int brojNaDresu, String pozicija, Fudbaler fudbaler) {
        this.tim = tim;
        this.brojNaDresu = brojNaDresu;
        this.pozicija = pozicija;
        this.fudbaler = fudbaler;
    }
    /**
     * Prazan konstruktor koji postavlja vrijednosti atributa igraca na pocetne
     * koje se odnose na njihov tip podatka.
     */
    public Igrac() {
    }
    /**
     * Vraca String koji sadrzi naziv tabele za klasu Igrac.
     * @return naziv tabele kao String za klasu Igrac.
     */
    @Override
    public String nazivTabele() {
        return " Igrac ";
    }
    /**
     * Vraca String koji sadrzi alijas tabele Igrac.
     * @return alijas tabele kao String za klasu Igrac koji je karakter i.
     */
    @Override
    public String alijas() {
        return " i ";
    }
    /**
     * Vraca String koji sadrzi JOIN klauzulu. Za klasu igrac vrsimo join po
     * Tabele Igrac se join-uje preko primarnog kljuca timID i spoljnog kljuca fudbalerID
     * @return JOIN klauzula kao String specificna za klasu Igrac kao gore spomenuto.
     */
    @Override
    public String join() {
        return "JOIN TIM T ON (T.TIMID = I.TIMID) "
                + "JOIN FUDBALER F ON (F.FUDBALERID = I.FUDBALERID)";
    }
    /**
     * Vraca listu sa elementima klase Igrac.
     * @param rs skup rezultata koje vraca SELECT upit.
     * @return lista sa elementima klase Igrac
     * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
     */
    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Tim t = new Tim(rs.getLong("TimID"),
                    rs.getString("NazivTima"), null);

            Fudbaler f = new Fudbaler(rs.getLong("FudbalerID"),
                    rs.getString("ImeFudbalera"), rs.getString("PrezimeFudbalera"),
                    rs.getInt("godine"));

            Igrac i = new Igrac(t, rs.getInt("brojNaDresu"), rs.getString("pozicija"), f);

            lista.add(i);
        }

        rs.close();
        return lista;
    }
    /**
     * Vraca String sa imenima kolona za INSERT upit. U ovom slucaju su to kolone
     * koje odgovaraju svim atributima klase Igrac.
     * @return imena kolona za INSERT upit kao String
     */
    @Override
    public String koloneZaInsert() {
        return " (TimID, brojNaDresu, pozicija, FudbalerID) ";
    }
    /**
     * Vraca String koji sadrzi vrijednost za primarni kljuc klase Igrac. U ovom
     * slucaju je to identifikator tima.
     * @return id tima igraca kao String.
     */
    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TimID = " + tim.getTimID();
    }
    /**
     * Vraca String sa vrijednostima kolona za INSERT upit. Za igraca to su 
     * svi njegovi atributi(id tima i id fudbalera).
     * @return String popunjen svim atributima igraca(id tima i id fudbalera).
     */
    @Override
    public String vrednostiZaInsert() {
        return " " + tim.getTimID() + ", " + brojNaDresu + ", "
                + "'" + pozicija + "', " + fudbaler.getFudbalerID() + " ";
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
     * Vraca String sa WHERE klauzulom. S obzirom da je za tabelu Igrac primarni kljuc
     * tim u kom igrac igra to je ujedno i njegov WHERE uslov.
     * @return id tima kao String
     */
    @Override
    public String uslov() {
        return " WHERE T.TIMID = " + tim.getTimID();
    }
    /**
     * Vraca Tim u kojem igrac igra.
     * @return tim igraca dat kao istanca klase Tim.
     */
    public Tim getTim() {
        return tim;
    }
    /**
     * Postavlja vrijednost za Tim igraca.
     * @param tim nova vrijednost za Tim igraca.
     */
    public void setTim(Tim tim) {
        this.tim = tim;
    }
    /**
     * Vraca broj koji se nalazi na dresu igraca.
     * @return broj na dresu igraca kao Integer.
     */
    public int getBrojNaDresu() {
        return brojNaDresu;
    }
    /**
     * Postavlja vrijednost broj na dresu igraca.
     * @param brojNaDresu nova vrijednost za broj na dresu igraca.
     */
    public void setBrojNaDresu(int brojNaDresu) {
        this.brojNaDresu = brojNaDresu;
    }
    /**
     * Vraca poziciju na kojoj igrac igra.
     * @return pozicija igraca kao String.
     */
    public String getPozicija() {
        return pozicija;
    }
    /**
     * Postavlja vrijednost za poziciju igraca.
     * @param pozicija nova vrijednost za poziciju igraca.
     */
    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }
    /**
     * Vraca fudbalera na kojeg se igrac odnosi.
     * @return fudbaler na kojeg se igrac odnosi dat kao istanca klase Fudbaler.
     */
    public Fudbaler getFudbaler() {
        return fudbaler;
    }
    /**
     * Postavlja vrijednost za fudbalera na kojeg se igrac odnosi.
     * @param fudbaler nova vrijednost za fudbalera na kojeg se igrac odnosi.
     */
    public void setFudbaler(Fudbaler fudbaler) {
        this.fudbaler = fudbaler;
    }

}
