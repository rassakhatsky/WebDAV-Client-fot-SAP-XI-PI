package com.test.webdav;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import sardineclient.SardineClient;

import com.sap.engine.services.webservices.espbase.configuration.ann.dt.AuthenticationDT;
import com.sap.engine.services.webservices.espbase.configuration.ann.dt.AuthenticationEnumsAuthenticationLevel;
import com.sap.engine.services.webservices.espbase.configuration.ann.dt.RelMessagingNW05DTOperation;
import com.sap.engine.services.webservices.espbase.configuration.ann.dt.SessionHandlingDT;
import com.sap.engine.services.webservices.espbase.configuration.ann.dt.TransportGuaranteeDT;
import com.sap.engine.services.webservices.espbase.configuration.ann.dt.TransportGuaranteeEnumsLevel;

@SessionHandlingDT(enableSession = false)
@AuthenticationDT(authenticationLevel = AuthenticationEnumsAuthenticationLevel.BASIC)
@TransportGuaranteeDT(level = TransportGuaranteeEnumsLevel.NONE)
@WebService(portName = "SI_WebDAV_SI_Port", serviceName = "SI_WebDAV_SI_Service", endpointInterface = "com.test.webdav.SIWebDAVSI", targetNamespace = "http://test.com/WebDAV", wsdlLocation = "META-INF/wsdl/com/test/webdav/SI_WebDAV_SI/SI_WebDAV_SI.wsdl")
@Stateless
public class SIWebDAVSIImplBean {

	@RelMessagingNW05DTOperation(enableWSRM = false)
	public com.test.webdav.DTWebDAVResp siWebDAVSI(com.test.webdav.DTWebDAV MT_WebDAV) throws com.test.webdav.FMFault_Exception {
		DTWebDAVResp response = new DTWebDAVResp();
		SardineClient webDAWServer = new SardineClient();
		try {
			response = webDAWServer.execute(MT_WebDAV, response);
        } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        } catch (ParserConfigurationException e) {
	        e.printStackTrace();
        } catch (SAXException e) {
	        e.printStackTrace();
        }
		return response;
	}
}