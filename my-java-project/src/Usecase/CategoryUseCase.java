package Usecase;

import Repository.CategoryRepository;
import Model.Category;

public class CategoryUseCase {
    private CategoryRepository categoryRepository;

    public CategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(CategoryCreateCommand command) {
        validateInput(command);
        showCategoryNotExist(command);
    }

    private void validateInput(CategoryCreateCommand command) {
        if (command == null || command.getName() == null || command.getName().isEmpty()) {
            throw new IllegalArgumentException("分類名稱為必填");
        }
        if (command.getIcon() == null || command.getIcon().isEmpty()) {
            throw new IllegalArgumentException("分類圖示為必填");
        }
    }

    private void showCategoryNotExist(CategoryCreateCommand command) {
        Category category = new Category(
                command.getName(),
                command.getIcon());
        categoryRepository.save(category);
    }
}
