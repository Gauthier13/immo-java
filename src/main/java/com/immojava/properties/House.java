package com.immojava.properties;

public class House extends RealEstate {
  private final double landSurface;

  public House(String adress, String city, double surface, double landSurface) {
    super(adress, city, surface);
    this.landSurface = landSurface;
  }

  public double getLandSurface() {
    return landSurface;
  }

  @Override
  public double calculateCharges() {
    return surface * 1.8 + landSurface * 0.5;
  }

  @Override
  public String toString() {
    return String.format("House with %.0f m2 of land - %s", landSurface, generateDescription());
  }
}
