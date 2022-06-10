package checkPopulation;

public class populationList {
    private String inputPlace;
    private int population;
    private int population65;
    private double percent65;

    public populationList(String inputPlace, int population, int population65, double percent65) {
        this.inputPlace = inputPlace;
        this.population = population;
        this.population65 = population65;
        this.percent65 = percent65;
    }

    public populationList(String inputPlace) {
        this.inputPlace = inputPlace;
    }

    public String getInputPlace() {
        return inputPlace;
    }
    public void setInputPlace(String inputPlace) {
        this.inputPlace = inputPlace;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public int getPopulation65() {
        return population65;
    }
    public void setPopulation65(int population65) {
        this.population65 = population65;
    }
    public double getPercent65() {
        return percent65;
    }
    public void setPercent65(double percent65) {
        this.percent65 = percent65;
    }
}