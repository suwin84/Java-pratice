import java.util.ArrayList;
import java.util.List;

public class StatisticsPointRepository {
    private List<StatisticsPoint> statisticsPoints = new ArrayList<>();

    public void saveAll(List<StatisticsPoint> points) {
        if (points != null && !points.isEmpty()) {
            statisticsPoints.addAll(points);
        }
    }

    public List<StatisticsPoint> findAll() {
        return new ArrayList<>(statisticsPoints);
    }

    public void clear() {
        statisticsPoints.clear();
    }

    public int size() {
        return statisticsPoints.size();
    }
}
