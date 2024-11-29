package ru.innopolis.java.attestation.attestation01.test.ru.innopolis.java.attestation.attestation01.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.java.attestation.attestation01.model.User;
import ru.innopolis.java.attestation.attestation01.repositories.UsersRepositoryFileImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {
    private UsersRepositoryFileImpl repository;
    @BeforeEach
    void setUp() {
        repository = new UsersRepositoryFileImpl();
        repository.deleteAll(); // Очищаем хранилище перед каждым тестом
    }

    @Test
    void create_ShouldAddUser() {
        User user = new User(LocalDate.now(), "testLogin", "password1_", "password1_", "Doe", "John", 30, true);
        repository.create(user);

        List<User> users = repository.findAll();
        assertEquals(1, users.size());
        assertEquals("testLogin", users.get(0).getLogin());
    }

    @Test
    void findById_ShouldReturnCorrectUser() {
        User user = new User(LocalDate.now(), "testLogin", "password1_", "password1_", "Doe", "John", 30, true);
        repository.create(user);

        User foundUser = repository.findById(user.getId());
        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void update_ShouldUpdateUserDetails() {
        User user = new User(LocalDate.now(), "testLogin", "password1_", "password1_", "Doe", "John", 30, true);
        repository.create(user);

        User updatedUser = new User(LocalDate.now(), "updatedLogin", "newPass1_", "newPass1_", "Doe", "John", 35, false);
        updatedUser.setId(user.getId());
        repository.update(updatedUser);

        User foundUser = repository.findById(user.getId());
        assertEquals("updatedLogin", foundUser.getLogin());
        assertEquals(35, foundUser.getAge());
    }

    @Test
    void deleteById_ShouldRemoveUser() {
        User user = new User(LocalDate.now(), "testLogin", "password1_", "password1_", "Doe", "John", 30, true);
        repository.create(user);

        repository.deleteById(user.getId());

        List<User> users = repository.findAll();
        assertEquals(0, users.size());
    }

    @Test
    void deleteAll_ShouldClearAllUsers() {
        User user1 = new User(LocalDate.now(), "testLogin1", "password1_", "password1_", "Doe", "John", 30, true);
        User user2 = new User(LocalDate.now(), "testLogin2", "password2_", "password2_", "Smith", "Jane", 25, false);
        repository.create(user1);
        repository.create(user2);

        repository.deleteAll();

        List<User> users = repository.findAll();
        assertEquals(0, users.size());
    }

}