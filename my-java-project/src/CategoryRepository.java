import java.util.List;
import java.util.stream.Collectors;

public class CategoryRepository {
    private List<Category> category = new List<>();

    public List<Category> findAll() {
        return new List<>(category);
    }

    public List<Category> findByName(String name) {
        return category.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList());
    }

    public boolean existsByName(String name) {
        return category.stream().anyMatch(c -> c.getName().equals(name));
    }

    public void save(Category c) {
        if (!existsByName(c.getName())) {
            category.add(c);
        }
    }
}