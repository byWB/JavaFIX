/**
 * FIX API: http://www.quickfixj.org/
 */ 
package BitFixServer;
import java.io.FileInputStream;
import java.io.IOException;

import quickfix.Acceptor;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

public class testMainServ {

	public static void main(String[] args) throws ConfigError, InterruptedException, IOException{

			String fileName = "testSettingsServ.txt";
		    // FIXApplication is a class that implements the Application interface
		    Application application = new FIXApplicationServ();

		    // set the settings file
		    SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
		    
		    MessageStoreFactory storeFactory = new FileStoreFactory(settings);
		    LogFactory logFactory = new FileLogFactory(settings);
		    MessageFactory messageFactory = new DefaultMessageFactory();
		    Acceptor acceptor = new SocketAcceptor
		      (application, storeFactory, settings, logFactory, messageFactory);
		  
		    // Server starts with an acceptor
		    acceptor.start();
		    
		    // waits for input to close
		    System.out.println("press to quit");
	        System.in.read();
	        
	        //stops
		    acceptor.stop();
		
	}
	
}
