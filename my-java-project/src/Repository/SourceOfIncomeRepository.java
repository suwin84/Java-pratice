package Repository;

import Model.SourceOfIncome;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Model.User;

public class SourceOfIncomeRepository {
    private List<SourceOfIncome> sourceOfIncomes = new ArrayList<>();

    public List<SourceOfIncome> findAll() {
        return new ArrayList<>(sourceOfIncomes);
    }

    public List<SourceOfIncome> findByName(String name) {
        return sourceOfIncomes.stream()
                .filter(income -> income.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public boolean existsByName(String name) {
        return sourceOfIncomes.stream()
                .anyMatch(income -> income.getName().equalsIgnoreCase(name));
    }

    public void save(SourceOfIncome sourceOfIncome) {
        if (sourceOfIncome != null && !existsByName(sourceOfIncome.getName())) {
            sourceOfIncomes.add(sourceOfIncome);
        }
    }
}
