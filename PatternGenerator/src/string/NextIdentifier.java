package string;
import java.io.File;
import java.io.FileWriter;

// generates identifier
public class NextIdentifier {

	private String nextIdentifier(char[] charset, String curIdentifier){
		char[] prevIdentifier = curIdentifier.toCharArray();
		char[] nextIdentifier= prevIdentifier.clone();
		int idLen = prevIdentifier.length;
		int charsetLen =  charset.length;
		boolean incr = true;
		boolean carry = false;
		while(--idLen>=0){
			int index;
			for(index=0; index<charsetLen ; index++){
				if(charset[index] == nextIdentifier[idLen]){
					break;
				}
			}
			if((index == charsetLen-1) && (carry || incr)){
				nextIdentifier[idLen] = charset[0];
				incr = false;
				carry = true;
			}else{
				if(incr){
					nextIdentifier[idLen] = charset[index+1];
					incr = false;
				}
				if(carry){
					nextIdentifier[idLen] = charset[index+1];
					carry = false;
				}
			}			
		}
		return String.valueOf(nextIdentifier);
	}
	
	static boolean isPalindrome(String str){
		return str.equals(new StringBuffer().append(str).reverse().toString());
	}
	
	public static void main(String[] args) throws Exception{
		char[] charset = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String curIdentifier = "0000";//"YYZZ";
//		System.out.println(new NextIdentifier().nextIdentifier(charset, curIdentifier));
		File file = new File("indentifers.txt");
		FileWriter writer = new FileWriter(file);
		for(int i=0; i<500; i++){
			curIdentifier = new NextIdentifier().nextIdentifier(charset, curIdentifier);
			// if(isPalindrome(curIdentifier))
			writer.write(i+"->"+curIdentifier+",");
		}
		writer.flush();
		writer.close();
		
	}

}
