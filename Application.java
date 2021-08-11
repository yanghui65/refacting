public class Application {

    public static void main(String[] args) {
        Customer customer = new Customer("一名测试顾客");
        Movie movie = new Movie();
        movie.setTitle("新视界");
        movie.setPriceCode(0);
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);

        System.out.println(customer.statement());
    }
}

