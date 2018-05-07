package entity;

import org.json.simple.JSONObject;
import java.util.HashMap;

public class IntermediateCalculation {
    private final JSONObject report;
    private final HashMap<String, Double> result;

    public IntermediateCalculation(JSONObject report, HashMap<String, Double> result) {
        this.report = report;
        this.result = result;
    }

    public JSONObject getReport() {
        return report;
    }

    public HashMap<String, Double> getResult() {
        return result;
    }
}
