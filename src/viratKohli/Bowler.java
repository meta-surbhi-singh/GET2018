package viratKohli;

/**
 * This class represents the bowler.
 *
 */
public class Bowler {
    private String name;
    private int ballsLeft;
    
    public Bowler(String name,int ballsLeft)
    {
        this.name=name;
        this.ballsLeft=ballsLeft;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBallsLeft() {
        return ballsLeft;
    }
    public void setBallsLeft(int ballsLeft) {
        this.ballsLeft = ballsLeft;
    }

}