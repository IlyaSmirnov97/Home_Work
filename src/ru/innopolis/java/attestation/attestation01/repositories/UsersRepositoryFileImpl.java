package ru.innopolis.java.attestation.attestation01.repositories;

import ru.innopolis.java.attestation.attestation01.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryFileImpl implements UsersRepository {
    private List<User> userList = new ArrayList<>();
    private static final String PATH_TO_USERS = "Users.txt";

    {
        loadFromFile();
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_TO_USERS))) {
            userList = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, создается новый файл.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_TO_USERS))) {
            oos.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(User user) {
        userList.add(user);
        saveToFile();
    }

    @Override
    public User findById(String id) {
        Optional<User> optionalUser = userList.stream().filter(user -> user.getId().equals(id)).findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("Пользователя с заданным идентификатором не существует");
        }
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void update(User user) {

        try {
            User existingUser = findById(user.getId());
            userList.remove(existingUser);
            userList.add(user);
            saveToFile();
        } catch (RuntimeException e) {
            System.out.println("Пользователь не найден. Добавляем нового пользователя.");
            create(user);
        }

    }

    @Override
    public void deleteById(String id) {
     User deleteUser =   findById(id);
     userList.removeIf(user -> user.equals(deleteUser));
     saveToFile();

    }

    @Override
    public void deleteAll() {
        userList.clear();
        saveToFile();
    }
}
