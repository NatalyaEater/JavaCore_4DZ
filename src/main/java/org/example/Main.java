package org.example;
/*
* 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.*/
public class Main {
    public static void main(String[] args) {
        try{
            int res=exceptionArrays(new String[][]{
                    {"1","2","3","4"},
                    {"5","6","7","8"},
                    {"9","0","1","2"},
                    {"3","4","5","6"}});
            System.out.println("Сумма всех элементов массива равна : "+res);
        }
        catch (MyArraySizeException e) {
            System.out.println("Размер массива не равен 4х4 ");
        }
        catch (MyArrayDataException e) {
            System.out.println("Ошибка в преобразовании :" +"  Строка  " +(e.i+1)  +"  Знак  "+ (e.j+1));
        }
        System.out.println();
    }

    public static int exceptionArrays(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sumArr = 0;
        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                    throw new MyArraySizeException(String.format("Размер массива не равен 4х4 ,кол-во знаков :" + i));
            }
            for (int j = 0; j < arr[i].length; j++) {
                    try {
                        sumArr = sumArr + Integer.parseInt(arr[i][j]);
                    }
                    catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            return sumArr;
    }

}
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}
class MyArrayDataException extends Exception {
    public int i;
    public int j;
    MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;

    }
}



