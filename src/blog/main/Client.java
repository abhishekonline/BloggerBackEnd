//Author: Abhishek Shukla
package blog.main;
import java.util.ArrayList;


public class Client {
	/*
	 * Client can Retrive a post(s) by metioning label and user
	 * Client can retrive comments associated with a post. By giving the post object
	 */
	
	/*
	 * Funtion to retrive post 
	 * Parameters: String - label, object(User) -user
	 * 
	 * return : ArrayList<Post> - Post objects
	 */
	public ArrayList<Post> retrivePost(String label, User user) {
		ArrayList<Post> answer=user.getLabelPostMap().get(label);
		if(answer==null)
		{
			System.out.println("label : "+label+" does not exits");
			ArrayList<Post> ans= new ArrayList<Post>();
			return ans;
		}
		else return answer;
	}
	
	/*
	 * Function to fetch comments for a post 
	 * 
	 * Parameter: Object(Post)
	 * 
	 * return: ArrayList<String> - Comments
	 */
	public ArrayList<String> getComments(Post post){
		ArrayList<String> answer=post.getComments();
		if(answer==null){
			System.out.println(" Post with title "+ post.getPostTitle() +" has no comments");
			ArrayList<String> empty= new ArrayList<String>();
			return empty;
		}
		else return answer;
		
	}
	
}
