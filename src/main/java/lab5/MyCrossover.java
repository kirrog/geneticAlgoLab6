package lab5;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    private double factor = 7.0;
    private double prob = 0.9;


    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList<double[]> children = new ArrayList<double[]>();
        double[] c1 = p1.clone();
        double[] c2 = p2.clone();

        for (int j = 0; j < p1.length; j++) {
            if (random.nextDouble() > prob) {
                c1[j] = (p1[j] + p2[j] + (((random.nextDouble() * 10.0) - 5.0) / (factor))) / (2 + (1 / factor));
            }
            if (random.nextDouble() > prob) {
                c2[j] = (p1[j] + p2[j] + (((random.nextDouble() * 10.0) - 5.0) / (factor))) / (2 + (1 / factor));
            }
        }
        children.add(c1);
        children.add(c2);
        return children;
    }
}
