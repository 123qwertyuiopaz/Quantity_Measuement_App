// TEST CODE
//USECASE 5
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetToInches() {
        assertEquals(12.0,
                Length.convert(1, LengthUnit.FEET, LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testInchesToFeet() {
        assertEquals(2.0,
                Length.convert(24, LengthUnit.INCHES, LengthUnit.FEET),
                0.0001);
    }

    @Test
    public void testYardsToInches() {
        assertEquals(36.0,
                Length.convert(1, LengthUnit.YARDS, LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testInchesToYards() {
        assertEquals(2.0,
                Length.convert(72, LengthUnit.INCHES, LengthUnit.YARDS),
                0.0001);
    }

    @Test
    public void testCentimetersToInches() {
        assertEquals(1.0,
                Length.convert(2.54, LengthUnit.CENTIMETERS,
                        LengthUnit.INCHES),
                0.001);
    }

    @Test
    public void testFeetToYards() {
        assertEquals(2.0,
                Length.convert(6, LengthUnit.FEET, LengthUnit.YARDS),
                0.0001);
    }

    @Test
    public void testZeroValue() {
        assertEquals(0.0,
                Length.convert(0, LengthUnit.FEET, LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testNegativeValue() {
        assertEquals(-12.0,
                Length.convert(-1, LengthUnit.FEET, LengthUnit.INCHES),
                0.0001);
    }

    @Test
    public void testRoundTrip() {
        double result =
                Length.convert(
                        Length.convert(5, LengthUnit.FEET,
                                LengthUnit.INCHES),
                        LengthUnit.INCHES,
                        LengthUnit.FEET);

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testSameUnit() {
        assertEquals(5.0,
                Length.convert(5, LengthUnit.FEET, LengthUnit.FEET),
                0.0001);
    }

    @Test
    public void testNullUnitThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(5, null, LengthUnit.FEET));
    }

    @Test
    public void testNaNThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }

    @Test
    public void testInfiniteThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.POSITIVE_INFINITY,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }
}