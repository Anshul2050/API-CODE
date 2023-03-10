package libraryAPI;

public class PayLoad {

	
	public static String libPostPayLoad(String bookN ,String isbn,
			 int aisle,String author) {
		
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\""+bookN+"\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\""+author+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
}
