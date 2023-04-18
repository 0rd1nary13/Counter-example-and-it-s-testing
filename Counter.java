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

/*
Sample Run:
/Users/jagerforest/Library/Java/JavaVirtualMachines/openjdk-20/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=51164:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/jagerforest/IdeaProjects/_666/out/production/_666 CounterTest
TESTING the constructor
Trying min < max
 Passes
Trying min = max
 Passes
Trying min > max
 Passes
Finished constructor testing


TESTING the toString method
Displaying the counter using toString:
Counter object with current value of 1, minimum of 1, and maximum of 9.
Rolled Over: false
The counter should have the value 1
 the minimum should be 1, the maximum should be 9
 it should not have rolled over
Finished toString testing


TESTING the equals method
trying two counters that should be in the same state
 passes
trying two counters that should be in a different state
 passes
trying two counters that should be in a different state
 passes
Finished equals testing


TESTING the increase method
Increasing counter 1 once
 passes
 passes
Increasing counter 1 again
 passes
 passes
Increasing counter 1 a third time
 passes
 passes
Increasing counter 2 until it rolls over
 passes
 passes
Increasing counter 3 until it rolls over
 passes
 passes
Finished increase testing


TESTING the decrase method
Decreasing the counter once
 passes
 passes
Decreasing the counter again
 passes
 passes
Decreasing the counter a third time
 passes
 passes
Decrease counter 2 twice, then decrease counter 2 until it rolls over again
 passes
 passes
Decrease counter 3 twice, then decrease counter 3 until it rolls over again
 passes
 passes
Finished decrease testing


TESTING combinations of the increase and decrease methods
Increasing counter 2 once
 passes
Decreasing counter 2 once
 passes
Decreasing then increasing counter 3
 passes
Finished combined testing

Process finished with exit code 0

*/
