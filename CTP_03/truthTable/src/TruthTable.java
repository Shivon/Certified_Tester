import java.io.Console;
import java.util.Arrays;


public class TruthTable {
    // columns = vector of boolean values for each variable
    // rows = all values for one variable
    private int rowCount;
    private int columnCount;
    private boolean[][] inputMatrice;
    private boolean[] resultArray;
    private String[] conditionNames;
    private Console console;

    public TruthTable(int rowCount, int columnCount, Console console) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.console = console;
        this.inputMatrice = new boolean[rowCount][columnCount];
        this.resultArray = new boolean[rowCount];
        this.conditionNames = new String[columnCount];
    }

    public void fillTable() {
        // Define condition names
        for (int column = 0; column < columnCount; column++) {
            String var = console.readLine("Enter condition NAME for column " + column + ":  ");
            conditionNames[column] = var;
        }

        System.out.println("------------------------------------------------------");

        // Fill truth table itself
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                String value = console.readLine("Enter boolean value for condition (row) " + row + " and vector (column) " + column + ":  ");
                inputMatrice[row][column] = parseBoolFromString(value);
            }
            System.out.println("Condition (row) " + row + ": " + Arrays.toString(inputMatrice[row]));
        }

        System.out.println("------------------------------------------------------");

        // Fill result column
        for (int row = 0; row < rowCount; row++) {
            String value = console.readLine("Enter boolean values for result column, vector (row) " + row + ":  ");
            resultArray[row] = parseBoolFromString(value);
        }

        System.out.println("Result row: " + Arrays.toString(resultArray));
    }

    public void printTable() {
        System.out.println(formatForPrint(Arrays.toString(conditionNames)));
        for (int row = 0; row < rowCount; row++) {
            System.out.println(formatForPrint(Arrays.toString(inputMatrice[row])) + " | " + resultArray[row]);
        }
    }

    public void printTableBinary() {
        System.out.println(formatForPrint(Arrays.toString(conditionNames)));
        for (int row = 0; row < rowCount; row++) {
            System.out.println(toBinaryString(inputMatrice[row]) + " | " + toBinaryString(resultArray[row]));
        }
    }

    // Getter

    public boolean[][] getInputMatrice() {
        return inputMatrice;
    }

    public boolean[] getResultColumn() {
        return resultArray;
    }

    public boolean getResultForVector(int rowIndex) {
        return resultArray[rowIndex];
    }

    public boolean[] getVector(int rowIndex) {
        return inputMatrice[rowIndex];
    }

    public boolean getCell(int row, int column) {
        return inputMatrice[row][column];
    }

    // Setter

    public void setInputMatrice(boolean[][] matrice) {
        inputMatrice = matrice;
    }

    public void setResultColumn(boolean[] result) {
        resultArray = result;
    }

    public void setVector(int rowIndex, boolean[] vector) {
        inputMatrice[rowIndex] = vector;
    }

    public void setCell(int row, int column, boolean value) {
        inputMatrice[row][column] = value;
    }

    // Private methods

    private String toBinaryString(boolean[] row) {
        String rowString = Arrays.toString(row);
        return formatForPrint(rowString.replace("false", "0").replace("true", "1"));
    }

    private String toBinaryString(boolean bool) {
        if (bool) {
            return "1";
        } else {
            return "0";
        }
    }

    private String formatForPrint(String string) {
        return string.replace(",", "").replace("[", "").replace("]", "");
    }

    private boolean parseBoolFromString(String string) {
        string = string.replace(" ", "").toLowerCase();

        if (string.equals("1") || string.equals("t")) {
            return true;
        }

        return Boolean.parseBoolean(string);
    }
}
