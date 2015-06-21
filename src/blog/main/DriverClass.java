package blog.main;
import java.util.ArrayList;


public class DriverClass {
	public static void main(String args[])
	{	
		//Creating two users
		User user_one= new User("USER_ONE");
		User user_two= new User("USER_TWO");
		
		//Users creating posts
		user_one.CreatePost("This is first test post from user one", "one first post");
		user_one.CreatePost("User one has made second post on blog", "one second post");
		user_two.CreatePost("This is first post by user two", "fisrt post :user two");
		
		//user commenting on post
		user_one.addComment(user_one.retrivePost(1), "fisrt comment on first post");
		user_one.addComment(user_one.retrivePost(1), "second comment on first post");
		user_one.addComment(user_one.retrivePost(2), "first comment on Second post");
		user_one.addComment(user_one.retrivePost(2), "First comment on Third post");
		user_two.addComment(user_two.retrivePost(3), "Fisrt comment by user two on post three");

		//user adding labels
		user_one.addLabel(user_one.retrivePost(1), "first");
		user_one.addLabel(user_one.retrivePost(1), "post");
		user_one.addLabel(user_one.retrivePost(2), "second");
		user_one.addLabel(user_one.retrivePost(2), "post");
		user_two.addLabel(user_two.retrivePost(3), "first");
		
		//creating a client object
		Client client= new Client();
		
		//client find post with label and user combination
		ArrayList<Post> answer=client.retrivePost("first", user_one);
		Post result = null;
		System.out.println("************");
		for(Post po:answer){
			result=po;
			System.out.println("Post Title : "+po.getPostTitle());
		}
		System.out.println("***********");
		
		//client find comments assoiciated with a post 
		ArrayList<String> comments= client.getComments(result);
		for(String s:comments){
			System.out.println("Comments : "+s);
		}
		System.out.println("***********");
		//Display post
		result.displayPost();
		
	}
}
