/*
 * An XML document type.
 * Localname: simplemail
 * Namespace: http://xyz.inetsolv.info/his/own/tags
 * Java type: info.inetsolv.xyz.his.own.tags.SimplemailDocument
 *
 * Automatically generated - do not modify.
 */
package info.inetsolv.xyz.his.own.tags.impl;
/**
 * A document containing one simplemail(@http://xyz.inetsolv.info/his/own/tags) element.
 *
 * This is a complex type.
 */
public class SimplemailDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.xyz.his.own.tags.SimplemailDocument
{
    
    public SimplemailDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIMPLEMAIL$0 = 
        new javax.xml.namespace.QName("http://xyz.inetsolv.info/his/own/tags", "simplemail");
    
    
    /**
     * Gets the "simplemail" element
     */
    public info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail getSimplemail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail target = null;
            target = (info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail)get_store().find_element_user(SIMPLEMAIL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "simplemail" element
     */
    public void setSimplemail(info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail simplemail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail target = null;
            target = (info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail)get_store().find_element_user(SIMPLEMAIL$0, 0);
            if (target == null)
            {
                target = (info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail)get_store().add_element_user(SIMPLEMAIL$0);
            }
            target.set(simplemail);
        }
    }
    
    /**
     * Appends and returns a new empty "simplemail" element
     */
    public info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail addNewSimplemail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail target = null;
            target = (info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail)get_store().add_element_user(SIMPLEMAIL$0);
            return target;
        }
    }
    /**
     * An XML simplemail(@http://xyz.inetsolv.info/his/own/tags).
     *
     * This is a complex type.
     */
    public static class SimplemailImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.xyz.his.own.tags.SimplemailDocument.Simplemail
    {
        
        public SimplemailImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TO$0 = 
            new javax.xml.namespace.QName("http://xyz.inetsolv.info/his/own/tags", "to");
        private static final javax.xml.namespace.QName FROM$2 = 
            new javax.xml.namespace.QName("http://xyz.inetsolv.info/his/own/tags", "from");
        private static final javax.xml.namespace.QName SUBJECT$4 = 
            new javax.xml.namespace.QName("http://xyz.inetsolv.info/his/own/tags", "subject");
        private static final javax.xml.namespace.QName CONTENT$6 = 
            new javax.xml.namespace.QName("http://xyz.inetsolv.info/his/own/tags", "content");
        
        
        /**
         * Gets the "to" element
         */
        public java.lang.String getTo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TO$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "to" element
         */
        public org.apache.xmlbeans.XmlString xgetTo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TO$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "to" element
         */
        public void setTo(java.lang.String to)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TO$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TO$0);
                }
                target.setStringValue(to);
            }
        }
        
        /**
         * Sets (as xml) the "to" element
         */
        public void xsetTo(org.apache.xmlbeans.XmlString to)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TO$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TO$0);
                }
                target.set(to);
            }
        }
        
        /**
         * Gets the "from" element
         */
        public java.lang.String getFrom()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FROM$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "from" element
         */
        public org.apache.xmlbeans.XmlString xgetFrom()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FROM$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "from" element
         */
        public void setFrom(java.lang.String from)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FROM$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FROM$2);
                }
                target.setStringValue(from);
            }
        }
        
        /**
         * Sets (as xml) the "from" element
         */
        public void xsetFrom(org.apache.xmlbeans.XmlString from)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FROM$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FROM$2);
                }
                target.set(from);
            }
        }
        
        /**
         * Gets the "subject" element
         */
        public java.lang.String getSubject()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBJECT$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "subject" element
         */
        public org.apache.xmlbeans.XmlString xgetSubject()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUBJECT$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "subject" element
         */
        public void setSubject(java.lang.String subject)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUBJECT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUBJECT$4);
                }
                target.setStringValue(subject);
            }
        }
        
        /**
         * Sets (as xml) the "subject" element
         */
        public void xsetSubject(org.apache.xmlbeans.XmlString subject)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SUBJECT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SUBJECT$4);
                }
                target.set(subject);
            }
        }
        
        /**
         * Gets the "content" element
         */
        public java.lang.String getContent()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTENT$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "content" element
         */
        public org.apache.xmlbeans.XmlString xgetContent()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTENT$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "content" element
         */
        public void setContent(java.lang.String content)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTENT$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTENT$6);
                }
                target.setStringValue(content);
            }
        }
        
        /**
         * Sets (as xml) the "content" element
         */
        public void xsetContent(org.apache.xmlbeans.XmlString content)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTENT$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CONTENT$6);
                }
                target.set(content);
            }
        }
    }
}
