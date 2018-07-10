package car_factory;

import file_util.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class CarFactory {

    private ArrayList<Car> objectCars;
    private ArrayList<String[]> stringCars;

    public CarFactory() {
        objectCars = new ArrayList();

        ReadFile readFile = new ReadFile();
        this.stringCars = readFile.run();

    }

    public void createCars () {
        int count = 0;
        for (String[] stringCar : this.stringCars) {
            if(count != 0 && stringCar.length == 16) {
                createCar(stringCar);
                count += 1;
            }

            count += 1;
        }
    }


    public void createCar (String[]stringCars){

        Car objectCar = new Car(
                    stringCars[0],
                    stringCars[1],
                    stringCars[2],
                    stringCars[3],
                    stringCars[4],
                    stringCars[5],
                    stringCars[6],
                    stringCars[7],
                    stringCars[8],
                    stringCars[9].split(","),
                    stringCars[10],
                    stringCars[11],
                    stringCars[12],
                    stringCars[13],
                    stringCars[14],
                    Float.valueOf(stringCars[15]));

            objectCars.add(objectCar);
    }

    public ArrayList<Car> getObjectCars() {
        return objectCars;
    }
}

