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
        Enumeration elements = rentals.elements();
        String result = "记录顾客: " + getName() + "\n";
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";

        }

        result += "总计消费: " + String.valueOf(getTotalCharge()) + "\n";
        result += "你将获得: " + String.valueOf(getTotalFrequentRenterPoints()) + " 的积分";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration elements = rentals.elements();

        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration elements = rentals.elements();

        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += each.getFrequentRenterPoints();
        }
        return result;

    }


}


