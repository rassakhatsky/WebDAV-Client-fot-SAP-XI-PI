package com.test.webdav;

/**
 * Service Endpoint Interface (generated by SAP WSDL to Java generator).
 */
@javax.jws.WebService(name = "SI_WebDAV_SI", targetNamespace = "http://test.com/WebDAV")
@javax.jws.soap.SOAPBinding(parameterStyle = javax.jws.soap.SOAPBinding.ParameterStyle.BARE, style = javax.jws.soap.SOAPBinding.Style.DOCUMENT, use = javax.jws.soap.SOAPBinding.Use.LITERAL)
public interface SIWebDAVSI {

	/**
	 * Java representation of web method [SI_WebDAV_SI].
	 */
	@javax.jws.WebMethod(operationName = "SI_WebDAV_SI", action = "http://sap.com/xi/WebService/soap1.1")
	@javax.jws.WebResult(name = "MT_WebDAV_resp", targetNamespace = "http://test.com/WebDAV", partName = "MT_WebDAV_resp")
	public com.test.webdav.DTWebDAVResp siWebDAVSI(@javax.jws.WebParam(name = "MT_WebDAV", targetNamespace = "http://test.com/WebDAV", partName = "MT_WebDAV") com.test.webdav.DTWebDAV MT_WebDAV) throws com.test.webdav.FMFault_Exception;

}