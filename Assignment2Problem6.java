import java.util.Arrays;
import java.util.Scanner;

public class Assignment2Problem6 {

	public static void main(String[] args) {
		System.out.println("You will now build set #1.");
		int [] set1 = getSet();
		System.out.println("You will now build set #2.");
		int [] set2 = getSet();
		
		union(set1,set2);
		intersect(set1, set2);
		set2Complement(set2);
		cartesianProduct(set1, set2);
		
	}
	
	public static int [] getSet () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size of this set: ");
		int size = sc.nextInt();
		int set [] = new int [size];
		int count = 0;
		int temp = 0;
		boolean dupe = false;
		boolean zeroSet = false;

		
		while (count != set.length) {
			System.out.println("Please enter index " + count + " of your set: ");
			temp = sc.nextInt();
			if(temp == 0 && !zeroSet) {														//arrays are initialized to zero by default, so adding 0 is an auto duplicate
				zeroSet = true;																//setting a flag for the first zero set allows the user to add a zero
			}																				//without the false positive due to array initialization
			else {
				for(int i = 0; i <set.length; i++) {
					if (set[i] == temp) {
						System.out.println("Duplicate entered, please enter a non-duplicate item.");
						dupe = true;
						break;
					}
				}
			}
			if(!dupe) {
				set[count] = temp;
				count++;
			}
			dupe = false; //reset dupe flag for next iteration
		}
		Arrays.sort(set);	//sorted arrays behave more like sets, so they're easier to work with
		return set;
	}
	
	public static void union(int[] set1, int[] set2) {
		String unionstring = "{";
		int size = 0, count = 0;
		
		if(Arrays.equals(set1,set2) ) {									//if sets are equal, then union set is just a copy of either set

			for (int i = 0; i < set1.length; i++) {
				if (i == set1.length - 1) {
					unionstring += Integer.toString(set1[i]); //for the sake of clean output
				}
				else {
					unionstring += Integer.toString(set1[i]) + ","; 
				}
				
			}
			unionstring += "}";
			
		}
		else {
		
			for(int i = 0; i < set1.length; i++) {
				for (int j = 0; j < set2.length; j++) {
					if(set1[i] == set2[j]) {
						size++;
					}
				}
			}
			int [] intersectSet = new int[size];							//create intersectSet array based off how many common elements you find
			
			for(int i = 0; i < set1.length; i++) {						//go back and check what elements are the ones they have in common, add to intersectSet
				for (int j = 0; j < set2.length; j++) {
					if(set1[i] == set2[j]) {
						intersectSet[count] = set1[i];
						count++;
					}
				}
			}
																		//we have to make a set for the union, so we calculate the size by taking the difference between 
			size = set1.length + set2.length - intersectSet.length;		//the total length of set1 + set2 and the intersect length
			int [] unionSet = new int[size];
			
			int i = 0, j = 0;											//we have to iterate through both set1 and set2, then set a count = 0 to keep an index of unionSet
			count = 0;
			
		
			while(i < set1.length && j < set2.length) {					//let's compare sets first for intersects
				if(set1[i] < set2[j]) {									//we have two different indicies, i and j for set 1 and set 2 respectively
					unionSet[count] = set1[i];							//if the i value of set1 is still less than the j value of set2, lets let set1[i]
					count++;											//be the next value to push into unionSet. Now we increment i and count so next
					i++;												//iteration of this loop, we check the next index of set1 and the next append onto
				}														//unionSet is done on the next index
				else if (set2[j] < set1[i]) {							//-- this is the same logic as the above, but we find that set 2 is less than set 1
					unionSet[count] = set2[j];
					count++;
					j++;
				}
				else {
					unionSet[count] = set2[j];							//if neither is less than, they're equal. Let's choose a value from one set, then 
					count++;											//add that to unionSet and increment both indicies
					i++;
					j++;
				}
			}
			
			while (i < set1.length) {									//if you reach this point, that means either one of set 1 or set 2 is out of bounds
				unionSet[count] = set1[i];								//these 2 while loops continue appending to unionSet until the last values are accounted for
				count++;
				i++;
			}
			while(j < set2.length) {
				unionSet[count] = set2[j];
				count++;
				j++;
			}
			
			for  (i = 0; i < unionSet.length; i++) {
				if (i == unionSet.length - 1) {
					unionstring += Integer.toString(unionSet[i]); //for the sake of clean output
				}
				else {
					unionstring += Integer.toString(unionSet[i]) + ",";
				}
				
			}
			unionstring += "}";
		}
		

		System.out.println("The union of sets 1 and 2 is " + unionstring);
	}
	
	public static void intersect(int[] set1, int[] set2) {
		int size = 0, count = 0;
		String intersectString = "{";
		
		for(int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				if(set1[i] == set2[j]) {
					size++;
				}
			}
		}
																
		int [] intersectSet = new int[size];							//create intersectSet array based off how many common elements you find
		
		for(int i = 0; i < set1.length; i++) {						//go back and check what elements are the ones they have in common, add to intersectSet
			for (int j = 0; j < set2.length; j++) {
				if(set1[i] == set2[j]) {
					intersectSet[count] = set1[i];
					count++;
				}
			}
		}
		
		for (int i = 0; i < intersectSet.length; i++) {
			if (i == intersectSet.length - 1) {
				intersectString += Integer.toString(intersectSet[i]);//for the sake of clean output
			}
			else {
				intersectString += Integer.toString(intersectSet[i]) + ",";
			}
			
		}
		intersectString += "}";
		
		System.out.println("The intersection of sets 1 and 2 is " + intersectString);
	}
	
	public static void set2Complement(int set[]) {
		String complementString = "{";
		int [] uSet = {0,1,2,3,4,5,6,7,8,9};
		int size = uSet.length - set.length;
		int [] complementSet = new int [size];
		int index = 0;
		boolean intersected = false;
		
		for(int i = 0; i < uSet.length; i++) {
			for (int j = 0; j < set.length; j++) {
				if(uSet[i] == set[j]) {
					intersected = true;
					break;
				}
			}
			if(!intersected) {
				complementSet[index] = uSet[i];
				index++;
			}
			intersected = false;
		}
		
		for (int i = 0; i < complementSet.length; i++) {
			if (i == complementSet.length - 1) {
				complementString += Integer.toString(complementSet[i]); //for the sake of clean output
			}
			else {
				complementString += Integer.toString(complementSet[i]) + ",";
			}
			
		}
		complementString += "}";
		System.out.println("The complement of set 2 is " + complementString);
		
	}
	
	public static void cartesianProduct(int [] set1, int [] set2) {
		String productString = "{";
		int size = 0, count = 0;
		
		for(int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				if(set1[i] == set2[j]) {
					size++;
				}
			}
		}
		int [] intersectSet = new int[size];							//create intersectSet array based off how many common elements you find
		
		for(int i = 0; i < set1.length; i++) {						//go back and check what elements are the ones they have in common, add to intersectSet
			for (int j = 0; j < set2.length; j++) {
				if(set1[i] == set2[j]) {
					intersectSet[count] = set1[i];
					count++;
				}
			}
		}
		
		for(int i = 0; i < intersectSet.length; i++) {
			for(int j = 0; j < set1.length; j++) {
				if (intersectSet[i] == intersectSet[intersectSet.length-1]&& set1[j] == set1[set1.length - 1]) { //for the sake of clean output
					productString += ("(" + intersectSet[i] + ", " + set1[j] + ")");
				}
				else {
					productString += ("(" + intersectSet[i] + "," + set1[j] + "), "  );
				}
			}
		}
		productString += "}";
		System.out.println("The cartesian product of intersect set 1/set2 and set 1 is " + productString);
	}
		
}
