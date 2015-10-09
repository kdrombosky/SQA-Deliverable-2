//Karyn Drombosky
//kmd127
//CitySim9000
//Deliverable 2


public class CitySim9000{

	 public static void main(String[] args) {
	 	//get the seed for random number generation
	 	
		int seed;
		 
		if(args.length < 1){
	 		System.out.println("Please enter a seed.");
	 		seed = 1;
	 		//System.exit(1);
	 	}
	 	else{
	 		seed = Integer.parseInt(args[0]);
	 	}

		//Add Locations to an array list for easy iteration
		map array = new map();
		array.populate();

 		//First, pick the starting location
 		Location start = array.PickStart(seed);
 		for(int i = 0; i < 5; i++){
 			//initiate the driver 
 			driver curr_driver = new driver();
			curr_driver.start = start;
			curr_driver.id = i;


 			boolean exit = false;
 			while(!exit){
 				Location next = curr_driver.PickMove(seed);
 			
 				exit = next.leave(curr_driver);
 				start = next;
 			}
 		}
 		

    } 
	 
}