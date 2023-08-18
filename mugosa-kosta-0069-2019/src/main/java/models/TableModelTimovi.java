package models;

import domain.Tim;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllTim;

/**
 * Klasa koja sluzi za kreiranje specificnog modela tabele timova i koristi se prilikom
 * pretrage timova.
 * 
 * @author Kosta
 */
public class TableModelTimovi extends AbstractTableModel implements Runnable {
	/**
	 * Lista postojecih timova.
	 */
    private ArrayList<Tim> lista;
    /**
     * Nazivi kolona tabele dati preko String-a
     */
    private String[] kolone = {"ID", "Naziv"};
    /**
     * Parametar na osnovu koga se vrsi sama pretraga dat kao String.
     */
    private String parametar = "";
    /**
     * Neparametrizovan konstruktor koji sluzi za pozivanje sistemske operacije koja vraca
     * postojece timove iz baze i prikazuje ih u tabeli za pretragu.
     */
    public TableModelTimovi() {
        try {
            SOGetAllTim so=new SOGetAllTim();
            so.templateExecute(new Tim());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTimovi.class.getName()).log(Level.SEVERE, null, ex);
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
        Tim t = lista.get(row);

        switch (column) {
            case 0:
                return t.getTimID();
            case 1:
                return t.getNazivTima();

            default:
                return null;
        }
    }
    /**
     * Vraca tim koji se nalazi u trazenom redu tabele.
     * @param row broj trazenog reda tabele
     * @return tim koji se nalazi u trazenom redu tabele.
     */
    public Tim getSelectedTim(int row) {
        return lista.get(row);
    }
    /**
     * Sluzi za osvjezaavanje(refresh) tabele nakon odredjenog broja sekundi(u ovom slucaju 10).
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTimovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Sluzi za postavljanje vrijednosti parametra na osnovu kog se vrsi pretraga timova.
     * @param parametar vrijednost na osnovu koje se vrsi pretraga timova.
     */
    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }
    /**
     * Sluzi za azuriranje stanja tabele nakon sto se unese parametar za pretragu ili u slucaju
     * izmjene ili brisanja nekog tima.
     * 
     * Prvo se poziva sistemska operacija kojoj se iz baze vracaju svi postojeci timovi, nakon cega se
     * provjerava da li je unijet parametar. Ako je to slucaj poredi naziv tima sa vrijednoscu parametra
     * i nakon toga ubacuje u tabelu samo one timove kod kojih postoji jednakost.
     */
    public void refreshTable() {
        try {
            SOGetAllTim so=new SOGetAllTim();
            so.templateExecute(new Tim());
            lista = so.getLista();
            if (!parametar.equals("")) {
                ArrayList<Tim> novaLista = new ArrayList<>();
                for (Tim t : lista) {
                    if (t.getNazivTima().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
