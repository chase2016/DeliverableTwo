import java.util.Random;
import java.util.Scanner;  

public class CitySim9002 {
	
	public boolean checkArgument(String[] args) {
		
		//checks for at least one seed
		if(args.length != 1) {
			return false;
		} else {
			String str = args[0];
			boolean isNum = str.matches("[0-9]+");
			if(isNum) {
				return true;
			} else {
				return false;
			}
		}				
	}
			
	public static void main(String[] args) {
		CitySim9002 sim = new CitySim9002();
		int seed = 0;
		boolean validArgument = sim.checkArgument(args);
		if(!validArgument) {
			System.out.println("Please enter one integer argument, seed");
			System.exit(0);
		} else {
			String str = args[0];
			seed = Integer.parseInt(str);
			System.out.println("Welcome to CitySim! Your seed is " + seed);	
		}
		
		Random random = new Random(seed);		
		
		for (int i = 1; i < 6; i++) {
			Visitor visitor = new Visitor();
			
			// gets the visitor
			String type = visitor.getType(random);
			System.out.println("Visitor " + i + " is a " + type + ".");
			
			// gets the location
			String location = visitor.getLocation(random);
			boolean outCity = false;			
			int count = 0;	
						
			while (!outCity) {
				location = visitor.getLocation(random);
				if (count != 0 && location == "Leaving" ) {
					outCity = true;
				} else {
					if (count == 0 && location == "Leaving") {
						do {
							location = visitor.getLocation(random);
							if (location == "Leaving") {
								outCity = true;
							} else {
								outCity = false;
							}
						}
						while (outCity);
					}					
					
					outCity = false;
					
					//output
					System.out.println("Visitor " + i + " is going to " + location + "!");
					if(visitor.likeLocation(type, location)) {
						System.out.println("Visitor " + i + " did like " + location + ".");
					} else {
						System.out.println("Visitor " + i + " did not like " + location + ".");
					}
					count++;
				}
			}
			
			System.out.println("Visitor " + i + " has left the city. ");
			System.out.println("***");
		}

	}

}

 
// The visitor class
class Visitor{	

	// the type of visitors
	public String getType(Random random) {
		String[] type = new String[4];
		type[0] = "Student";
		type[1] = "Professor";
		type[2] = "Business Person";
		type[3] = "Blogger";
		int num = random.nextInt(4);
		return type[num];		
	}
		
	// the location
	public String getLocation(Random random) {
		String[] loc = new String[5];
		loc[0] = "The Cathedral of Learning";
		loc[1] = "Squirrel Hill";
		loc[2] = "The Point";
		loc[3] = "Downtown";
		loc[4] = "Leaving";
		int num = random.nextInt(5);
		return loc[num];
	}
		
	
	public boolean likeLocation(String type, String location) {
		
		// if statement of liking
		if (type == "Student") {
			if (location == "The Cathedral of Learning") {
				return false;
			} else {
				return true;
			}
		} else if (type == "Professor") {
			return true;		
		} else if (type == "Business Person") {
			if (location == "Squirrel Hill" || location == "Downtown") {
				return true;
			} else {
				return false;
			}						
		} else {
			return false;
		}	
		
	}
	
}

 