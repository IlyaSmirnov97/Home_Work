package ru.innopolis.java.Ilya_Smirnov.homework07;

/*• Скидочный продукт — специальный продукт, цена которого снижена наразмер скидки.
У скидки есть также срок действия. После завершения срокадействия скидка меняется.
Ограничения в классах для продуктов:- Название продукта не должно содержать только цифры;-
Если   название   продукта   короче,   чем   3   символа,   то   такое   названиенедействительно;-
Если   стоимость   продукта   или   скидочного   продукта   0   илиотрицательная, то такая цена неправильная.
Должна быть ошибка валидации.Программа реализуется  в  отдельной  ветке git   homeworks/homework07.
При   сохранении   состояния   программы   (коммиты)   пишется   сообщение   сописанием хода работы по задаче.
В корне папки с программой должен быть файл .gitignore.
Программа локально коммитится и публикуется в репозиторий GitHub напроверку.
 */

import java.time.LocalDate;
import java.util.Date;

public class DiscountProduct extends Product {
    int discount;
    LocalDate validity;

    public DiscountProduct(String productName, double price, int discount, LocalDate validity) {
        super(productName, price);
        if (validValidity(validity)) {

            if (chekDiscount(discount)) {
                this.discount = discount;
                this.validity = validity;
                setPrice(price / 100 * this.discount);
            } else {
                System.out.println("Неккоректный % скидки, скидка не будет применена");
                this.discount = 1;
            }
        } else {
            System.out.println("Время действия скидки завершено");
            this.discount = 1;
        }

    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "Скидка=" + discount + "%" +
                ", Дата окончания скидки: " + validity
                ;
    }

    public boolean chekDiscount(int discount) {
        if (discount >= 1 && discount <= 100) {
            return true;
        }
        return false;
    }

    public boolean validValidity(LocalDate validity) {
        LocalDate today = LocalDate.now();
        if (validity.isEqual(today) || validity.isAfter(today)) {
            return true;

        }
        return false;
    }
}
