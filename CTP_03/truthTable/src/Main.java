import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.err.println("No console available, use bash if not already or configure your IDE.");
            System.exit(1);
        }

        System.out.println("Welcome to truth table viewer!");
        String numberOfColumns = console.readLine("Enter the number of atomic conditions your table will have (columns): ");
        int columns = Integer.parseInt(numberOfColumns);
        String numberOfRows = console.readLine("Enter the number of vectors your table will have (rows): ");
        int rows = Integer.parseInt(numberOfRows);
        TruthTable truthTable = new TruthTable(rows, columns, console);
        truthTable.fillTable();
        System.out.println("\n");
//        truthTable.printTable();
//        System.out.println("\n");
//        TruthTable truthTable = new TruthTable(6, 3, console);
//        boolean[] test1 = new boolean[] {true, true, true};
//        boolean[] test2 = new boolean[] {true, true, true};
//        System.out.println("test1 areNeighbours test2? " + truthTable.areNeighbours(test1, test2));
//        boolean[] test3 = new boolean[] {false, true, false};
//        boolean[] test4 = new boolean[] {true, true, false};
//        System.out.println("test3 areNeighbours test4? " + truthTable.areNeighbours(test3, test4));
        truthTable.printTableBinary();
        System.out.println("\n");
        truthTable.conditionCoverage();
        System.out.println("\n");
        truthTable.minimalMultipleConditionCoverage();
    }
}
