// TEST CODE

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertTrue(
                new Length(1.0, LengthUnit.FEET)
                .equals(
                new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(
                new Length(1.0, LengthUnit.INCHES)
                .equals(
                new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(
                new Length(1.0, LengthUnit.FEET)
                .equals(
                new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(
                new Length(1.0, LengthUnit.FEET)
                .equals(
                new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesInequality() {
        assertFalse(
                new Length(1.0, LengthUnit.INCHES)
                .equals(
                new Length(2.0, LengthUnit.INCHES)));
    }

    @Test
    public void testCrossUnitInequality() {
        assertFalse(
                new Length(1.0, LengthUnit.FEET)
                .equals(
                new Length(10.0, LengthUnit.INCHES)));
    }

    @Test
    public void testSameReference() {
        Length length =
                new Length(1.0, LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void testNullComparison() {
        Length length =
                new Length(1.0, LengthUnit.FEET);

        assertFalse(length.equals(null));
    }
}
