package Calculator;

import Model.IncomeRecord;
import Model.StatisticsPoint;
import java.util.List;

public interface IncomeStatisticsCalculator {
    List<StatisticsPoint> calculate(List<IncomeRecord> records);
}
