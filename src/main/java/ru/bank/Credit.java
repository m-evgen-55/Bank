package ru.bank;

public class Credit {

    private String lastName;        // фамилия клиента, зпрашивающего кредит
    private String firstName;       // имя клиента, зпрашивающего кредит
    private int age;                // возраст заемщика
    private int sumOfCredit;        // запрашиваемая сумма кредита
    private int salary;             // зп клиента, запрашивающего кредит
    private int timeOfCredit;       // запрашиваемый срок кредита (в годах) (должен быть не более, чем 3 года)

    public Credit(String lastName, String firstName, int age, int sumOfCredit, int salary, int timeOfCredit) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sumOfCredit = sumOfCredit;
        this.salary = salary;
        this.timeOfCredit = timeOfCredit;
    }

    // реализовать проверку является ли клиентов лицо, запроашивающее кредит

    public boolean creditDecision(int age, int sumOfCredit, int salary, int timeOfCredit) {
        int resultSum = (sumOfCredit+(sumOfCredit/10))*timeOfCredit;
        int paymentPerMonth = resultSum/36;
        int maxPossablePaymentPerMonth = salary/2;
        if (age < 50 && paymentPerMonth < maxPossablePaymentPerMonth) {
            // выдать данные о сумме кредита, дате его погащения?, сумме ежемесячного платежа,
            // процентной ставке (10%)
            return true;
        } else {
            // выдать информацию об отказе (причину), суму, которую банк готов одобрить
            return false;
        }

    }

}
