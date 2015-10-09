import java.util.*;

public class map {
	ArrayList<Location> locations = new ArrayList<Location>();
	
	public ArrayList<Location> populate(){

		Location mall  = new Location();
		Location book  = new Location();
		Location coffee  = new Location();
		Location uni  = new Location();
		Location out  = new Location();

		//Add Mall Info
	 	mall.name = "Mall";
	 	mall.outStreet1 = "Fourth Ave.";
	 	mall.outStreet2 = "Meow St.";
	 	mall.option1 = book;
	 	mall.option2 = coffee;

	 	//Add Bookstore Info
	 	book.name = "Bookstore";
	 	book.outStreet1 = "Fourth Ave.";
	 	book.outStreet2 = "Chirp St.";
	 	book.option1 = out;
	 	book.option2 = uni;

	 	//Add Coffee Shop Info
	 	coffee.name = "Coffee Shop";
	 	coffee.outStreet1 = "Meow St.";
	 	coffee.outStreet2 = "Fifth Ave.";
	 	coffee.option1 = mall;
	 	coffee.option2 = out;

	 	//Add Info for University
	 	uni.name = "University";
	 	uni.outStreet1 = "Chirp St.";
	 	uni.outStreet2 = "Fifth Ave.";
	 	uni.option1 = book;
	 	uni.option2 = coffee;

	 	//Add Info for Outside
	 	out.name = "Outside City";
	 	out.outStreet1 = "Fifth Ave.";
	 	out.outStreet2 = "Fourth Ave";
	 	out.option1 = uni;
	 	out.option2 = mall;
	 	
	 	locations.add(mall);
	 	locations.add(book);
	 	locations.add(coffee);
	 	locations.add(uni);
	 	locations.add(out);

		return locations;
	}
	
	public Location PickStart(int seed){
    	//This method picks the starting location
    	Random rand = new Random(seed);
    	int start = rand.nextInt(5);
    	return locations.get(start);
    }

}
