package com.szczerbicki;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by pawel on 27.04.15.
 */
public class PresidentService {

    public static final Random RANDOM = new Random();
    public static List<President> presidents;

    static {
        presidents = Arrays.asList(
                new President("Grzegorz Braun", "Bezpartyjny"),
                new President("Andrzej Duda", "Prawo i Sprawiedliwość"),
                new President("Adam Jarubas", "Polskie Stronnictwo Ludowe"),
                new President("Bronisław Komorowski", "Bezpartyjny, WHAT?!"),
                new President("Janusz Korwin-Mikke", "Korwin"),
                new President("Marian Kowalski", "Ruch narodowy"),
                new President("Paweł Kukiz", "Bezpartyjny"),
                new President("Magdalena Ogórek", "Bezpartyjna :)"),
                new President("Janusz Palikot", "Twój Ruch"),
                new President("Paweł Tanajno", "Demokracja Bezpośrednia"),
                new President("Jacek Wilk", "Konkgres Nowej Prawicy")
        );
    }

    public President random(){
        return presidents.get(RANDOM.nextInt(presidents.size()));
    }
}
