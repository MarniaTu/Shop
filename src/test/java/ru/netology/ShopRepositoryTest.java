package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(35, "Пакет подарочный", 115);
    Product product2 = new Product(117, "Фотоальбом", 697);
    Product product3 = new Product(249, "Фоторамка", 539);


    @Test
    public void shouldRemoveProductById() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
    }

    @Test
    public void shouldThrowException() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {

            repo.removeById(325);
        });
    }
}


