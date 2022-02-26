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

    public static int fullHouse(Roll roll) {
        Map<Integer, Integer> occurences = getMinimumOccurencesMap(roll, 2);
        return (occurences.size() < 2 ||
                occurences.values().stream().mapToInt(v -> v).max().orElse(0) < 3) ?
                0 : roll.dices.stream().reduce(0, Integer::sum);
    }

    public static Map<Integer, Integer> getMinimumOccurencesMap(Roll roll, int occurence) {
        Map<Integer, Integer> result = roll.dices.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        result.values().removeIf(nbOccurence -> nbOccurence < occurence);
        return result;
    }

    public static int smallStraight(Roll roll) {
        return (roll.dices.stream().distinct().count() < 5 ||
                roll.dices.stream().mapToInt(v -> v).min().orElse(6) > 1)
                 ? 0 : 15;
    }

    public static int largeStraight(Roll roll) {
        return (roll.dices.stream().distinct().count() < 5 ||
                roll.dices.stream().mapToInt(v -> v).min().orElse(6) < 2)
                ? 0 : 20;
    }
}



