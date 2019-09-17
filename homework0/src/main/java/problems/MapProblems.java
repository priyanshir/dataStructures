package problems;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Parts b.i and b.ii should go here.
 *
 * (Implement `contains3` and `intersect` as described by the spec.
 *  See the spec on the website for examples and more explanation!)
 */
public class MapProblems {

    //returns a map that contains the common elements from m1 and m2
    public static Map<String, Integer> intersect(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> myMap = new HashMap<>();
        if (!m1.isEmpty() && !m2.isEmpty()) { //checking empty/null case
            for (String name1: m1.keySet()) { //going through m1
                for (String name2: m2.keySet()) { //through m2
                    if (name1.equals(name2)) { //if names are equal
                        if (m1.get(name1).equals(m2.get(name2))) { //if values are also equal
                            myMap.put(name1, m1.get(name1)); //put the name and value in new map
                        }
                    }
                }
            }
        }
        return myMap;
    }

    //returns true if any single string occurs at least 3 times in the list, and false otherwise.
    public static boolean contains3(List<String> input) {
        Map<String, Integer> myMap = new HashMap<>();
        if (input != null && !input.isEmpty()){ //checking empty/null case
            for (String str: input) {
                if (myMap.containsKey(str)) { //if it already contains the string as a key
                    myMap.put(str, myMap.get(str) + 1);
                    if (myMap.get(str) == 3) {//immediately returns true if count of the string hits 3
                        return true;
                    }
                }
                else { //if it has never seen the string before add it as a key with value 1
                    myMap.put(str, 1);
                }
            }
        }
        return false; //only if it never is able to return true
    }
}
