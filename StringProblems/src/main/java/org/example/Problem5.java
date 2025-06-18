package org.example;

public class Problem5 {

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";
        if(isRotation(str1, str2)){
            System.out.println(str2 + " is a rotation of " + str1);
        }
        else{
            System.out.println(str2 + " is NOT a rotation of " + str1);
        }
    }

    public static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length() || s1.length() == 0){
            return false;
        }
        String concatenate = s1 + s1;
        return concatenate.contains(s2);
    }

}
