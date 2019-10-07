package ru.bank;

public class Account {

    private double accNaum;          // номер счета
    private int payment;          // сумма, внесенная на счет
    private int sum;              // сумма, находящаяся на счете
    private String lastName;      // фамилия клиента, которому открывается счет
    private String firstName;     // имя клиента, которому открывается счет

    public Account(int payment, String lastName, String firstName) {
        this.payment = payment;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // присваивает счету индивидуальный номер
    private void setAccNaum() {
        accNaum = Math.random()*10000;
    }

    // внесение денег на счет
    public void putMoney(int payment) {
        setSum(sum + payment);
    }

    // снятие денег со счета (добавить exception)
    public void getMoney(int getMoney) {
        if (getMoney < sum) {
            setSum(sum - getMoney);
        } else {
            System.out.println("На Вашем счете недостаточно денег!");
        }
    }

    // добавить логирование операций со счетом (открытие, закрытие, снятие, внесение)


    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
