public class TruthTable {
    private int rowCount;
    private int columnCount;
    private int[][] inputMatrice;
    private int[] resultArray;

    public TruthTable(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
//        for (int i = 0; i < rowCount; i++) {
//
//            this.inputMatrice[i] = new InputVector(columnCount);
//        }
        this.inputMatrice = new int[rowCount][columnCount];
    }

    public void setRow(int rowIndex, String inputString) {
        InputVector inputVector = new InputVector(columnCount);
        inputMatrice[rowIndex] = inputVector.setVector(inputString);
    }
}
