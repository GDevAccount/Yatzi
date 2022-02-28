import model.Roll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yatzy.IYatzy;
import yatzy.Yatzy;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyTest {

    private IYatzy yatzy;

    @BeforeEach
    public void initEach(){
       yatzy = new Yatzy();
    }

    @Test
    public void chance() {
        assertEquals(5, yatzy.chance(new Roll(1,1,1,1,1)));
        assertEquals(15,yatzy.chance(new Roll(1,2,3,4,5)));
        assertEquals(16, yatzy.chance(new Roll(3,3,4,5,1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, yatzy.yatzy(new Roll(4,4,4,4,4)));
        assertEquals(50, yatzy.yatzy(new Roll(6,6,6,6,6)));
        assertEquals(0, yatzy.yatzy(new Roll(6,6,6,6,3)));
    }

    @Test
    public void ones() {
        assertEquals(0,yatzy.ones(new Roll(6,2,2,4,5)));
        assertEquals(1,yatzy.ones(new Roll(1,2,3,4,5)));
        assertEquals(2,yatzy.ones(new Roll(1,2,1,4,5)));
        assertEquals(3,yatzy.ones(new Roll(6,1,1,1,5)));
        assertEquals(4,yatzy.ones(new Roll(1,2,1,1,1)));
        assertEquals(5,yatzy.ones(new Roll(1,1,1,1,1)));
    }

    @Test
    public void twos() {
        assertEquals(0, yatzy.twos(new Roll(1,3,4,5,6)));
        assertEquals(2, yatzy.twos(new Roll(2,1,1,1,1)));
        assertEquals(4, yatzy.twos(new Roll(1,2,3,2,6)));
        assertEquals(6, yatzy.twos(new Roll(1,2,5,2,2)));
        assertEquals(8, yatzy.twos(new Roll(2,2,6,2,2)));
        assertEquals(10, yatzy.twos(new Roll(2,2,2,2,2)));
    }

    @Test
    public void threes() {
        assertEquals(0, yatzy.threes(new Roll(1,1,1,1,1)));
        assertEquals(3, yatzy.threes(new Roll(6,3,2,5,1)));
        assertEquals(6, yatzy.threes(new Roll(1,2,3,2,3)));
        assertEquals(9, yatzy.threes(new Roll(3,5,3,2,3)));
        assertEquals(12, yatzy.threes(new Roll(2,3,3,3,3)));
        assertEquals(15, yatzy.threes(new Roll(3,3,3,3,3)));
    }

    @Test
    public void fours()
    {
        assertEquals(0, yatzy.fours(new Roll(6,5,1,2,3)));
        assertEquals(4, yatzy.fours(new Roll(6,2,1,2,4)));
        assertEquals(8, yatzy.fours(new Roll(4,4,5,5,5)));
        assertEquals(12, yatzy.fours(new Roll(4,4,4,5,5)));
        assertEquals(16, yatzy.fours(new Roll(4,1,4,4,4)));
        assertEquals(20, yatzy.fours(new Roll(4,4,4,4,4)));
    }

    @Test
    public void fives() {
        assertEquals(0, yatzy.fives(new Roll(4,2,3,1,6)));
        assertEquals(5, yatzy.fives(new Roll(5,4,4,2,3)));
        assertEquals(10, yatzy.fives(new Roll(4,5,4,1,5)));
        assertEquals(15, yatzy.fives(new Roll(4,4,5,5,5)));
        assertEquals(20, yatzy.fives(new Roll(4,5,5,5,5)));
        assertEquals(25, yatzy.fives(new Roll(5,5,5,5,5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, yatzy.sixes(new Roll(4,4,4,5,5)));
        assertEquals(6, yatzy.sixes(new Roll(4,4,6,5,5)));
        assertEquals(12, yatzy.sixes(new Roll(6,5,4,1,6)));
        assertEquals(18, yatzy.sixes(new Roll(6,5,6,6,5)));
        assertEquals(24, yatzy.sixes(new Roll(1,6,6,6,6)));
        assertEquals(30, yatzy.sixes(new Roll(6,6,6,6,6)));
    }
    
    @Test
    public void onePair() {
        assertEquals(0, yatzy.pair(new Roll(1,3,4,5,6)));
        assertEquals(8, yatzy.pair(new Roll(3,3,3,4,4)));
        assertEquals(6, yatzy.pair(new Roll(3,4,3,5,6)));
        assertEquals(10, yatzy.pair(new Roll(5,3,3,3,5)));
        assertEquals(12, yatzy.pair(new Roll(5,3,6,6,5)));
    }

    @Test
    public void twoPair() {
        assertEquals(0, yatzy.twoPair(new Roll(1,3,4,5,6)));
        assertEquals(0, yatzy.twoPair(new Roll(3,4,3,5,6)));
        assertEquals(14, yatzy.twoPair(new Roll(3,3,3,4,4)));
        assertEquals(16, yatzy.twoPair(new Roll(3,3,5,4,5)));
        assertEquals(18, yatzy.twoPair(new Roll(3,3,6,6,6)));
    }

    @Test
    public void threeOfAKind()
    {
        assertEquals(0, yatzy.threeOfAKind(new Roll(1,3,6,4,5)));
        assertEquals(0, yatzy.threeOfAKind(new Roll(1,3,3,1,5)));
        assertEquals(9, yatzy.threeOfAKind(new Roll(3,3,3,4,5)));
        assertEquals(15, yatzy.threeOfAKind(new Roll(5,3,5,4,5)));
        assertEquals(9, yatzy.threeOfAKind(new Roll(3,3,3,3,5)));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(0, yatzy.fourOfAKind(new Roll(1,3,6,4,5)));
        assertEquals(0, yatzy.fourOfAKind(new Roll(1,3,3,1,5)));
        assertEquals(0, yatzy.fourOfAKind(new Roll(3,3,3,4,5)));
        assertEquals(12, yatzy.fourOfAKind(new Roll(3,3,3,3,5)));
        assertEquals(20, yatzy.fourOfAKind(new Roll(5,5,5,4,5)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, yatzy.smallStraight(new Roll(1,2,3,4,5)));
        assertEquals(15, yatzy.smallStraight(new Roll(2,3,4,5,1)));
        assertEquals(0, yatzy.smallStraight(new Roll(1,2,2,4,5)));
        assertEquals(0, yatzy.smallStraight(new Roll(3,2,6,4,5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, yatzy.largeStraight(new Roll(6,2,3,4,5)));
        assertEquals(20, yatzy.largeStraight(new Roll(2,3,4,5,6)));
        assertEquals(0, yatzy.largeStraight(new Roll(1,2,2,4,5)));
        assertEquals(0, yatzy.largeStraight(new Roll(3,1,2,4,5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, yatzy.fullHouse(new Roll(6,2,2,2,6)));
        assertEquals(0, yatzy.fullHouse(new Roll(2,3,4,5,6)));
        assertEquals(0, yatzy.fullHouse(new Roll(2,2,4,5,5)));
        assertEquals(0, yatzy.fullHouse(new Roll(2,2,4,5,6)));
        assertEquals(0, yatzy.fullHouse(new Roll(2,2,2,5,6)));
    }
}
