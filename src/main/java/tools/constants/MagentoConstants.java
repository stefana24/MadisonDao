package tools.constants;

import tools.PropertyFileReader;

public class MagentoConstants {
    public static final String ADMIN = PropertyFileReader.getValue("ADMIN_USER");
    public static final String PASS = PropertyFileReader.getValue("ADMIN_PASSWORD");
}
