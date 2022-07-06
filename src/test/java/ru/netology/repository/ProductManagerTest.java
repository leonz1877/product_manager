package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManagerTest {
    Product item1 = new Book(11, "Красная таблетка", 1_399, "Курпатов");
    Product item2 = new Book(22, "Властелин колец", 2_999, "Толкиен");
    Product item3 = new Book(33, "Бойцовский клуб", 1_699, "Паланик");
    Product item4 = new Book(44, "12 негритят", 299, "Кристи");
    Product item5 = new Smartphone(515, "Bison", 8_999, "Umidigi");
    Product item6 = new Smartphone(626, "OnePlus", 38_999, "OnePlus");
    Product item7 = new Smartphone(737, "Iphone 12 mini", 32_999, "Apple");
    Product item8 = new Smartphone(848, "Iphone 12", 42_999, "Apple");

    //Поиск по наименованию, одно значение
    @Test
    public void SearchByIdOneItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);

        Product[] expected = {
                item1,
                //item2,
                //item3,
                //item4,
                //item5,
                //item6,
                //item7,
                //item8
        };
        Product[] actual = manager.searchBy("Красная");

        Assertions.assertArrayEquals(expected, actual);

    }

    //Поиск по наименованию, три значения
    @Test
    public void SearchByIdThreeItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);

        Product[] expected = {
                //item1,
                //item2,
                //item3,
                item4,
                //item5,
                //item6,
                item7,
                item8
        };
        Product[] actual = manager.searchBy("12");

        Assertions.assertArrayEquals(expected, actual);
    }
    //Поиск по наименованию, нет значений
    @Test
    public void SearchByIdNotItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);

        Product[] expected = {
                //item1,
                //item2,
                //item3,
                //item4,
                //item5,
                //item6,
                //item7,
                //item8
        };
        Product[] actual = manager.searchBy("Iphone 13");

        Assertions.assertArrayEquals(expected, actual);

    }

    //Удалить 1 товар
    @Test
    public void delByIdOneItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.delById(515);

        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                //item5,
                item6,
                item7,
                item8
        };
        Product[] actual = manager.watch();

        Assertions.assertArrayEquals(expected, actual);

    }

    //Удалить 3 товара
    @Test
    public void delByIdThreeItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.delById(11);
        manager.delById(515);
        manager.delById(848);

        Product[] expected = {
                //item1,
                item2,
                item3,
                item4,
                //item5,
                item6,
                item7,
                //item8
        };
        Product[] actual = manager.watch();

        Assertions.assertArrayEquals(expected, actual);

    }
    //Удалить все товары
    @Test
    public void delByIdAllItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.delById(11);
        manager.delById(515);
        manager.delById(848);
        manager.delById(22);
        manager.delById(44);
        manager.delById(626);
        manager.delById(33);
        manager.delById(737);

        Product[] expected = {

        };
        Product[] actual = manager.watch();

        Assertions.assertArrayEquals(expected, actual);

    }

    //Попытаться удалть товар с несуществующим Id, сломалось, добавил проверку в методе
    @Test
    public void delByIdNotExistItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.delById(222);

        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                item7,
                item8
        };
        Product[] actual = manager.watch();

        Assertions.assertArrayEquals(expected, actual);

    }

}



