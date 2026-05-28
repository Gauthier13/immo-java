package com.immojava;

import com.immojava.agents.Agent;
import com.immojava.offers.Offer;
import com.immojava.properties.Flat;
import com.immojava.properties.House;

public class Main {
  public static void main(String[] args) {
    Agent sophie = new Agent("Sophie Martin", "sophie@immojava.fr");
    Agent martin = new Agent("Martin Dubois", "martin@immojava.fr");

    Flat flat = new Flat("15 rue de la Paix", "Marseille", 72, 3, true);

    Offer offer1 = new Offer.Builder()
        .id(1L)
        .title("Bel appartement T3 bien lumineux")
        .price(320_000)
        .realEstate(flat)
        .build();

    offer1.publish();
    sophie.AddOffer(offer1);

    House house = new House("12 chemin de l’olivier", "Aix-en-Provence", 145, 600);

    Offer offer2 = new Offer.Builder()
        .id(2L)
        .title("Maison familiale avec grand terrain")
        .price(650_000)
        .build();

    martin.AddOffer(offer2);

    System.out.println("=== Agents ImmoJava ===");
    System.out.println(sophie);
    System.out.println("Published Offers : " + sophie.getPublishedOffers().size());
    sophie.getOffers().forEach(System.out::println);

    System.out.println();
    System.out.println(martin);
    System.out.println(martin);
    System.out.println("Published Offers : " + martin.getPublishedOffers().size());

    try {
      offer1.publish();
    } catch (IllegalStateException e) {
      System.out.println("Error : " + e.getMessage());
    }
  };
}
