package service;

import entity.Product;
import entity.Result;
import org.json.simple.JSONObject;

public class Search {
    private final JaroWinkler similarity;
    private final Feature feature;
    private final Product product;
    private String resultName;

    public Search(Product product) {
        this.similarity = new JaroWinkler();
        this.product = product;
        this.feature = new Feature(product);
    }

    public Result getResult() {
        Result result = new Result();
        result.setReport(getReport());
        result.setName(resultName);

        if (!feature.getAll().isEmpty()) {
            result.setFeature(feature.getFirst());
        }

        result.setProductId(product.getId());

        return result;
    }

    private JSONObject getReport() {
        JSONObject report = new JSONObject();
        double max = 0;

        for (int i = 0; i < product.getNames().length; i++) {
            String current = product.getNames()[i];

            for (int n = i + 1; n < product.getNames().length; n++) {
                String next = product.getNames()[n];
                double calculation = similarity.similarity(current, next);

                if (calculation != 1 && calculation > max) {
                    max = calculation;
                    resultName = current;
                }

                report.put(current, calculation);
            }
        }

        return report;
    }
}
