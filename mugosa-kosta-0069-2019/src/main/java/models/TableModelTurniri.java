package models;

import domain.Turnir;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import so.SOGetAllTurnir;

/**
 * Klasa koja sluzi za kreiranje specificnog modela tabele turnira i koristi se prilikom
 * pretrage turnira.
 * 
 * @author Kosta
 */
public class TableModelTurniri extends AbstractTableModel implements Runnable {
	/**
	 * Lista postojecih turnira.
	 */
    private ArrayList<Turnir> lista;
    /**
     * Nazivi kolona tabele dati preko String-a
     */
    private String[] kolone = {"ID", "Naziv", "Grad", "Datum od", "Datum do"};
    /**
     * Parametar na osnovu koga se vrsi sama pretraga dat kao String
     */
    private String parametar = "";
    /**
     * Neparametrizovan konstruktor koji sluzi za pozivanje sistemske operacije koja vraca
     * postojece turnire iz baze i prikazuje ih u tabeli za pretragu.
     */
    public TableModelTurniri() {
        try {
            SOGetAllTurnir so=new SOGetAllTurnir();
            so.templateExecute(new Turnir());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTurniri.class.getName()).log(Level.SEVERE, null, ex);
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
        Turnir t = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return t.getTurnirID();
            case 1:
                return t.getNazivTurnira();
            case 2:
                return t.getGrad();
            case 3:
                return sdf.format(t.getDatumOd());
            case 4:
                return sdf.format(t.getDatumDo());

            default:
                return null;
        }
    }
    /**
     * Vraca turnir koji se nalazi u trazenom redu tabele.
     * @param row broj trazenog reda tabele
     * @return turnir koji se nalazi u trazenom redu tabele.
     */
    public Turnir getSelectedTurnir(int row) {
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
            Logger.getLogger(TableModelTurniri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Sluzi za postavljanje vrijednosti parametra na osnovu kog se vrsi pretraga turnira.
     * @param parametar vrijednost na osnovu koje se vrsi pretraga turnira.
     */
    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }
    /**
     * Sluzi za azuriranje stanja tabele nakon sto se unese parametar za pretragu ili u slucaju
     * izmjene ili brisanja nekog turnira.
     * 
     * Prvo se poziva sistemska operacija kojoj se iz baze vracaju svi postojeci turniri, nakon cega se
     * provjerava da li je unijet parametar. Ako je to slucaj poredi naziv turnira sa vrijednoscu parametra
     * i nakon toga ubacuje u tabelu samo one turnire kod kojih postoji jednakost.
     */
    public void refreshTable() {
        try {
            SOGetAllTurnir so=new SOGetAllTurnir();
            so.templateExecute(new Turnir());
            lista = so.getLista();
            if (!parametar.equals("")) {
                ArrayList<Turnir> novaLista = new ArrayList<>();
                for (Turnir t : lista) {
                    if (t.getNazivTurnira().toLowerCase().contains(parametar.toLowerCase())) {
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
