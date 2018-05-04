package repository;

import entity.Result;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ResultRepository {
    private final DataSource dataSource;

    public ResultRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Result> create(List<Result> results) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO results (report, name, feature, product_id) VALUES (?::JSON, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            for (Result result : results) {
                statement.setString(1, result.getReport().toJSONString());
                statement.setString(2, result.getName());
                statement.setString(3, result.getFeature());
                statement.setInt(4, result.getProductId());

                statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);

            ResultSet rs = statement.getGeneratedKeys();
            for (Result result : results) {
                if (rs.next()) {
                    result.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return results;
    }
}
