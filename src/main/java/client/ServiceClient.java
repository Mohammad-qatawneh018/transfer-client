package client;

import com.jk.core.config.JKConfig;
import com.jk.core.util.JK;
import com.jk.services.client.JKMatureServiceClient;

public class ServiceClient extends JKMatureServiceClient<AccountsClient> {

	@Override
	public String getBase() {
	
		//JK.print(JKConfig.get().getProperty("service.accounts.url"));
		return JKConfig.get().getProperty("service.accounts.url");
		
		
		//return "http://localhost:8080/transfer/accounts";
	}
}
