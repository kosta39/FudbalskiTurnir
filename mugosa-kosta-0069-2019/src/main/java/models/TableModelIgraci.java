package models;

import domain.Igrac;
import domain.Tim;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllIgrac;

/**
 * Klasa koja sluzi za kreiranje modela tabele igraci koji igraju u datom timu.
 * Koristi se prilikom dodavanja novog tima ili izmjene postojeceg.
 * 
 * @author Kosta
 */
public class TableModelIgraci extends AbstractTableModel {
	/**
	 * Lista sa igracima koji igraju u datom timu.
	 */
    private ArrayList<Igrac> lista;
    /**
     * Nazivi kolona u tabeli kao String.
     */
    private String[] kolone = {"Broj na dresu", "Fudbaler", "Pozicija"};
    /**
     * Prazan konstruktor koji sluzi za inicijalizaciju liste igraca.
     */
    public TableModelIgraci() {
        lista = new ArrayList<>();
    }
    /**
     * Konstruktor koji sluzi za pozivanje sistemske operacije koja vraca sve igrace datog
     * tima iz baze koji je unijet kao parametar.
     * @param t tim iz baze na osnovu kog se ucitavaju svi igraci.
     */
    public TableModelIgraci(Tim t) {
        try {
            SOGetAllIgrac so=new SOGetAllIgrac();
            Igrac i=new Igrac();
            i.setTim(t);
            so.templateExecute(i);
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelIgraci.class.getName()).log(Level.SEVERE, null, ex);
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
        Igrac i = lista.get(row);

        switch (column) {
            case 0:
                return i.getBrojNaDresu();
            case 1:
                return i.getFudbaler();
            case 2:
                return i.getPozicija();

            default:
                return null;
        }
    }
    /**
     * Dodaje igraca u tabelu nakon cega je azurira
     * @param i igrac koji se dodaje u tabelu
     */
    public void dodajIgraca(Igrac i) {
        lista.add(i);
        fireTableDataChanged();
    }
    /**
     * Brise igraca iz tabele nakon cega je azurira
     * @param row red tabele igraca koji se brise
     */
    public void obrisiIgraca(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    /**
     * Sluzi za provjeru da li u tabeli igraca vec postoji igrac sa datim brojem na dresu tog tima.
     * @param brojNaDresu broj na osnovu kojeg se vrsi provjera
     * @return true - ako postoji vec igrac sa tim brojem na dresu, false - ako u tabeli ne postoji igrac sa datim brojem na dresu.
     */
    public boolean postojiBrojDresa(int brojNaDresu) {
        for (Igrac igrac : lista) {
            if (igrac.getBrojNaDresu() == brojNaDresu) {
                return true;
            }
        }
        return false;
    }
    /**
     * Vraca listu igraca koji igraju za dati tim.
     * @return lista igraca koji igraju za dati tim.
     */
    public ArrayList<Igrac> getLista() {
        return lista;
    }

}
