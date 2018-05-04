package repository;

import entity.Product;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getUnchecked() throws SQLException {
        List<Product> products = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT id, names, checked FROM products WHERE checked = false"
            );

            while (rs.next()) {
                Product product = createObject(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    public List<Product> update(List<Product> products) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE products SET names = ?, checked = ? WHERE id = ?"
            );

            for (Product product : products) {
                statement.setArray(1, connection.createArrayOf("text", product.getNames()));
                statement.setBoolean(2, product.getChecked());
                statement.setInt(3, product.getId());
                statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    private Product createObject(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setNames((String[]) rs.getArray("names").getArray());
        product.setChecked(rs.getBoolean("checked"));

        return product;
    }
}
