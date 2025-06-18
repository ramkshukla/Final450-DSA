package org.example;

public class Problem7 {
    public static void main(String[] args) {
//  Print All Terms:
        int n = 10; // You can change this to any number you want
        System.out.println("Count and Say Sequence up to term " + n + ":");

        String term = "1"; // Starting term
        System.out.println("1: " + term); // Print the first term

        for (int i = 2; i <= n; i++) {
            term = getNext(term);
            System.out.println(i + ": " + term);
        }

//        int n = 5;
//        System.out.println("Term " + n + " in Count and Say sequence: " + countAndSay(n));
//
    }

    public static String getNext(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ch){
                count++;
            }
            else {
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(ch);
        return  sb.toString();
    }
    public static String countAndSay(int n){
        if(n==1) return "1";
        String prev = "1";
        for(int i=2; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char ch = prev.charAt(0);
            for(int j=1; j<prev.length(); j++){
                if(prev.charAt(j) == ch){
                    count++;
                }
                else {
                    sb.append(count).append(ch);
                    ch = prev.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(ch);
            prev = sb.toString();
        }
        return prev;
    }

}
