/*
 * An XML document type.
 * Localname: simplestudent
 * Namespace: http://www.inetsolv.info/my/tags
 * Java type: info.inetsolv.my.tags.SimplestudentDocument
 *
 * Automatically generated - do not modify.
 */
package info.inetsolv.my.tags.impl;
/**
 * A document containing one simplestudent(@http://www.inetsolv.info/my/tags) element.
 *
 * This is a complex type.
 */
public class SimplestudentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.my.tags.SimplestudentDocument
{
    
    public SimplestudentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SIMPLESTUDENT$0 = 
        new javax.xml.namespace.QName("http://www.inetsolv.info/my/tags", "simplestudent");
    
    
    /**
     * Gets the "simplestudent" element
     */
    public info.inetsolv.my.tags.SimplestudentDocument.Simplestudent getSimplestudent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.my.tags.SimplestudentDocument.Simplestudent target = null;
            target = (info.inetsolv.my.tags.SimplestudentDocument.Simplestudent)get_store().find_element_user(SIMPLESTUDENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "simplestudent" element
     */
    public void setSimplestudent(info.inetsolv.my.tags.SimplestudentDocument.Simplestudent simplestudent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.my.tags.SimplestudentDocument.Simplestudent target = null;
            target = (info.inetsolv.my.tags.SimplestudentDocument.Simplestudent)get_store().find_element_user(SIMPLESTUDENT$0, 0);
            if (target == null)
            {
                target = (info.inetsolv.my.tags.SimplestudentDocument.Simplestudent)get_store().add_element_user(SIMPLESTUDENT$0);
            }
            target.set(simplestudent);
        }
    }
    
    /**
     * Appends and returns a new empty "simplestudent" element
     */
    public info.inetsolv.my.tags.SimplestudentDocument.Simplestudent addNewSimplestudent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            info.inetsolv.my.tags.SimplestudentDocument.Simplestudent target = null;
            target = (info.inetsolv.my.tags.SimplestudentDocument.Simplestudent)get_store().add_element_user(SIMPLESTUDENT$0);
            return target;
        }
    }
    /**
     * An XML simplestudent(@http://www.inetsolv.info/my/tags).
     *
     * This is a complex type.
     */
    public static class SimplestudentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements info.inetsolv.my.tags.SimplestudentDocument.Simplestudent
    {
        
        public SimplestudentImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("http://www.inetsolv.info/my/tags", "name");
        private static final javax.xml.namespace.QName ADDRESS$2 = 
            new javax.xml.namespace.QName("http://www.inetsolv.info/my/tags", "address");
        private static final javax.xml.namespace.QName AGE$4 = 
            new javax.xml.namespace.QName("http://www.inetsolv.info/my/tags", "age");
        private static final javax.xml.namespace.QName FEEPAID$6 = 
            new javax.xml.namespace.QName("http://www.inetsolv.info/my/tags", "fee-paid");
        
        
        /**
         * Gets the "name" element
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" element
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "name" element
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$0);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" element
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$0);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "address" element
         */
        public java.lang.String getAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "address" element
         */
        public org.apache.xmlbeans.XmlString xgetAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "address" element
         */
        public void setAddress(java.lang.String address)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESS$2);
                }
                target.setStringValue(address);
            }
        }
        
        /**
         * Sets (as xml) the "address" element
         */
        public void xsetAddress(org.apache.xmlbeans.XmlString address)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESS$2);
                }
                target.set(address);
            }
        }
        
        /**
         * Gets the "age" element
         */
        public int getAge()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGE$4, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "age" element
         */
        public org.apache.xmlbeans.XmlInt xgetAge()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(AGE$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "age" element
         */
        public void setAge(int age)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AGE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AGE$4);
                }
                target.setIntValue(age);
            }
        }
        
        /**
         * Sets (as xml) the "age" element
         */
        public void xsetAge(org.apache.xmlbeans.XmlInt age)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(AGE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(AGE$4);
                }
                target.set(age);
            }
        }
        
        /**
         * Gets the "fee-paid" element
         */
        public float getFeePaid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEEPAID$6, 0);
                if (target == null)
                {
                    return 0.0f;
                }
                return target.getFloatValue();
            }
        }
        
        /**
         * Gets (as xml) the "fee-paid" element
         */
        public org.apache.xmlbeans.XmlFloat xgetFeePaid()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlFloat target = null;
                target = (org.apache.xmlbeans.XmlFloat)get_store().find_element_user(FEEPAID$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "fee-paid" element
         */
        public void setFeePaid(float feePaid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEEPAID$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FEEPAID$6);
                }
                target.setFloatValue(feePaid);
            }
        }
        
        /**
         * Sets (as xml) the "fee-paid" element
         */
        public void xsetFeePaid(org.apache.xmlbeans.XmlFloat feePaid)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlFloat target = null;
                target = (org.apache.xmlbeans.XmlFloat)get_store().find_element_user(FEEPAID$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlFloat)get_store().add_element_user(FEEPAID$6);
                }
                target.set(feePaid);
            }
        }
    }
}
