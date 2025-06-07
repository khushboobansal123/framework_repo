package Practice;

public class GenerateAlphanumericRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		
		//choose a character random from this string
		String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create stringbuilder 
		StringBuilder s = new StringBuilder(n);
		
		for(int i=0; i<n; i++)
		{
			//generate a random number between 0 to length of alphanum
			int random = (int)(Math.random() * alphanum.length());
			
			s.append(alphanum.charAt(random));
		}

		
		System.out.println(s);
	}

}
