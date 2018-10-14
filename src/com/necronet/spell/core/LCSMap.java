package com.necronet.spell.core;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LCSMap {


    private List<LCSObject> LCSObjects;
    private Logger logger = Logger.getLogger("Spell");

    /*
        Each log entry is assigned a unique line id which is initialized
        to 0 and auto-incremented for the arrival of a new log entry
     */
    private int lineId = 0;

    public LCSMap() {
        LCSObjects = new ArrayList<>();
    }

    //Insert a log entry into the LCSMap
    public void insert(String entry) {

        String seq[] = entry.trim().split("[\\s]+");

        //logger.info(Stream.of(seq).collect(Collectors.joining(" ")));
        LCSObject obj = getMatch(seq);

        //If no existing match create a new LCSObject, otherwise add the line id to an existing one
        if(obj == null) {
            obj = new LCSObject(seq, lineId++);
            LCSObjects.add(obj);
        } else {
            obj.insert(seq, lineId++);
        }
        //logger.info(String.format("LCSObjects size: %d",LCSObjects.size()));
    }

    // Find LCSObject that is the closest match
    private LCSObject getMatch(String seq[]) {
        return SimpleLoopMatch.match(seq, LCSObjects);
    }

    // Returns LCSObject at a given index
    public LCSObject objectAt(int index) {
        return LCSObjects.get(index);
    }

    // Returns number of LCSObjects made
    public int size() {
        return LCSObjects.size();
    }

    //To string method for testing
    public String toString() {
        String temp = "\t" + size() + " Objects in the LCSMap\n\n";
        int entryCount = 0;

        for(int i = 0; i < size(); i++) {
            temp = temp + "\tObject " + i + ":\n\t\t" + objectAt(i).toString() + "\n";
            entryCount += objectAt(i).count();
        }

        temp = temp + "\n\t" + entryCount + " total entries found, " + lineId + " expected.";

        return temp;
    }

}

