package commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FunctionUtils {
	
	public static String PropertyReader(String key) throws IOException
	{  FileInputStream fis=null;
	   File file=null;
	   Properties prop=null;
	   try
	   {
		 file=new File(System.getProperty("user.dir")+"//resourses//globalconfig.properties");
		fis=new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
	   }
	   catch(FileNotFoundException fnfe)
	   {
		   fnfe.printStackTrace();
	   }
	   
	   catch(IOException  ioe)
	   {
		   ioe.printStackTrace();
	   }
		 String propkey=  prop.getProperty(key);
		return propkey;
		
	}

}
