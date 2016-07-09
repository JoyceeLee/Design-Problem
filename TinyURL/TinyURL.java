/*
  unsigned long: 0～4294967295
  long:          2147483648～2147483647
  62 ^ 6 = 56.8 billion > range of long
  62 ^ 7 = 3.5216146e+12 ～ 3500 billion > range of long
*/
public class TinyURL {
	public static void main(String[] args) {
		TinyURL turl = new TinyURL();
		long id = 12345;
		String url = turl.id2TinyURL(id);
		id = turl.tinyURL2Id(url);
		
		System.out.println(id);
		System.out.println(url);
	}
	
	private char[] map = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'0','1','2','3','4','5','6','7','8','9'};
	
	private String id2TinyURL(long id) {
		StringBuilder url = new StringBuilder();
		
		while (id > 0) {
			url.append(map[(int)(id % 62)]); // there is no function to append from index 0
			id /= 62;
		}
		
		url.reverse();
		return url.toString();
	}
	
	private long tinyURL2Id(String url) {
		long id = 0;

		for (int i = 0; i < url.length(); i++) {
			char c = url.charAt(i);
			if (c >= 'a' && c <= 'z') {
				id = id * 62 + (c-'a');
			} else if (c >= 'A' && c <= 'Z') {
				id = id * 62 + c - 'A' + 26;
			} else {
				id = id * 62 + c - '0' + 52;
			}
		}

		return id;
	}
}
