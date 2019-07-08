public class FileUtil {

	public static boolean isFileClosed(File file) throws Exception {
		boolean closed = false;
		FileChannel channel = null;
		
		try {
			channel = new RandomAccessFile(file, "rw").getChannel();
			closed = true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return closed;
	}
	
	/**
	 * INI 파일로부터 파일명 얻기  ( Name1=ABC00123_20190429102300_0.pdf )
	 * @param line
	 * @return
	 */
	public static String getFileName(String line) {
		if (StringUtil.isEmpty(line)) return null;
		
		String name = null;
		String[] keyAndValue = line.split("=");
		if (keyAndValue != null && keyAndValue.length == 2) {
			name = keyAndValue[1];
		}
		
		return name;
	}
	
	/**
	 * 확장자를 제외한 파일명만 얻기 			<br>
	 * ABC00123_20190429112300_0.pdf  	<br>
	 * ABC00123_20190429112300_1.pdf  	<br>
	 * ABC00123_20190429112300_2.pdf  	<br>
	 * 									<br>
	 * ABC00123_20190429112300_1of1.jpg	<br>
	 * @param name
	 * @return
	 */
	public static String getFileNameWithoutExt(String name) {
		if (StringUtil.isEmpty(name)) return null;
		
		int lastDot = name.lastIndexOf(".");
		String withoutExt = name.substring(0, lastDot);
		return withoutExt;
	}
	
	/**
	 * 머지 후 파일명 						<br>
	 * ABC00123_20190429112300_0.pdf  	<br>
	 * ABC00123_20190429112300_1.pdf  	<br>
	 * ABC00123_20190429112300_2.pdf  	<br>
	 * 									<br>
	 * ABC00123_20190429112300_1of1.jpg	<br>
	 * @param name
	 * @return
	 */
	public static String getMergedFileName(String name) {
		if (StringUtil.isEmpty(name)) return null;
		
		String fileNameWithoutExt = getFileNameWithoutExt(name);
		
		int lastUnderBar = fileNameWithoutExt.lastIndexOf("_");
		String result = fileNameWithoutExt.substring(0, lastUnderBar);
		return result;
	}

	/**
	 * PDF 파일 머지 후 저장할 경로
	 * @return
	 */
	public static String getMergedPath() {
		String path = System.getenv("SFS_HOME") + File.separator + CommonData.vMergedPath;
		return path;
	}
	
	/**
	 * 경로명에서 파일명만 제거.  												<br>
	 * [INPUT]																<br>
	 * E:\various_home\Fax_Send\MFP_upload\DRY02936_20190708094540_0.pdf	<br> 
	 * [OUTPUT]																<br>
	 * E:\various_home\Fax_Send\MFP_upload									<br> 
	 * @param path 파일경로
	 * @return 파일명을 제외한 경로
	 */
	public static String getPath(String path) {
		if (StringUtil.isEmpty(path)) return null;
		
		path = path.replaceAll("/", Matcher.quoteReplacement(File.separator));
		int lastDot = path.lastIndexOf("\\");
		
		return path.substring(0, lastDot);
	}
	
