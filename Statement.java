import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.util.Enumeration;

class Statement{

}

class TextStatement extends Statement{
    String headString( Customer aCustomer ){
        return "记录顾客: " + aCustomer.getName() + "\n";
    }
    String eachRentalString( Rental aRental ){
        return "\t" + aRental.getMovie().getTitle() + "\t"
                    + String.valueOf(aRental.getCharge()) + "\n";
    }

    String footerString( Customer aCustomer ){
        return "总计消费: " + String.valueOf(aCustomer.getTotalCharge()) + "\n" + "你将获得: " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " 的积分";
    }

    public String value( Customer aCustomer ){
        Enumeration elements = aCustomer.getRentals();
        String result = headString( aCustomer );
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += eachRentalString( each );

        }
        result += footerString( aCustomer );

        return result;

    }

}

class HtmlStatement extends Statement{
    String headString( Customer aCustomer ){
        return "<H1>记录顾客: <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }
    String eachRentalString( Rental aRental ){

        return aRental.getMovie().getTitle() + ": "
                    + String.valueOf(aRental.getCharge()) + "<BR>\n";
    }

    String footerString( Customer aCustomer ){

        return "<P>总计消费: <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" + "你将获得: <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + "</EM> 的积分";
    }
    public String value( Customer aCustomer ){
        Enumeration elements = aCustomer.getRentals();
        String result = headString( aCustomer );
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += eachRentalString( each );
        }
        result += footerString( aCustomer );
        return result;

    }
}
