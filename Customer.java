import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.util.Enumeration;
public class Customer {

    private String name;

    private Vector<Rental> rentals = new Vector<Rental>();

    public Enumeration getRentals(){
        return rentals.elements();
    }


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
        return new TextStatement().value(this);
    }
    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }


    public double getTotalCharge(){
        double result = 0;
        Enumeration elements = rentals.elements();

        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration elements = rentals.elements();

        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += each.getFrequentRenterPoints();
        }
        return result;

    }


}


