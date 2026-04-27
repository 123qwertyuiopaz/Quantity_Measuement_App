// TEST CODE
// USECASE 7
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddTargetFeet() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        assertEquals(
                new Length(2, LengthUnit.FEET),
                a.add(b, LengthUnit.FEET));
    }

    @Test
    public void testAddTargetInches() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        assertEquals(
                new Length(24, LengthUnit.INCHES),
                a.add(b, LengthUnit.INCHES));
    }

    @Test
    public void testAddTargetYards() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        assertEquals(
                new Length(0.6667, LengthUnit.YARDS),
                a.add(b, LengthUnit.YARDS));
    }

    @Test
    public void testAddTargetCentimeters() {
        Length a = new Length(1, LengthUnit.INCHES);
        Length b = new Length(1, LengthUnit.INCHES);

        assertEquals(
                new Length(5.08,
                        LengthUnit.CENTIMETERS),
                a.add(b,
                        LengthUnit.CENTIMETERS));
    }

    @Test
    public void testSameAsFirstOperand() {
        Length a = new Length(2, LengthUnit.YARDS);
        Length b = new Length(3, LengthUnit.FEET);

        assertEquals(
                new Length(3, LengthUnit.YARDS),
                a.add(b, LengthUnit.YARDS));
    }

    @Test
    public void testSameAsSecondOperand() {
        Length a = new Length(2, LengthUnit.YARDS);
        Length b = new Length(3, LengthUnit.FEET);

        assertEquals(
                new Length(9, LengthUnit.FEET),
                a.add(b, LengthUnit.FEET));
    }

    @Test
    public void testWithZero() {
        Length a = new Length(5, LengthUnit.FEET);
        Length b = new Length(0, LengthUnit.INCHES);

        assertEquals(
                new Length(1.6667,
                        LengthUnit.YARDS),
                a.add(b, LengthUnit.YARDS));
    }

    @Test
    public void testNegativeValue() {
        Length a = new Length(5, LengthUnit.FEET);
        Length b = new Length(-2, LengthUnit.FEET);

        assertEquals(
                new Length(36,
                        LengthUnit.INCHES),
                a.add(b, LengthUnit.INCHES));
    }

    @Test
    public void testNullTargetUnit() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> a.add(b, null));
    }

    @Test
    public void testLargeToSmallScale() {
        Length a = new Length(1000,
                LengthUnit.FEET);

        Length b = new Length(500,
                LengthUnit.FEET);

        assertEquals(
                new Length(18000,
                        LengthUnit.INCHES),
                a.add(b,
                        LengthUnit.INCHES));
    }

    @Test
    public void testSmallToLargeScale() {
        Length a = new Length(12,
                LengthUnit.INCHES);

        Length b = new Length(12,
                LengthUnit.INCHES);

        assertEquals(
                new Length(0.6667,
                        LengthUnit.YARDS),
                a.add(b,
                        LengthUnit.YARDS));
    }
}