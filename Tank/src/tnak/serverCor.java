package tnak;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class serverCor extends Thread{
	private int port;
	ServerSocket ss;
	private boolean stop = false;
	private ItankLoger logger=null;
	
	public serverCor(int port) throws IOException {
		this.setPort(port);
		//logger = new TextChatLogger();
		//logger.systemMessage("Server started...");
		this.start();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ServerSocket getSs() {
		return ss;
	}

	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public ItankLoger getLogger() {
		return logger;
	}

	public void setLogger(ItankLoger logger) {
		this.logger = logger;
	}
	
	
	@Override
	public void run() {
		int nb=0;
		try (ServerSocket ss = new ServerSocket(port)) {
			//ss.setSoTimeout(1000);
			while (!stop) {
				
				try {
					//if(nb>3) {
					Socket s = ss.accept();
					//nb++;
					//System.out.println(nb);
					//logger.clientConnected(s.toString());
					new Thread(new gamerHandler(s,logger,nb)).start();
					nb++;
					/*}
					ss.close();*/
				} catch (SocketTimeoutException ex) {}
			}
		}catch (IOException e) {
			System.out.println("Could not bind port " + port);
			//Logger.getLogger(ServerCore.class.getName()).log(Level.SEVERE,null, e);
		}
		
		
	}
}
