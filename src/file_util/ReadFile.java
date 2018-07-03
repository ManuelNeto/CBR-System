package file_util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    private ArrayList<String[]> stringCars;

    public ReadFile() {
        stringCars = new ArrayList();
    }

    public ArrayList<String[]> run() {

        String arquivoCSV = "/home/treinamento-asus/CBR-System/src/file_util/data.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {

                String[] carro = linha.split(csvDivisor);
                stringCars.add(carro);


            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return stringCars;
    }

}