public class PoolListener implements Runnable {

	private Logger logger;
	private int port;
	private ServerSocket sSocket;
	private ExecutorService service;
	private boolean bWatermark;

	public PoolListener(int port, int iTotal) {
		logger = Logger.getLogger(this.getClass());
		
		this.port = port;
		
		try {
			sSocket = new ServerSocket(port);
			service = Executors.newFixedThreadPool(iTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			logger.debug("Port : " + port + " 연결 대기중... ");
			if (sSocket.isClosed()) break;
			
			try {
				Socket cSocket = sSocket.accept();
				logger.debug(cSocket.getRemoteSocketAddress() + ", Client 연결 됨 ");
				
				service.execute(new CommunicationThread(cSocket));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	class CommunicationThread extends Thread {

		private Socket cSocket;
		private BufferedReader br;
		private BufferedWriter bw;
		private StringBuffer reqBuf;
		private String lineFeed = "\r\n";

		public CommunicationThread(Socket cSocket) {
			this.cSocket = cSocket;
			
			try {
				br = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			while (!cSocket.isClosed()) {
				try {
					if (br.ready()) {
						String msg = br.readLine();
						
						if (msg != null && !msg.equals("")) 
							makeRequest(msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			logger.debug("[Closed. Request from deviceIp : " + cSocket.getRemoteSocketAddress() + ", Thread ID : " + Thread.currentThread().getId() + "]");
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void makeRequest(String msg) {
			logger.debug("msg : " + msg);
		}
		
		private void sendResponse(String msg) {
			try {
				bw.write(msg);
				bw.flush();
				
				logger.debug("[Response to deviceIP:" + cSocket.getRemoteSocketAddress() + ", Thread ID : " + Thread.currentThread().getId() + "]");
				logger.debug(msg);
				
				cSocket.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		
		public void addString(StringBuffer buf, String str) {
			buf.append(str + lineFeed);
		}
	}
}