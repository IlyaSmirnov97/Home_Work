package ru.innopolis.java.attestation.attestation01;

import ru.innopolis.java.attestation.attestation01.model.User;
import ru.innopolis.java.attestation.attestation01.repositories.UsersRepositoryFileImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static UsersRepositoryFileImpl usersRepositoryFile = new UsersRepositoryFileImpl();

    public static void main(String[] args) {
        //Добавим сканер
        Scanner scanner = new Scanner(System.in);
        //Добавим интерфейса
        while (true) {
            System.out.println("Какой функционал хотите использовать?\n" +
                    "1. Добавить пользователя\n" +
                    "2. Удалить пользователя по id\n" +
                    "3. Обновить пользователя\n" +
                    "4. Посмотреть список пользователей\n" +
                    "5. Очистить список пользователей\n" +
                    "6. Найти пользователя по id\n" +
                    "7. Для завершения программы, введите end");
            String interfaceUser = scanner.nextLine();
            if (interfaceUser.equalsIgnoreCase("end")) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                int num = Integer.parseInt(interfaceUser);
                interfaceCommand(num, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 7.");
            }
        }


    }

    //Создаем метод, для управление интерфэйсом
    private static void interfaceCommand(int num, Scanner scanner) {
        if (num == 1) {
            User user = creatUser(scanner);
            usersRepositoryFile.create(user);

        } else if (num == 2) {
            System.out.println("Введите id: ");
            String id = scanner.nextLine();
            usersRepositoryFile.deleteById(id);

        } else if (num == 3) {
            System.out.println("Введите id: ");
            String id = scanner.nextLine();
            User user = usersRepositoryFile.findById(id);
            System.out.println("Данные пользователя: \n" + user);
            User userUpdate = creatUser(scanner);
            userUpdate.setId(user.getId());
            usersRepositoryFile.update(userUpdate);

        } else if (num == 4) {
            System.out.println("Список пользователей: ");
            List<User> userList = usersRepositoryFile.findAll();
            for (User user1 : userList) {
                System.out.println(user1);
            }

        } else if (num == 5) {
            usersRepositoryFile.deleteAll();
            System.out.println("Пользователи удалены.");
            System.out.println("Список пользователей: ");
            System.out.println(usersRepositoryFile.findAll());

        } else if (num == 6) {
            System.out.println("Введите id: ");
            String id = scanner.nextLine();
            System.out.println(usersRepositoryFile.findById(id));

        } else {
            System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 6.");
        }
    }
    private static User creatUser (Scanner scanner){
        System.out.println("Введите логин пользователя: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();
        System.out.println("Введите фамилию пользователя: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите имя пользователя: ");
        String name = scanner.nextLine();
        System.out.println("Введите отчество пользователя (при отсутствии отчества, поле оставить пустым): ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите возраст пользователя (если возраст неизвестен, поле оставить пустым): ");
        String age = scanner.nextLine();
        System.out.println("Данный пользователь является сотрудником? (Введите true, если является сотрудником, " +
                "введите false, если не является сотрудником): ");
        boolean isWorker = scanner.nextBoolean();
        scanner.nextLine();
        if ((patronymic == null || patronymic.isEmpty()) && (age == null || age.isEmpty())) {
            return new User(LocalDate.now(), login, password, confirmPassword, lastName, name, isWorker);
        } else if (age == null || age.isEmpty()) {
            return new User(LocalDate.now(), login, password, confirmPassword, lastName, name, patronymic, isWorker);
        } else if (patronymic == null || patronymic.isEmpty()) {
            int ageInt = Integer.parseInt(age);
            return new User(LocalDate.now(), login, password, confirmPassword, lastName, name, ageInt, isWorker);
        } else {
            int ageInt = Integer.parseInt(age);
           return new User(LocalDate.now(), login, password, confirmPassword, lastName, name, patronymic, ageInt, isWorker);
        }

    }
}
