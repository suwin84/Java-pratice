package Calculator;

import Model.ExpenditureRecord;
import Model.StatisticsPoint;
import java.util.List;

public interface ExpenditureStatisticsCalculator {
    List<StatisticsPoint> calculate(List<ExpenditureRecord> records);
}
