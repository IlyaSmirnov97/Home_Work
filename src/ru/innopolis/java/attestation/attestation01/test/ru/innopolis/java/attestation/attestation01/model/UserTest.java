package ru.innopolis.java.attestation.attestation01.test.ru.innopolis.java.attestation.attestation01.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.java.attestation.attestation01.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User validUser;

    @BeforeEach
    void setUp() {
        // Создание корректного пользователя для позитивных тестов
        validUser = new User(
                LocalDate.now(),
                "validUser",
                "Password_123",
                "Password_123",
                "Doe",
                "John",
                30,
                true
        );
    }

    @Test
    public void testUserCreationPositive() {
        // Проверка, что пользователь корректно создается
        assertNotNull(validUser.getId());
        assertEquals("validUser", validUser.getLogin());
        assertEquals("Password_123", validUser.getPassword());
        assertEquals("Doe", validUser.getLastName());
        assertEquals("John", validUser.getName());
        assertEquals(30, validUser.getAge());
        assertTrue(validUser.isWorker());
    }

    @Test
    public void testUserPasswordValidation() {
        // Проверка корректности валидации пароля
        assertDoesNotThrow(() -> validUser.setPassword("NewPass_456"));
        assertEquals("NewPass_456", validUser.getPassword());
    }

    @Test
    public void testUserPasswordMismatchException() {
        // Проверка, что выбрасывается исключение при несовпадении паролей
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new User(
                    LocalDate.now(),
                    "user1",
                    "Password_123",
                    "DifferentPassword",
                    "Smith",
                    "Anna",
                    25,
                    true
            );
        });

        assertEquals("Пароли не совпадают", thrown.getMessage());
    }

    @Test
    public void testInvalidPasswordException() {
        // Проверка, что выбрасывается исключение при некорректном пароле
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validUser.setPassword("invalidpassword");
        });

        assertEquals("Пароль не корректный. Пароль должен содержать буквы, цифры, знак подчеркивания, длина меньше 20 символов", thrown.getMessage());
    }

    @Test
    public void testAgeValidation() {
        // Проверка корректности установки и получения возраста
        validUser.setAge(25);
        assertEquals(25, validUser.getAge());
    }

    @Test
    public void testUserCreationWithoutPatronymic() {
        // Проверка создания пользователя без отчества
        User userWithoutPatronymic = new User(
                LocalDate.now(),
                "login2",
                "Password_123",
                "Password_123",
                "Ivanov",
                "Ivan",
                28,
                false
        );

        assertEquals("", userWithoutPatronymic.getPatronymic());
        assertEquals("Ivanov", userWithoutPatronymic.getLastName());
        assertEquals("Ivan", userWithoutPatronymic.getName());
    }

}