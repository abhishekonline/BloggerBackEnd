//Author: Abhishek Shukla
package blog.main;
import java.util.ArrayList;

public class Post {
	
	private int postID;					//unique id assoiciated with post
	private int userID;					//Corresponding User associated with the post
	private String postContent;
	private String postTitle;
	private ArrayList<String> comments;
	private ArrayList<String> lables;
	private static int counter=1;
	
	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public ArrayList<String> getLables() {
		return lables;
	}

	public void setLables(ArrayList<String> lables) {
		this.lables = lables;
	}

	/*
	 * Post constructor
	 * 
	 * initialize post with Post Content,post title,and user Id 
	 * 
	 */
	public  Post(String postContent,int userID,String postTitle){
		this.postID=counter++;
		this.postContent=postContent;
		this.userID=userID;
		this.postTitle= postTitle;
		comments=null;
		lables=null;
		
	}
	/*
	 * Funtion to display contents of a post.
	 */
	public void displayPost(){
		System.out.println("*****************Post ID :: "+postID+"*******************************");
		System.out.println("Title :: "+postTitle);
		System.out.println("Content :: "+postContent);
		System.out.println("Labels :: "+lables);
		System.out.println("Comments :: "+comments);
		System.out.println("************************************************************");
	}

	
}
