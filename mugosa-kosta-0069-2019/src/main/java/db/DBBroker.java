package db;

import domain.AbstractDomainObject;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *Cini genericku klasu koja sluzi za ostvarivanje konekcije sa bazom podataka.
 *Sastoji se od CRUD operacija kojima se komunicira sa bazom podataka i na osnovu 
 *kojih se radi sa tabelama u okviru nje.
 *@author Kosta
 *
 */
public class DBBroker {
	/**
	 * Staticka instanca klase DBBroker
	 */
    private static DBBroker instance;
    /**
     * Instanca klase Connection koja sluzi za povezivanje sa bazom
     */
    private Connection connection;
    /**
     * Konstruktor koji je prazan, a sluzi za povezivanje sa bazom.
     */
    private DBBroker() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Vraca instancu za konekciju na bazu
     * @return instancu za konekciju na bazu kao Connection
     */
    public Connection getConnection() {
        return connection;
    }
    /**
     * Vraca instancu klase DBBroker
     * Ovo je primjer Singleton paterna, ako je data instanca jednaka null, tada
     * pozivamo privatni kontruktor u kome se ostvaruje konekcija sa bazom putem
     * username-a, password-a i url-a koji se uzimaju iz properties fajla.
     * Koristi se singleton da bi se ta radnja odvila samo jednom, a svaki sledeci
     * put bi se vratila ta ista instanca.
     * @return instanca kao DBBroker
     */
    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }
    /**
     * Vraca Array listu koja sadrzi elemente apstraktne domenske klase.
     * Zapravo predstavlja rezultat SELECT upita nad bazom.
     * @param ado domenski objekat koji sadrzi podatke potrebne za izvrsavanje SELECT upita
     * @return Array lista sa elementima apstraktne domenske klase
     * @throws SQLException ukoliko dodje do greske prilikom izvrsavanja upita
     */
    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.join() + " " + ado.uslov();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }
    /**
     * Izvrsava INSERT upit nad bazom podataka
     * Zapravo predstavlja dodavanje novog reda u tabelu baze
     * @param ado domenski objekat koji sadrzi podatke potrebne za izvrsavanje INSERT upita
     * @return odredjeni upit kao PreparedStatement
     * @throws SQLException ukoliko dodje do greske prilikom ubacivanja novog reda u tabelu
     */
    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }
    /**
     * Izvrsava UPDATE upit nad bazom podataka
     * Namijenjen je za izmjenu postojeceg reda u tabeli baze
     * @param ado domenski objekat koji sadrzi podatke potrebne za izvrsavanje UPDATE upita
     * @throws SQLException ukoliko dodje do greske prilikom izmjene postojeceg reda tabele
     */
    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    /**
     * Izvrsava DELETE upit nad bazom podataka.
     * Namijenjen je za brisanje postojeceg reda u tabeli baze
     * @param ado domenski objekat koji sadrzi podatke potrebne za izvrsavanje DELETE upita
     * @throws SQLException ukoliko dodje do greske prilikom brisanja postojeceg reda tabele
     */
    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

}
