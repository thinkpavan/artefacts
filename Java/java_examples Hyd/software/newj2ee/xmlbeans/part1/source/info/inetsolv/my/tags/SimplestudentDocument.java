/*
 * An XML document type.
 * Localname: simplestudent
 * Namespace: http://www.inetsolv.info/my/tags
 * Java type: info.inetsolv.my.tags.SimplestudentDocument
 *
 * Automatically generated - do not modify.
 */
package info.inetsolv.my.tags;


/**
 * A document containing one simplestudent(@http://www.inetsolv.info/my/tags) element.
 *
 * This is a complex type.
 */
public interface SimplestudentDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.sAC1F2400FC2BDAE5F86E217236159A9B.TypeSystemHolder.typeSystem.resolveHandle("simplestudent7716doctype");
    
    /**
     * Gets the "simplestudent" element
     */
    info.inetsolv.my.tags.SimplestudentDocument.Simplestudent getSimplestudent();
    
    /**
     * Sets the "simplestudent" element
     */
    void setSimplestudent(info.inetsolv.my.tags.SimplestudentDocument.Simplestudent simplestudent);
    
    /**
     * Appends and returns a new empty "simplestudent" element
     */
    info.inetsolv.my.tags.SimplestudentDocument.Simplestudent addNewSimplestudent();
    
    /**
     * An XML simplestudent(@http://www.inetsolv.info/my/tags).
     *
     * This is a complex type.
     */
    public interface Simplestudent extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.sAC1F2400FC2BDAE5F86E217236159A9B.TypeSystemHolder.typeSystem.resolveHandle("simplestudent1901elemtype");
        
        /**
         * Gets the "name" element
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "name" element
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "name" element
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" element
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Gets the "address" element
         */
        java.lang.String getAddress();
        
        /**
         * Gets (as xml) the "address" element
         */
        org.apache.xmlbeans.XmlString xgetAddress();
        
        /**
         * Sets the "address" element
         */
        void setAddress(java.lang.String address);
        
        /**
         * Sets (as xml) the "address" element
         */
        void xsetAddress(org.apache.xmlbeans.XmlString address);
        
        /**
         * Gets the "age" element
         */
        int getAge();
        
        /**
         * Gets (as xml) the "age" element
         */
        org.apache.xmlbeans.XmlInt xgetAge();
        
        /**
         * Sets the "age" element
         */
        void setAge(int age);
        
        /**
         * Sets (as xml) the "age" element
         */
        void xsetAge(org.apache.xmlbeans.XmlInt age);
        
        /**
         * Gets the "fee-paid" element
         */
        float getFeePaid();
        
        /**
         * Gets (as xml) the "fee-paid" element
         */
        org.apache.xmlbeans.XmlFloat xgetFeePaid();
        
        /**
         * Sets the "fee-paid" element
         */
        void setFeePaid(float feePaid);
        
        /**
         * Sets (as xml) the "fee-paid" element
         */
        void xsetFeePaid(org.apache.xmlbeans.XmlFloat feePaid);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static info.inetsolv.my.tags.SimplestudentDocument.Simplestudent newInstance() {
              return (info.inetsolv.my.tags.SimplestudentDocument.Simplestudent) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static info.inetsolv.my.tags.SimplestudentDocument.Simplestudent newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (info.inetsolv.my.tags.SimplestudentDocument.Simplestudent) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static info.inetsolv.my.tags.SimplestudentDocument newInstance() {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.lang.String s) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( s, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.lang.String s, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( s, type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.io.File f) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( f, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.io.File f, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( f, type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        public static info.inetsolv.my.tags.SimplestudentDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (info.inetsolv.my.tags.SimplestudentDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
