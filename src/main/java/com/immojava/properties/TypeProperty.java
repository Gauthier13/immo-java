package com.immojava.properties;

public enum TypeProperty {
  FLAT("Flat", 1.2),
  HOUSE("House", 0.9),
  VILLA("Villa", 1.5),
  LAND("Land", 0.5);

  private String propertyLabel;
  private double expenseCoefficient;

  TypeProperty(String propertyLabel, double expenseCoefficient) {
    this.propertyLabel = propertyLabel;
    this.expenseCoefficient = expenseCoefficient;
  }

  public String getPropertyLabel() {
    return propertyLabel;
  }

  public double getExpenseCoefficient() {
    return expenseCoefficient;
  }

  public double calculateEstimatedExpense(double surface) {
    return surface * expenseCoefficient * 2.5;
  }

  public static TypeProperty fromPropertyLabel(String propertyLabel) {
    for (TypeProperty type : values()) {
      if (type.propertyLabel.equalsIgnoreCase(propertyLabel)) {
        return type;
      }
    }
    throw new IllegalArgumentException("Type of property is unknown: " + propertyLabel);
  }
}
