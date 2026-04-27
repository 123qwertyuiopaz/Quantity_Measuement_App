// TEST CODE
//USECASE 9
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Weight;

public class QuantityMeasurementAppTest {

    @Test
    public void kilogramEqualKilogram() {
        assertTrue(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new Weight(1,
                                        WeightUnit.KILOGRAM)));
    }

    @Test
    public void kilogramEqualGram() {
        assertTrue(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new Weight(1000,
                                        WeightUnit.GRAM)));
    }

    @Test
    public void poundEqualGram() {
        assertTrue(
                new Weight(1,
                        WeightUnit.POUND)
                        .equals(
                                new Weight(453.592,
                                        WeightUnit.GRAM)));
    }

    @Test
    public void kilogramNotEqual() {
        assertFalse(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new Weight(2,
                                        WeightUnit.KILOGRAM)));
    }

    @Test
    public void weightNullCheck() {
        assertFalse(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .equals(null));
    }

    @Test
    public void weightSelfEqual() {
        Weight w =
                new Weight(5,
                        WeightUnit.GRAM);

        assertTrue(w.equals(w));
    }

    @Test
    public void convertKgToGram() {
        assertTrue(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM)
                        .equals(
                                new Weight(1000,
                                        WeightUnit.GRAM)));
    }

    @Test
    public void convertPoundToKg() {
        assertTrue(
                new Weight(2.20462,
                        WeightUnit.POUND)
                        .convertTo(
                                WeightUnit.KILOGRAM)
                        .equals(
                                new Weight(1,
                                        WeightUnit.KILOGRAM)));
    }

    @Test
    public void addKgAndGram() {
        assertTrue(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Weight(1000,
                                        WeightUnit.GRAM))
                        .equals(
                                new Weight(2,
                                        WeightUnit.KILOGRAM)));
    }

    @Test
    public void addWithTargetGram() {
        assertTrue(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Weight(1000,
                                        WeightUnit.GRAM),
                                WeightUnit.GRAM)
                        .equals(
                                new Weight(2000,
                                        WeightUnit.GRAM)));
    }

    @Test
    public void addPoundAndKg() {
        assertTrue(
                new Weight(2.20462,
                        WeightUnit.POUND)
                        .add(
                                new Weight(1,
                                        WeightUnit.KILOGRAM),
                                WeightUnit.POUND)
                        .equals(
                                new Weight(4.40924,
                                        WeightUnit.POUND)));
    }

    @Test
    public void weightVsLength() {
        assertFalse(
                new Weight(1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new Length(1,
                                        LengthUnit.FEET)));
    }
}