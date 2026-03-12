public class IncomeUseCase {
    private IncomeRecordRepository incomeRecordRepository;

    public IncomeUseCase(IncomeRecordRepository incomeRecordRepository) {
        this.incomeRecordRepository = incomeRecordRepository;
    }

    public void execute(IncomeCommand command) throws SourceOfIncomeNotSupport {
        validateInput(command);
        validateSourceOfIncome(command);
        saveIncome(command);
    }

    public void execute(IncomeCommand command) {
        try {
            execute(command);
        } catch (SourceOfIncomeNotSupport e) {
            System.err.println("警告: " + e.getMessage());
        }
    }

    private void validateInput(IncomeCommand command) throws SourceOfIncomeNotSupport {
        if (command == null) {
            throw new SourceOfIncomeNotSupport("收入命令不可為空");
        }
        if (command.getAmount() < 0) {
            throw new SourceOfIncomeNotSupport("收入金額不可為負數");
        }
    }

    private void validateSourceOfIncome(IncomeCommand command) throws SourceOfIncomeNotSupport {
        if (command.getSourceOfIncome() == null || command.getSourceOfIncome().isEmpty()) {
            throw new SourceOfIncomeNotSupport("收入來源不可為空");
        }
    }

    private void saveIncome(IncomeCommand command) {
        IncomeRecord record = new IncomeRecord(
            command.getUser(),
            command.getDate(),
            command.getAmount(),
            command.getSourceOfIncome(),
            command.getRemark()
        );
        incomeRecordRepository.save(record);
    }
}
