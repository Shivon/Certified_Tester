import java.io.Console;
import java.util.Arrays;


public class TruthTableBeta {
    private int rowCount;
    private int columnCount;
    private boolean[][] inputMatrice;
    private boolean[] resultArray;
    private Console console;

    public TruthTableBeta(int rowCount, int columnCount, Console console) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.console = console;
        this.inputMatrice = new boolean[rowCount][columnCount];
        this.resultArray = new boolean[columnCount];
    }

    public void fillTable() {
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                String value = console.readLine("Enter boolean value for row " + row + " and column " + column + ":  ");
                inputMatrice[row][column] = parseBoolFromString(value);
            }
            System.out.println("Row " + row + ": " + Arrays.toString(inputMatrice[row]));
        }

        System.out.println("------------------------------------------------------");

        for (int column = 0; column < columnCount; column++) {
            String value = console.readLine("Enter boolean value for result row, column " + column + ":  ");
            resultArray[column] = parseBoolFromString(value);
        }

        System.out.println("Result row: " + Arrays.toString(resultArray));
    }

    public void printTable() {
        for (int row = 0; row < rowCount; row++) {
            System.out.println(Arrays.toString(inputMatrice[row]));
        }
        System.out.println("------------------------------------------------------");
        System.out.println(Arrays.toString(resultArray));
    }

    public void printTableBinary() {
        for (int row = 0; row < rowCount; row++) {
            System.out.println(toBinaryString(inputMatrice[row]));
        }
        System.out.println("------------------------------------------------------");
        System.out.println(toBinaryString(resultArray));
    }

    // Getter

    public boolean[][] getInputMatrice() {
        return inputMatrice;
    }

    public boolean[] getResultVector() {
        return resultArray;
    }

    public boolean[] getRow(int row) {
        return inputMatrice[row];
    }

    public boolean getCell(int row, int column) {
        return inputMatrice[row][column];
    }

    // Setter

    public void setInputMatrice(boolean[][] matrice) {
        inputMatrice = matrice;
    }

    public void setResultVector(boolean[] result) {
        resultArray = result;
    }

    public void setRow(int rowNumber, boolean[] rowContent) {
        inputMatrice[rowNumber] = rowContent;
    }

    public void setCell(int row, int column, boolean value) {
        inputMatrice[row][column] = value;
    }

    // Private methods

    private String toBinaryString(boolean[] row) {
        String rowString = Arrays.toString(row);
        return rowString.replace("false", "0").replace("true", "1").replace(",", "");
    }

    private boolean parseBoolFromString(String string) {
        string = string.replace(" ", "").toLowerCase();

        if (string.equals("1") || string.equals("t")) {
            return true;
        }

        return Boolean.parseBoolean(string);
    }
}
