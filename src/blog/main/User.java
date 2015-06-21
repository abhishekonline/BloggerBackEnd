package blog.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
	/* USER has following functions
	 *  user  add post 
	 *  user  retrieve post
	 *	user  add comment to post
	 *	user  add label to post
	 */
	private final int userID;
	private String username;
	private static int counter = 1;

	private HashMap<Integer, Post> postIdMap = new HashMap<Integer, Post>(); // mapping post id with post
	private HashMap<String, ArrayList<Post>> labelPostMap = new HashMap<String, ArrayList<Post>>();// mapping label to posts
	//Constructor: user is initialised with and "username"
	
	public User(String username) {
		if(username.length()==0)
		{
			System.out.println("User name can not be blank,Please enter name in console");
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = null;
			try {
				input = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			username=input;
			
			
		}
		this.username = username;
		this.userID = counter++;
		System.out.println(username + " created with user ID= " + this.userID);
	}
	
	//getter & setter for hashmap labelPostMap
	
	public HashMap<String, ArrayList<Post>> getLabelPostMap() {
		return labelPostMap;
	}

	public void setLabelPostMap(HashMap<String, ArrayList<Post>> labelPostMap) {
		this.labelPostMap = labelPostMap;
	}

	/*
	 * User create post with post content and post title
	 * 
	 * parameter: string -title, string -post content
	 * 
	 * return : integer -post unique id
	 */

	public int CreatePost(String postContent, String postTitle) {
		Post post = new Post(postContent, this.userID, postTitle);
		System.out.println(this.username + " created post with post id= "+ post.getPostID());
		
		//mapping post to post id
		postIdMap.put(post.getPostID(), post);
		
		return post.getPostID();
	}

	/*
	 * User can retrive post by giving post id
	 * 
	 * parameters: Integer - post id
	 * 
	 * return: object of type post
	 */
	public Post retrivePost(int postId) {
		if (postIdMap.containsKey(postId))
			return postIdMap.get(postId);
		else {
			System.out.println("Post id " + postId + " do not exist for username "+this.username);
			Post newPost = null;
			return newPost;
		}
	}
	
	/*
	 * User can add comment to a post
	 * 
	 * parameters: Object(Post) and String  - comment
	 *  
	 */
	public void addComment(Post post, String comments) {
		//null check
		if (post == null) {
			System.out.println("Post is not valid, cannot add comment");
			return;
		}
		Post incomingpost = post;
		ArrayList<String> oldComment = incomingpost.getComments();
		if (oldComment != null) {
			oldComment.add(comments);
			incomingpost.setComments(oldComment);
		} else {
			ArrayList<String> newComment = new ArrayList<String>();
			newComment.add(comments);
			incomingpost.setComments(newComment);
		}

	}

	/*
	 * User can add label to a post(only his post)
	 * 
	 * parameter: Object(Post) and String  - label
	 */
	public void addLabel(Post post, String Labels) {
		
		//null check
		if (post == null) {
			System.out.println("Post is not valid, cannot add label");
			return;
		}
		//check : post was created by user or not
		if(post.getUserID()!=this.userID){
			System.out.println("You can not add label to other user's posts");
			return;
		}
		ArrayList<String> oldLabels = post.getLables();
		if (oldLabels != null) {
			oldLabels.add(Labels);
			post.setLables(oldLabels);
		} else {
			ArrayList<String> newLabels = new ArrayList<String>();
			newLabels.add(Labels);
			post.setLables(newLabels);
		}

		// Maintaing Label -post map

		if (labelPostMap.containsKey(Labels)) {
			ArrayList<Post> postlist = labelPostMap.get(Labels);
			postlist.add(post);
			labelPostMap.put(Labels, postlist);
		} else {
			ArrayList<Post> postList = new ArrayList<Post>();
			postList.add(post);
			labelPostMap.put(Labels, postList);
		}
	}
}
