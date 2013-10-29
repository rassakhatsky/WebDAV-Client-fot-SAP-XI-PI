package com.test.webdav;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.test.webdav package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _MTWebDAV_QNAME = new QName("http://test.com/WebDAV", "MT_WebDAV");
	private final static QName _MTWebDAVResp_QNAME = new QName("http://test.com/WebDAV", "MT_WebDAV_resp");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.test.webdav
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link DTWebDAV.WebDAV }
	 * 
	 */
	public DTWebDAV.WebDAV createDTWebDAVWebDAV() {
		return new DTWebDAV.WebDAV();
	}

	/**
	 * Create an instance of {@link DTWebDAVResp.WebDAV }
	 * 
	 */
	public DTWebDAVResp.WebDAV createDTWebDAVRespWebDAV() {
		return new DTWebDAVResp.WebDAV();
	}

	/**
	 * Create an instance of {@link DTMessage }
	 * 
	 */
	public DTMessage createDTMessage() {
		return new DTMessage();
	}

	/**
	 * Create an instance of {@link DTWebDAV }
	 * 
	 */
	public DTWebDAV createDTWebDAV() {
		return new DTWebDAV();
	}

	/**
	 * Create an instance of {@link ExchangeLogData }
	 * 
	 */
	public ExchangeLogData createExchangeLogData() {
		return new ExchangeLogData();
	}

	/**
	 * Create an instance of {@link DTWebDAVResp }
	 * 
	 */
	public DTWebDAVResp createDTWebDAVResp() {
		return new DTWebDAVResp();
	}

	/**
	 * Create an instance of {@link FMFault }
	 * 
	 */
	public FMFault createFMFault() {
		return new FMFault();
	}

	/**
	 * Create an instance of {@link DTMessage.Row }
	 * 
	 */
	public DTMessage.Row createDTMessageRow() {
		return new DTMessage.Row();
	}

	/**
	 * Create an instance of {@link ExchangeFaultData }
	 * 
	 */
	public ExchangeFaultData createExchangeFaultData() {
		return new ExchangeFaultData();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DTWebDAV }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://test.com/WebDAV", name = "MT_WebDAV")
	public JAXBElement<DTWebDAV> createMTWebDAV(DTWebDAV value) {
		return new JAXBElement<DTWebDAV>(_MTWebDAV_QNAME, DTWebDAV.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DTWebDAVResp }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://test.com/WebDAV", name = "MT_WebDAV_resp")
	public JAXBElement<DTWebDAVResp> createMTWebDAVResp(DTWebDAVResp value) {
		return new JAXBElement<DTWebDAVResp>(_MTWebDAVResp_QNAME, DTWebDAVResp.class, null, value);
	}

}
