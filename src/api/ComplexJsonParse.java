package api;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import jsons.PostApiJson;

public class ComplexJsonParse {
	public static void main(String[] args) {
		PostApiJson apj=new PostApiJson();
		JsonPath jp = new JsonPath(apj.getCourseInfo());
		
//1. Print No of courses returned by API
		System.out.println("1. Print No of courses returned by API");
		System.out.println(jp.getInt("courses.size()"));

//2.Print Purchase Amount
		System.out.println("2.Print Purchase Amount");
		System.out.println(jp.getInt("dashboard.purchaseAmount"	));

//3. Print Title of the first course
		System.out.println("3. Print Title of the first course");
		System.out.println(jp.getString("courses[0].title"));
//4. Print All course titles and their respective Price
		System.out.println("4. Print All course titles and their respective Price");
for(int i=0;i<jp.getInt("courses.size()");i++)
{
System.out.println(jp.getString("courses["+i+"].title")+" and price is :"+jp.getString("courses["+i+"].price"));
}
		

//5. Print no of copies sold by RPA Course
System.out.println("5.Print no of copies sold by RPA Course");
for(int i=0;i<jp.getInt("courses.size()");i++)
{
String  courseTitle=jp.getString("courses["+i+"].title");

if(courseTitle.equalsIgnoreCase("rpa"))
{
	System.out.println(jp.getString("courses["+i+"].price"));
	break;
}
}

//6. Verify if Sum of all Course prices matches with Purchase Amount

System.out.println("6. Verify if Sum of all Course prices matches with Purchase Amount");
double sum=0;
for(int i =0; i<jp.getInt("courses.size()");i++) {
 sum =sum+jp.getDouble("courses["+i+"].price")*jp.getDouble("courses["+i+"].copies");}

if(sum == jp.getDouble("dashboard.purchaseAmount"))
{
	System.out.println(sum +" = "+jp.getDouble("dashboard.purchaseAmount"));
}
else {
	System.out.println("some audit error");
}
	}

}
