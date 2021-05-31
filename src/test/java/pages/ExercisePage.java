package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExercisePage extends BaseTestPage {

	public ExercisePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="lbl_val_1")
	public WebElement label_Value1;
	@FindBy(id="lbl_val_2")
	public WebElement label_Value2;
	@FindBy(id="lbl_val_3")
	public WebElement label_Value3;
	@FindBy(id="lbl_val_4")
	public WebElement label_Value4;
	@FindBy(id="lbl_val_5")
	public WebElement label_Value5;
	
	@FindBy(id="txt_val_1")
	public WebElement txt_Value1;
	@FindBy(id="txt_val_2")
	public WebElement txt_Value2;
	@FindBy(id="txt_val_3")
	public WebElement txt_Value3;
	@FindBy(id="txt_val_4")
	public WebElement txt_Value4;
	@FindBy(id="txt_val_5")
	public WebElement txt_Value5;
	
	@FindBy(id="txt_val_5")
	public WebElement txt_totalvalue;

}
