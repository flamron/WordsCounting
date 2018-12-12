package by.it.seroglazov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class WordsCounting {
    // f - plain text file. Use whitespace as delimiter
    public static Map<String, Integer> getSortedWordsFreq(File f) throws FileNotFoundException {
        Scanner sc;
        sc = new Scanner(f);
        HashMap<String, Integer> myMap = new HashMap<>(500);
        while (sc.hasNext()) {
            String str = sc.next().toLowerCase();
            str = str.replaceAll("[,!?;(){}\\[\\]:.]", "");
            if (str.length() > 2){
                myMap.merge(str, 1, (x, y) -> x + 1);
            }
        }
        // Now sort and return
        return myMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
    }
}
