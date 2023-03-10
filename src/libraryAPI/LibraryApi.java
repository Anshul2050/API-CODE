package libraryAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LibraryApi {
     
	@Test
	public void LibraryEndtoEndTest() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String add_book=
		given().log().all()
		.body(PayLoad.libPostPayLoad("anshul12","bad2",10102,"Anshul Badgaiyan"))
		.when().post("Library/Addbook.php").then().assertThat().statusCode(200)
		.body("Msg", equalTo("successfully added")).extract().asString();
		
		System.out.println(add_book);
		
		
	}

}
