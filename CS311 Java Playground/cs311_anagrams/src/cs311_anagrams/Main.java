package cs311_anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(new File("dict2"))) {
			AnagramBST tree = new AnagramBST();
			
			while(s.hasNext()){ //keep reading while we have words to read
				String readString = s.nextLine().trim(); //read a value, make sure there isnt any whitespace
				tree.addMember(AnagramUtils.sortString(readString), readString); //sort value to get tag, add as a member to the binary tree
			}
			
			tree.dump(); //dump all values to stdout
			//System.out.print(tree.nodeCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}
