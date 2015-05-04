package applet;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Few simple utils to read DOM. This is originally from the Jakarta Commons
 * Modeler.
 * 
 * @author Costin Manolache
 */
public class XMLUtils {
  /**
   * Read XML as DOM.
   */
  public static Document readXml(InputStream is) throws SAXException, IOException,
      ParserConfigurationException {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      dbf.setValidating(false);
      dbf.setIgnoringComments(false);
      dbf.setIgnoringElementContentWhitespace(true);
      dbf.setNamespaceAware(true);
      // dbf.setCoalescing(true);
      // dbf.setExpandEntityReferences(true);

      DocumentBuilder db = null;
      db = dbf.newDocumentBuilder();
      db.setEntityResolver(new NullResolver());

      // db.setErrorHandler( new MyErrorHandler());

      return db.parse(is);
  }
}

class NullResolver implements EntityResolver {
  public InputSource resolveEntity(String publicId, String systemId) throws SAXException,
      IOException {
    return new InputSource(new StringReader(""));
  }
}