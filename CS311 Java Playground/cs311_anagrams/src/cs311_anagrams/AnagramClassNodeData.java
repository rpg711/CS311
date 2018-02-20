package cs311_anagrams;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/***
 * Data object representing an anagram class with a unique tag identifier and a list of members(anagrams)
 * @author rpg711
 *
 */
public class AnagramClassNodeData implements Comparable<AnagramClassNodeData>{
	//tag is an ABSOLUTE representation
	private String tag; //sorted string representing the exact lexicographically ordered anagram string, may/not be a member
	private List<String> members;
	
	
	public AnagramClassNodeData(String tag){
		this.tag = tag;
		this.members = new LinkedList<String>();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<String> iter = this.members.iterator();
		
		while(iter.hasNext()){
			sb.append(iter.next());
			if(iter.hasNext())
				sb.append(" ");
		}
		sb.append('\n');
		return sb.toString();
	}
	
	@Override
	public int compareTo(AnagramClassNodeData o) {
		// TODO Auto-generated method stub
		return this.getTag().compareTo(o.getTag());
	} 
	
	public List<String> getMembers(){
		return this.members;
	}
	
	public String getTag(){
		return this.tag;
	}
	
	public void addMember(String member){
		this.members.add(member);
	}
}
