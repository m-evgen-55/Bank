package ru.bank;

public class Clients {

    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;

    public Clients(String lastName, String firstName, String birthDate, int age) {
//        this.FirstName = firstName;
//        this.LastName = lastName;
//        this.BirthDate = birthDate;
//        this.age = age;

        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }

    public void checkClientAge (int age) {
        if (age < 18) {
            //бросить исклчение, обработать его и вывести текст что такой клиент не может быть создан
            System.out.println("Клиенту меньше 18 лет. Такой клиент не может быть зарегистрирован");
        } else {
            // записать данные клиента в БД
        }
    }





    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        birthDate = birthDate;
    }
}
