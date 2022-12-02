package pl.sda.hibernate.sprzedaz;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.sprzedaz.HibernateUtil;
import pl.sda.hibernate.sprzedaz.Model.Sprzedaz;

import java.util.List;

public class WyswietlListeSprzedazy {

    public static void obslugaListaSprzedazy() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM Sprzedaz", Sprzedaz.class);
            List<Sprzedaz> listaWszystkichSprzedazy = zapytanie.getResultList();

            listaWszystkichSprzedazy.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Błąd bazy" + e);
        }
    }
}
