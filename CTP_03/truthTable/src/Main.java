public class Main {

    public static void main(String[] args) {
        int[] vec = new int[5];
        System.out.println("Länge vec = " + vec.length);
        System.out.println("Inhalt vec = " + vec[0]);

        InputVector inputVector = new InputVector(5);
        int[] vector = inputVector.getVector();
        System.out.println("Länge vector = " + vector.length);
        System.out.println("Inhalt vector = " + vector[2]);

        inputVector.setVector("1,0,1,0,2");
        System.out.println("vector: " + inputVector.vectorAsString());
        int[] v = {1,0,10,5};
        inputVector.onlyAllowValues(v);
        System.out.println("allow: " + inputVector.allowedValuesAsString());
        inputVector.setVector("1,0,1,0,10");
        System.out.println("vector after allow: " + inputVector.vectorAsString());

    }
}
