package ru.netology.repository;
import ru.netology.domain.Product;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add (Product item) {
        repository.save(item);
    }

    public void delById (int id) {
        repository.removeById(id);
    }

    public Product [] watch () {
        return repository.findAll();
    }

    public Product [] searchBy(String text) {
        Product[] result = new Product[0];
        int index = 0;
        //Не работает
        /*for (Product product : repository.findAll()) {
            Product[] temp = new Product[result.length + 1];

            if (matches(product, text)) {

                temp [index] = product;
                index++;
                result = temp;
            }
        }*/
        //Работет,но цикл в цикле
        int index2;
        for (Product product : repository.findAll()) {
            Product[] temp = new Product[result.length + 1];

            if (matches(product, text)) {
                index2 = 0;
                for (Product product2 : result)
                {
                    temp[index2] = product2;
                    index2++;
                }
                temp [index] = product;
                index++;
                result = temp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}