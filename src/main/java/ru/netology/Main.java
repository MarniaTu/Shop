package ru.netology;

public class Main {
    public static void main(String[] args) {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(35, "Пакет подарочный", 115);
        Product product2 = new Product(117, "Фотоальбом", 697);
        Product product3 = new Product(249, "Фоторамка", 539);
        Product product4 = new Product(249, "Светильник", 1240);

        repo.add(product1);
        repo.add(product2);


        try {
            repo.addById(product3.getId());
            System.out.println("Hello");
        } catch (AlreadyExistsException e) {
            System.out.println("Error");
        }

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        try {
            repo.addById(product4.getId());
            System.out.println("Hello");
        } catch (AlreadyExistsException e) {
            System.out.println("Error");
        }


    }

}
