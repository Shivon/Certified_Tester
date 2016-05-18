import java.io.Console;

public class Main {

    public static void main(String[] args) {
//        int[] vec = new int[5];
//        System.out.println("Länge vec = " + vec.length);
//        System.out.println("Inhalt vec = " + vec[0]);
//
//        InputVector inputVector = new InputVector(5);
//        int[] vector = inputVector.getVector();
//        System.out.println("Länge vector = " + vector.length);
//        System.out.println("Inhalt vector = " + vector[2]);
//
//        inputVector.setVector("1,0,1,0,2");
//        System.out.println("vector: " + inputVector.vectorAsString());
//        int[] v = {1,0,10,5};
//        inputVector.onlyAllowValues(v);
//        System.out.println("allow: " + inputVector.allowedValuesAsString());
//        inputVector.setVector("1,0,1,0,10");
//        System.out.println("vector after allow: " + inputVector.vectorAsString());
        Console console = System.console();
        System.out.println("Welcome to truth table viewer!");
        String numberOfRows = console.readLine("Enter the number of rows your table will have (excl result row): ");
        int rows = Integer.parseInt(numberOfRows);
        String numberOfColumns = console.readLine("Enter the number of columns your table will have: ");
        int columns = Integer.parseInt(numberOfColumns);
        TruthTableBeta beta = new TruthTableBeta(rows, columns, console);
        beta.fillTable();
    }
}
