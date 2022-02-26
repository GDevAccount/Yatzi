import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yatzy {

    public static int chance(Roll roll) {
        return roll.dices.stream().reduce(0, Integer::sum);
    }

    public static int yatzy(Roll roll) {
        return  roll.dices.stream().distinct().count() == 1 ? 50 : 0;
    }

    public static int ones(Roll roll) {
        return getOccurence(roll, 1) * 1 ;
    }

    public static int twos(Roll roll) {
        return getOccurence(roll, 2) * 2 ;
    }

    public static int threes(Roll roll) {
        return getOccurence(roll, 3) * 3 ;
    }

    public static int fours(Roll roll) {
        return getOccurence(roll, 4) * 4 ;
    }

    public static int fives(Roll roll) {
        return getOccurence(roll, 5) * 5 ;
    }

    public static int sixes(Roll roll) {
        return getOccurence(roll, 6) * 6;
    }

    private static int getOccurence(Roll roll, int value) {
        return (int) roll.dices.stream().filter((d) -> d== value).count();
    }

    public static int pair(Roll roll) {
        Map<Integer, Integer> occurences = getMinimumOccurencesMap(roll, 2);
        return occurences.isEmpty() ? 0 :Collections.max(occurences.keySet()) * 2;

    }

    public static int twoPair(Roll roll) {
        Map<Integer, Integer> occurences = getMinimumOccurencesMap(roll, 2);
        return occurences.size() < 2 ? 0 : occurences.keySet().stream().reduce(0, (prev, current) -> prev + (current * 2));
    }

    public static int threeOfAKind(Roll roll) {
        Map<Integer, Integer> occurences = getMinimumOccurencesMap(roll, 3);
        return occurences.isEmpty() ? 0 : occurences.keySet().stream().reduce(0, (prev, current) -> prev + (current * 3));
    }

    public static int fourOfAKind(Roll roll) {
        Map<Integer, Integer> occurences = getMinimumOccurencesMap(roll, 4);
        return occurences.isEmpty() ? 0 : occurences.keySet().stream().reduce(0, (prev, current) -> prev + (current * 4));
    }

    public static Map<Integer, Integer> getMinimumOccurencesMap(Roll roll, int occurence) {
        Map<Integer, Integer> result = roll.dices.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        result.values().removeIf(nbOccurence -> nbOccurence < occurence);
        return result;
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



