package com.immojava.properties;

/**
 * Flat
 */
public class Flat extends RealEstate {
  private final int story;
  private final boolean elevator;

  public Flat(String adress, String city, double surface, int story, boolean elevator) {
    super(adress, city, surface);
    this.story = story;
    this.elevator = elevator;
  }

  public int getStory() {
    return story;
  }

  @Override
  public double calculateCharges() {
    return surface * 2.5 + (elevator ? 50 : 0);
  }

  @Override
  public String toString() {
    return String.format("Flat’s story %d*s - %s", story, elevator ? " (elevator)" : "", generateDescription());
  }
}
