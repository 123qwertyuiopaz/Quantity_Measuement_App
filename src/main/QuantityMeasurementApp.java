// APP CODE
//USECASE 9
package com.apps.quantitymeasurement;

enum LengthUnit {
    FEET(12.0), INCHES(1.0), YARDS(36.0), CENTIMETERS(0.393701);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double base) {
        return base / factor;
    }
}

enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double base) {
        return base / factor;
    }
}

public class QuantityMeasurementApp {

    public static class Length {
        private double value;
        private LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double base() {
            return unit.toBase(value);
        }

        public Length convertTo(LengthUnit target) {
            return new Length(
                    target.fromBase(base()),
                    target);
        }

        public Length add(Length other) {
            return add(other, this.unit);
        }

        public Length add(Length other,
                          LengthUnit target) {

            double total =
                    this.base() + other.base();

            return new Length(
                    target.fromBase(total),
                    target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Length))
                return false;

            Length other = (Length) obj;

            return Math.abs(
                    this.base() -
                            other.base()) < 0.0001;
        }
    }

    public static class Weight {
        private double value;
        private WeightUnit unit;

        public Weight(double value,
                      WeightUnit unit) {

            this.value = value;
            this.unit = unit;
        }

        private double base() {
            return unit.toBase(value);
        }

        public Weight convertTo(
                WeightUnit target) {

            return new Weight(
                    target.fromBase(base()),
                    target);
        }

        public Weight add(Weight other) {
            return add(other, this.unit);
        }

        public Weight add(Weight other,
                          WeightUnit target) {

            double total =
                    this.base() + other.base();

            return new Weight(
                    target.fromBase(total),
                    target);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (!(obj instanceof Weight))
                return false;

            Weight other = (Weight) obj;

            return Math.abs(
                    this.base() -
                            other.base()) < 0.0001;
        }
    }

    public static void main(String[] args) {

        Weight w1 =
                new Weight(1,
                        WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(1000,
                        WeightUnit.GRAM);

        System.out.println(
                w1.equals(w2));

        System.out.println(
                w1.add(w2));

        System.out.println(
                w1.convertTo(
                        WeightUnit.POUND));
    }
}