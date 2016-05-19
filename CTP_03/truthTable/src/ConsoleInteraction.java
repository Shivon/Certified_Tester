//import java.io.Console;
//
//public class ConsoleInteraction {
//    private int inputRows = 0;
//    private int columns = 0;
//
//
//
//    public static void main(String[] args) {
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console available.");
//            System.exit(1);
//        }
//
//        String s = "1,    2,3";
//        String[] arr = s.replace(" ", "").split(",");
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//
//        int [] res = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            res[i] = Integer.parseInt(arr[i]);
//        }
//        System.out.println(res[0]);
//        System.out.println(res[1]);
//        System.out.println(res[2]);
//
////        String login = console.readLine("Enter your login: ");
////        char [] oldPassword = console.readPassword("Enter your old password: ");
//        System.out.println("Welcome to truth table viewer!");
//        String numberOfRows = console.readLine("Enter the number of rows your table will have (excl result row): ");
//        inputRows = Integer.parseInt(numberOfRows);
//        String numberOfColumns = console.readLine("Enter the number of columns your table will have: ");
//        columns = Integer.parseInt(numberOfColumns);
//
//    }
//}
