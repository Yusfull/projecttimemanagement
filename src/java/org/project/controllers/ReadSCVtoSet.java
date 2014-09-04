/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.project.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.project.entities.TimeSpent;

/**
 *
 * @author Eusuph
 */
public class ReadSCVtoSet {

    String path = "U:/Work/CSV/testData.csv";

    public void readScv() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;

            while ((line = br.readLine()) != null) {
                //if(line.charAt(0))
                int z = 0;
                List dt = new ArrayList();
                String[] data = line.split(";");
                String[] copyData = data;
                //String guid = data[3];
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < copyData.length; j++) {
                        if (copyData[j].charAt(z) == data[i].charAt(z)) {
                            dt.add(data[i]);
                            System.out.println("Values!!: " + dt.get(i));
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReadSCVtoSet().readScv();
    }
}
