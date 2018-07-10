package car_factory;

import java.util.Arrays;

public class Car implements  Comparable<Car>{

    private String make;
    private String model;
    private String year;
    private String engineFuelType;
    private String engineHp;
    private String engineCylinders;
    private String transmissionType;
    private String driven_wheels;
    private String numberOfDoors;
    private String[] marketCategory;
    private String vehicleSize;
    private String vehicleStyle;
    private String highwayMPG;
    private String cityMpg;
    private String popularity;
    private float msrp;
    private int muchSimilar;

    public Car(String make, String model, String year, String engineFuelType, String engineHp, String engineCylinders, String transmissionType, String driven_wheels,
               String numberOfDoors, String[] marketCategory, String vehicleSize, String vehicleStyle, String highwayMPG, String cityMpg, String popularity, float msrp) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.engineFuelType = engineFuelType;
        this.engineHp = engineHp;
        this.engineCylinders = engineCylinders;
        this.transmissionType = transmissionType;
        this.driven_wheels = driven_wheels;
        this.numberOfDoors = numberOfDoors;
        this.marketCategory = marketCategory;
        this.vehicleSize = vehicleSize;
        this.vehicleStyle = vehicleStyle;
        this.highwayMPG = highwayMPG;
        this.cityMpg = cityMpg;
        this.popularity = popularity;
        this.msrp = msrp;
        this.muchSimilar = 0;
    }

    public int getMuchSimilar() {
        return muchSimilar;
    }

    public void setMuchSimilar(int muchSimilar) {
        this.muchSimilar = muchSimilar;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngineFuelType() {
        return engineFuelType;
    }

    public void setEngineFuelType(String engineFuelType) {
        this.engineFuelType = engineFuelType;
    }

    public String getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(String engineHp) {
        this.engineHp = engineHp;
    }

    public String getEngineCylinders() {
        return engineCylinders;
    }

    public void setEngineCylinders(String engineCylinders) {
        this.engineCylinders = engineCylinders;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getDriven_wheels() {
        return driven_wheels;
    }

    public void setDriven_wheels(String driven_wheels) {
        this.driven_wheels = driven_wheels;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String[] getMarketCategory() {
        return marketCategory;
    }

    public void setMarketCategory(String[] marketCategory) {
        this.marketCategory = marketCategory;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleStyle() {
        return vehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    public String getHighwayMPG() {
        return highwayMPG;
    }

    public void setHighwayMPG(String highwayMPG) {
        this.highwayMPG = highwayMPG;
    }

    public String getCityMpg() {
        return cityMpg;
    }

    public void setCityMpg(String cityMpg) {
        this.cityMpg = cityMpg;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public float getMsrp() {
        return msrp;
    }

    public void setMsrp(float msrp) {
        this.msrp = msrp;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", engineFuelType='" + engineFuelType + '\'' +
                ", engineHp='" + engineHp + '\'' +
                ", engineCylinders='" + engineCylinders + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", driven_wheels='" + driven_wheels + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                ", marketCategory=" + Arrays.toString(marketCategory) +
                ", vehicleSize='" + vehicleSize + '\'' +
                ", vehicleStyle='" + vehicleStyle + '\'' +
                ", highwayMPG='" + highwayMPG + '\'' +
                ", cityMpg='" + cityMpg + '\'' +
                ", popularity='" + popularity + '\'' +
                ", msrp='" + msrp + '\'' +
                ", muchSimilar=" + muchSimilar +
                '}';
    }

    @Override
    public int compareTo(Car otherCar) {
        if (this.muchSimilar > otherCar.getMuchSimilar()) {
            return -1;
        }
        if (this.muchSimilar < otherCar.getMuchSimilar()) {
            return 1;
        }
        return 0;
    }
}