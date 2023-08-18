package models;

import domain.Turnir;
import domain.Utakmica;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllUtakmica;

/**
 * Klasa koja sluzi za kreiranje modela tabele utakmica koje su odigrane na nekom turniru.
 * Koristi se prilikom dodavanja novog turnira ili izmjene postojeceg.
 * @author Kosta
 */
public class TableModelUtakmice extends AbstractTableModel {
	/**
	 * Lista sa utakmicama koje su odigrane na datom turniru.
	 */
    private ArrayList<Utakmica> lista;
    /**
     * Nazivi kolona u tabeli kao String
     */
    private String[] kolone = {"Prvi tim", "Drugi tim", "Broj golova prvog", "Broj golova drugog",
        "Pobednik"};
    /**
     * Redni broj utakmice kao cijeli broj.
     */
    private int rb = 0;
    /**
     * Prazan konstruktor koji sluzi za inicijalizaciju liste utakmica.
     */
    public TableModelUtakmice() {
        lista = new ArrayList<>();
    }
    /**
     * Konstruktor koji sluzi za pozivanje sistemske operacije koja vraca sve utakmice datog
     * turnira iz baze koji je unijet kao parametar.
     * @param t tunrir iz baze na osnovu kog se ucitavaju sve utakmice.
     */
    public TableModelUtakmice(Turnir t) {
        try {
            SOGetAllUtakmica so=new SOGetAllUtakmica();
            so.templateExecute(new Utakmica());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelUtakmice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Vraca broj redova tabele.
     * @return broj redova tabele kao cijeli broj.
     */
    @Override
    public int getRowCount() {
        return lista.size();
    }
    /**
     * Vraca broj kolona tabele
     * @return broj kolona tabele kao cijeli broj.
     */
    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    /**
     * Vraca naziv i-te kolone tabele.
     * @param i broj kolone tabele ciji naziv treba da se vrati.
     * @return naziv i-te kolone tabele kao String.
     */
    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    /**
     * Vraca vrijednost polja u tabeli.
     * 
     * @param row red u tabeli u kojem se nalazi dato polje.
     * @param column kolona u tabeli u kojoj se nalazi dato polje.
     * @return vrijednost trazenog polja u tabeli kao Object.
     */
    @Override
    public Object getValueAt(int row, int column) {
        Utakmica u = lista.get(row);

        switch (column) {
            case 0:
                return u.getPrviTim();
            case 1:
                return u.getDrugiTim();
            case 2:
                return u.getBrojGolovaPrvi();
            case 3:
                return u.getBrojGolovaDrugi();
            case 4:
                return u.getPobednik();

            default:
                return null;
        }
    }
    /**
     * Dodaje utakmicu u tabelu nakon cega je azurira
     * @param u utakmica koja se dodaje u tabelu
     */
    public void dodajUtakmicu(Utakmica u) {
        rb = lista.size();
        u.setRbUtakmice(++rb);
        lista.add(u);
        fireTableDataChanged();
    }
    /**
     * Brise utakmicu iz tabele nakon cega je azurira
     * @param row red tabele utakmice koja se brise
     */
    public void obrisiUtakmicu(int row) {
        lista.remove(row);

        rb = 0;
        for (Utakmica utakmica : lista) {
            utakmica.setRbUtakmice(++rb);
        }

        fireTableDataChanged();
    }
    /**
     * Vraca listu utakmica koje se odnose na dati turnir.
     * @return lista utakmica koje se odnose na dati turnir.
     */
    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
