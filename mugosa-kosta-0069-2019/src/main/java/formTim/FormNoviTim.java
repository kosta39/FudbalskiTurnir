package formTim;

import domain.Fudbaler;
import domain.Igrac;
import domain.Tim;
import forme.MainForm;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelIgraci;
import so.SOAddTim;
import so.SOGetAllFudbaler;

/**
 * Forma koje sluzi za dodavanje novog tima u bazu podataka.
 * 
 * @author Kosta
 */
public class FormNoviTim extends javax.swing.JDialog {
	/**
     * Konstruktor koji sluzi za kreiranje same forme. Postavlja lokaciju same forme
     * na ekranu, postavlja naslov i inicijalizuje njene osnovne komponente.
     * @param parent forma roditelj iz koje se postojeca otvara
     * @param modal predstavlja modalitet
     */
    public FormNoviTim(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Unos tima");
        popuniFudbalere();
        tblIgraci.setModel(new TableModelIgraci());
    }

    /**
     *      * Konstruktor koji sluzi za kreiranje same forme. Postavlja lokaciju same forme
     * na ekranu, postavlja naslov i inicijalizuje njene osnovne komponente.
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNazivTima = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbFudbaler = new javax.swing.JComboBox();
        cmbPozicije = new javax.swing.JComboBox();
        txtBrojNaDresu = new javax.swing.JFormattedTextField();
        btnDodajIgraca = new javax.swing.JButton();
        btnObrisiIgraca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIgraci = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos tima"));

        jLabel2.setText("Naziv tima:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos igraca"));

        jLabel1.setText("Fudbaler:");

        jLabel3.setText("Pozicija:");

        jLabel4.setText("Broj na dresu:");

        cmbFudbaler.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPozicije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Golman", "Stoper", "Bek", "Krilo", "Spic" }));

        txtBrojNaDresu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtBrojNaDresu.setText("1");

        btnDodajIgraca.setText("Dodaj igraca");
        btnDodajIgraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajIgracaActionPerformed(evt);
            }
        });

        btnObrisiIgraca.setText("Obrisi igraca");
        btnObrisiIgraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiIgracaActionPerformed(evt);
            }
        });

        tblIgraci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIgraci);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(cmbFudbaler, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)
                        .addComponent(cmbPozicije, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtBrojNaDresu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDodajIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFudbaler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPozicije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBrojNaDresu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodajIgraca)
                    .addComponent(btnObrisiIgraca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnDodaj.setText("Dodaj tim");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNazivTima))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNazivTima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    /**
     * Funkcija koja sluzi za otkazivanje prethodno trazenih funkcionalnosti ukoliko
     * se korisnik odluci da odustane od istih.
     * 
     * Forma se automatski zatvara.
     * 
     * @param evt event listener
     */
    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                        
    /**
     * Dugme koje sluzi za dodavanje novog tima.
     * Preduslov je da sva polja za unos moraju biti popunjena. Kupi se naziv tima iz same forme
     * a zatim i dodati igraci iz tabele nakon cega se kreira novi tim sa svojim parametrima.
     * Poziva se sistemska operacija za dodavanje tima,a zatim se javlja poruka o uspjesnoti izvrsenja.
     * 
     * @param evt
     */
    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            if (txtNazivTima.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }

            String nazivTima = txtNazivTima.getText();
            TableModelIgraci tm = (TableModelIgraci) tblIgraci.getModel();

            Tim t = new Tim(null, nazivTima, tm.getLista());

            (new SOAddTim()).templateExecute(t);
            MainForm mf = (MainForm) getParent();
            mf.popuniTimove();
            JOptionPane.showMessageDialog(this, "Uspesno dodat tim.");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                        
    /**
     * Dugme koje sluzi za dodavanje novog igraca u tim. Provjerava da li je unijet broj na dresu
     * ako jeste nastavlja, iz combo boxova bira samog fudbalera i njegovu poziciju kao i broj na dresu,
     * opet provjerava da li je sam broj validan, ako jeste nastavlja da kreira novog igraca na osnovu
     * unijetih parametara. Zatim vrsi poslednju provjeru, da li u timu vec postoji igrac sa tim brojem na dresu 
     * i ako nema konacno dodaje novog igraca u tabelu.
     * 
     * @param evt event listener
     */
    private void btnDodajIgracaActionPerformed(java.awt.event.ActionEvent evt) {                                               

        if (txtBrojNaDresu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti broj na dresu!");
            return;
        }

        Fudbaler fudbaler = (Fudbaler) cmbFudbaler.getSelectedItem();
        String pozicija = (String) cmbPozicije.getSelectedItem();
        int brojNaDresu = Integer.parseInt(txtBrojNaDresu.getText());

        if (brojNaDresu < 1 || brojNaDresu > 99) {
            JOptionPane.showMessageDialog(this, "Broj na dresu mora biti izmedju 1 i 99!");
            return;
        }

        Igrac i = new Igrac(null, brojNaDresu, pozicija, fudbaler);

        TableModelIgraci tm = (TableModelIgraci) tblIgraci.getModel();

        if (tm.postojiBrojDresa(brojNaDresu)) {
            JOptionPane.showMessageDialog(this, "Vec postoji igrac sa brojem na dresu "
                    + brojNaDresu + "!");
            return;            
        }

        tm.dodajIgraca(i);

    }                                              
    /**
     * Dugme koje sluzi za brisanje igraca iz tabele tima. Selektovani igrac biva obrisan iz
     * tabele na osnovu broja selektovanog reda tabele.
     * @param evt event listener
     */
    private void btnObrisiIgracaActionPerformed(java.awt.event.ActionEvent evt) {                                                

        int row = tblIgraci.getSelectedRow();

        if (row >= 0) {
            TableModelIgraci tm = (TableModelIgraci) tblIgraci.getModel();
            tm.obrisiIgraca(row);
        }

    }                                               

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajIgraca;
    private javax.swing.JButton btnObrisiIgraca;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cmbFudbaler;
    private javax.swing.JComboBox cmbPozicije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIgraci;
    private javax.swing.JFormattedTextField txtBrojNaDresu;
    private javax.swing.JTextField txtNazivTima;
    // End of variables declaration                   
    /**
     * Vrsi se pozivanje sistemske operacije za ucitavanje svih fudbalera iz baze u
     * namjeri da se popuni combo box fudbalerima sa ucitanim vrijednostima radi 
     * dodavanja novih fudbalera(igraca) u sam tim.
     */
    private void popuniFudbalere() {

        try {
            SOGetAllFudbaler so=new SOGetAllFudbaler();
            so.templateExecute(new Fudbaler());
            ArrayList<Fudbaler> fudbaleri = so.getLista();

            cmbFudbaler.removeAllItems();

            for (Fudbaler fudbaler : fudbaleri) {
                cmbFudbaler.addItem(fudbaler);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNoviTim.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

