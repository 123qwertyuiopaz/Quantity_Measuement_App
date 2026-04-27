// TEST CODE
//USECASE 4
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(1, LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(new Length(1, LengthUnit.INCHES)
                .equals(new Length(1, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    public void testYardEquals36Inches() {
        assertTrue(new Length(1, LengthUnit.YARDS)
                .equals(new Length(36, LengthUnit.INCHES)));
    }

    @Test
    public void testYardEquals3Feet() {
        assertTrue(new Length(1, LengthUnit.YARDS)
                .equals(new Length(3, LengthUnit.FEET)));
    }

    @Test
    public void testCentimeterEqualsInches() {
        assertTrue(new Length(1, LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, LengthUnit.INCHES)));
    }

    @Test
    public void testThreeFeetEqualsOneYard() {
        assertTrue(new Length(3, LengthUnit.FEET)
                .equals(new Length(1, LengthUnit.YARDS)));
    }

    @Test
    public void testThirtyPoint48CmEqualsOneFoot() {
        assertTrue(new Length(30.48, LengthUnit.CENTIMETERS)
                .equals(new Length(1, LengthUnit.FEET)));
    }

    @Test
    public void testSameReference() {
        Length length = new Length(1, LengthUnit.FEET);
        assertTrue(length.equals(length));
    }

    @Test
    public void testNullComparison() {
        Length length = new Length(1, LengthUnit.FEET);
        assertFalse(length.equals(null));
    }

    @Test
    public void testDifferentValuesNotEqual() {
        assertFalse(new Length(1, LengthUnit.FEET)
                .equals(new Length(2, LengthUnit.FEET)));
    }

    @Test
    public void testCrossUnitNotEqual() {
        assertFalse(new Length(1, LengthUnit.YARDS)
                .equals(new Length(2, LengthUnit.FEET)));
    }
}