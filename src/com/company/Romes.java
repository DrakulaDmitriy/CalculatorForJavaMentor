package com.company;


import static com.company.MathOperations.DefineMathOperation;

public class Romes {
    private final int firstRomesValueInt;
    private final int secondRomesValueInt;
    private final String sign;
    Romes(String firstValue,String sign, String secondValue) {
        this.sign = sign;
        this.firstRomesValueInt = ConvertToInt(firstValue);
        this.secondRomesValueInt = ConvertToInt(secondValue);
    }
    private int ConvertToInt(String romes_value) {
        char[] valueChar = romes_value.toCharArray();
        int[] values_int = new int[valueChar.length];
        for (int i = 0; i < valueChar.length; i++) {
            switch (valueChar[i]) {
                case 'I' -> values_int[i] = 1;
                case 'V' -> values_int[i] = 5;
                case 'X' -> values_int[i] = 10;
                default -> {
                    System.out.println("""
                            Содержится неверный символ. Проверьте правильность ввода римских цифр:
                            I = 1
                            V = 5
                            X = 10""");
                    System.exit(0);
                }
            }
        }
        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i + 1]) {
                result += values_int[i + 1];
            } else if (values_int[i] < values_int[i + 1]) {
                result = result + values_int[i + 1] - 2;
            }
        }
        try {
            if (result <= 10)
                return result;
            else{
                throw new Exception("\"Калькулятор принимат на вход числа от I до X включительно\\n" +
                        "Попробуйте еще раз.");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(0);
            return 0;
        }

    }
    public int GetResult() {
        try {
            switch (sign) {
                case "+" -> {
                    DefineMathOperation(firstRomesValueInt, secondRomesValueInt, MathematicalCalculations.SUM);
                    return MathOperations.ArabicResult();
                }
                case "-" -> {
                    try {
                        DefineMathOperation(firstRomesValueInt, secondRomesValueInt, MathematicalCalculations.SUBTRACT);
                        if (MathOperations.ArabicResult() < 0){
                            throw new Exception("В римской системе нет отрицательных чисел");
                        }
                        else
                            return MathOperations.ArabicResult();
                    }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    System.exit(0);
                    return 0;
                    }
                }
                case "*" -> {
                    DefineMathOperation(firstRomesValueInt, secondRomesValueInt, MathematicalCalculations.MULTIPLY);
                    return MathOperations.ArabicResult();
                }
                case "/" -> {
                    DefineMathOperation(firstRomesValueInt, secondRomesValueInt, MathematicalCalculations.DIVISION);
                    return MathOperations.ArabicResult();

                }
                default -> throw new NumberFormatException("""
                        Неверный формат ввода математической операции!
                        Введите выражение в формате: два операнда и один оператор (+, -, /, *),
                        разделяя каждый символ пробелом.""");
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
            return 0;
        }
    }

    public static String romanDigit(int n, String one, String five, String ten){

        if(n >= 1)
        {
            switch (n) {
                case 1:
                    return one;
                case 2:
                    return one + one;
                case 3:
                    return one + one + one;
                case 4:
                    return one + five;
                case 5:
                    return five;
                case 6:
                    return five + one;
                case 7:
                    return five + one + one;
                case 8:
                    return five + one + one + one;
                case 9:
                    return one + ten;
            }

        }
        return "";
    }
    public  String ArabicInRomes(int number){
        String romanOnes = romanDigit(number % 10, "I", "V", "X");
        number /= 10;

        String romanTens = romanDigit(number % 10, "X", "L", "C");
        number /= 10;

        String romanHundreds = romanDigit(number % 10, "C", "D", "M");

        return romanHundreds + romanTens + romanOnes;
    }
}
