/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Predstavlja fudbalera koji ucestvuje na turniru. Ima svoj id, ime, prezime i broj godina.
 *
 * Fudbaler nasledjuje AbstractDomainObject klasu i samim tim implementira njene
 * metode
 * @author Kosta
 */
public class Fudbaler extends AbstractDomainObject {
	/**
	 * Id fudbalera kao Long
	 */
    private Long fudbalerID;
    /**
     * Ime fudbalera kao String
     */
    private String imeFudbalera;
    /**
     * Prezime fudbalera kao String
     */
   private String prezimeFudbalera;
   /**
    * Godine fudbalera kao cijeli broj.
    */
    private int godine;
    /**
     * Vraca String sa imenom i prezimenom fudbalera.
     * @return ime i prezime fudbalera kao String.
     */
    @Override
    public String toString() {
        return imeFudbalera + " " + prezimeFudbalera;
    }
    /**
     * Parametrizovani konstruktor koji postavlja vrijednost atributa fudbalera na
     * one koji su dati kao parametri.
     * @param fudbalerID vrijednost koja predstavlja id fudbalera
     * @param imeFudbalera vrijednost koja predstavlja ime fudbalera
     * @param prezimeFudbalera vrijednost koja predstavlja prezime fudbalera
     * @param godine vrijednost koja predstavlja broj godina fudbalera
     */
    public Fudbaler(Long fudbalerID, String imeFudbalera, String prezimeFudbalera, int godine) {
        this.fudbalerID = fudbalerID;
        this.imeFudbalera = imeFudbalera;
        this.prezimeFudbalera = prezimeFudbalera;
        this.godine = godine;
    }
    /**
     * /**
     * Prazan konstruktor koji postavlja vrijednosti atributa fudbalera na pocetne
     * koje se odnose na njihov tip podatka.
     */
    public Fudbaler() {
    }
    /**
     * Vraca String koji sadrzi naziv tabele za klasu Fudbaler.
     * @return naziv tabele kao String za klasu Fudbaler.
     */

    @Override
    public String nazivTabele() {
        return " Fudbaler ";
    }
    /**
     * Vraca String koji sadrzi alijas tabele Fudbaler.
     * @return alijas tabele kao String za klasu Fudbaler koji je karakter f.
     */

    @Override
    public String alijas() {
        return " f ";
    }
    /**
     * Vraca String koji sadrzi JOIN klauzulu. Tabelu Fudbaler ne povezujemo ni sa
     * jednom drugom pa je kod nje String prazan.
     * @return prazan String.
     */

    @Override
    public String join() {
        return "";
    }
    /**
     * Vraca listu sa elementima klase Fudbaler.
     * @param rs skup rezultata koje vraca SELECT upit.
     * @return lista sa elementima klase Fudbaler
     * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
     */

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Fudbaler f = new Fudbaler(rs.getLong("FudbalerID"),
                    rs.getString("ImeFudbalera"), rs.getString("PrezimeFudbalera"),
                    rs.getInt("godine"));

            lista.add(f);
        }

        rs.close();
        return lista;
    }
    /**
     * Vraca String sa imenima kolona za INSERT upit. U ovom slucaju se nikad 
     * ne radi insert za tabelu Fudbaler pa je String prazan.
     * @return prazan String.
     */
    
    @Override
    public String koloneZaInsert() {
        return "  ";
    }
    /**
     * Vraca String koji sadrzi vrijednost za primarni kljuc klase Igrac. U ovom
     * slucaju je to identifikator fudbalera.
     * @return id fudbalera kao String.
     */

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " FudbalerID = " + fudbalerID;
    }
    /**
     * Vraca String sa vrijednostima kolona za INSERT upit. U ovom slucaju ne radimo
     * INSERT pa je prazan String.
     * @return prazan String.
     */

    @Override
    public String vrednostiZaInsert() {
        return "";
    }
    /**
     * Vraca String sa vrijednostima kolona za UPDATE upit. S obzirom da se ne vrsi izmjena
     * date tabele nikad vrijednost je uvijek prazan String.
     * @return prazan String.
     */

    @Override
    public String vrednostiZaUpdate() {
        return "  ";
    }
    /**
     * Vraca String sa WHERE klauzulom. S obzirom da je za tabelu Fudbaler nije potrebno
     * koristi WHERE uslov vraca se prazan String.
     * @return prazan String.
     */

    @Override
    public String uslov() {
        return "";
    }
    /**
     * Vraca id fudbalera.
     * @return id fudbalera kao Long
     */
    public Long getFudbalerID() {
        return fudbalerID;
    }
    /**
     * Postavlja vrijednost za id fudbalera.
     * @param fudbalerID nova vrijednost za id fudbalera.
     */
    public void setFudbalerID(Long fudbalerID) {
        this.fudbalerID = fudbalerID;
    }
    /**
     * Vraca ime fudbalera.
     * @return ime fudbalera kao String
     */
    public String getImeFudbalera() {
        return imeFudbalera;
    }
    /**
     * Postavlja vrijednost za ime fudbalera.
     * @param imeFudbalera nova vrijednost za ime fudbalera.
     */
    public void setImeFudbalera(String imeFudbalera) {
        this.imeFudbalera = imeFudbalera;
    }
    /**
     * Vraca prezime fudbalera.
     * @return prezime fudbalera kao String
     */
    public String getPrezimeFudbalera() {
        return prezimeFudbalera;
    }
    /**
     * Postavlja vrijednost za prezime fudbalera.
     * @param prezimeFudbalera nova vrijednost za prezime fudbalera.
     */
    public void setPrezimeFudbalera(String prezimeFudbalera) {
        this.prezimeFudbalera = prezimeFudbalera;
    }
    /**
     * Vraca broj godina fudbalera.
     * @return broj godina fudbalera kao Integer
     */
    public int getGodine() {
        return godine;
    }
    /**
     * Postavlja vrijednost za godine fudbalera.
     * @param godine nova vrijednost za godine fudbalera.
     */
    public void setGodine(int godine) {
        this.godine = godine;
    }

}
