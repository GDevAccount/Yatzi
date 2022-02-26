import java.util.ArrayList;
import java.util.List;

public class Roll {
    public List<Integer> dices;

    public Roll(int a,int b, int c, int d, int e) {
        dices = new ArrayList<>();
        dices.add(a);
        dices.add(b);
        dices.add(c);
        dices.add(d);
        dices.add(e);
    }

}
