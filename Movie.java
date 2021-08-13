import java.lang.IllegalArgumentException;
public class Movie {

    public static final int CHILDREN = 2;

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;

    private String title;

    private Price _price;

    public Movie(String title, int priceCode){
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg ) {
        switch(arg){
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDREN:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException( "Incorrent Price Code" );
        }
    }

    public double getCharge(int dayRented){
        return _price.getCharge(dayRented);
    }
    public int getFrequentRenterPoints(int dayRented) {
        return _price.getFrequentRenterPoints(dayRented);
    }

}

