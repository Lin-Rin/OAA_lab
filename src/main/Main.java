package src.main;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String run(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder query = new StringBuilder();
        while (scanner.hasNextLine()) {
            query.append(" ").append(scanner.nextLine());

            if (Objects.equals(query.substring(query.length() - 1), ";"))
                break;
        }

        scanner.close();
        return query.toString();
    }

    public static void main(String[] args) {
        String query = run();
        Parser parser = new Parser(query);

        Table table;
        String[] action = parser.action();

//        while() {
        if (action[0].equals("CREATE") || action[0].equals("create")) {
            table = new Table(action[1]);
            table.createTable();
            table.selectAll();

            Random random = new Random();
            for(int i = 0; i < 10; i ++){
                Row row = new Row(random.nextInt(30), random.nextInt(100), random.nextInt(200));
                table.insert(row);
            }
//            create student_info (age, avg_mark, height)

        } else {
            System.out.println("unknown");
        }
//        }



//        Table table = new Table("student_info", "age", "avg_mark", "height");
//        table.createTable();
//
//        Random random = new Random();
//        for(int i = 0; i < 10; i ++){
//            Row row = new Row(random.nextInt(30), random.nextInt(100), random.nextInt(200));
//            table.insert(row);
//        }
//
//
//        table.selectAll();
//
//        Parser parser = new Parser("CREATE         students (age, average_grade)");
//        System.out.println(Arrays.toString(parser.action()));
//
    }

}