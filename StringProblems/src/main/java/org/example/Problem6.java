package org.example;

import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";
        String result = "dabecf";
        if(isValidShuffle(str1, str2, result)){
            System.out.println(result + " is a valid shuffle of " + str1 + " and " + str2);
        }
        else{
            System.out.println(result + " is NOT a valid shuffle of " + str1 + " and " + str2);
        }
    }
    public static boolean isValidShuffle(String str1, String str2, String result){
        if(str1.length() + str2.length() != result.length()){
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch : (str1 + str2).toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch,0)+1);
        }

        for(char ch :  result.toCharArray()){
            if(!countMap.containsKey(ch)) return false;
            countMap.put(ch, countMap.get(ch)-1);
            if(countMap.get(ch) < 0) return false;
        }
        return true;
    }
}
