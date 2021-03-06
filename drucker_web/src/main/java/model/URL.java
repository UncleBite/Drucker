package model;
import java.sql.*;
import java.util.ArrayList;

public class URL {
    public URL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getUrl(String type) {
        ArrayList<String> url_set = new ArrayList<String>();

        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","myblog","123456");
            System.out.println("Success connect Mysql server!");
            Statement stmt = connect.createStatement();
            String sql_command = "select * from url_resources where type=" + "'" + type + "'";
            ResultSet rs = stmt.executeQuery(sql_command);
            while (rs.next()) {
                String url = rs.getString("url");
                url_set.add(url);
            }
        } catch (SQLException e) {
            System.out.println("mysql exception");
        }

        return url_set;
    }

    public ArrayList<ArrayList<String>> getUrlTitle(String type) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>> ();
        ArrayList<String> url_set = new ArrayList<String>();
        ArrayList<String> url_title = new ArrayList<String>();

        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","myblog","123456");
            System.out.println("Success connect Mysql server!");
            Statement stmt = connect.createStatement();
            String sql_command = "select * from url_resources where type=" + "'" + type + "'";
            ResultSet rs = stmt.executeQuery(sql_command);
            while (rs.next()) {
                String url = rs.getString("url");
                url_set.add(url);
                String title = rs.getString("title");
                url_title.add(title);
            }
        } catch (SQLException e) {
            System.out.println("mysql exception");
        }
        result.add(url_set);
        result.add(url_title);
        return result;
    }

    public ArrayList<Link> getLinks() {
        ArrayList<Link> result = new ArrayList<> ();
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","myblog","123456");
            System.out.println("Success connect Mysql server!");
            Statement stmt = connect.createStatement();
            String sql_command = "select * from url_resources";
            ResultSet rs = stmt.executeQuery(sql_command);
            while (rs.next()) {
                String url = rs.getString("url");
                String title = rs.getString("title");
                String type = rs.getString("type");
                result.add(new Link(title, url, type));
            }
        } catch (SQLException e) {
            System.out.println("mysql exception");
        }
        return result;
    }

}
