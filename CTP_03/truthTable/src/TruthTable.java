import java.io.Console;
import java.util.*;


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
//
//       this.inputMatrice = new boolean[][]{
//               {false, false, false},
//               {false, true, false},
//               {false, true, false},
//               {false, true, true},
//               {true, true, true},
//               {true, true, true}
//       };
//       this.resultArray = new boolean[] {
//               false, true, false, true, false, true
//       };
//       this.conditionNames = new String[] {
//               "A", "B", "C"
//       };
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

    // Prints table with "true" and "false" values
    public void printTable() {
        System.out.println(formatForPrint(Arrays.toString(conditionNames)));
        for (int row = 0; row < rowCount; row++) {
            System.out.println(formatForPrint(Arrays.toString(inputMatrice[row])) + " | " + resultArray[row]);
        }
    }

    // Prints table with "0" and "1" values
    public void printTableBinary() {
        System.out.println(formatForPrint(Arrays.toString(conditionNames)));
        for (int row = 0; row < rowCount; row++) {
            System.out.println(formatForPrint(toBinaryString(inputMatrice[row])) + " | " + toBinaryString(resultArray[row]));
        }
    }

    // Evaluation of (multiple) condition coverage

    // Returns Hash with test cases for simple condition coverage
    // keys = indices of matrix row, values = test case
    public HashMap<Integer, ArrayList> conditionCoverage() {
        HashMap<String, ArrayList> toggledConditions = new HashMap<>();
        Set<Boolean> toggledConditionsResult = new LinkedHashSet<>();
        Set<Integer> indicesOfTestCases = new LinkedHashSet<>();

        for (String condition : conditionNames) {
            toggledConditions.put(condition, new ArrayList());
        }

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                String conditionName = conditionNames[column];
                ArrayList<Boolean> currentConditionValues = toggledConditions.get(conditionName);
                Boolean bool = inputMatrice[row][column];

                // Check if current condition already has a test case with current boolean value
                // If not, test case will be added
                if (!currentConditionValues.contains(bool)) {
                    // Add boolean value of current condition to its list
                    currentConditionValues.add(bool);
                    toggledConditions.put(conditionName, currentConditionValues);
                    // Add value of result column to its set
                    toggledConditionsResult.add(resultArray[row]);
                    // Add index of test case to its set
                    indicesOfTestCases.add(row);
                }
            }
        }

        HashMap<Integer, ArrayList> result = new HashMap<>();
        System.out.println("Test cases for simple condition coverage: ");
        for (Integer index : indicesOfTestCases) {
            result.put(index, new ArrayList(Arrays.asList(inputMatrice[index])));
            System.out.println("Index of vector: " + index + ", test case: "+ toBinaryString(inputMatrice[index]) + ", result: "+ toBinaryString(resultArray[index]));
        }
        System.out.println("Decision coverage reached? " + decisionCoverageReached(toggledConditionsResult));

        return result;
    }

    public HashMap<Integer, ArrayList> minimalMultipleConditionCoverage() {
        HashMap<Integer, ArrayList> testCases = new HashMap<>();
        Set<Integer> indicesOfTestCases = new LinkedHashSet<>();


        for (int row = 0; row < rowCount; row++) {
            boolean[] currentVector = inputMatrice[row];

            for (int rowNeighbour = 0; rowNeighbour < rowCount; rowNeighbour++) {
                boolean[] potentialNeighbour = inputMatrice[rowNeighbour];

                if (areNeighbours(currentVector, potentialNeighbour) && differentResultValues(row, rowNeighbour)) {
                    indicesOfTestCases.add(row);
                    indicesOfTestCases.add(rowNeighbour);
                }
            }
        }

        System.out.println("Test cases for minimal multiple condition coverage: ");
        for (Integer index : indicesOfTestCases) {
            testCases.put(index, new ArrayList(Arrays.asList(inputMatrice[index])));
            System.out.println("Index of vector: " + index + ", test case: "+ toBinaryString(inputMatrice[index]) + ", result: "+ toBinaryString(resultArray[index]));
        }

        return testCases;
    }

    public boolean areNeighbours(boolean[] vector1, boolean[] vector2) {
        for (int column = 0; column < columnCount; column++) {
            vector1[column] = !vector1[column];

            if (Arrays.equals(vector1, vector2)) {
                vector1[column] = !vector1[column];
                return true;
            }

            vector1[column] = !vector1[column];
        }

        return false;
    }

    // Getter

    public boolean[][] getInputMatrice() {
        return inputMatrice;
    }

    public boolean[] getResultColumn() {
        return resultArray;
    }

    public String[] getConditionNames() {
        return conditionNames;
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

    public void setConditionNames(String[] names) {
        conditionNames = names;
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
        return rowString.replace("false", "0").replace("true", "1");
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

    // TODO: check if we should only check it or guarantee that decision coverage is reached
    private boolean decisionCoverageReached(Set<Boolean> toggledValues) {
        return (toggledValues.contains(true) && toggledValues.contains(false));
    }

    private boolean differentResultValues(int index1, int index2) {
        return (resultArray[index1] != resultArray[index2]);
    }
}
