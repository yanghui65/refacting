import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.util.Enumeration;
public class Customer {

    private String name;

    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration elements = rentals.elements();
        String result = "记录顾客: " + getName() + "\n";
        while (elements.hasMoreElements()) {

            double thisAmount = 0;
            Rental each = (Rental) elements.nextElement();

            thisAmount = amountFor(each);

            frequentRenterPoints ++;

            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        result += "总计消费: " + String.valueOf(totalAmount) + "\n";
        result += "你将获得: " + String.valueOf(frequentRenterPoints) + " 的积分";
        return result;
    }
    double amountFor( Rental aRental ){
        double result = 0;

        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDayRented() > 2) {
                    result += (aRental.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDayRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (aRental.getDayRented() > 3) {
                    result += (aRental.getDayRented() - 3) * 1.5;
                    break;
                }
        }
        return result;
    }

}


