package clothes.data;

import clothes.business.Product;
import java.sql.*;
import java.util.*;

public class ProductDB {

    //This method returns null if a product isn't found.
    public static Product selectProduct(String productCode) throws ClassNotFoundException {
        // load the driver

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductCode = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // get a connection
            String dbURL = "jdbc:mysql://localhost:3307/earn";
            String username = "root";
            String password = "Password666";

            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("ProductID"));
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    //This method returns null if a product isn't found.
    public static Product selectProduct(long productID) throws ClassNotFoundException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductID = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // get a connection
            String dbURL = "jdbc:mysql://localhost:3307/MySQL";
            String username = "root";
            String password = "Password666";

            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            ps = connection.prepareStatement(query);
            ps.setLong(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("ProductID"));
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    //This method returns null if a product isn't found.
    public static List<Product> selectProducts() throws ClassNotFoundException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // get a connection
            String dbURL = "jdbc:mysql://localhost:3307/earn";
            String username = "root";
            String password = "Password666";

            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }
}
