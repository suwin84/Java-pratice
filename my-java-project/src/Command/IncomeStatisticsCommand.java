package Command;

import Model.User;
import java.time.LocalDate;
import java.util.List;

public class IncomeStatisticsCommand {
    private LocalDate date;
    private List<String> sourceOfIncome;

    public IncomeStatisticsCommand(LocalDate date, List<String> sourceOfIncome) {
        this.date = date;
        this.sourceOfIncome = sourceOfIncome;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSourceOfIncome(List<String> sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    public List<String> getSourceOfIncome() {
        return sourceOfIncome;
    }
}
