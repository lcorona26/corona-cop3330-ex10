/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Luis Corona
 */
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        String[][] item = app.readItem();
        int[][] itemInt = app.Conversion(item);
        float total = app.calcTotal(itemInt);
        app.printOutput(total);
    }


    private void printOutput(float total) {
        String newline = System.lineSeparator();
        String message = String.format("Subtotal: $%.2f" +newline+ "Tax: $%.2f" +newline+ "Total: $%.2f", total, total*.055, total+(total*.055));
        System.out.print(message);

    }

    private int[][] Conversion(String[][] item) {
        int[][] itemInt = new int[10][10];
        for(int i = 0; i<2; i++){
            for(int j = 0; j<3; j++){
                itemInt[i][j] = Integer.parseInt(item[i][j]);
            }
        }
        return itemInt;
    }

    private float calcTotal(int[][] itemInt) {
        float sum = 0;
        float subTotal = 0;
        for(int j = 0; j<3; j++){
            sum = itemInt[0][j] * itemInt[1][j];
            subTotal += sum;
        }
        return  subTotal;
    }


    private String[][] readItem() {

        String[][] store = new String[10][10];
        String[] item = new String[10];
        String[] quantity = new String[10];
        for (int i = 0; i < 3; i++) {
            String message = String.format("Enter the price of item %s: ", i + 1);
            System.out.print(message);
            item[i] = in.nextLine();
            store[0][i] = item[i];
            String message2 = String.format("Enter the quantity of item %s: ", i + 1);
            System.out.print(message2);
            quantity[i] = in.nextLine();
            store[1][i] = quantity[i];
        }
        return store;
    }
}
