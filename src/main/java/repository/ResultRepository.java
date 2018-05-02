package repository;

import entity.Result;
import javax.sql.DataSource;
import java.sql.*;

public class ResultRepository {
    private final DataSource dataSource;

    public ResultRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Result create(Result result) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement;
            statement = connection.prepareStatement(
                    "INSERT INTO results (calculations, name, feature, product_id) VALUES (?::JSON, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, result.getCalculations().toJSONString());
            statement.setString(2, result.getName());
            statement.setString(3, result.getFeature());
            statement.setInt(4, result.getProductId());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                result.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
