// APP CODE
//usecase 7
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
            double result =
                    convertToBaseUnit() /
                            targetUnit.getFactor();

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
                    this.convertToBaseUnit() +
                            other.convertToBaseUnit();

            double result =
                    totalBase /
                            targetUnit.getFactor();

            return new Length(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null ||
                    getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;

            return Math.abs(
                    this.convertToBaseUnit() -
                            other.convertToBaseUnit())
                    < 0.0001;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            Length.LengthUnit targetUnit) {

        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {

        Length a =
                new Length(1,
                        Length.LengthUnit.FEET);

        Length b =
                new Length(12,
                        Length.LengthUnit.INCHES);

        System.out.println(
                demonstrateLengthAddition(
                        a, b,
                        Length.LengthUnit.FEET));

        System.out.println(
                demonstrateLengthAddition(
                        a, b,
                        Length.LengthUnit.INCHES));

        System.out.println(
                demonstrateLengthAddition(
                        a, b,
                        Length.LengthUnit.YARDS));
    }
}