package com.company;

import static com.company.MathOperations.DefineMathOperation;

public class Arabic {
    public static void ArabicCalculation(String signOperations, float firstValueFloat, float secondValueFloat) {
        try {
            switch (signOperations) {
                case "+" -> DefineMathOperation(firstValueFloat, secondValueFloat, MathematicalCalculations.SUM);
                case "-" -> DefineMathOperation(firstValueFloat, secondValueFloat, MathematicalCalculations.SUBTRACT);
                case "*" -> DefineMathOperation(firstValueFloat, secondValueFloat, MathematicalCalculations.MULTIPLY);
                case "/" -> DefineMathOperation(firstValueFloat, secondValueFloat, MathematicalCalculations.DIVISION);
                default -> throw new NumberFormatException("""
                        Неверный формат ввода математической операции!
                        Введите выражение в формате: два операнда и один оператор (+, -, /, *),
                        разделяя каждый символ пробелом.""");
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
