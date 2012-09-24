package StringPractice;

public class StringOps {

	public boolean isUniqueChars(String str) {
		if (str.length() > 256)
			return false;

		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;

	}

	public String reserveString(String str) {
		
		if(str==null) return null;

		int length = str.length();

		if (length == 0)
			return "";

		char[] reversedChars = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			reversedChars[i]=str.charAt(length-i-1);
		}
		
		return new String(reversedChars);
	}
	
	public String sortString(String str){
		char[] charSet=str.toCharArray();
		java.util.Arrays.sort(charSet);
		return new String(charSet);
	}
	
	/*
	 * Assumptions: The Blank space also be considered as a character. 
	 */
	public boolean isPermutation(String str1, String str2){
		if(str1.length()!=str2.length()) return false;
		return sortString(str1).equals(sortString(str2));
	}
	
	
	public String replaceSpaces(String str){
		char[] content=str.toCharArray();
		int length=str.length();
		int spaceCount=0, newlength,i=0;
		
		for(i=0;i<length;i++){
			if(content[i]==' '){
				spaceCount++;
			}
		}
		
		newlength=length+2*spaceCount;
		char[] str2=new char[newlength];
		//str2[newlength]='\0';
		
		for(i=length-1;i>=0;i--){
			if(content[i]==' '){
				str2[newlength-1]='0';
				str2[newlength-2]='2';
				str2[newlength-3]='%';
				newlength-=3;
			}else{
				str2[newlength-1]=content[i];
				newlength-=1;
			}
		}
		
		return new String(str2);
	}
	
	public static void main(String[] args){
		StringOps sp=new StringOps();
		
		System.out.println(sp.reserveString("abc"));
		System.out.println(sp.reserveString(null));
		System.out.println(sp.reserveString(""));
		System.out.println(sp.reserveString("1234567890"));
		
		System.out.println(sp.replaceSpaces("Hello   LLL   "));
	}

}
