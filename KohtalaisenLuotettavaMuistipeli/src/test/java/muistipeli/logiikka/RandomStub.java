
package muistipeli.logiikka;

import java.util.*;

public class RandomStub extends Random{
    List<Integer> ints;
    List<Double> doubles;
    
    public RandomStub(Integer ... luvut) {
        this.ints = new ArrayList<>();
        ints.addAll(Arrays.asList(luvut));
    }
    
    public RandomStub(Double ... luvut) {
        this.doubles = new ArrayList<>();
        doubles.addAll(Arrays.asList(luvut));
    }
    
    public int nextInt(int bound) {
        return ints.remove(0);
    }
    
    public double nextDouble() {
        return doubles.remove(0);
    }
    
}
