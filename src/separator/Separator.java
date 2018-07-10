package separator;

import car_factory.Car;
import car_factory.CarFactory;
import file_util.WriteFile;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Separator {

    private CarFactory carFactory;
    private TrainingCars trainingCars;
    private ValidationCars validationCars;
    private More_similar more_similar;
    private WriteFile writeFile;
    private int limitOfTrainingCars;
    private int limitOfValidationCars;
    private Random gerador;

    public Separator() {
        this.carFactory = new CarFactory();
        this.trainingCars = new TrainingCars();
        this.validationCars = new ValidationCars();
        this.more_similar = new More_similar();
        this.limitOfTrainingCars = 6581;
        this.limitOfValidationCars = 1646;
        this.gerador = new Random();
        this.writeFile = new WriteFile();

        carFactory.createCars();
        System.out.println("Total: " + carFactory.getObjectCars().size());
    }

    public void separateCars(){
        for(Car car : carFactory.getObjectCars()){
            int coin = (int) gerador.nextInt(2);

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

    public void averagePriceEstimate() throws IOException {

        for(Car validationCar : this.validationCars.getValidationCars()){

            ArrayList<Car> twentyMostSimilar = twentyMostSimilar(validationCar);

            float average = averagePrice(twentyMostSimilar);
            float errorMeasurement = errorMeasurement(average, validationCar.getMsrp());
            int bestK = bestKexamples(twentyMostSimilar, validationCar,  errorMeasurement);

            this.writeFile.writeReportCar(validationCar, average, errorMeasurement, bestK);
        }

    }

    public float errorMeasurement(float average, float price) {
        return (float) Math.pow(average - price, 2);
    }



    public float averagePrice(ArrayList<Car> mostSilimar){
        float sum = 0;
        for(Car currentCar : mostSilimar){
            sum += currentCar.getMsrp();
        }

        return sum/mostSilimar.size();
    }

    public int bestKexamples(ArrayList<Car> twentyMostSimilar, Car car, float errorMeasurement){

        int bestK = 20;
        float lessDifference = errorMeasurement;


        for(int i = 1; i < 11; i++){

            ArrayList<Car> selectKexemples =  selectKexemples(twentyMostSimilar, i);
            float average = averagePrice(selectKexemples);
            float errorMeasurementForKExemples = errorMeasurement(average, car.getMsrp());

            if(lessDifference > errorMeasurementForKExemples){
                lessDifference = errorMeasurementForKExemples;
                bestK = i;
            }
        }

        return bestK;
    }

    private ArrayList<Car> selectKexemples(ArrayList<Car> twentyMostSimilar, int k){
        ArrayList<Car> selectKexemples = new ArrayList<>();

        for (int i = 0; i < k + 1 ; i++) {
            selectKexemples.add(twentyMostSimilar.get(i));
        }

        return selectKexemples;
    }



    public  ArrayList<Car> twentyMostSimilar(Car car){
        return this.more_similar.twentyMostSimilar(this.trainingCars.getTrainingCars(), car);
    }


}
