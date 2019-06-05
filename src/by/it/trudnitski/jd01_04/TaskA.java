package by.it.trudnitski.jd01_04;

import java.util.Scanner;

/**@author Timofei Rudnitski;
 */
public class TaskA {

    //Метод распечатывает таблицу умножения;
    public static void main(String[] args) {
        printMulTable();
      //  String line="3 4 6 8 1 6 9 7 0 4";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);
     //   Arrays.copyOf();
     //   System.array.copy();


    }

    static void printMulTable(){
        for (int i = 2; i <=9; i++) {
            for (int j = 2; j <=9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i,j,i*j);
            }
            System.out.println();
        }
    }



    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last=array[array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        InOut.printArray(array,"V",4);

        for (int i = 0; i < array.length; i++) {
            if(array[i]==first){
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]==last){
                System.out.println("Index of last element=" + i);
                break;
            }
        }
        //int IndexFirst = Arrays.binarySearch(array, first);
        //System.out.println("Index of first element=" + IndexFirst);
        //int IndexLast = Arrays.binarySearch(array, last);
        //System.out.println("Index of last element=" + IndexLast);
    }
}
