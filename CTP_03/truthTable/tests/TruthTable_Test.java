import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class TruthTable_Test {
    private TruthTable truthTable;

    @Before
    public void setUp() throws Exception {
        boolean[][] inputMatrix = new boolean[][]{
            {false, false, false},
            {false, false, true},
            {false, true, false},
            {false, true, true},
            {true, false, false},
            {true, false, true},
            {true, true, false},
            {true, true, true}
        };
        boolean[] resultArray = new boolean[] { true, false, true, true, false, false, false, false };
        String[] conditionNames = new String[] { "A", "B", "C" };
        truthTable = new TruthTable(conditionNames, inputMatrix, resultArray);
    }

    @After
    public void tearDown() throws Exception {
        truthTable = null;
    }

    @Test
    public void conditionCoverageTest() {
        HashMap<Integer, ArrayList> testCases = truthTable.conditionCoverage();

        ArrayList<Integer> expectedIndices = new ArrayList<>(Arrays.asList(0,1,2,4));
        ArrayList<Integer> actualIndices =  new ArrayList<>();
        actualIndices.addAll(testCases.keySet());

        assertEquals(expectedIndices, actualIndices);
    }

    @Test
    public void minimalMultipleConditionCoverageTest() {
        HashMap<Integer, ArrayList> testCases = truthTable.minimalMultipleConditionCoverage();

        ArrayList<Integer> expectedIndices = new ArrayList<>(Arrays.asList(0,1,2,3,4,6,7));
        ArrayList<Integer> actualIndices =  new ArrayList<>();
        actualIndices.addAll(testCases.keySet());

        assertEquals(expectedIndices, actualIndices);
    }
}
