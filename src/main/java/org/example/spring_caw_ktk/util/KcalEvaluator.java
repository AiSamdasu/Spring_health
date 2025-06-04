package org.example.spring_caw_ktk.util;

public class KcalEvaluator {
    public static String evaluate(double bmi, int sumKcal) {
        int 기준;

        if (bmi < 18) {
            기준 = 2000;
        } else if (bmi < 25) {
            기준 = 2500;
        } else {
            기준 = 1800;
        }

        if (sumKcal <= 기준) {
            return "3급 (정상)";
        } else if (sumKcal <= 기준 + 300) {
            return "2급 (주의)";
        } else {
            return "1급 (과다)";
        }
    }
}
