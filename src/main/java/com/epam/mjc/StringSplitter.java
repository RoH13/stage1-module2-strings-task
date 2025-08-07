package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> res = new ArrayList<String>();
        if (source == null || delimiters.isEmpty()) {
            return res;
        }
        int indexL = 0;
        int indexR = 0;
        while (indexR < source.length()) {
            for (String x : delimiters) {
                if (source.startsWith(x, indexR)) {
                    if (indexR > indexL) {
                        res.add(source.substring(indexL, indexR));
                    }
                    indexL = indexR + x.length();
                    indexR = indexL - 1;
                    break;
                }
                
            }
            indexR++;
        }
        if (indexL < source.length()) {
            res.add(source.substring(indexL));
        }
        return res;
        //throw new UnsupportedOperationException("You should implement this method.");
    }
   /*   public static void main(String[] args) {
        System.out.println(splitByDelimiters("qwe tre qwewq tre rewr", new ArrayList<String>(List.of("re", "k"))));
    }*/
}
