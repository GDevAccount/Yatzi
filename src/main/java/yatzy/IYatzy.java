package yatzy;

import model.Roll;

public interface IYatzy {

    public int chance(Roll roll);

    public int yatzy(Roll roll);

    public int ones(Roll roll);

    public int twos(Roll roll);

    public int threes(Roll roll);

    public int fours(Roll roll);

    public int fives(Roll roll);

    public int sixes(Roll roll);

    public int pair(Roll roll);

    public int twoPair(Roll roll);

    public int threeOfAKind(Roll roll);

    public int fourOfAKind(Roll roll);

    public int fullHouse(Roll roll);

    public int smallStraight(Roll roll);

    public int largeStraight(Roll roll);

}
