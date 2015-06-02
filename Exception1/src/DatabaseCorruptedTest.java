
public class DatabaseCorruptedTest {
	public static void main(String... args){
		String username = "";
		 try { 
	            getUsername(username);
	        } catch (DatabaseCorruptedException e) {
	            e.printStackTrace();
	        } 
	}

	private static void getUsername(String username) throws DatabaseCorruptedException {
		// TODO Auto-generated method stub
		 if(username == "")
             throw new DatabaseCorruptedException(); 
         else  
             System.out.println("The username is" + username);
		
      
	}
}
