package com.immojava.offers;

public enum OfferStatus {
  DRAFT {
    @Override
    public boolean canBePublished() {
      return true;
    }

    @Override
    public String describe() {
      return "Currently being drafted, not publicly visible";
    }
  },

  PUBLISHED {
    @Override
    public boolean canBePublished() {
      return false;
    }

    @Override
    public String describe() {
      return "Visible on the platform";
    }
  },

  SOLD {
    @Override
    public boolean canBePublished() {
      return false;
    }

    @Override
    public String describe() {
      return "The property is sold";
    }
  };

  public abstract boolean canBePublished();

  public abstract String describe();
}
