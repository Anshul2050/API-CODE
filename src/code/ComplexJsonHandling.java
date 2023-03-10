package code;

import java.util.ArrayList;

import io.restassured.path.json.JsonPath;
import payload.PayLoad;

public class ComplexJsonHandling {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(PayLoad.complexJson());
		
		int noOfCourses =js.getInt("courses.size()");
		
		
		
		System.out.println(noOfCourses);
		
		System.out.println(js.getString("courses[2].title"));
		
		System.out.println(js.getString("dashboard.purchaseAmount"));
		
		for(int i = 0;i<noOfCourses;i++) {
			
			System.out.println(js.getString("courses["+i+"].price"));
			
			
			
		}
		
		

	}

}
