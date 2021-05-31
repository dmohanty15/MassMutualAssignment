package stepdefinition;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtils.FunctionUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;
import pages.ExercisePage;

@RunWith(Cucumber.class)
public class StepDef {
	public static WebDriver driver;
	Map<String,String> hm;
	 List<String> lst;
	 public ExercisePage exp;
	 String  totalbalance;
	 double dtotal;
	
	@Before
	public void setup() throws IOException
	{
		System.out.println("browser initialization");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resourses//chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	
	@Given("Navigating to the exercises page")
	public void navigating_to_the_exercises_page() throws IOException {
		
		//driver.get(FunctionUtils.PropertyReader("baseurl"));
		System.out.println("hitting url");
	}

	  @When("verify the right count of values appear on the screen")
	  public void verify_the_right_count_of_values_appear_on_the_screen() throws IOException {
	     hm=new HashMap<String,String>();
	     try
	     {
	     hm.put("value1", FunctionUtils.PropertyReader("value1"));
	     hm.put("value2", FunctionUtils.PropertyReader("value2"));
	     hm.put("value3", FunctionUtils.PropertyReader("value3"));
	     hm.put("value4", FunctionUtils.PropertyReader("value4"));
	     hm.put("value5", FunctionUtils.PropertyReader("value5"));
	     
	     for(String  M:hm.values())
	     {
	    	 System.out.println(M);
	     }
	     
	     lst=new ArrayList<>(hm.values());
	     if(lst.size()==5)
	     {
	    	 System.out.println("the count of values are matching");
	     }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	   
	  }

	  @Then("verify the values on the screen are greater than {int}")
	  public void verify_the_values_on_the_screen_are_greater_than(Integer int1) {
	     try
	     {
		 String[] strar=new String[lst.size()];
		 strar=lst.toArray(strar);
		 String[] empty=new String[lst.size()];
		 
		  
		for(int i=0;i<strar.length;i++)
		{
			if(strar[i].contains("$"))
			{
				empty[i]=strar[i].substring(1);
				//System.out.println("***"+empty[i]);
				double double1=Double.parseDouble(empty[i]);
			//	System.out.println("******"+double1);
				if(double1!=0)
				{
					System.out.println("the values are greater than 0");
				}
			}
		}
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
		  
	  }

	  @Then("verify the total balance is correct based on the values listed on the screen")
	  public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() throws ParseException, IOException {
		  exp= new ExercisePage(driver);
		  String totalbalance1=FunctionUtils.PropertyReader("totalbalance").substring(1);
		 
		 try
		 {
		 
		  dtotal=Double.parseDouble(totalbalance1.replace(",", ""));
		 System.out.println("***************"+dtotal);
		 Assert.assertEquals("total value should be same as present on screen", 1000000.0, dtotal);	
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

		  
	    	  }

	  @Then("verify the values are formatted as currencies")
	  public void verify_the_values_are_formatted_as_currencies() {
		  try
		  {
		  for(int i=0;i<lst.size();i++)
		  {
			  if(lst.get(i).contains("$"))
			  {
				  System.out.println("values "+lst.get(i)+" are formated in currencies");
			  }
			  
		  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  finally
		  {
			  
		  }
	      
	  }

	  @Then("verify the total balance matches the sum of the values")
	  public void verify_the_total_balance_matches_the_sum_of_the_values() {
		  double sumvalue=0;
		  try
		  {
	    for(int i=0;i<lst.size();i++)
	    {
	    	String values=lst.get(i).substring(1);
	    	double dvalues=Double.parseDouble(values.replace(",", ""));
	    	sumvalue=sumvalue+dvalues;
	    	
	    	
	    }
	   
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  finally
		  {
			  Assert.assertEquals("Total balance should match with sumvalue", dtotal, sumvalue);
		  }
	  }
	  
	  @After
	  public void tearDown()
	  {
		  driver.close();
	  }

}
