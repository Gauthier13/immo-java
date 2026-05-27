package com.immojava.offers;

import com.immojava.properties.RealEstate;

import jdk.tools.jlink.internal.plugins.PluginsResourceBundle;

public class Offer {
  private final Long id;
  private final String title;
  private final double price;
  private final RealEstate realEstate;
  private OfferStatus status;

  private Offer(Builder builder) {
    this.id = builder.id;
    this.title = builder.title;
    this.price = builder.price;
    this.realEstate = builder.realEstate;
    this.status = OfferStatus.DRAFT;
  }

  public void publish() {
    if (!status.canBePublished()) {
      throw new IllegalStateException("Offer cannot be published from status : " + status);
    }
    this.status = OfferStatus.PUBLISHED;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public double getPrice() {
    return price;
  }

  public RealEstate getRealEstate() {
    return realEstate;
  }

  public OfferStatus getOfferStatus() {
    return status;
  }

  @Override
  public String toString() {
    return String.format("[%s] %s - %.2f $ (%s)", status, title, price, realEstate.generateDescription());
  }

  public static class Builder {
    private Long id;
    private String title;
    private double price;
    private RealEstate realEstate;

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder price(double price) {
      if (price <= 0) {
        throw new IllegalArgumentException("Price must be positiv");
      }
      this.price = price;
      return this;
    }

    public Builder realEstate(RealEstate realEstate) {
      this.realEstate = realEstate;
      return this;
    }

    public Offer build() {
      if (title == null || realEstate == null) {
        throw new IllegalStateException("Title and real estate are mandatory");
      }
      return new Offer(this);
    }
  }
}
