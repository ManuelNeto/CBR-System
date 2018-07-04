package separator;

import car_factory.Car;

import java.util.ArrayList;
import java.util.Collections;

public class More_similar {

    private ArrayList<Car> more_similar;
    private int muchSimilar;

    public More_similar() {
        this.more_similar = new ArrayList();
        this.muchSimilar = 0;
    }

    public void setMuch_similar(ArrayList<Car> cars, Car carComparete){
        for(Car car : cars){

            this.muchSimilar = 0;
            car.setMuchSimilar(0);


            if(car.getMake().equals(carComparete.getMake())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getCityMpg().equals(carComparete.getCityMpg())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getEngineCylinders().equals(carComparete.getEngineCylinders())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getDriven_wheels().equals(carComparete.getDriven_wheels())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getEngineFuelType().equals(carComparete.getEngineFuelType())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getEngineHp().equals(carComparete.getEngineHp())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getHighwayMPG().equals(carComparete.getHighwayMPG())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getMarketCategory().equals(carComparete.getMarketCategory())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getModel().equals(carComparete.getModel())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getNumberOfDoors().equals(carComparete.getNumberOfDoors())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getMsrp().equals(carComparete.getMsrp())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getPopularity().equals(carComparete.getPopularity())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getTransmissionType().equals(carComparete.getTransmissionType())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getVehicleSize().equals(carComparete.getVehicleSize())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getVehicleStyle().equals(carComparete.getVehicleStyle())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            if(car.getYear().equals(car.getYear())){
                this.muchSimilar = this.muchSimilar + 1;
            }

            car.setMuchSimilar(this.muchSimilar);
            this.more_similar.add(car);

        }

        sortMoreSimilar();
    }

    public void sortMoreSimilar(){
        Collections.sort(this.more_similar);
    }

    public ArrayList<Car> twentyMostSimilar(ArrayList<Car> cars, Car carComparete){

        setMuch_similar(cars, carComparete);

        ArrayList<Car> twentyMostSimilar = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            twentyMostSimilar.add(this.more_similar.get(i));
        }

        return twentyMostSimilar;
    }
}
