// APP CODE
//USECASE 4
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

            private final double conversionFactor;

            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }

            public double getConversionFactor() {
                return conversionFactor;
            }
        }

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        public boolean compare(Length other) {
            return Double.compare(this.convertToBaseUnit(),
                    other.convertToBaseUnit()) == 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;
            return compare(other);
        }
    }

    public static void demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        System.out.println(value1 + " " + unit1 +
                " == " + value2 + " " + unit2 +
                " : " + length1.equals(length2));
    }

    public static void main(String[] args) {

        demonstrateLengthComparison(1.0,
                Length.LengthUnit.FEET,
                12.0,
                Length.LengthUnit.INCHES);

        demonstrateLengthComparison(1.0,
                Length.LengthUnit.YARDS,
                36.0,
                Length.LengthUnit.INCHES);

        demonstrateLengthComparison(100.0,
                Length.LengthUnit.CENTIMETERS,
                39.3701,
                Length.LengthUnit.INCHES);

        demonstrateLengthComparison(3.0,
                Length.LengthUnit.FEET,
                1.0,
                Length.LengthUnit.YARDS);

        demonstrateLengthComparison(30.48,
                Length.LengthUnit.CENTIMETERS,
                1.0,
                Length.LengthUnit.FEET);
    }
}