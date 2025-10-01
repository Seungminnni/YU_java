package Homework_04;

import java.util.ArrayList;
import java.util.List;

public class FareResult {
    public final int rawFare;
    public final List<String> steps = new ArrayList<>();
    public final int finalFare;

    public FareResult(int rawFare, List<String> steps, int finalFare) {
        this.rawFare = rawFare;
        if (steps != null) this.steps.addAll(steps);
        this.finalFare = finalFare;
    }
}
