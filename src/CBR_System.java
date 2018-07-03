import car_factory.Car;
import car_factory.CarFactory;
import file_util.ReadFile;

import java.util.ArrayList;

public class CBR_System {

    public static void main(String[] args) {

        CarFactory carFactory = new CarFactory();
        carFactory.createCars();
        System.out.println(carFactory.getObjectCars());


    }
}
