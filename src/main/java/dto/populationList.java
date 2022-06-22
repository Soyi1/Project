package dto;

public class populationList {
    private String inputPlace;
    private int year;

    public populationList(String inputPlace, int year) {
        this.inputPlace = inputPlace;
        this.year = year;
    }

    public String getInputPlace() {
        return inputPlace;
    }

    public void setInputPlace(String inputPlace) {
        this.inputPlace = inputPlace;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}