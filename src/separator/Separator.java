package separator;

import car_factory.Car;
import car_factory.CarFactory;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

public class Separator {

    private CarFactory carFactory;
    private TrainingCars trainingCars;
    private ValidationCars validationCars;
    private More_similar more_similar;
    private int limitOfTrainingCars;
    private int limitOfValidationCars;

    public Separator() {
        this.carFactory = new CarFactory();
        this.trainingCars = new TrainingCars();
        this.validationCars = new ValidationCars();
        this.more_similar = new More_similar();
        this.limitOfTrainingCars = 9532;
        this.limitOfValidationCars = 2383;

        carFactory.createCars();
        System.out.println("Total: " + carFactory.getObjectCars().size());
    }

    public void separateCars(){
        for(Car car : carFactory.getObjectCars()){
            int coin = (int) Math.random();

            if(coin % 2 == 0){
                if(checkLimitOfTrainingCars()){
                    trainingCars.addTrainingCar(car);
                }else if(checkLimitOfValidationCars()) {
                    validationCars.addValidationCar(car);
                }
            }else if(coin % 2 == 1){
                if(checkLimitOfValidationCars()) {
                    validationCars.addValidationCar(car);
                }else if(checkLimitOfTrainingCars()){
                    trainingCars.addTrainingCar(car);
                }
            }
        }

        System.out.println("Training: " + this.trainingCars.sizeOfTrainingCars());
        System.out.println("Validation: " + this.validationCars.sizeOfValidationCars());

    }

    public boolean checkLimitOfTrainingCars(){
        if(this.trainingCars.sizeOfTrainingCars() < this.limitOfTrainingCars){
            return  true;
        }else {
            return false;
        }
    }

    public boolean checkLimitOfValidationCars(){
        if(this.validationCars.sizeOfValidationCars() < this.limitOfValidationCars){
            return  true;
        }else {
            return false;
        }
    }

    public void averagePriceEstimate(){

        for(Car validationCar : this.validationCars.getValidationCars()){
            float average = averagePrice(validationCar);
            System.out.println("---------------");
            System.out.println(validationCar);
            System.out.println("Average price: " + average);
        }

    }


    public float averagePrice(Car car){
        ArrayList<Car>  twentyMostSimilar = twentyMostSimilar(car);
        float sum = 0;
        for(Car currentCar : twentyMostSimilar){
            sum += Float.parseFloat(currentCar.getMsrp());
        }

        return sum/twentyMostSimilar.size();
    }


    public  ArrayList<Car> twentyMostSimilar(Car car){
        return this.more_similar.twentyMostSimilar(this.trainingCars.getTrainingCars(), car);
    }


}
