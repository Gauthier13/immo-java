package com.immojava.properties;

public abstract class RealEstate {
  protected final String adress;
  protected final String city;
  protected final double surface;

  protected RealEstate(String adress, String city, double surface) {
    if (surface <= 0) {
      throw new IllegalArgumentException("Surface area should be positive");
    }
    this.adress = adress;
    this.city = city;
    this.surface = surface;
  }

  public String getAdress() {
    return adress;
  }

  public String getCity() {
    return city;
  }

  public double getSurface() {
    return surface;
  }

  public abstract double calculateCharges();

  public String getLocalization() {
    return adress + " " + city;
  }

  public final String generateDescription() {
    return String.format("%s - %.0f m2 - Estimated charges : %.2f $/month", getLocalization(), surface,
        calculateCharges());
  }

}
