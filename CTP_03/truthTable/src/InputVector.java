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

            if (allowedValues != null && !hasAllowedValue(value)) {
                System.err.println("Your input values are invalid.");
                System.exit(1);
            }

            vector[i] = value;
        }

        return vector;
    }

    private boolean hasAllowedValue(int integer) {
        int index = Arrays.binarySearch(allowedValues, integer);
        return index >= 0;
    }

    public int[] getVector() {
        return vector;
    }

    public int[] getAllowedValues() {
        return allowedValues;
    }

    public void onlyAllowValues(int[] values) {
        allowedValues = values;
        Arrays.sort(allowedValues);
    }

    public String vectorAsString() {
        return Arrays.toString(vector);
    }

    public String allowedValuesAsString() {
        return Arrays.toString(allowedValues);
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
