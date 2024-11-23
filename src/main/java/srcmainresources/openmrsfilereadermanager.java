

package srcmainresources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class openmrsfilereadermanager {
	private static Properties property;
	private static FileInputStream fileinputstream;
	private static void setupProperty() throws IOException{
		if(property==null) {
			File file=new File("C:\\Users\\Yuvan_New\\eclipse-workspace\\Maven_Project\\src\\main\\java\\srcmainresources\\openmrs.properties");
			try {
				fileinputstream=new FileInputStream(file);
				property= new Properties();
				property.load(fileinputstream);
				
			}
			catch(FileNotFoundException e) {
				Assert.fail("ERROR: FILENOTFOUND EXCEPTION OCCUR DURING THE PROPERTY FILE LOADING");
			}
			catch(Exception e) {
				Assert.fail("ERROR: FILENOTFOUND EXCEPTION OCCUR DURING THE PROPERTY FILE LOADING");
			}
		}
	}
	public static String getDataProperty(String datavalue) throws IOException{
		setupProperty();
		String browserName=property.getProperty(datavalue);
		return browserName;
	}

}
