package com.google.firebase.codelab.friendlychat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ronel on 12/12/2016.
 */
public class DynamicAdHelper {

    private HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

    public DynamicAdHelper(String room){
        wordCountMap.put(room, 1);
    }

    public void countText(String text){
        String[] words = text.toLowerCase().split(" ");
        for (String word : words){
            //if word is already present in wordCountMap, updating its count
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            }
            //otherwise inserting the word as key and 1 as its value
            else {
                wordCountMap.put(word, 1);
            }
        }
    }

    public String getMostRepeatedWord(){
        //Getting all the entries of wordCountMap in the form of Set
        Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();
        //Creating a List by passing the entrySet
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(entrySet);

        //Sorting the list in the decreasing order of values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return (e2.getValue().compareTo(e1.getValue()));
            }
        });

        return list.get(0).getKey();
    }
}
