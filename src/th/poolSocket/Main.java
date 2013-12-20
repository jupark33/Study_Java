public class Main {

	private String port;
	private Logger logger;
	private PoolListener listen;
	private String total;
	
	public Main() {
		String path = System.getProperty("user.dir");
    	PropertyConfigurator.configureAndWatch(path + "/log4j/log4j.properties", 1000);
    	logger = Logger.getLogger(this.getClass());
    	
    	port = "70070";
		watermark = "true";
		total = "200";
    	
		if (getProperties()) {
			int iPort = Integer.parseInt(port);
			boolean bWaterMark = Boolean.parseBoolean(watermark);
			int iTotal = Integer.parseInt(total);
//			listen = new ListenThread(ip, iPort);
			listen = new PoolListener(iPort, bWaterMark, iTotal);
			
			Thread th = new Thread(listen);
			th.start();
		}
	}
	
	private boolean getProperties() {
		String workingDir = System.getProperty("user.dir");
		File file = new File(workingDir + "/" + "env.properties");
		
		logger.debug("Environment Properties file path : " + file.getPath());
		
		InputStream isProp = null;
		
		try {
			isProp = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		
		Properties prop = new Properties();
		try {
			prop.load(isProp);
			
			if (prop != null && prop.getProperty("port") != null) port = prop.getProperty("port");
			if (prop != null && prop.getProperty("total") != null) total = prop.getProperty("total");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		logger.debug("Properties port : " + port);
		logger.debug("Properties total : " + total);
		
		return true;
	}
	
	public static void main(String args[]) {
		new Main();
	}
}