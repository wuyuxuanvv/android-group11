package com.example.healthapp.common;

/** Shared unit-safe calculations used by the exercise and diet modules. */
public final class HealthCalculations {
    private HealthCalculations() {
    }

    public static double estimateExerciseCalories(double metValue, double weightKg,
                                                   int durationMinutes) {
        requireNonNegative(metValue, "MET");
        requireNonNegative(weightKg, "Weight");
        if (durationMinutes < 0) {
            throw new IllegalArgumentException("Duration must not be negative");
        }
        return metValue * weightKg * durationMinutes / 60.0;
    }

    public static double calculateNutrientAmount(double per100Grams, double weightGrams) {
        requireNonNegative(per100Grams, "Value per 100 grams");
        requireNonNegative(weightGrams, "Food weight");
        return per100Grams * weightGrams / 100.0;
    }

    private static void requireNonNegative(double value, String name) {
        if (!Double.isFinite(value) || value < 0) {
            throw new IllegalArgumentException(name + " must be a finite non-negative number");
        }
    }
}
