public class Rental {

    private Movie movie;

    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public double getCharge(){
        double result = 0;

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDayRented() > 2) {
                    result += (getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDayRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (getDayRented() > 3) {
                    result += (getDayRented() - 3) * 1.5;
                    break;
                }
        }
        return result;

    }
    public int getFrequentRenterPoints() {
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE
                && getDayRented() > 1) {
            return 2;
        }else{
            return 1;
        }

    }
}

