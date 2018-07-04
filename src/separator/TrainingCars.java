package separator;

import car_factory.Car;

import java.util.ArrayList;

public class TrainingCars {

    private ArrayList<Car> trainingCars;

    public TrainingCars() {
        this.trainingCars = new ArrayList<>();
    }

    public void addTrainingCar(Car car) {
        this.trainingCars.add(car);
    }

    public int sizeOfTrainingCars(){
        return this.trainingCars.size();
    }

    public ArrayList<Car> getTrainingCars() {
        return trainingCars;
    }
}
