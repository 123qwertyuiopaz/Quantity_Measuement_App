// APP CODE
//usecase 6
package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {

        private double value;
        private LengthUnit unit;

        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

            private final double factor;

            LengthUnit(double factor) {
                this.factor = factor;
            }

            public double getFactor() {
                return factor;
            }
        }

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getFactor();
        }

        public Length convertTo(LengthUnit targetUnit) {
            double baseValue = convertToBaseUnit();
            double result = baseValue / targetUnit.getFactor();
            return new Length(result, targetUnit);
        }

        public Length add(Length other) {
            if (other == null)
                throw new IllegalArgumentException("Null length");

            double totalBase =
                    this.convertToBaseUnit() +
                            other.convertToBaseUnit();

            double result =
                    totalBase / this.unit.getFactor();

            return new Length(result, this.unit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;

            return Math.abs(
                    this.convertToBaseUnit()
                            - other.convertToBaseUnit()) < 0.0001;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static boolean demonstrateLengthEquality(
            Length length1, Length length2) {

        return length1.equals(length2);
    }

    public static Length demonstrateLengthAddition(
            Length length1, Length length2) {

        return length1.add(length2);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0,
                Length.LengthUnit.FEET);

        Length l2 = new Length(12.0,
                Length.LengthUnit.INCHES);

        Length sum =
                demonstrateLengthAddition(l1, l2);

        System.out.println(sum);

        Length l3 = new Length(1.0,
                Length.LengthUnit.YARDS);

        Length l4 = new Length(3.0,
                Length.LengthUnit.FEET);

        System.out.println(
                demonstrateLengthAddition(l3, l4));
    }
}