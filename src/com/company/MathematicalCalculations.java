package com.company;

enum MathematicalCalculations {
    SUM{
        public float action(float firstValue, float secondValue){return firstValue+secondValue;}
    },
    SUBTRACT{
        public float action(float firstValue, float secondValue){ return firstValue - secondValue;}
    },
    MULTIPLY{
        public float action(float firstValue, float secondValue){ return firstValue * secondValue;}
    },
    DIVISION{
        public float action(float firstValue, float secondValue){
            try {
                {return firstValue / secondValue;}
            }catch (ArithmeticException ex){System.out.print("Деление на 0!\nПрограмма завершилась!");
                System.exit(0);
                return 0;
            }
        }
    };
    public abstract float action(float firstValue, float secondValue);
}
class MathOperations {
    private static int arabicResult;

    public static int DefineMathOperation(float firstValueInt, float secondValueInt, MathematicalCalculations operation) {
      arabicResult = (int) operation.action(firstValueInt, secondValueInt);
        return 0;
    }
    public static int ArabicResult(){
        return arabicResult;
    }
}