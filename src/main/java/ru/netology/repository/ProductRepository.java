package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] items = new Product[0];

    public void save (Product item) {
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;

    }

    public void removeById (int id) {
        //Проверяем есть ли такой id в коррзине
        boolean validId = false;
        for (Product delItem : items) {
            if (delItem.getId() == id) {
                validId = true;
            }
        }
        if (validId == true){
            Product[] temp = new  Product[items.length - 1];
            int index = 0;
            for (Product item  : items){
                if (item.getId() != id) {
                    temp[index] = item;
                    index++;
                }
            }
            items = temp;
        }
        else return;

    }

    public Product[] findAll() {
        return items;
    }
}
