/*
 * Group Name: "Better Call Stack"
 * Group Members: Linh Pham, Huiguang Ma, Jaya Singh and Vincent Xayasak
 * Instructor: Mirsaeid Abolghasemi
 * Date: 4/20/23
 * 
 * The counter class itself is a custom data structure representing a counter that can take a given minimum and maximum,
 * starting the value at the minimum and increasing or decreasing whenever the increase or decrease method is called,
 * and can tell when its value has rolled over the minimum or maximum. 
 */
public class Counter
{
    private int min;
    private int max;
    private int val;
    private int previousVal;

    public Counter()
    {
        this.min = 0;
        this.max = Integer.MAX_VALUE;
        this.val = 0;
        this.previousVal = this.val;
    }

    public Counter(int min, int max)
    {
        if(min >= max) {
            throw new CounterInitializationException("Minimum and Maximum cannot be the same!");
        }
        this.min = min;
        this.max = max;
        this.val = min;
        this.previousVal = this.val;
    }

    public boolean equals(Object otherObject)
    {
        if(otherObject instanceof Counter otherCounter){
            return this.val == otherCounter.val && this.min == otherCounter.min && this.max == otherCounter.max && this.previousVal == otherCounter.previousVal;
        }
        return false;
    }

    public void increase()
    {
        this.val++;
        this.previousVal = this.val;
        if(rolledOver()){
            this.val = this.min;
        }
    }

    public void decrease()
    {
        this.val--;
        this.previousVal = this.val;
        if(rolledOver()){
            this.val = this.max;
        }
    }

    public int value()
    {
        return this.val;
    }

    public boolean rolledOver()
    {
        if(this.previousVal > this.max || this.previousVal < this.min){
            return true;
        }
        return false;
    }

    public String toString()
    {
        return "Counter object with current value of "+this.val+", minimum of "+this.min+", and maximum of "+this.max+".\nRolled Over: "+rolledOver();
    }
}