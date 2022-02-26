import java.util.*;
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
        Set<Integer> occurences = getMinimumOccurences(roll, 2);
        return occurences.isEmpty() ? 0 : Collections.max(occurences) * 2;
    }

    public static int twoPair(Roll roll) {
        Set<Integer> occurences = getMinimumOccurences(roll, 2);
        return occurences.size() < 2 ? 0 : occurences.stream().reduce(0, (prev, current) -> prev + (current * 2));
    }

    public static int threeOfAKind(Roll roll) {
        Set<Integer> occurences = getMinimumOccurences(roll, 3);
        return occurences.stream().findFirst().orElse(0) * 3;
    }

    public static int fourOfAKind(Roll roll) {
        Set<Integer> occurences = getMinimumOccurences(roll, 4);
        return occurences.stream().findFirst().orElse(0) * 4;
    }

    public static int fullHouse(Roll roll) {
        return getMinimumOccurences(roll,2).size() == 2 && getMinimumOccurences(roll,3).size() == 1 ?
                roll.dices.stream().reduce(0, Integer::sum) : 0;
    }

    private static Set<Integer> getMinimumOccurences(Roll roll, int occurence) {
        return roll.dices.stream().filter((dice) -> Collections.frequency(roll.dices,dice) >= occurence).collect(Collectors.toSet());
    }

    public static int smallStraight(Roll roll) {
        return (roll.dices.stream().distinct().count() < 5 ||
                roll.dices.contains(6))
                 ? 0 : 15;
    }

    public static int largeStraight(Roll roll) {
        return (roll.dices.stream().distinct().count() < 5 ||
                roll.dices.contains(1))
                ? 0 : 20;
    }

}



