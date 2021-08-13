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
        double result = 0;

        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (dayRented > 2) {
                    result += (dayRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += dayRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (dayRented > 3) {
                    result += (dayRented - 3) * 1.5;
                    break;
                }
        }
        return result;

    }
    public int getFrequentRenterPoints(int dayRented) {
        if (getPriceCode() == Movie.NEW_RELEASE
                && dayRented > 1) {
            return 2;
        }else{
            return 1;
        }

    }

}

