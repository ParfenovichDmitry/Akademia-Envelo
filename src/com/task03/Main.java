package com.task03;

import org.json.simple.parser.ParseException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {

    //Stały adres strony internetowej
    public static final String KANYE_API_URL = "https://api.kanye.rest";

    public static void main(String[] args) throws ParseException, MalformedURLException {

        Scanner sc = new Scanner(System.in);
        URL url = new URL(KANYE_API_URL);

        Set<String> quotes = new HashSet<>();  // Tabela unikatowych cytatów

        /* Сykl cytowania */
        while (true) {
            String quote = UrlUtil.readQuote(url); // Uzyskanie nowego cytatu

            /* Cykl sprawdzania wyjątkowości cytatu.
               Jeśli nie, dodaj do tabeli, jeśli powtórzysz, wyślij wiadomość */
            while (quotes.contains(quote)) {
                // Wiadomość, jeśli cytat już był
                System.out.println("Ups... niestety jest już taki cytat: " + quote);
                quote = UrlUtil.readQuote(url);
            }
            System.out.println("Nowy cytat: " + quote); // Wiadomość z nowym cytatem
            quotes.add(quote);
            // Zarządzanie cytatami za pomocą polecenia "next"
            if (!sc.nextLine().equalsIgnoreCase("next")) {
                break;
            }
        }
    }
}
