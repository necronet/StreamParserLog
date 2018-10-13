package com.necronet.spell;

import com.necronet.spell.core.LCSMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        try {
            File logFile = new File("sample_logs/wall.csv");
            BufferedReader br = new BufferedReader(new FileReader(logFile));

            LCSMap map = new LCSMap();

            String line;
            while((line = br.readLine()) != null) {
                line = line.split(",")[4];
                map.insert(line);
            }

            System.out.println("Test Results:");
            System.out.println(map.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
