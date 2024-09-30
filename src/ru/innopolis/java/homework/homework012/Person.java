package ru.innopolis.java.homework.homework012;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private Long phoneNumber;
    private Character gender;
    private Integer age;

    // Конструктор
    public Person(String surname, String name, String patronymic, String birthDate, Long phoneNumber, Character gender, Integer age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    // Конструктор по умолчанию (если нужен)
    public Person() {
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender + " " + age;
    }

    // Методы доступа (геттеры)
    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Character getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }
}







