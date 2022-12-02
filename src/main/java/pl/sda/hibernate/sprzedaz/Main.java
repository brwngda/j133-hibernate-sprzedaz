package pl.sda.hibernate.sprzedaz;

import java.util.Scanner;

import static pl.sda.hibernate.sprzedaz.DodajProdukt.obslugaDodajProdukt;
import static pl.sda.hibernate.sprzedaz.DodajSprzedaz.obslugaDodajSprzedaz;
import static pl.sda.hibernate.sprzedaz.UsunProdukt.obslugaUsunProdukt;
import static pl.sda.hibernate.sprzedaz.UsunSprzedaz.obslugaUsunSprzedaz;
import static pl.sda.hibernate.sprzedaz.WyswietlListeSprzedazy.obslugaListaSprzedazy;
import static pl.sda.hibernate.sprzedaz.WyswietlListeSprzedazyProduktu.obslugaListaSprzedazyProduktu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz jedna z ponizszych komend:" +
                "\n* dodaj produkt" +
                "\n* dodaj sprzedaz" +
                "\n* wyswietl liste sprzedazy" +
                "\n* wyswietl liste sprzedazy danego prouktu" +
                "\n* usun sprzedaz" +
                "\n* usun produkt");
        String komenda = scanner.nextLine();

        if (komenda.equalsIgnoreCase("dodaj produkt")) {
            obslugaDodajProdukt(scanner);
        } else if (komenda.equalsIgnoreCase("dodaj sprzedaz")) {
            obslugaDodajSprzedaz(scanner);
        } else if (komenda.equalsIgnoreCase("wyswietl liste sprzedazy")) {
            obslugaListaSprzedazy();
        } else if (komenda.equalsIgnoreCase("wyswietl liste sprzedazy danego prouktu")) {
            obslugaListaSprzedazyProduktu();
        } else if (komenda.equalsIgnoreCase("usun sprzedaz")) {
            obslugaUsunSprzedaz(scanner);
        } else if (komenda.equalsIgnoreCase("usun produkt")) {
            obslugaUsunProdukt(scanner);
        }
    }


}
