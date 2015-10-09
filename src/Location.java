public class Location{
    	String name;
    	String outStreet1;
    	String outStreet2;

    	Location option1;
    	Location option2;
    	
    	public String printOutput(driver driver){
    		//This method generates the string that we print at each driver stop
    		String street = new String();
    		if(name == driver.start.option1.name){
 				street = driver.start.outStreet1;
 			}
 			else{
 				street = driver.start.outStreet2;
 			}
        	String printStr = "Driver " + driver.id + " heading from " + driver.start.name + " to " + name + " via " + street;
        	return printStr;
        	
    	}
    	
    	public boolean leave(driver drv){
    		if(name == "Outside City"){
        		String exitStr = "Driver " + drv.id + " has left the city!";
        		System.out.println(exitStr);
        		return true;
        	}
        	return false;
    	}
    	
}

