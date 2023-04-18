/*
 *   The counter class implements a counter object that can take a given minimum and maximum,
 *   starting the value at the minimum and increasing or decreasing whenever increase or decrease method is called,
 *   and can tell when its value has rolled over the minimum or maximum.
 *   Group Name: "Better Call Stack"
 *   Group Members:  Linh Pham, Huiguang Ma, Jaya Singh and Vincent Xayasak.
 */
public class Counter
{
    private int min;
    private int max;
    private int val;

    public Counter()
    {
        this.min = 0;
        this.max = Integer.MAX_VALUE;
        this.val = 0;
    }

    public Counter(int min, int max)
    {
        if(min == max) {
            throw new CounterInitializationException("Minimum and Maximum cannot be the same!");
        }
        this.min = min;
        this.max = max;
        this.val = min;
    }

    public boolean equals(Object otherObject)
    {
        if(otherObject instanceof Counter otherCounter){
            return this.val == otherCounter.val && this.min == otherCounter.min && this.max == otherCounter.max;
        }
        return false;
    }

    public void increase()
    {
        this.val++;
    }

    public void decrease()
    {
        this.val--;
    }

    public int value()
    {
        return this.val;
    }

    public boolean rolledOver()
    {
        return this.val == this.max || this.val == this.min;
    }

    public String toString()
    {
        return "A Counter object that keeps track of the amount of clicks as values, incrementing or decrementing.";
    }
}