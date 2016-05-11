public class Main {

    public static void main(String[] args) {
        int[] vec = new int[5];
        System.out.println("Länge vec = " + vec.length);
        System.out.println("Inhalt vec = " + vec[0]);
        System.out.println("Inhalt vec = " + vec[1]);

        InputVector inputVector = new InputVector(5);
        int[] vector = inputVector.getVector();
        System.out.println("Länge vector = " + vector.length);
        System.out.println("Inhalt vector = " + vector[2]);
        System.out.println("Inhalt vector = " + vector[3]);
    }
}
