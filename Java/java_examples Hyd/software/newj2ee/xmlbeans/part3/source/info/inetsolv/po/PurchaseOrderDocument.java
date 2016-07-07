/*
 * An XML document type.
 * Localname: purchase-order
 * Namespace: http://inetsolv.info/po
 * Java type: info.inetsolv.po.PurchaseOrderDocument
 *
 * Automatically generated - do not modify.
 */
package info.inetsolv.po;


/**
 * A document containing one purchase-order(@http://inetsolv.info/po) element.
 *
 * This is a complex type.
 */
public interface PurchaseOrderDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.s601429713BA5C8ABE578B4B70687AA09.TypeSystemHolder.typeSystem.resolveHandle("purchaseorderf199doctype");
    
    /**
     * Gets the "purchase-order" element
     */
    info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder getPurchaseOrder();
    
    /**
     * Sets the "purchase-order" element
     */
    void setPurchaseOrder(info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder purchaseOrder);
    
    /**
     * Appends and returns a new empty "purchase-order" element
     */
    info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder addNewPurchaseOrder();
    
    /**
     * An XML purchase-order(@http://inetsolv.info/po).
     *
     * This is a complex type.
     */
    public interface PurchaseOrder extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.s601429713BA5C8ABE578B4B70687AA09.TypeSystemHolder.typeSystem.resolveHandle("purchaseorder313belemtype");
        
        /**
         * Gets the "customer" element
         */
        info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer getCustomer();
        
        /**
         * Sets the "customer" element
         */
        void setCustomer(info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer customer);
        
        /**
         * Appends and returns a new empty "customer" element
         */
        info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer addNewCustomer();
        
        /**
         * Gets array of all "line-item" elements
         */
        info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem[] getLineItemArray();
        
        /**
         * Gets ith "line-item" element
         */
        info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem getLineItemArray(int i);
        
        /**
         * Returns number of "line-item" element
         */
        int sizeOfLineItemArray();
        
        /**
         * Sets array of all "line-item" element
         */
        void setLineItemArray(info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem[] lineItemArray);
        
        /**
         * Sets ith "line-item" element
         */
        void setLineItemArray(int i, info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem lineItem);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "line-item" element
         */
        info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem insertNewLineItem(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "line-item" element
         */
        info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem addNewLineItem();
        
        /**
         * Removes the ith "line-item" element
         */
        void removeLineItem(int i);
        
        /**
         * An XML customer(@http://inetsolv.info/po).
         *
         * This is a complex type.
         */
        public interface Customer extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.s601429713BA5C8ABE578B4B70687AA09.TypeSystemHolder.typeSystem.resolveHandle("customer3535elemtype");
            
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
             * Gets the "age" attribute
             */
            int getAge();
            
            /**
             * Gets (as xml) the "age" attribute
             */
            org.apache.xmlbeans.XmlInt xgetAge();
            
            /**
             * True if has "age" attribute
             */
            boolean isSetAge();
            
            /**
             * Sets the "age" attribute
             */
            void setAge(int age);
            
            /**
             * Sets (as xml) the "age" attribute
             */
            void xsetAge(org.apache.xmlbeans.XmlInt age);
            
            /**
             * Unsets the "age" attribute
             */
            void unsetAge();
            
            /**
             * Gets the "sa" attribute
             */
            int getSa();
            
            /**
             * Gets (as xml) the "sa" attribute
             */
            org.apache.xmlbeans.XmlInt xgetSa();
            
            /**
             * True if has "sa" attribute
             */
            boolean isSetSa();
            
            /**
             * Sets the "sa" attribute
             */
            void setSa(int sa);
            
            /**
             * Sets (as xml) the "sa" attribute
             */
            void xsetSa(org.apache.xmlbeans.XmlInt sa);
            
            /**
             * Unsets the "sa" attribute
             */
            void unsetSa();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer newInstance() {
                  return (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.Customer) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML line-item(@http://inetsolv.info/po).
         *
         * This is a complex type.
         */
        public interface LineItem extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schema.system.s601429713BA5C8ABE578B4B70687AA09.TypeSystemHolder.typeSystem.resolveHandle("lineitem82f3elemtype");
            
            /**
             * Gets the "description" element
             */
            java.lang.String getDescription();
            
            /**
             * Gets (as xml) the "description" element
             */
            org.apache.xmlbeans.XmlString xgetDescription();
            
            /**
             * Sets the "description" element
             */
            void setDescription(java.lang.String description);
            
            /**
             * Sets (as xml) the "description" element
             */
            void xsetDescription(org.apache.xmlbeans.XmlString description);
            
            /**
             * Gets the "price" element
             */
            java.math.BigDecimal getPrice();
            
            /**
             * Gets (as xml) the "price" element
             */
            org.apache.xmlbeans.XmlDecimal xgetPrice();
            
            /**
             * Sets the "price" element
             */
            void setPrice(java.math.BigDecimal price);
            
            /**
             * Sets (as xml) the "price" element
             */
            void xsetPrice(org.apache.xmlbeans.XmlDecimal price);
            
            /**
             * Gets the "quantity" element
             */
            java.math.BigInteger getQuantity();
            
            /**
             * Gets (as xml) the "quantity" element
             */
            org.apache.xmlbeans.XmlInteger xgetQuantity();
            
            /**
             * Sets the "quantity" element
             */
            void setQuantity(java.math.BigInteger quantity);
            
            /**
             * Sets (as xml) the "quantity" element
             */
            void xsetQuantity(org.apache.xmlbeans.XmlInteger quantity);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem newInstance() {
                  return (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder.LineItem) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder newInstance() {
              return (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (info.inetsolv.po.PurchaseOrderDocument.PurchaseOrder) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static info.inetsolv.po.PurchaseOrderDocument newInstance() {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.lang.String s) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( s, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.lang.String s, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( s, type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.io.File f) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( f, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.io.File f, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( f, type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        public static info.inetsolv.po.PurchaseOrderDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (info.inetsolv.po.PurchaseOrderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
