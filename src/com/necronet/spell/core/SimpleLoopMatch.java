package com.necronet.spell.core;

import java.util.List;

public class SimpleLoopMatch {

    public static LCSObject match(String[] seq, List<LCSObject> LCSObjects) {
        LCSObject bestMatch = null;
        int bestMatchLength = 0;

        //Find LCS of all existing LCSObjects and determine if they're a match as described in the paper
        for(LCSObject obj : LCSObjects) {

            //Use the pruning described in the paper
            if(obj.length() < seq.length / 2 || obj.length() > seq.length * 2)
                continue;


            //Get LCS and see if it's a match
            int l = obj.getLCS(seq);
            if(l >= seq.length / 3 && l > bestMatchLength) {
                bestMatchLength = l;
                bestMatch = obj;
            }
        }

        return bestMatch;
    }

}
