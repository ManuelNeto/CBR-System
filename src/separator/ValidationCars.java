package separator;

import car_factory.Car;

import java.util.ArrayList;

public class ValidationCars {

    private ArrayList<Car> validationCars;

    public ValidationCars() {
        this.validationCars = new ArrayList<>();
    }

    public void addValidationCar(Car car) {
        this.validationCars.add(car);
    }

    public int sizeOfValidationCars(){
        return this.validationCars.size();
    }

    public ArrayList<Car> getValidationCars() {
        return validationCars;
    }
}
