package by.it.seroglazov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        File myFile = new File("Text.txt");
        Map<String, Integer> sortedWordsFreq;
        try {
            sortedWordsFreq = WordsCounting.getSortedWordsFreq(myFile);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        sortedWordsFreq.entrySet().forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));
        // Print reverse order
        /*ArrayList<String> strings = new ArrayList<>(sortedWordsFreq.keySet());
        ListIterator<String> it = strings.listIterator(strings.size());
        while (it.hasPrevious()){
            String str = it.previous();
            System.out.println(str + " - " + sortedWordsFreq.get(str));
        }*/
    }
}
