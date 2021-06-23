package Lesson4;



public class Function {
    public boolean triangle(Integer number1, Integer number2, Integer number3){
        int p;
        if (number1 + number2 > number3 && number1 + number3 > number2 && number2 + number3 > number1){
            p =(number1 + number2 + number3)/2;
            Math.sqrt(p*(p - number1)*(p - number2)*(p - number3));
            return true;
        }else {
            return false;
        }
    }
}
