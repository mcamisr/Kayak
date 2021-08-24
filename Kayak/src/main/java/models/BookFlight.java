package models;

public class BookFlight {
    private String originCity;
    private String destinationCity;
    private String passengers;
    private String goDate;
    private String returnDate;

    public BookFlight(String originCity, String destinationCity, String passengers, String goDate, String returnDate) {
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.passengers = passengers;
        this.goDate = goDate;
        this.returnDate = returnDate;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getGoDate() {
        return goDate;
    }

    public void setGoDate(String goDate) {
        this.goDate = goDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
