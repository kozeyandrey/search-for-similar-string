package entity;

import org.json.simple.JSONObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Calculation {
    private final JSONObject report;
    private final HashMap<String, Double> result;

    public Calculation(JSONObject report, HashMap<String, Double> result) {
        this.report = report;
        this.result = result;
    }

    public String getName() {
        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public JSONObject getReport() {
        return report;
    }

    public HashMap<String, Double> getResult() {
        return result;
    }
}
