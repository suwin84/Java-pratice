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
            throw new IllegalArgumentException("分類名稱不可為空");
        }
    }

    private void showCategoryNotExist(CategoryCreateCommand command) {
        String categoryName = command.getName();
        if (!categoryRepository.existsByName(categoryName)) {
            categoryRepository.save(new Category(categoryName));
        }
    }
}
