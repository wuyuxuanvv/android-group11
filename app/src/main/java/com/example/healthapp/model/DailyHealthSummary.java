package com.example.healthapp.model;

/** Cross-module daily statistics. A null sleepDurationMinutes means no sleep record. */
public class DailyHealthSummary {
    public final String date;
    public final int exerciseCount;
    public final double calorieIntakeKcal;
    public final Integer sleepDurationMinutes;

    public DailyHealthSummary(String date, int exerciseCount, double calorieIntakeKcal,
                              Integer sleepDurationMinutes) {
        this.date = date;
        this.exerciseCount = exerciseCount;
        this.calorieIntakeKcal = calorieIntakeKcal;
        this.sleepDurationMinutes = sleepDurationMinutes;
    }
}
