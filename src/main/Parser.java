package src.main;

public class Parser {

    private final String sqlQuery;
    private final String action;
    private String nameOfColum[];

    private static final String create   = "CREATE";
    private static final String delete   = "DELETE";
    private static final String insert   = "INSERT";
    private static final String into     = "INTO";
    private static final String select   = "SELECT";
    private static final String from     = "FROM";
    private static final String where    = "WHERE";
    private static final String group_by = "GROUP_BY";

    public Parser(String sqlQuery){
        this.sqlQuery = sqlQuery;
        action = "";

    }

    public String[] action(){
        String _sqlQuery = sqlQuery.replaceAll("[,();]"," ");

        return _sqlQuery.replaceAll("\\s+"," ").split(" ");
    }


}
