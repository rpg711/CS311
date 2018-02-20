package cs311_anagrams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AnagramBST {	
	private AnagramClassNode root; //root will contain empty tag as sentinel
	
	public AnagramBST()
	{
		this.root = new AnagramClassNode("");
	}
	
	public void addMember(String tag, String member){
		AnagramClassNodeData foundNode = this.searchNode(tag); //search for the anagram class
		if(foundNode == null)
			addNode(new AnagramClassNode(tag,member)); //member is a new anagram, create new class
		else
			foundNode.addMember(member); //class already existing, add the anagram to the class
	}
	
	private void addNode(AnagramClassNode n){
		addNode(n, this.root);
	}
	
	/***
	 * Adds a node to the given tree, left-justifies equal values in general, but an equal value
	 * implies a matching anagram, and so there will not exist equal tag values
	 * @param n
	 * @param tree
	 */
	private void addNode(AnagramClassNode n, AnagramClassNode tree){
		if(n.compareTo(tree) <= 0){ 
			if(tree.hasLeftChild())
				addNode(n, tree.getLeftChild());
			else 
				tree.setLeftChild(n);
		}
		else{
			if(tree.hasRightChild())
				addNode(n, tree.getRightChild());
			else
				tree.setRightChild(n);
		}
	}
	
	/***
	 * Searches tree for tag
	 * @param tag
	 * @return found node for tag, null if not found
	 */
	public AnagramClassNodeData searchNode(String tag) {
		return this.searchNode(tag, root);
	}
	
	/***
	 * Searches tree for node
	 * @param tag
	 * @param tree
	 * @return found node, or null if not found
	 */
	private AnagramClassNodeData searchNode(String tag, AnagramClassNode tree) {
		if(tree == null)
			return null;
		else if(tag.compareTo(tree.getData().getTag()) == 0)
			return tree.getData();
		else if(tag.compareTo(tree.getData().getTag()) < 0)
			return searchNode(tag, tree.getLeftChild());
		else 
			return searchNode(tag, tree.getRightChild());
	}
	
	/***
	 * Dumps entire tree to std out, skipping the root as it is a sentinel
	 */
	public void dump(){
		p_inOrderPrint(root.getLeftChild());
		p_inOrderPrint(root.getRightChild());
	}
	
	//public int nodeCount = 0;
	
	private void p_inOrderPrint(AnagramClassNode root){
		if ( root != null ) {  
			p_inOrderPrint(root.getLeftChild());
			System.out.print(root.toString()); 
			//nodeCount ++; //count node if it is a valid node when we visit it
			p_inOrderPrint(root.getRightChild()); 
		}
	}
}
