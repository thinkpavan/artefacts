When a programmer wants to use xml in his program he need to either
develop his own parser( software that seperates the xml doc into
tokens which can be processed by the program , which is very tedious)
or use a pre-existing parser.

For java we have several parsers (set of classes and interfaces)
available in the market. Javasoft has defined an JAXP (java api for
xml parsing) for manuplating xml data).


Note: to run these examples include jaxp.jar and parser.jar in the classpath.

javax.xml.parsers is JAXP API.

It contains two vendor neutral parsers 

1) SAXParserFactory.

2) DocumentBuilderFactory.
