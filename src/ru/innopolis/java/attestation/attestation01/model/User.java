package ru.innopolis.java.attestation.attestation01.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private LocalDate date;
    private String login;

    private String password;
    private String confirmPassword;
    private String lastName;
    private String name;
    private String patronymic ="";
    private int age = -1;
    private boolean isWorker;


    public User(LocalDate date, String login, String password, String confirmPassword, String lastName, String name, String patronymic, int age, boolean isWorker) {
        this(date, login, password, confirmPassword, lastName, name, isWorker);
        this.patronymic = patronymic;
        this.age = age;
    }
    public User(LocalDate date, String login, String password, String confirmPassword, String lastName, String name, String patronymic,  boolean isWorker) {
        this(date, login, password, confirmPassword, lastName, name, isWorker);
        this.patronymic = patronymic;
    }

    public User(LocalDate date, String login, String password, String confirmPassword, String lastName, String name,  int age, boolean isWorker) {
        this(date, login, password, confirmPassword, lastName, name, isWorker);
        this.age = age;
    }

    public User(LocalDate date, String login, String password, String confirmPassword, String lastName, String name, boolean isWorker) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.login = login;
        if (password.equals(confirmPassword)) {
            setPassword(password);
            setConfirmPassword(confirmPassword);
        } else {
            throw new IllegalArgumentException("Пароли не совпадают");
        }

        this.lastName = lastName;
        this.name = name;
        this.isWorker = isWorker;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {


        if (isValid(password)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Пароль не корректный. Пароль должен содержать буквы, цифры, знак подчеркивания, длина меньше 20 символов");
        }
    }

    private boolean isValid(String password) {
        boolean hasLength = password.length() < 20;
        boolean hasLetter = password.chars().anyMatch(Character::isLetter);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasUnderlining = password.chars().anyMatch(ch -> ch == '_');
        return hasLength && hasLetter && hasDigit && hasUnderlining;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

}
