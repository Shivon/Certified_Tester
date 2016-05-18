import java.io.Console;
import java.util.Arrays;

/**
 * Created by marjan on 18.05.16.
 */
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

    private boolean parseBoolFromString(String string) {
        string = string.replace(" ", "").toLowerCase();

        if (string.equals("1") || string.equals("t")) {
            return true;
        }

        return Boolean.parseBoolean(string);
    }
}
