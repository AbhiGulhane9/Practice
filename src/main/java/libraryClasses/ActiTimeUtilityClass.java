package libraryClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class ActiTimeUtilityClass 
{
	// This method is used to get test data from excel 
	public static String exceldata(int getrow,int getcol) throws EncryptedDocumentException, IOException
	{
		//1st basic way 
		//FileInputStream file = new FileInputStream("F:\\Eclipse data\\SeleniumAdv\\TestDataExcel\\Pomddfexcel.xlsx");
		
		//2nd way 
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestDataExcel/Pomddfexcel.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDf");
		
		String value = sh.getRow(getrow).getCell(getcol).getStringCellValue();
		return value;
	}
	
	public static void CapturesShot(WebDriver driver) throws IOException
	{
		/*First Simple Way 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Path="F:\\Eclipse data\\SeleniumAdv\\ScreenShotFailTc\\TCID.png";
		File dest=new File(Path);
		FileHandler.copy(src, dest);*/
		
		//2nd way
		String Rs=RandomString.make(2);  // use to generate random string of length 2
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\ScreenShotFailTc\\TCID"+Rs+".jpeg");
        FileHandler.copy(src, dest);
		
	}
	public static String propertyFile(String key) throws IOException
	{
		//FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\PropertyFile.properties");
		Properties p = new Properties();
		
		FileInputStream file=new FileInputStream("F:\\Eclipse data\\SeleniumAdv\\PropertyFile.properties");
		
		
	
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
		
	}  

}

