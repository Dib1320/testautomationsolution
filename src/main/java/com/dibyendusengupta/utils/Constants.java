package com.dibyendusengupta.utils;

public class Constants {

	/****
	 * Directory Paths
	 */

	public final static String USERDIRECTORY = System.getProperty("user.dir") + System.getProperty("file.separator");
	
	public final static String FILESEPARATOR = System.getProperty("file.separator");

	public final static String RESOURCESDIRECTORY = USERDIRECTORY + "//src//test//resources//";

	public final static String DRIVERSDIRECTORY = RESOURCESDIRECTORY + "drivers//";

	public final static String SCREENSHOTSDIRECTORY = RESOURCESDIRECTORY + "screenshots//";

	public final static String LOGSDIRECTORY = RESOURCESDIRECTORY + "logs//";

	/****
	 * Browser Constnats
	 */

	public static final String CHROME = "CHROME";

	public static final String INTERNETEXPLORER = "INTERNETEXPLORER";

	public static final String FIREFOX = "FIREFOX";

	public static final String EDGE = "EDGE";

	/*******
	 * Driver Executable Path
	 */
	
	public static final String INTERNETEXPLOREREXE = DRIVERSDIRECTORY + "IEDriverServer.exe";

	public static final String EDGEEXE = DRIVERSDIRECTORY + "chromedriver.exe";

	public static final String CHROMEEXE = DRIVERSDIRECTORY + "chromedriver.exe";
	
	/****
	 * Payment Type Constants
	 */
	
	public static final String PAYBANKWIRE = "PAYBANKWIRE";
	
	public static final String PAYBYCHECK = "PAYBYCHECK";
	

}
