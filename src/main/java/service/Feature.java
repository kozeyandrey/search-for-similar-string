package service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Feature {
    private final Pattern featurePattern = Pattern.compile("\\d+[\\.]?\\d*");

    public HashMap<Double, Integer> get(String name) {
        Matcher matcher = featurePattern.matcher(name);
        HashMap<Double, Integer> features = new HashMap<>();

        while (matcher.find()) {
            features.merge(Double.valueOf(matcher.group()), 1, Integer::sum);
        }

        return features;
    }
}
