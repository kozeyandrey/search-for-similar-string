package service;

import entity.Calculation;
import entity.IntermediateCalculation;
import entity.Product;
import entity.Result;
import org.json.simple.JSONObject;
import java.util.HashMap;

public class Search {
    private final JaroWinkler jaroWinkler;
    private final Feature feature;
    private final Product product;

    public Search(Product product) {
        this.jaroWinkler = new JaroWinkler();
        this.product = product;
        this.feature = new Feature(product);
    }

    public Result getResult() {
        Calculation calculation = getCalculation();

        Result result = new Result();
        result.setReport(calculation.getReport());
        result.setName(calculation.getName());

        if (!feature.getAll().isEmpty()) {
            result.setFeature(feature.getFirst());
        }

        result.setProductId(product.getId());

        return result;
    }

    private Calculation getCalculation() {
        JSONObject report = new JSONObject();
        HashMap<String, Double> intermediateResult = new HashMap<>();
        for (String s : product.getNames()) {
            intermediateResult.put(s, 0.0);
        }

        for (int i = 1; intermediateResult.size() > 2; i++) {
            IntermediateCalculation intermediateCalculation = getIntermediateCalculation(intermediateResult);
            intermediateResult = intermediateCalculation.getResult();
            report.put("Stage " + i, intermediateCalculation.getReport());

            double totalForAll = intermediateResult.values().stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
            double mediumForAll = totalForAll / intermediateResult.size();
            intermediateResult.values().removeIf(value -> value <= mediumForAll);
        }

        return new Calculation(report, intermediateResult);
    }

    private IntermediateCalculation getIntermediateCalculation(HashMap<String, Double> calculations) {
        JSONObject report = new JSONObject();
        for (String current : calculations.keySet()) {
            JSONObject intermediateReport = new JSONObject();
            double totalForWord = 0;
            int fail = 0;

            for (String next : calculations.keySet()) {
                double result = jaroWinkler.similarity(current, next);

                if (result != 1) {
                    intermediateReport.put(next, result);

                    if (fail < calculations.size() / 2) {
                        if (result > 0.65) {
                            totalForWord += result;
                        } else {
                            fail += 1;
                        }
                    } else {
                        break;
                    }
                }
            }

            report.put(current, intermediateReport);

            if (fail < calculations.size() / 2) {
                double mediumForWord = totalForWord / (calculations.size() - fail - 1);
                calculations.replace(current, mediumForWord);
            }
        }

        return new IntermediateCalculation(report, calculations);
    }
}
