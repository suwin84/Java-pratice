package Repository;

import com.example.model.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.model.User;

public class CategoryRepository {
    private List<Category> category = new ArrayList<>();

    public List<Category> findAll() {
        return new ArrayList<>(category);
    }

    public List<Category> findByName(String name) {
        return category.stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean existsByName(String name) {
        return category.stream().anyMatch(c -> c.getName().equalsIgnoreCase(name));
        // 改為不分大小寫的比對
    }

    public void save(Category c) {
        if (existsByName(c.getName())) {
            System.out.println("該消費類別已存在");
            // 如果存在，就印出訊息，不進行新增
        } else {
            category.add(c);
            // 如果不存在，才新增到列表中
        }
    }
}