package pl.sda.hibernate.sprzedaz;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.sprzedaz.Model.Sprzedaz;

import java.util.List;

public class WyswietlListeSprzedazyProduktu {

    public static void obslugaListaSprzedazyProduktu() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            // PONIŻSZA LINIJKA DO SPRAWDZENIA
            TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM SprzedazProduktu", Sprzedaz.class);
            List<Sprzedaz> listaWszystkichSprzedazy = zapytanie.getResultList();

            listaWszystkichSprzedazy.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Błąd bazy" + e);
        }
    }
}