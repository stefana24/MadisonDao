package tools.constants;

import net.bytebuddy.utility.RandomString;
import tools.PropertyFileReader;

public class UserConstants {
    public static final String EMAIL = PropertyFileReader.getValue("EMAIL");
    public static final String PASSWORD = PropertyFileReader.getValue("PASSWORD");
}
