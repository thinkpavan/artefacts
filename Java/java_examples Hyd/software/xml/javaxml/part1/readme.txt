javax.xml.parsers   package contains JAXP API.

For SAX parser we use SAXParserFactory and
for DOM complaint Document object we use DocumentBuilderFactory.

There can be a variety of SAX and DOM implementation.

We can choose the implementation by setting 
javax.xml.parsers.SAXParserFactory

and

javax.xml.parsers.DocumentBuilderFactory  system properties.

org.w3c.dom and org.xml.sax  are api's for sax and dom parsers.


To compile you can use javac source.java.

To run we can use java classname.

If you are use older version of java you need to include the jar files as
part of the class path.

we can use D"java.endorsed.dirs=c:\j2ee\lib\endorsed" property to
specify the location of endorsed library.