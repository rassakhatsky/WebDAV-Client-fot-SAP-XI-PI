package sardineclient;

import com.test.webdav.DTMessage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.test.webdav.DTWebDAVResp.WebDAV;
import java.util.ArrayList;

public class SAXHandler_4_Get extends DefaultHandler {

	private String tagContent;
	private WebDAV xml = new WebDAV();
	private DTMessage message = new DTMessage();

	//Check place
	private boolean index_MT_WebDAV_resp, index_Message, index_Row, index_Record;

	//Level
	private int level_Row;
	private int level_Record;

	//temp
	private ArrayList<String> records = new ArrayList<String>();
	private ArrayList<DTMessage.Row> rows = new ArrayList<DTMessage.Row>();
	private DTMessage.Row row = new DTMessage.Row();

	@Override
	public void startDocument() throws SAXException {
		level_Record = 0;
		level_Row = 0;
		index_MT_WebDAV_resp = false;
		index_Message = false;
		index_Row = false;
		index_Record = false;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if (qName.indexOf("MT_WebDAV_resp") != -1) {
				index_MT_WebDAV_resp = true;
			}
			if (qName.indexOf("Message") != -1) {
				index_Message = true;
			}
			if (qName.indexOf("Row") != -1) {
				index_Row = true;
			}
			if (qName.indexOf("Record") != -1) {
				index_Record = true;
			}

		} catch (Exception e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		try {
			if (tagContent == null) {
				tagContent = new String(ch, start, length);
			} else {
				tagContent = new String(ch, start, length);
			}
		} catch (Exception e) {
			throw new SAXException(e);
		}
	}

	@Override
	@SuppressWarnings("empty-statement")
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (index_Record) {
			records.add(level_Record, tagContent);
			index_Record = false;
			level_Record += 1;
		} else {
			if (index_Row) {
				rows.add(new DTMessage.Row());
				rows.get(level_Row).getRecord().addAll(new ArrayList<String>(records));
				records.clear();
				index_Row = false;
				level_Row += 1;
				level_Record = 0;
			} else {
				if (index_Message) {
					message.getRow().addAll(rows);
					index_Message = false;
					level_Row = 0;
				} else {
					if (index_MT_WebDAV_resp) {
						index_MT_WebDAV_resp = false;
					}
				}
			}
		}
	}

	@Override
	public void endDocument() throws SAXException {
		xml.setMessage(message);
	}

	public WebDAV getOutput() {
		return xml;
	}
}
