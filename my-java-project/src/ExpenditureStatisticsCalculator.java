import java.util.List;

public interface ExpenditureStatisticsCalculator {
    List<StatisticsPoint> calculate(List<ExpenditureRecord> records);
}
