import car_factory.Car;
import car_factory.CarFactory;
import file_util.ReadFile;
import separator.Separator;

import java.io.IOException;
import java.util.ArrayList;

public class CBR_System {


    public static void main(String[] args) throws IOException {

        Separator separator = new Separator();
        separator.separateCars();
        separator.averagePriceEstimate();
    }
}
