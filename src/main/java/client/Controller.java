package client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;

import com.jk.core.util.JK;
import com.jk.web.faces.controllers.JKWebController;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("controller")
@ViewScoped
public class Controller extends JKWebController implements Serializable {

	ServiceClient client = new ServiceClient();
	AccountsClient account;
	AccountsClient viewAccount;
	List<AccountsClient> accountsViewd;
	AccountsClient newAccount;

	public Controller() {

		accountsViewd = allAccounts();
	}

	public ServiceClient getClient() {
		return client;
	}

	public void setClient(ServiceClient client) {
		this.client = client;
	}

	public AccountsClient getViewAccount() {
		return viewAccount;
	}

	public void setViewAccount(AccountsClient viewAccount) {
		this.viewAccount = viewAccount;
	}

	public List<AccountsClient> getAccountsViewd() {
		return accountsViewd;
	}

	public void setAccountsViewd(List<AccountsClient> accountsViewd) {
		this.accountsViewd = accountsViewd;
	}

	public AccountsClient getNewAccount() {
		return newAccount;
	}

	public void setNewAccount(AccountsClient newAccount) {
		this.newAccount = newAccount;
	}

	public AccountsClient getAccount() {
		return account;
	}

	public void setAccount(AccountsClient account) {
		this.account = account;
	}

	public List<AccountsClient> allAccounts() {
		List<AccountsClient> accountsList = client.getAll();

		accountsViewd = new ArrayList<>();
		for (AccountsClient accounts : accountsList) {
			viewAccount = new AccountsClient();
			viewAccount.setId(accounts.getId());
			viewAccount.setAccountName(accounts.getAccountName());
			viewAccount.setAccountNumber(accounts.getAccountNumber());
			viewAccount.setBalance(accounts.getBalance());
			accountsViewd.add(viewAccount);

		}
		return accountsViewd;
	}

	public void openNewAccount() {

		newAccount = new AccountsClient();
	}

	public void saveNewAccount() {

		if (newAccount.getId() == 0) {
			accountsViewd.add(newAccount);
			client.callJsonWithPost(newAccount);
			success("New Account has been Added!");
			PrimeFaces.current().executeScript("PF('manageAccountsDialog').hide()");
			PrimeFaces.current().ajax().update("form:messages", "form:dataTableAccounts");
		}
	}

}
