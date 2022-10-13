package src.main;

import java.util.ArrayList;

public class Table {

    private final String tableName;
    private String[] rowsName;
    private ArrayList<Row> rowArrayList = new ArrayList();

    public Table(String tableName, String... rowsName){
        this.tableName = tableName;
        this.rowsName = rowsName;
    }

    public Table createTable(){
        System.out.println(tableName + " has been created\n");
        return new Table(tableName, rowsName);
    }

    public void insert(Row row){
        System.out.println("1 row has been inserted into " + tableName);
        rowArrayList.add(row);
    }

    private String[] fromIntToString(int[] intArray){
        String[] strArray = new String[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            strArray[i] = String.valueOf(intArray[i]);
        }

        return strArray;
    }

    public void selectAll() {
        String[][] arr = new String[rowArrayList.size() + 1][rowsName.length];

        String[] new_rowsName = new String[rowsName.length + 1];
        new_rowsName[0] = "id";

        System.arraycopy(rowsName, 0, new_rowsName, 1, rowsName.length);

        arr[0] = new_rowsName;

        for (int i = 0; i < rowArrayList.size(); i++){
            arr[i + 1] = fromIntToString(rowArrayList.get(i).getRow());
        }

        printTable(arr);
    }

    private static void printTable(String[][] table) {
        // Find out what the maximum number of columns is in any row
        int maxColumns = 0;
        for (int i = 0; i < table.length; i++) {
            maxColumns = Math.max(table[i].length, maxColumns);
        }

        // Find the maximum length of a string in each column
        int[] lengths = new int[maxColumns];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                lengths[j] = Math.max(table[i][j].length(), lengths[j]);
            }
        }

        // Generate a format string for each column
        String[] formats = new String[lengths.length];
        for (int i = 0; i < lengths.length; i++) {
            formats[i] = "%1$" + lengths[i] + "s"
                    + (i + 1 == lengths.length ? "\n" : "   ");
        }

        // Print 'em out
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf(formats[j], table[i][j]);
            }
        }
    }
}
