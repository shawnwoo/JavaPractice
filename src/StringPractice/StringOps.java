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
	
	public static void main(String[] args){
		StringOps sp=new StringOps();
		
		System.out.println(sp.reserveString("abc"));
		System.out.println(sp.reserveString(null));
		System.out.println(sp.reserveString(""));
		System.out.println(sp.reserveString("1234567890"));
	}

}
