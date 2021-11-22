import java.util.Scanner;

public class Calc {

    private static String exp;

    private static String result;

    private static String[] exps;

    private static boolean itIsNumbers;

    public static void start() {
        readExp();
        split();
        if (!itIsNumbers) {
            getResultForStrings();
        } else {
            getResultForNumbers();
        }
        print();
    }

    private static void getResultForNumbers() {
        if (exps[1].contains("+")) {
            result = String.valueOf(Integer.parseInt(exps[0]) + Integer.parseInt(exps[2]));
            return;
        }
        if (exps[1].contains("-")) {
            result = String.valueOf(Integer.parseInt(exps[0]) - Integer.parseInt(exps[2]));
            return;
        }
        if (exps[1].contains("/")) {
            result = String.valueOf(Integer.parseInt(exps[0]) / Integer.parseInt(exps[2]));
            return;
        }
        if (exps[1].contains("*")) {
            result = String.valueOf(Integer.parseInt(exps[0]) * Integer.parseInt(exps[2]));
            return;
        }
        throw new RuntimeException();
    }

    private static void readExp() {
        Scanner s = new Scanner(System.in);
        exp = s.nextLine();

    }

    private static void sum() {
        result = exps[1] + exps[3];
    }

    private static void minus() {
        result = exps[1].replace(exps[3], "");
    }

    private static void getResultForStrings() {
        if (exps[2].contains("+")) {
            sum();
            return;
        }
        if (exps[2].contains("-")) {
            minus();
            return;
        }
        if (exps[2].contains("/")) {
            divide();
            return;
        }
        if (exps[2].contains("*")) {
            if (Integer.parseInt(exps[2].substring(3)) > 10) {
                throw new RuntimeException();
            }
            multiply();
            return;
        }
        throw new RuntimeException();
    }

    private static void divide() {
        result = exps[1].substring(0, exps[1].getBytes().length / Integer.parseInt(exps[2].substring(3)));
    }

    private static void multiply() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(exps[2].substring(3)); i++) {
            sb.append(exps[1]);
        }
        result = sb.toString();
    }

    private static void split() {
        exps = exp.split("\"");
        if (exps.length > 1) {
            for (String element : exps) {
                if (element.getBytes().length > 10) {
                    throw new RuntimeException();
                }
            }
        } else {
            itIsNumbers = true;
            exps = exp.split(" ");
            if (exps.length > 3) {
                throw new RuntimeException();
            }
            if (Integer.parseInt(exps[0]) > 10) {
                throw new RuntimeException();
            }
            if (Integer.parseInt(exps[2]) > 10) {
                throw new RuntimeException();
            }
        }

    }

    public static void print() {
        if (result.length() > 40) {
            System.out.println(result.substring(0, 40) + "...");
            return;
        }
        System.out.println(result);
    }
}
