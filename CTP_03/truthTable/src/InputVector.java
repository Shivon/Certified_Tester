import java.util.*;

public class InputVector extends ArrayList {
    private int[] vector;
    private int[] allowedValues;


    public InputVector(int length) {
        vector = new int[length];
        // init vector with -1 therewith it is not misunderstood for boolean value zero
        Arrays.fill(vector, -1);
    }

    public int[] setVector(String string) {
        String[] stringArray = string.replace(" ", "").split(",");

        if (stringArray.length != vector.length) {
            System.err.println("Length of your input vector is not equal to the set column size");
            System.exit(1);
        }

        for (int i = 0; i < stringArray.length; i++) {
            int value = Integer.parseInt(stringArray[i]);

            if (allowedValues != null && !Arrays.asList(allowedValues).contains(value)) {
                System.err.println("Your input values are invalid.");
                System.exit(1);
            }

            vector[i] = value;
        }

        return vector;
    }

    public int[] getVector() {
        return vector;
    }

    public void onlyAllowValues(int[] values) {
        int length = values.length;
        allowedValues = new int[length];
        allowedValues = Arrays.copyOf(values, length);
    }

//    public InputVector(int[] intArray, int[] validValues) {
//        TODO if wanted
//    }
//
//    public InputVector(int[] intArray) {
//        int length = intArray.length;
//        vector = new int[length];
//        vector = Arrays.copyOf(intArray, length);
//    }
//
//    public int[] setVector(int[] intArray) {
//        if (intArray.length != vector.length) {
//            System.err.println("Length of your input vector is not equal to the set column size");
//            System.exit(1);
//        }
//
//        int length = intArray.length;
//        vector = new int[length];
//
//        for (int i = 0; i < intArray.length; i++) {
//            int value = intArray[i];
//
//            if (allowedValues != null && !Arrays.asList(allowedValues).contains(value)) {
//                System.err.println("Your input values are invalid.");
//                System.exit(1);
//            }
//
//            vector[i] = value;
//        }
//
//        return vector;
//    }
}
