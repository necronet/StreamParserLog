package com.necronet.spell;

import com.necronet.spell.core.LCSMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;


public class Main {

    static Logger logger = Logger.getLogger("Spell");

    public static void main(String[] args) {

        final long startTime = System.nanoTime();
        try {
            File logFile = new File("sample_logs/dhcpd.csv");
            BufferedReader br = new BufferedReader(new FileReader(logFile));

            LCSMap map = new LCSMap();

            String line;
            while((line = br.readLine()) != null) {
                line = line.split(",")[4];
                map.insert(line);
            }

            final long duration = System.nanoTime() - startTime;
            logger.info("Test Results: " + duration/1000000);
            //int lcs = map.objectAt(1).getLCS("wall: user 1 broadcasted 1 lines (10 chars)".split("\\s+"));
            logger.info("obj: "+map.toString());
            //logger.info("lcs: "+lcs);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
