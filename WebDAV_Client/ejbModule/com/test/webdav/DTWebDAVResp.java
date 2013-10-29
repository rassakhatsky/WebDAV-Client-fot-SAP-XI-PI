package com.test.webdav;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DT_WebDAV_resp complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DT_WebDAV_resp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebDAV" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Message" type="{http://test.com/WebDAV}DT_Message" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Action" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="User" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ServerAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ServerAddressFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ServerAddressTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_WebDAV_resp", propOrder = { "webDAV" })
public class DTWebDAVResp {

	@XmlElement(name = "WebDAV", required = true)
	protected List<DTWebDAVResp.WebDAV> webDAV;

	/**
	 * Gets the value of the webDAV property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the webDAV property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWebDAV().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTWebDAVResp.WebDAV }
	 * 
	 * 
	 */
	public List<DTWebDAVResp.WebDAV> getWebDAV() {
		if (webDAV == null) {
			webDAV = new ArrayList<DTWebDAVResp.WebDAV>();
		}
		return this.webDAV;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="Message" type="{http://test.com/WebDAV}DT_Message" minOccurs="0"/>
	 *       &lt;/sequence>
	 *       &lt;attribute name="Action" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *       &lt;attribute name="User" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *       &lt;attribute name="Password" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *       &lt;attribute name="ServerAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *       &lt;attribute name="ServerAddressFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *       &lt;attribute name="ServerAddressTo" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "message" })
	public static class WebDAV {

		@XmlElement(name = "Message")
		protected DTMessage message;
		@XmlAttribute(name = "Action")
		protected String action;
		@XmlAttribute(name = "User")
		protected String user;
		@XmlAttribute(name = "Password")
		protected String password;
		@XmlAttribute(name = "ServerAddress")
		protected String serverAddress;
		@XmlAttribute(name = "ServerAddressFrom")
		protected String serverAddressFrom;
		@XmlAttribute(name = "ServerAddressTo")
		protected String serverAddressTo;

		/**
		 * Gets the value of the message property.
		 * 
		 * @return possible object is {@link DTMessage }
		 * 
		 */
		public DTMessage getMessage() {
			return message;
		}

		/**
		 * Sets the value of the message property.
		 * 
		 * @param value
		 *            allowed object is {@link DTMessage }
		 * 
		 */
		public void setMessage(DTMessage value) {
			this.message = value;
		}

		/**
		 * Gets the value of the action property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getAction() {
			return action;
		}

		/**
		 * Sets the value of the action property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setAction(String value) {
			this.action = value;
		}

		/**
		 * Gets the value of the user property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getUser() {
			return user;
		}

		/**
		 * Sets the value of the user property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setUser(String value) {
			this.user = value;
		}

		/**
		 * Gets the value of the password property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Sets the value of the password property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setPassword(String value) {
			this.password = value;
		}

		/**
		 * Gets the value of the serverAddress property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getServerAddress() {
			return serverAddress;
		}

		/**
		 * Sets the value of the serverAddress property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setServerAddress(String value) {
			this.serverAddress = value;
		}

		/**
		 * Gets the value of the serverAddressFrom property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getServerAddressFrom() {
			return serverAddressFrom;
		}

		/**
		 * Sets the value of the serverAddressFrom property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setServerAddressFrom(String value) {
			this.serverAddressFrom = value;
		}

		/**
		 * Gets the value of the serverAddressTo property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getServerAddressTo() {
			return serverAddressTo;
		}

		/**
		 * Sets the value of the serverAddressTo property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setServerAddressTo(String value) {
			this.serverAddressTo = value;
		}

	}

}
