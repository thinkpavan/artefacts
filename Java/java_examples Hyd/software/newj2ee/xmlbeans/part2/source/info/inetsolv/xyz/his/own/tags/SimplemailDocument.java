/*
 * An XML document type.
 * Localname: simplemail
 * Namespace: http://xyz.inetsolv.info/his/own/tags
 * Java type: info.inetsolv.xyz.his.own.tags.SimplemailDocument
 *
 * Automatically generated - do not modify.
 */
package info.inetsolv.xyz.his.own.tags;


/**
 * A document containing one simplemail(@http://xyz.inetsolv.info/his/own/tags) element.
 *
 * This is a complex type.
 */
public interface SimplemailDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.s3949E174FE493802CFFC772AEA4E358E.TypeSystemHolder.typeSystem.resolveHandle("simplemail3315doctype");
    
    /**
     * Gets the "simplemail" element
     */
    info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail getSimplemail();
    
    /**
     * Sets the "simplemail" element
     */
    void setSimplemail(info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail simplemail);
    
    /**
     * Appends and returns a new empty "simplemail" element
     */
    info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail addNewSimplemail();
    
    /**
     * An XML simplemail(@http://xyz.inetsolv.info/his/own/tags).
     *
     * This is a complex type.
     */
    public interface Simplemail extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.s3949E174FE493802CFFC772AEA4E358E.TypeSystemHolder.typeSystem.resolveHandle("simplemail5df0elemtype");
        
        /**
         * Gets the "to" element
         */
        java.lang.String getTo();
        
        /**
         * Gets (as xml) the "to" element
         */
        org.apache.xmlbeans.XmlString xgetTo();
        
        /**
         * Sets the "to" element
         */
        void setTo(java.lang.String to);
        
        /**
         * Sets (as xml) the "to" element
         */
        void xsetTo(org.apache.xmlbeans.XmlString to);
        
        /**
         * Gets the "from" element
         */
        java.lang.String getFrom();
        
        /**
         * Gets (as xml) the "from" element
         */
        org.apache.xmlbeans.XmlString xgetFrom();
        
        /**
         * Sets the "from" element
         */
        void setFrom(java.lang.String from);
        
        /**
         * Sets (as xml) the "from" element
         */
        void xsetFrom(org.apache.xmlbeans.XmlString from);
        
        /**
         * Gets the "subject" element
         */
        java.lang.String getSubject();
        
        /**
         * Gets (as xml) the "subject" element
         */
        org.apache.xmlbeans.XmlString xgetSubject();
        
        /**
         * Sets the "subject" element
         */
        void setSubject(java.lang.String subject);
        
        /**
         * Sets (as xml) the "subject" element
         */
        void xsetSubject(org.apache.xmlbeans.XmlString subject);
        
        /**
         * Gets the "content" element
         */
        java.lang.String getContent();
        
        /**
         * Gets (as xml) the "content" element
         */
        org.apache.xmlbeans.XmlString xgetContent();
        
        /**
         * Sets the "content" element
         */
        void setContent(java.lang.String content);
        
        /**
         * Sets (as xml) the "content" element
         */
        void xsetContent(org.apache.xmlbeans.XmlString content);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail newInstance() {
              return (info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument newInstance() {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.lang.String s) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( s, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.lang.String s, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( s, type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.io.File f) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( f, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.io.File f, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( f, type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        public static info.inetsolv.xyz.his.own.tags.SimplemailDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (info.inetsolv.xyz.his.own.tags.SimplemailDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
