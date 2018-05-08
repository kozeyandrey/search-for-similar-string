import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import entity.Product;
import entity.Result;
import org.flywaydb.core.Flyway;
import repository.ProductRepository;
import repository.ResultRepository;
import service.Search;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Flyway flyway = new Flyway();
        HikariConfig cfg = new HikariConfig("./src/main/resources/db.properties");
        HikariDataSource dataSource = new HikariDataSource(cfg);

        flyway.setDataSource(dataSource);
        flyway.migrate();

        ProductRepository productRepository = new ProductRepository(dataSource);
        ResultRepository resultRepository = new ResultRepository(dataSource);

        List<Product> products = productRepository.getUnchecked();
        List<Result> results = new ArrayList<>();
        for (Product product : products) {
            Search search = new Search(product);
            results.add(search.getResult());
            product.setChecked(true);
        }

        resultRepository.create(results);
        productRepository.update(products);
    }
}
