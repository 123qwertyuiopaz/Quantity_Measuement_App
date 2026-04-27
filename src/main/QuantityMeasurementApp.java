// APP CODE
//USECASE 5
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

        private double convertToBaseUnit() {
            return value * unit.getFactor();
        }

        public Length convertTo(LengthUnit targetUnit) {
            double baseValue = convertToBaseUnit();
            double convertedValue = baseValue / targetUnit.getFactor();
            return new Length(convertedValue, targetUnit);
        }

        public static double convert(double value,
                                     LengthUnit source,
                                     LengthUnit target) {

            if (source == null || target == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid number");

            double baseValue = value * source.getFactor();
            return baseValue / target.getFactor();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;

            return Double.compare(
                    this.convertToBaseUnit(),
                    other.convertToBaseUnit()) == 0;
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

    public static double demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        return Length.convert(value, fromUnit, toUnit);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        System.out.println(
                demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));

        System.out.println(
                demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.FEET));

        System.out.println(
                demonstrateLengthConversion(
                        36.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.YARDS));

        Length length = new Length(2.0,
                Length.LengthUnit.FEET);

        System.out.println(
                demonstrateLengthConversion(
                        length,
                        Length.LengthUnit.INCHES));
    }
}