/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sardineclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import com.test.webdav.DTMessage;
import com.test.webdav.DTWebDAV;
import com.test.webdav.DTWebDAVResp;
import com.test.webdav.FMFault_Exception;

/**
 * WebDav client template for SAP Java Proxy Main class for WebDAV client
 * 
 * @author rassakhatsky
 */
public class SardineClient {

	public static void main(String[] args) throws IOException, FMFault_Exception, ParserConfigurationException, SAXException {
		//Test data
		DTWebDAV requestMessage = new DTWebDAV();
		String server = "";
		String user = "";
		String password = "";

		//delete action
		DTWebDAV.WebDAV deleteMessage = new DTWebDAV.WebDAV();
		String deleteFile = "/delete.xml";
		deleteMessage.setAction("delete");
		deleteMessage.setServerAddress(server + deleteFile);
		deleteMessage.setUser(user);
		deleteMessage.setPassword(password);

		//put message
		DTWebDAV.WebDAV putMessage = new DTWebDAV.WebDAV();
		String putFile = "/put.xml";
		DTMessage message = new DTMessage();
		DTMessage.Row row = new DTMessage.Row();
		row.getRecord().add("Record_1");
		row.getRecord().add("Record_2");

		putMessage.setAction("put");
		putMessage.setServerAddress(server + putFile);
		putMessage.setUser(user);
		putMessage.setPassword(password);
		message.getRow().add(row);
		putMessage.setMessage(message);

		//get message
		DTWebDAV.WebDAV getMessage = new DTWebDAV.WebDAV();
		String getFile = "/11.xml";
		getMessage.setAction("get");
		getMessage.setServerAddress(server + getFile);
		getMessage.setUser(user);
		getMessage.setPassword(password);
                SardineClient neww = new SardineClient();
                DTWebDAVResp resp = new DTWebDAVResp();
                requestMessage.getWebDAV().add(getMessage);
                neww.execute(requestMessage, resp);

		//Create Directory message
		DTWebDAV.WebDAV cdMessage = new DTWebDAV.WebDAV();
		String directory = "newDirectory";
		cdMessage.setAction("cd");
		cdMessage.setServerAddress(server + directory);
		cdMessage.setUser(user);
		cdMessage.setPassword(password);

		//move message
		DTWebDAV.WebDAV moveMessage = new DTWebDAV.WebDAV();
		String moveFrom = "move1.xml";
		String moveTo = "move2.xml";
		moveMessage.setAction("move");
		moveMessage.setServerAddressFrom(moveFrom);
		moveMessage.setServerAddressTo(moveTo);
		moveMessage.setUser(user);
		moveMessage.setPassword(password);

		//copy message
		DTWebDAV.WebDAV copyMessage = new DTWebDAV.WebDAV();
		String copyFrom = "copy1.xml";
		String copyTo = "copy2.xml";
		copyMessage.setAction("copy");
		copyMessage.setServerAddressFrom(copyFrom);
		copyMessage.setServerAddressTo(copyTo);
		copyMessage.setUser(user);
		copyMessage.setPassword(password);

		//list message
		DTWebDAV.WebDAV listMessage = new DTWebDAV.WebDAV();
		String listDirectory = "/";
		listMessage.setAction("list");
		listMessage.setServerAddress(server + listDirectory);
		listMessage.setUser(user);
		listMessage.setPassword(password);

		//exist  message
		DTWebDAV.WebDAV exMessage = new DTWebDAV.WebDAV();
		String exFile = "/ex.xml";
		exMessage.setAction("ex");
		exMessage.setServerAddress(server + exFile);
		exMessage.setUser(user);
		exMessage.setPassword(password);
	}

	/**
	 * Main method
	 * 
	 * @param requestMessage
	 *            - request message with action
	 * @param responseMessage
	 * @return
	 * @throws IOException
	 * @throws com.test.webdav.FMFault_Exception
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public DTWebDAVResp execute(DTWebDAV requestMessage, DTWebDAVResp responseMessage) throws IOException, com.test.webdav.FMFault_Exception, ParserConfigurationException, SAXException {

		for (int i = 0; i < requestMessage.getWebDAV().size(); i++) { //take each structure in the message
			DTMessage message = new DTMessage(); //result message (body)
			DTWebDAVResp.WebDAV webDAW = new DTWebDAVResp.WebDAV(); //result message (header)
			DTMessage.Row row = new DTMessage.Row();//result message (rows in the header of the message)

			/**
			 * Take header data
			 */
			String action = requestMessage.getWebDAV().get(i).getAction(); //take action
			String user = requestMessage.getWebDAV().get(i).getUser(); //take user name
			String password = requestMessage.getWebDAV().get(i).getPassword(); //take password
			String serverAddress = requestMessage.getWebDAV().get(i).getServerAddress(); //take server address
			String serverAddressTo = requestMessage.getWebDAV().get(i).getServerAddressTo(); //take server address (target for copy/move actions)
			String serverAddressFrom = requestMessage.getWebDAV().get(i).getServerAddressFrom(); //take server address (source for copy/move actions)

			/**
			 * Create new WebDAV client and after check which action has to be
			 * used
			 */
			Sardine sardine = SardineFactory.begin(user, password);

			/**
			 * This uses a HTTP HEAD request to see if a file exists on the
			 * remote server.
			 */
			if (action.equalsIgnoreCase("exists") || action.equalsIgnoreCase("ex")) {
				if (sardine.exists(serverAddress)) {
					row.getRecord().add("File/Directory exists");
				} else {
					row.getRecord().add("File/Directory doesn't exist");
				}
				message.getRow().add(row);
			}

			/**
			 * This uses HTTP PUT to delete a resource on a webdav server. Most
			 * likely you will want to pass in a username/password for this one
			 * unless the server is behind a firewall. =)
			 */
			if (action.equalsIgnoreCase("delete")) { // delete action                
				//Check if file is exist
				if (sardine.exists(serverAddress)) {
					//file exists
					sardine.delete(serverAddress);
					row.getRecord().add("File has been deleted.");
				} else {
					//file doesn't exist
					row.getRecord().add("File not found.");
				}
				message.getRow().add(row);
			}

			/**
			 * This creates a directory on the remote server.
			 */
			if (action.equalsIgnoreCase("createDirectory") || action.equalsIgnoreCase("cd")) { // createDirectory
				//Check if directory exists
				if (sardine.exists(serverAddress)) {
					//directory exists
					row.getRecord().add("Directory exists.");
				} else {
					//directory doesn't exist
					sardine.createDirectory(serverAddress);
					row.getRecord().add("Directory has been created successfuly.");
				}
				message.getRow().add(row);
			}

			/**
			 * This allows you to HTTP PUT a file up on a webdav server. It
			 * takes an InputStream so that you don't have to buffer the entire
			 * file into memory first as a byte array.
			 */
			if (action.equalsIgnoreCase("put")) { // put action
				Handler handler = new Handler();
				byte[] file = handler.executePut(requestMessage.getWebDAV().get(i));
				sardine.put(serverAddress, file);
				row.getRecord().add("File has been created successfuly.");
				message.getRow().add(row);
			}

			/**
			 * This moves a file from one location to another on the remote
			 * server. It assumes you want to overwrite all files.
			 */
			if (action.equalsIgnoreCase("move")) { // move action
				//check if file exists
				if (sardine.exists(serverAddressFrom)) {
					//file exists
					sardine.move(serverAddressFrom, serverAddressTo);
					row.getRecord().add("File has been moved successfuly.");
				} else {
					//directory doesn't exist
					row.getRecord().add("File doesn't exist.");
				}
				message.getRow().add(row);
			}

			/**
			 * This copies a file from one location to another on the remote
			 * server. It assumes you want to overwrite all files.
			 */
			if (action.equalsIgnoreCase("copy")) { // copy action
				//check if file exists
				if (sardine.exists(serverAddressFrom)) {
					//file exists
					sardine.copy(serverAddressFrom, serverAddressTo);
					row.getRecord().add("File has been copied successfuly.");
				} else {
					//directory doesn't exist
					row.getRecord().add("File doesn't exist.");
				}
				message.getRow().add(row);
			}

			/**
			 * This returns a List of DavResource objects for a directory or a
			 * single DavResource for a file on a remote dav server. The URL
			 * should be properly encoded and must end with a "/" for a
			 * directory. The depth is an optional parameter that defaults to 1.
			 */
			if (action.equalsIgnoreCase("list")) {
				//Check if directory exists
				if (sardine.exists(serverAddress)) {
					//directory exists
					row.getRecord().add("Directory exists.");
					List<DavResource> resources = sardine.list(serverAddress);
					for (DavResource res : resources) {
						row.getRecord().add(res.toString());
					}
				} else {
					//directory doesn't exist
					row.getRecord().add("Directory doesn't exist.");
				}
				message.getRow().add(row);
			}

			/**
			 * This will get an InputStream reference to a remote file.
			 * Obviously you want to point at a file and not a directory for
			 * this one. The url should be properly encoded
			 */
			if (action.equalsIgnoreCase("get")) { // get action
				//if server address contains * - it could be dynamic name
				if (serverAddress.indexOf("*") != -1) {
					//dynamic name, so we should find name
					DynamicNames dynamicNames = new DynamicNames();
					serverAddress = dynamicNames.getLink(sardine, serverAddress);
				}
				
				//check if file exists
				if (sardine.exists(serverAddress)) {
					//file exists
					InputStream is = sardine.get(serverAddress);
					SAXParserFactory factory = SAXParserFactory.newInstance();
					SAXParser parcer = factory.newSAXParser();
					SAXHandler_4_Get handlerXI = new SAXHandler_4_Get();
                    parcer.parse(is, handlerXI);
					message = handlerXI.getOutput().getMessage();
				} else {
					//directory doesn't exist
					row.getRecord().add("File/Directory doesn't exist.");
					message.getRow().add(row);
				}
			}

			webDAW.setMessage(message); //set message (body)
			webDAW.setAction(action);
			webDAW.setServerAddress(serverAddress);
			webDAW.setServerAddressFrom(serverAddressFrom);
			webDAW.setServerAddressTo(serverAddressTo);
			webDAW.setUser(user);
			responseMessage.getWebDAV().add(i, webDAW);
		}
		return responseMessage;
	}
}
