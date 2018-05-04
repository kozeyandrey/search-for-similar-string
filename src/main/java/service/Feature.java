package service;

import entity.Product;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Feature {
    private final DecimalFormat decimalFormat;
    private final Product product;
    private final HashMap<Double, Integer> features;
    private Pattern featurePattern;

    public Feature(Product product) {
        this.product = product;
        this.decimalFormat = new DecimalFormat("0.#");
        this.features = new HashMap<>();
    }

    public HashMap<Double, Integer> getAll() {
        featurePattern = Pattern.compile("\\d*[.]\\d+|\\d+");

        for (String name : product.getNames()) {
            Matcher matcher = featurePattern.matcher(name);

            while (matcher.find()) {
                features.merge(Double.valueOf(matcher.group()), 1, Integer::sum);
            }
        }

        return features;
    }

    public String getFirst() {
        String result = null;

        if (features.isEmpty()) {
            features.putAll(getAll());
        }

        double feature = Collections.max(features.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

        if (feature % 1 == 0) {
            featurePattern = Pattern.compile(decimalFormat.format(feature) + "+\\D?[a-zA-Z]+");
        } else {
            featurePattern = Pattern.compile(feature + "+\\D?[a-zA-Z]+");
        }

        for (String name : product.getNames()) {
            Matcher matcher = featurePattern.matcher(name);

            if (matcher.find()) {
                result = matcher.group();
                break;
            }
        }

        return result;
    }
}
