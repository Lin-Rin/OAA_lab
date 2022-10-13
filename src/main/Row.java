package src.main;

public class Row {

    private final int[] row;
    private static int staticID = 0;
    private int rowId;

    public Row(int... row){
        rowId = staticID;

        this.row = new int[row.length + 1];
        this.row[0] = rowId;

        for(int i = 0; i < row.length; i++){
            this.row[i+1] = row[i];
        }

        staticID++;
    }

    public int[] getRow() {
        return row;
    }
}
