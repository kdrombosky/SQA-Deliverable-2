import java.util.Random;

public class driver{
    	int id = 0;
    	Location start;
    	Location next;


    	public void move(){
    		start = next;
    	}
    	
        public Location PickMove(int seed){
        	//This method chooses the next stop
        	Random rand = new Random(seed);
        	int nextInt = rand.nextInt(2);
        	if(nextInt < 1){
        		Location returnMe = start.option1;
        		next = returnMe;
        		String print = returnMe.printOutput(this);
        		System.out.println(print);
        		move();
        		return returnMe;
        	}
    		Location returnMe = start.option2;
    		next = returnMe;
    		String print = returnMe.printOutput(this);
    		System.out.println(print);
        	move();
        	return returnMe;
        	
        }

}