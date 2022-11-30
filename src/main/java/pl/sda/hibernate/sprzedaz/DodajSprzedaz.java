package pl.sda.hibernate.sprzedaz;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.sprzedaz.HibernateUtil;
import pl.sda.hibernate.sprzedaz.Model.Produkt;
import pl.sda.hibernate.sprzedaz.Model.Sprzedaz;

import java.util.Scanner;

public class DodajSprzedaz {

    public static void obslugaDodajSprzedaz(Scanner scanner) {
        Scanner scanner1 = new Scanner(System.in);
        String cenaString = scanner1.nextLine();
        Double cena = Double.parseDouble(cenaString);
        String iloscString = scanner1.nextLine();
        Double ilosc = Double.parseDouble(iloscString);


        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Sprzedaz sprzedaz = Sprzedaz.builder()
                    .cena(cena)
                    .ilosc(ilosc)
                    .build();

            session.persist(sprzedaz);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd dodawania do bazy danych");
        }
    }
}