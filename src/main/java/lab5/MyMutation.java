package lab5;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    private double factor = 4.0;
    private double entityProbability = 0.5;
    private double fieldProbability = 0.5;

    public List<double[]> apply(List<double[]> population, Random random) {
        for (int i = 0; i < population.size(); i++) {
            if (random.nextDouble() > entityProbability) {
                double[] entity = population.get(i);
                for (int j = 0; j < entity.length; j++) {
                    if (random.nextDouble() > fieldProbability) {
                        entity[j] = (entity[j] + (((random.nextDouble() * 10.0) - 5.0) / (factor))) / (1 + (1 / factor));
                    }
                }
            }
        }
        return population;
    }
}
