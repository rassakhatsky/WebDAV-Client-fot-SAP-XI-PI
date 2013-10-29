/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sardineclient;

import com.test.webdav.DTWebDAVResp.WebDAV;

/**
 * 
 * @author rassakhatsky
 */
class Execution {

	public StringBuffer resultMessage;

	public void createFile(WebDAV source) {

		String address;
		String addressTo;
		String password;
		String addressFrom;
		String user;
		String action;

		if (!(source.getServerAddress() == null)) {
			address = source.getServerAddress();
		} else {
			address = "";
		}
		if (!(source.getServerAddressTo() == null)) {
			addressTo = source.getServerAddressTo();
		} else {
			addressTo = "";
		}
		if (!(source.getServerAddressFrom() == null)) {
			addressFrom = source.getServerAddressFrom();
		} else {
			addressFrom = "";
		}
		if (!(source.getUser() == null)) {
			user = source.getUser();
		} else {
			user = "";
		}
		if (!(source.getPassword() == null)) {
			password = source.getPassword();
		} else {
			password = "";
		}
		if (!(source.getAction() == null)) {
			action = source.getAction();
		} else {
			action = "";
		}

		resultMessage = new StringBuffer(250000);
		resultMessage.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		resultMessage.append("<ns0:MT_WebDAV_resp xmlns:ns0=\"http://test.com/WebDAV\">");
		resultMessage.append("<WebDAV");

		if ((!action.isEmpty()) || (!(action == null))) {
			resultMessage.append("  Action=\"");
			resultMessage.append(action);
			resultMessage.append("\"");
		}

		if ((!user.isEmpty()) || (!(user == null))) {
			resultMessage.append("  User=\"");
			resultMessage.append(user);
			resultMessage.append("\"");
		}

		if ((!(password == null)) || (!password.isEmpty())) {
			resultMessage.append("  Password=\"");
			resultMessage.append(password);
			resultMessage.append("\"");
		}

		if ((!address.isEmpty()) || (!(address == null))) {
			resultMessage.append("  ServerAddress=\"");
			resultMessage.append(address);
			resultMessage.append("\"");
		}

		if ((!addressFrom.isEmpty()) || (!(addressFrom == null))) {
			resultMessage.append("  ServerAddressFrom=\"");
			resultMessage.append(addressFrom);
			resultMessage.append("\"");
		}

		if ((!addressTo.isEmpty()) || (!(addressTo == null))) {
			resultMessage.append("  ServerAddressTo=\"");
			resultMessage.append(addressTo);
			resultMessage.append("\"");
		}

		resultMessage.append(">");

		if ((!source.getMessage().getRow().isEmpty()) || (!(source.getMessage().getRow() == null))) {
			resultMessage.append("<Message>");

			for (int i = 0; i < source.getMessage().getRow().size(); i++) {
				resultMessage.append("<Row>");

				for (int j = 0; j < source.getMessage().getRow().get(i).getRecord().size(); j++) {
					resultMessage.append("<Record>");
					resultMessage.append(source.getMessage().getRow().get(i).getRecord().get(j));
					resultMessage.append("</Record>");
				}
				resultMessage.append("</Row>");
			}
			resultMessage.append("</Message>");
		}
		resultMessage.append("</WebDAV>");
		resultMessage.append("</ns0:MT_WebDAV_resp>");
	}

	public byte[] getOutput() {
		return String.valueOf(resultMessage).getBytes();
	}
}