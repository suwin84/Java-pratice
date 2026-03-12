package com.example;

import java.util.List;

public interface IncomeStatisticsCalculator {
    List<StatisticsPoint> calculate(List<IncomeRecord> records);
}
