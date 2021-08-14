import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.util.Enumeration;

class Statement{

}

class TextStatement extends Statement{
    public String value( Customer aCustomer ){
        Enumeration elements = aCustomer.getRentals();
        String result = "记录顾客: " + aCustomer.getName() + "\n";
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";

        }

        result += "总计消费: " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "你将获得: " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " 的积分";
        return result;

    }

}

class HtmlStatement extends Statement{
    public String value( Customer aCustomer ){
        Enumeration elements = aCustomer.getRentals();
        String result = "<H1>记录顾客: <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
        while (elements.hasMoreElements()) {

            Rental each = (Rental) elements.nextElement();

            result += each.getMovie().getTitle() + ": "
                    + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        result += "<P>总计消费: <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
        result += "你将获得: <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + "</EM> 的积分";
        return result;

    }




}
