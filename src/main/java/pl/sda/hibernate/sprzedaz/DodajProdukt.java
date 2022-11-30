package pl.sda.hibernate.sprzedaz;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.sprzedaz.HibernateUtil;
import pl.sda.hibernate.sprzedaz.Model.Produkt;

import java.util.Scanner;
public class DodajProdukt {

    public static void obslugaDodajProdukt(Scanner scanner) {
        Scanner scanner1 = new Scanner(System.in);
        String nazwa = scanner1.nextLine();
        String kategoria = scanner1.nextLine();


        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Produkt produkt = Produkt.builder()
                    .nazwa(nazwa)
                    .kategoria(kategoria)
                    .build();

            session.persist(produkt);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd dodawania do bazy danych");
        }
    }
}