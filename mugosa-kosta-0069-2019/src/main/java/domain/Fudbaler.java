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

    @Override
    public String nazivTabele() {
        return " Fudbaler ";
    }

    @Override
    public String alijas() {
        return " f ";
    }

    @Override
    public String join() {
        return "";
    }

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

    @Override
    public String koloneZaInsert() {
        return "  ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " FudbalerID = " + fudbalerID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "  ";
    }

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
