package com.task03;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlUtil {
     /*Metoda pobierania danych z określonego linku*/

    public static String readQuote(URL url) throws ParseException {
        String resultJson = UrlUtil.readFrom(url);                                      //Odczytywanie wyniku JSON
        JSONObject resultPerl = (JSONObject) JSONValue.parseWithException(resultJson);  //Parsowanie wyniku w JSON
        return (String) resultPerl.get("quote");                                        //Zwrócenie wartości linijki cytatu
    }

    /*Metoda odczytu i konwersji danych z URL w JSON jako linijkę*/
    public static String readFrom(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
