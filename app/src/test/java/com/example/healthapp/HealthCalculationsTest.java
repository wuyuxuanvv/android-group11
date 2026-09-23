package com.example.healthapp;

import static org.junit.Assert.assertEquals;

import com.example.healthapp.common.DateTimeUtils;
import com.example.healthapp.common.HealthCalculations;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class HealthCalculationsTest {
    @Test
    public void estimateExerciseCalories_usesMetFormula() {
        assertEquals(280.0,
                HealthCalculations.estimateExerciseCalories(8.0, 70.0, 30), 0.001);
    }

    @Test
    public void calculateSleepDuration_supportsCrossMidnight() {
        ZoneId zone = ZoneId.systemDefault();
        long start = LocalDateTime.of(2026, 9, 23, 23, 30)
                .atZone(zone).toInstant().toEpochMilli();
        long end = LocalDateTime.of(2026, 9, 24, 7, 0)
                .atZone(zone).toInstant().toEpochMilli();
        assertEquals(450, DateTimeUtils.calculateDurationMinutes(start, end));
    }
}
