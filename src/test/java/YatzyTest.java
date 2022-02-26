import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(5, Yatzy.chance(new Roll(1,1,1,1,1)));
        assertEquals(15,Yatzy.chance(new Roll(1,2,3,4,5)));
        assertEquals(16, Yatzy.chance(new Roll(3,3,4,5,1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.yatzy(new Roll(4,4,4,4,4)));
        assertEquals(50, Yatzy.yatzy(new Roll(6,6,6,6,6)));
        assertEquals(0, Yatzy.yatzy(new Roll(6,6,6,6,3)));
    }

    @Test
    public void ones() {
        assertEquals(0,Yatzy.ones(new Roll(6,2,2,4,5)));
        assertEquals(1,Yatzy.ones(new Roll(1,2,3,4,5)));
        assertEquals(2,Yatzy.ones(new Roll(1,2,1,4,5)));
        assertEquals(3,Yatzy.ones(new Roll(6,1,1,1,5)));
        assertEquals(4,Yatzy.ones(new Roll(1,2,1,1,1)));
        assertEquals(5,Yatzy.ones(new Roll(1,1,1,1,1)));
    }

    @Test
    public void twos() {
        assertEquals(0, Yatzy.twos(new Roll(1,3,4,5,6)));
        assertEquals(2, Yatzy.twos(new Roll(2,1,1,1,1)));
        assertEquals(4, Yatzy.twos(new Roll(1,2,3,2,6)));
        assertEquals(6, Yatzy.twos(new Roll(1,2,5,2,2)));
        assertEquals(8, Yatzy.twos(new Roll(2,2,6,2,2)));
        assertEquals(10, Yatzy.twos(new Roll(2,2,2,2,2)));
    }

    @Test
    public void threes() {
        assertEquals(0, Yatzy.threes(new Roll(1,1,1,1,1)));
        assertEquals(3, Yatzy.threes(new Roll(6,3,2,5,1)));
        assertEquals(6, Yatzy.threes(new Roll(1,2,3,2,3)));
        assertEquals(9, Yatzy.threes(new Roll(3,5,3,2,3)));
        assertEquals(12, Yatzy.threes(new Roll(2,3,3,3,3)));
        assertEquals(15, Yatzy.threes(new Roll(3,3,3,3,3)));
    }

    @Test
    public void fours()
    {
        assertEquals(0, Yatzy.fours(new Roll(6,5,1,2,3)));
        assertEquals(4, Yatzy.fours(new Roll(6,2,1,2,4)));
        assertEquals(8, Yatzy.fours(new Roll(4,4,5,5,5)));
        assertEquals(12, Yatzy.fours(new Roll(4,4,4,5,5)));
        assertEquals(16, Yatzy.fours(new Roll(4,1,4,4,4)));
        assertEquals(20, Yatzy.fours(new Roll(4,4,4,4,4)));
    }

    @Test
    public void fives() {
        assertEquals(0, Yatzy.fives(new Roll(4,2,3,1,6)));
        assertEquals(5, Yatzy.fives(new Roll(5,4,4,2,3)));
        assertEquals(10, Yatzy.fives(new Roll(4,5,4,1,5)));
        assertEquals(15, Yatzy.fives(new Roll(4,4,5,5,5)));
        assertEquals(20, Yatzy.fives(new Roll(4,5,5,5,5)));
        assertEquals(25, Yatzy.fives(new Roll(5,5,5,5,5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(new Roll(4,4,4,5,5)));
        assertEquals(6, Yatzy.sixes(new Roll(4,4,6,5,5)));
        assertEquals(12, Yatzy.sixes(new Roll(6,5,4,1,6)));
        assertEquals(18, Yatzy.sixes(new Roll(6,5,6,6,5)));
        assertEquals(24, Yatzy.sixes(new Roll(1,6,6,6,6)));
        assertEquals(30, Yatzy.sixes(new Roll(6,6,6,6,6)));
    }
    
    @Test
    public void onePair() {
        assertEquals(0, Yatzy.pair(new Roll(1,3,4,5,6)));
        assertEquals(8, Yatzy.pair(new Roll(3,3,3,4,4)));
        assertEquals(6, Yatzy.pair(new Roll(3,4,3,5,6)));
        assertEquals(10, Yatzy.pair(new Roll(5,3,3,3,5)));
        assertEquals(12, Yatzy.pair(new Roll(5,3,6,6,5)));
    }

    @Test
    public void twoPair() {
        assertEquals(0, Yatzy.twoPair(new Roll(1,3,4,5,6)));
        assertEquals(0, Yatzy.twoPair(new Roll(3,4,3,5,6)));
        assertEquals(14, Yatzy.twoPair(new Roll(3,3,3,4,4)));
        assertEquals(16, Yatzy.twoPair(new Roll(3,3,5,4,5)));
        assertEquals(18, Yatzy.twoPair(new Roll(3,3,6,6,6)));
    }

    @Test
    public void threeOfAKind()
    {
        assertEquals(0, Yatzy.threeOfAKind(new Roll(1,3,6,4,5)));
        assertEquals(0, Yatzy.threeOfAKind(new Roll(1,3,3,1,5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,4,5)));
        assertEquals(15, Yatzy.threeOfAKind(new Roll(5,3,5,4,5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3,3,3,3,5)));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
