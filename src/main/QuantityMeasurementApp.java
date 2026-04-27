// APP CODE
//USECASE 8
package com.apps.quantitymeasurement;

enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double getConversionFactor() {
        return factor;
    }

    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}

public class QuantityMeasurementApp {

    public static class Length {

        private double value;
        private LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value))
                throw new IllegalArgumentException();

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        public Length convertTo(LengthUnit targetUnit) {
            double base = unit.convertToBaseUnit(value);
            double result =
                    targetUnit.convertFromBaseUnit(base);

            return new Length(result, targetUnit);
        }

        public Length add(Length other) {
            return add(other, this.unit);
        }

        public Length add(Length other,
                          LengthUnit targetUnit) {

            if (other == null || targetUnit == null)
                throw new IllegalArgumentException();

            double totalBase =
                    this.unit.convertToBaseUnit(this.value)
                            + other.unit.convertToBaseUnit(other.value);

            double result =
                    targetUnit.convertFromBaseUnit(totalBase);

            return new Length(result, targetUnit);
        }

        private boolean compare(Length other) {
            double first =
                    unit.convertToBaseUnit(value);

            double second =
                    other.unit.convertToBaseUnit(
                            other.value);

            return Math.abs(first - second) < 0.0001;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null ||
                    getClass() != obj.getClass())
                return false;

            return compare((Length) obj);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        System.out.println(a.convertTo(
                LengthUnit.INCHES));

        System.out.println(a.add(
                b, LengthUnit.FEET));

        System.out.println(
                new Length(36,
                        LengthUnit.INCHES)
                        .equals(
                                new Length(1,
                                        LengthUnit.YARDS)));
    }
}