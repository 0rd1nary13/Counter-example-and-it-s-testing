public class CounterTest {
    public static void main(String[] args){
        //Value testing
        Counter counter1 = new Counter(0,10);
        System.out.println(counter1);
        for(int i = 0; i < 20; i++){
            counter1.increase();
            System.out.println(counter1.value());
            if(counter1.rolledOver()){
                System.out.println("Rolled Over");
            }
        }
        System.out.println();

        //Equals testing
        Counter counter2 = new Counter(5,7);
        Counter counter3 = new Counter(5,7);
        System.out.println(counter2.equals(counter3));
        System.out.println();

        //Exception testing
        Counter counter4 = new Counter(10,10);
        System.out.println(counter4);
    }
}