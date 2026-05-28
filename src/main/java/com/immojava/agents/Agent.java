package com.immojava.agents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.immojava.offers.Offer;
import com.immojava.offers.OfferStatus;

public class Agent {
  private final String name;
  private final String email;
  private final List<Offer> offers = new ArrayList<>();

  public Agent(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public void AddOffer(Offer offer) {
    offers.add(offer);
  }

  public List<Offer> getOffers() {
    return Collections.unmodifiableList(offers);
  }

  public List<Offer> getPublishedOffers() {
    return offers.stream()
        .filter(a -> a.getOfferStatus() == OfferStatus.PUBLISHED)
        .toList();
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return String.format("Agent %s (%s) - %d offer(s)", name, email, offers.size());
  }
}
