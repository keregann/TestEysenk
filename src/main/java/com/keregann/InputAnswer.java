package com.keregann;

import java.util.Scanner;

public class InputAnswer {
    public static Integer inputAnswer() {

        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            //aici poate fi in neregula
            answer = scanner.nextInt();
        }
        while (!isValid(answer));
        return answer;
    }


    public static boolean isValid(Integer answer4validate) {
        if (answer4validate.equals(1) || answer4validate.equals(0)) {
            return true;
        } else {
            System.out.println("Reintrodu raspunsul (1/0):");
            return false;
        }
    }
}
