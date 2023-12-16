package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(35, "Пакет подарочный", 115);
    Product product2 = new Product(117, "Фотоальбом", 697);
    Product product3 = new Product(249, "Фоторамка", 539);
    Product product4 = new Product(249, "Светильник", 1240);


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

    @Test
    public void shouldAddById() {

        repo.add(product1);
        repo.add(product2);

        repo.addById(product3.getId());

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

    }

    @Test
    public void shouldThrowAlreadyExistsException() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {

            repo.addById(product4.getId());
        });

    }
}



