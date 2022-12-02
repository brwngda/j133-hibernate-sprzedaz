package pl.sda.hibernate.sprzedaz;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.sprzedaz.Model.Produkt;
import pl.sda.hibernate.sprzedaz.Model.Sprzedaz;

import java.util.Scanner;

public class UsunProdukt {

    public static void obslugaUsunProdukt(Scanner scanner){
        System.out.println("Podaj identyfikator usuwanej produktu:");
        String identyfikator = scanner.nextLine();
        Long id = Long.parseLong(identyfikator);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Produkt produkt = session.get(Produkt.class, id);

            if (produkt == null) {
                System.err.println("Rekord nie istnieje");
            } else {
                session.remove(produkt);
                System.out.println("Usunięto rekord o identyfikatorze: " + id);
            }
            transaction.commit();
        } catch (Exception ioe) {
            System.err.println("Błąd usuwania rekordu z bazy danych");
        }
    }
}