package client;

import com.jk.services.server.JKServiceConfig;
import com.jk.web.embedded.JKWebApplication;

import jakarta.ws.rs.ApplicationPath;

public class App extends JKServiceConfig {
	public static void main(String[] args) {
		JKWebApplication.run(8181);
	}
}
