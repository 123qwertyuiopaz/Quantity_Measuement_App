// TEST CODE
//usecase 6
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetPlusFeet() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(2, LengthUnit.FEET);

        assertEquals(
                new Length(3, LengthUnit.FEET),
                a.add(b));
    }

    @Test
    public void testInchPlusInch() {
        Length a = new Length(6, LengthUnit.INCHES);
        Length b = new Length(6, LengthUnit.INCHES);

        assertEquals(
                new Length(12, LengthUnit.INCHES),
                a.add(b));
    }

    @Test
    public void testFeetPlusInches() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        assertEquals(
                new Length(2, LengthUnit.FEET),
                a.add(b));
    }

    @Test
    public void testInchPlusFeet() {
        Length a = new Length(12, LengthUnit.INCHES);
        Length b = new Length(1, LengthUnit.FEET);

        assertEquals(
                new Length(24, LengthUnit.INCHES),
                a.add(b));
    }

    @Test
    public void testYardPlusFeet() {
        Length a = new Length(1, LengthUnit.YARDS);
        Length b = new Length(3, LengthUnit.FEET);

        assertEquals(
                new Length(2, LengthUnit.YARDS),
                a.add(b));
    }

    @Test
    public void testCentimeterPlusInch() {
        Length a = new Length(2.54,
                LengthUnit.CENTIMETERS);

        Length b = new Length(1,
                LengthUnit.INCHES);

        assertEquals(
                new Length(5.08,
                        LengthUnit.CENTIMETERS),
                a.add(b));
    }

    @Test
    public void testWithZero() {
        Length a = new Length(5, LengthUnit.FEET);
        Length b = new Length(0, LengthUnit.INCHES);

        assertEquals(
                new Length(5, LengthUnit.FEET),
                a.add(b));
    }

    @Test
    public void testNegativeValues() {
        Length a = new Length(5, LengthUnit.FEET);
        Length b = new Length(-2, LengthUnit.FEET);

        assertEquals(
                new Length(3, LengthUnit.FEET),
                a.add(b));
    }

    @Test
    public void testNullOperand() {
        Length a = new Length(1, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> a.add(null));
    }

    @Test
    public void testLargeValues() {
        Length a = new Length(1000000,
                LengthUnit.FEET);

        Length b = new Length(1000000,
                LengthUnit.FEET);

        assertEquals(
                new Length(2000000,
                        LengthUnit.FEET),
                a.add(b));
    }

    @Test
    public void testSmallValues() {
        Length a = new Length(0.001,
                LengthUnit.FEET);

        Length b = new Length(0.002,
                LengthUnit.FEET);

        assertEquals(
                new Length(0.003,
                        LengthUnit.FEET),
                a.add(b));
    }

    @Test
    public void testCommutativeProperty() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCHES);

        assertTrue(
                a.add(b).equals(
                        new Length(2,
                                LengthUnit.FEET)));
    }
}