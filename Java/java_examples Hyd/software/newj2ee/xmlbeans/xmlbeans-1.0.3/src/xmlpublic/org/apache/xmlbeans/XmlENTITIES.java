/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.xmlbeans;

import java.util.List;


/**
 * Corresponds to the XML Schema
 * <a target="_blank" href="http://www.w3.org/TR/xmlschema-2/#ENTITIES">xs:ENTITIES</a> type,
 * a list type.
 * <p>
 * A list type.
 */ 
public interface XmlENTITIES extends XmlAnySimpleType
{
    /** The constant {@link SchemaType} object representing this schema type. */
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITIES");
    
    /** Returns the value as a {@link List} of {@link String} values */
    List getListValue();
    /** Returns the value as a {@link List} of {@link XmlENTITY} values **/
    List xgetListValue();
    /** Sets the value as a {@link List} */
    void setListValue(List l);

    /**
     * Returns the value as a {@link List} of {@link String} values
     * @deprecated replaced by {@link #getListValue}
     **/
    List listValue();
    /**
     * Returns the value as a {@link List} of {@link XmlENTITY} values
     * @deprecated replaced by {@link #getListValue}
     **/
    List xlistValue();
    /**
     * Sets the value as a {@link List}
     * @deprecated replaced by {@link #getListValue}
     **/
    void set(List l);

    /**
     * A class with methods for creating instances
     * of {@link XmlENTITIES}.
     */
    public static final class Factory
    {
        /** Creates an empty instance of {@link XmlENTITIES} */
        public static XmlENTITIES newInstance() {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        /** Creates an empty instance of {@link XmlENTITIES} */
        public static XmlENTITIES newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** Creates an immutable {@link XmlENTITIES} value */
        public static XmlENTITIES newValue(Object obj) {
          return (XmlENTITIES) type.newValue( obj ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a String. */
        public static XmlENTITIES parse(java.lang.String s) throws org.apache.xmlbeans.XmlException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( s, type, null ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a String. */
        public static XmlENTITIES parse(java.lang.String s, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( s, type, options ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a File. */
        public static XmlENTITIES parse(java.io.File f) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( f, type, null ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a File. */
        public static XmlENTITIES parse(java.io.File f, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( f, type, options ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a URL. */
        public static XmlENTITIES parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( u, type, null ); }

        /** Parses a {@link XmlENTITIES} fragment from a URL. */
        public static XmlENTITIES parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( u, type, options ); }

        /** Parses a {@link XmlENTITIES} fragment from an InputStream. */
        public static XmlENTITIES parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        /** Parses a {@link XmlENTITIES} fragment from an InputStream. */
        public static XmlENTITIES parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a Reader. */
        public static XmlENTITIES parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a Reader. */
        public static XmlENTITIES parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a DOM Node. */
        public static XmlENTITIES parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        /** Parses a {@link XmlENTITIES} fragment from a DOM Node. */
        public static XmlENTITIES parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** Parses a {@link XmlENTITIES} fragment from an XMLInputStream.
         * @deprecated Superceded by JSR 173 */
        public static XmlENTITIES parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** Parses a {@link XmlENTITIES} fragment from an XMLInputStream.
         * @deprecated Superceded by JSR 173 */
        public static XmlENTITIES parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** Returns a validating XMLInputStream.
         * @deprecated Superceded by JSR 173 */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** Returns a validating XMLInputStream.
         * @deprecated Superceded by JSR 173 */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

