package file_util;

import car_factory.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeReportCar(Car car, float average, float errorMeasurement) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/home/treinamento-asus/CBR-System/src/file_util/report.txt", true));
        buffWrite.append("---------------" + "\n");
        buffWrite.append(car.toString() + "\n");
        buffWrite.append("Average price: " + average + "\n");
        buffWrite.append("Error Measurement: " + errorMeasurement + "\n");
        buffWrite.close();
    }
}
