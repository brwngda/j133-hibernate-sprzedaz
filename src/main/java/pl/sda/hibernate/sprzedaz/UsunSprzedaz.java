package pl.sda.hibernate.sprzedaz;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.sprzedaz.Model.Sprzedaz;

import java.util.Scanner;

public class UsunSprzedaz {

    public static void obslugaUsunSprzedaz(Scanner scanner) {
        System.out.println("Podaj identyfikator usuwanej sprzedazy:");
        String identyfikator = scanner.nextLine();
        Long id = Long.parseLong(identyfikator);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Sprzedaz sprzedaz = session.get(Sprzedaz.class, id);

            if (sprzedaz == null) {
                System.err.println("Rekord nie istnieje");
            } else {
                session.remove(sprzedaz);
                System.out.println("Usunięto rekord o identyfikatorze: " + id);
            }
            transaction.commit();
        } catch (Exception ioe) {
            System.err.println("Błąd usuwania rekordu z bazy danych");
        }
    }
}
