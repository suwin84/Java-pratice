public class PaymentMethodUseCase {
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodUseCase(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public void execute(PaymentMethodCreateCommand command) throws PaymentMethodNotExists {
        validateInput(command);
        checkAndCreatePaymentMethod(command);
    }

    private void validateInput(PaymentMethodCreateCommand command) throws PaymentMethodNotExists {
        if (command == null || command.getName() == null || command.getName().isEmpty()) {
            throw new PaymentMethodNotExists("付款方式名稱不可為空");
        }
    }

    private void checkAndCreatePaymentMethod(PaymentMethodCreateCommand command) {
        String paymentMethodName = command.getName();
        if (!paymentMethodRepository.existsByName(paymentMethodName)) {
            paymentMethodRepository.save(new PaymentMethod(paymentMethodName));
        }
    }
}
