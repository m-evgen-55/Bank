//package ru.bank;
//
//
//import java.sql.*;
//import java.util.Random;
//
//public class App {
//
//    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
//
//        Connection connection;
//
//        String url = "jdbc:postgresql://127.0.0.1:5432";
//        String user = "postgres";
//        String password = "";
//
//        Class.forName("org.postgresql.Driver");
//        connection = DriverManager.getConnection(url, user, password);
//        connection.setAutoCommit(false);
//
//
//        Statement st = connection.createStatement();
//
//        ResultSet rest = st.executeQuery("select \"Id\" from public.\"Accounts\"");
//
//        // вывод данныз
////        int c = 0;
////        while (rest.next()) {
////            String data = rest.getString("Id");
////            System.out.println(++c + "\t|" + data);
////        }
//
//        // если нужно вывести вторую колонку
////        rest.next();
////        String data = rest.getString("STATUS");
////        System.out.println(data);
//
//        st.close();
//        connection.close();
//
//
//        //////////////////////////////////////////////////////////////////////////////////
//        Clients client1 = new Clients("Ivanov", "Ivan", "11.08.1990", 29);
//        // сгенерировать Id
//        int id = (int) (Math.random() * 10000);
//        String lastName = client1.getLastName();
//        String firstName = client1.getFirstName();
//        String birthDay = client1.getBirthDate();
//        String query = "INSERT INTO Clients(LastName, Id, FirstName, BirthDay, AccountId) " +
//                "VALUES (lastName, id, firstName, birthDay, null);
//
//
//
//
//
//
//
//    }
//
//}
