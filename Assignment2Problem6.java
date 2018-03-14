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
			if(temp == 0 && !zeroSet) {
				zeroSet = true;
			}
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
			dupe = false;
		}
		Arrays.sort(set);
		return set;
	}
	
	public static void union(int[] set1, int[] set2) {
		String unionstring = "{";
		int size = 0, count = 0;
		
		if(Arrays.equals(set1,set2) ) {									//if sets are equal, then union set is just a copy of either set

			for (int i = 0; i < set1.length; i++) {
				if (i == set1.length - 1) {
					unionstring += Integer.toString(set1[i]);
				}
				else {
					unionstring += Integer.toString(set1[i]) + ",";
				}
				
			}
			unionstring += "}";
			
		}
		
		for(int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				size++;
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
		
		size = (set1.length + set2.length - intersectSet.length );
//		int [] unionSet = new int [size];
		
		
		
	
//		for(int i = 0; i < unionSet.length; i++) {
//			if(set1[set1.length - 1] < intersectSet[0]) {
//				while(set1[count] < intersectSet[0]) {
//					unionSet[i] = set1[count];
//					count++;
//				}
//				count = 0;
//				while(intersectSet[count] < set2[0]) {
//					
//				}
//			}
//			
//		}
		
		
		
		
		
		
		
		
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
				intersectString += Integer.toString(intersectSet[i]);
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
				complementString += Integer.toString(complementSet[i]);
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
		System.out.println(intersectSet.length);
		
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
				if (intersectSet[i] == intersectSet[intersectSet.length-1]&& set1[j] == set1[set1.length - 1]) {
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
