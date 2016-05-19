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
        truthTable.printTableBinary();
    }
}
