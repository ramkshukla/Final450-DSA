package org.example;

public class Problem20 {
    static final String[] keypad = {
            "0",    // space
            "",     // 1
            "ABC",  // 2
            "DEF",  // 3
            "GHI",  // 4
            "JKL",  // 5
            "MNO",  // 6
            "PQRS", // 7
            "TUV",  // 8
            "WXYZ"  // 9
    };

    public static String convertToKeypadSequence(String input) {
        input = input.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                result.append("0");
            } else {
                for (int i = 2; i <= 9; i++) {
                    String str = keypad[i];
                    int pos = str.indexOf(ch);
                    if (pos != -1) {
                        // Repeat key (pos + 1) times
                        result.append(String.valueOf(i).repeat(pos + 1));
                        break;
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "HELLO WORLD";
        String sequence = convertToKeypadSequence(sentence);
        System.out.println("Keypad Sequence: " + sequence);
    }
}
