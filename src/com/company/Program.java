package com.company;

import java.util.Scanner;


public class Program {
    private static boolean isArabicNumber = true;
    private static String romesResult;


    private static String[] Pars(String input){
        String[] parsedInput = input.split(" ");
        try{
            if(parsedInput.length == 3){
                return parsedInput;
            } else {
                throw new Exception("""
                    Неверный формат ввода математической операции!
                    Введите выражение в формате: два операнда и один оператор (+, -, /, *),
                    разделяя каждый символ пробелом.""");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(0);
            return null;
        }

    }

    public static void main(String[] args) {

        Scanner imputValue = new Scanner(System.in);
        String input = imputValue.nextLine();

        String[] parsedInput = Program.Pars(input);
        String signOperations = parsedInput[1];

        float firstValueFloat = 0.0f;
        float secondValueFloat = 0.0f;

        try {
            firstValueFloat = Float.parseFloat(parsedInput[0]);
            secondValueFloat = Float.parseFloat(parsedInput[2]);
            if ((10 < firstValueFloat || firstValueFloat < 1) || (10 < secondValueFloat || secondValueFloat < 1)) {
                throw new Exception("Калькулятор принимат на вход числа от 1 до 10 включительно\n" +
                        "Попробуйте еще раз.");
            } else if (firstValueFloat % 1 != 0 || secondValueFloat % 1 != 0) {
                throw new Exception("Калькулятор умеет работать только с целыми числами.\n" +
                        "Попробуйте еще раз.");
            }
        } catch (NumberFormatException ex) {
            isArabicNumber = false;
            Romes values = new Romes(parsedInput[0], parsedInput[1], parsedInput[2]);
            romesResult = values.ArabicInRomes(values.GetResult());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        Arabic.ArabicCalculation(signOperations, firstValueFloat, secondValueFloat);

        if (isArabicNumber) {
            System.out.println("Ответ: " + MathOperations.ArabicResult());
        } else {
            System.out.println("Ответ: " + romesResult);
        }
    }


}

