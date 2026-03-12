public class SourceOfIncomeUseCase {
    private SourceOfIncomeRepository sourceOfIncomeRepository;

    public SourceOfIncomeUseCase(SourceOfIncomeRepository sourceOfIncomeRepository) {
        this.sourceOfIncomeRepository = sourceOfIncomeRepository;
    }

    public void execute(SourceOfIncomeCreateCommand command) throws SourceOfIncomeNotExists {
        validateInput(command);
        checkAndCreateSourceOfIncome(command);
    }

    private void validateInput(SourceOfIncomeCreateCommand command) throws SourceOfIncomeNotExists {
        if (command == null || command.getName() == null || command.getName().isEmpty()) {
            throw new SourceOfIncomeNotExists("收入來源名稱不可為空");
        }
    }

    private void checkAndCreateSourceOfIncome(SourceOfIncomeCreateCommand command) {
        String sourceOfIncomeName = command.getName();
        if (!sourceOfIncomeRepository.existsByName(sourceOfIncomeName)) {
            sourceOfIncomeRepository.save(new SourceOfIncome(sourceOfIncomeName));
        }
    }
}
