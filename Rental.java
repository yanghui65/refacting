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
        return movie.getCharge(dayRented);
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

