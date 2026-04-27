// TEST CODE
//USECASE 8
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetConstant() {
        assertEquals(12.0,
                LengthUnit.FEET.getConversionFactor(),
                0.0001);
    }

    @Test
    public void testInchesToBase() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertToBaseUnit(12),
                0.0001);
    }

    @Test
    public void testYardsToBase() {
        assertEquals(36.0,
                LengthUnit.YARDS.convertToBaseUnit(1),
                0.0001);
    }

    @Test
    public void testCentimetersToBase() {
        assertEquals(1.0,
                LengthUnit.CENTIMETERS
                        .convertToBaseUnit(2.54),
                0.0001);
    }

    @Test
    public void testBaseToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES
                        .convertFromBaseUnit(12),
                0.0001);
    }

    @Test
    public void testEquality() {
        assertTrue(
                new Length(1, LengthUnit.FEET)
                        .equals(
                                new Length(12,
                                        LengthUnit.INCHES)));
    }

    @Test
    public void testConvertTo() {
        assertEquals(
                new Length(12,
                        LengthUnit.INCHES),
                new Length(1,
                        LengthUnit.FEET)
                        .convertTo(
                                LengthUnit.INCHES));
    }

    @Test
    public void testAdd() {
        assertEquals(
                new Length(2,
                        LengthUnit.FEET),
                new Length(1,
                        LengthUnit.FEET)
                        .add(
                                new Length(12,
                                        LengthUnit.INCHES),
                                LengthUnit.FEET));
    }

    @Test
    public void testAddTargetYards() {
        assertEquals(
                new Length(0.6667,
                        LengthUnit.YARDS),
                new Length(1,
                        LengthUnit.FEET)
                        .add(
                                new Length(12,
                                        LengthUnit.INCHES),
                                LengthUnit.YARDS));
    }

    @Test
    public void testNullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1, null));
    }

    @Test
    public void testInvalidValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.NaN,
                        LengthUnit.FEET));
    }

    @Test
    public void testRoundTrip() {
        Length value =
                new Length(1,
                        LengthUnit.FEET)
                        .convertTo(
                                LengthUnit.INCHES)
                        .convertTo(
                                LengthUnit.FEET);

        assertEquals(
                new Length(1,
                        LengthUnit.FEET),
                value);
    }
}