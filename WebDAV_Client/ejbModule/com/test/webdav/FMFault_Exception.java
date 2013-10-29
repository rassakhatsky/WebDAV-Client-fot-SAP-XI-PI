package com.test.webdav;

/**
 * Exception class for service fault.
 */
@javax.xml.ws.WebFault(name = "FM_Fault", targetNamespace = "http://test.com/WebDAV", faultBean = "com.test.webdav.FMFault")
public class FMFault_Exception extends java.lang.Exception {

	private final com.test.webdav.FMFault _FMFault_Exception;

	public FMFault_Exception(final String message, final com.test.webdav.FMFault faultInfo) {
		super(message);
		this._FMFault_Exception = faultInfo;
	}

	public FMFault_Exception(final String message, final com.test.webdav.FMFault faultInfo, final Throwable cause) {
		super(message, cause);
		this._FMFault_Exception = faultInfo;
	}

	public com.test.webdav.FMFault getFaultInfo() {
		return this._FMFault_Exception;
	}

}
