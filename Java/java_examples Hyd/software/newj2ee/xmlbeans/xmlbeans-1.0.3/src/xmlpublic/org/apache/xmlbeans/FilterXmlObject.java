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

import org.apache.xmlbeans.xml.stream.XMLInputStream;

import java.io.InputStream;
import java.io.Reader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

import javax.xml.namespace.QName;

/**
 * A FilterXmlObject delegates to some other XmlObject, which it can use as
 * its basic source of data, possibly transforming the data along the way or
 * providing additional functionality. The class FilterXmlObject itself
 * simply overrides all methods of XmlObject with versions that pass all
 * requests to the underlying XmlObject. Subclasses of FilterXmlObject may
 * further override some of these methods and may also provide additional
 * methods and fields.
 * <p>
 * Note: it is important that FilterXmlOBject has no storage (i.e., no
 * non-transient fields), because subclasses may be serializable and
 * adding storage would break the serialization format.
 */ 
public abstract class FilterXmlObject implements XmlObject, SimpleValue
{
    /**
     * This abstract method is called to obtain the underlying XmlObject.
     * Override this method to supply or compute the wrapped object.
     * <p>
     * Every other method of this class delegates to the object returned
     * from this method. It is assumed that the object implements all the
     * methods of both XmlObject and SimpleValue.
     */ 
    public abstract XmlObject underlyingXmlObject();

    public SchemaType schemaType()
    {
        return underlyingXmlObject().schemaType();
    }

    public boolean validate()
    {
        return underlyingXmlObject().validate();
    }

    public boolean validate(XmlOptions options)
    {
        return underlyingXmlObject().validate(options);
    }

    public XmlObject[] selectPath(String path)
    {
        return underlyingXmlObject().selectPath(path);
    }

    public XmlObject[] selectPath(String path, XmlOptions options)
    {
        return underlyingXmlObject().selectPath(path, options);
    }

    public XmlObject[] execQuery(String query)
    {
        return underlyingXmlObject().execQuery(query);
    }

    public XmlObject[] execQuery(String query, XmlOptions options)
    {
        return underlyingXmlObject().execQuery(query, options);
    }

    public XmlObject changeType(SchemaType newType)
    {
        return underlyingXmlObject().changeType(newType);
    }

    public boolean isNil()
    {
        return underlyingXmlObject().isNil();
    }

    public void setNil()
    {
        underlyingXmlObject().setNil();
    }

    public boolean isImmutable()
    {
        return underlyingXmlObject().isImmutable();
    }

    public XmlObject set(XmlObject srcObj)
    {
        return underlyingXmlObject().set(srcObj);
    }

    public XmlObject copy()
    {
        return underlyingXmlObject().copy();
    }

    public boolean valueEquals(XmlObject obj)
    {
        return underlyingXmlObject().valueEquals(obj);
    }

    public int valueHashCode()
    {
        return underlyingXmlObject().valueHashCode();
    }

    public int compareTo(Object obj)
    {
        return underlyingXmlObject().compareTo(obj);
    }

    public int compareValue(XmlObject obj)
    {
        return underlyingXmlObject().compareValue(obj);
    }

    public Object monitor()
    {
        return underlyingXmlObject().monitor();
    }

    public XmlDocumentProperties documentProperties()
    {
        return underlyingXmlObject().documentProperties();
    }

    public XmlCursor newCursor()
    {
        return underlyingXmlObject().newCursor();
    }

    /**
     * @deprecated Superceded by JSR 173
     */
    public XMLInputStream newXMLInputStream()
    {
        return underlyingXmlObject().newXMLInputStream();
    }

    public String xmlText()
    {
        return underlyingXmlObject().xmlText();
    }

    public InputStream newInputStream()
    {
        return underlyingXmlObject().newInputStream();
    }

    public Reader newReader()
    {
        return underlyingXmlObject().newReader();
    }

    public Node newDomNode()
    {
        return underlyingXmlObject().newDomNode();
    }

    public void save(ContentHandler ch, LexicalHandler lh) throws SAXException
    {
        underlyingXmlObject().save(ch, lh);
    }

    public void save(File file) throws IOException
    {
        underlyingXmlObject().save(file);
    }

    public void save(OutputStream os) throws IOException
    {
        underlyingXmlObject().save(os);
    }

    public void save(Writer w) throws IOException
    {
        underlyingXmlObject().save(w);
    }

    /**
     * @deprecated Superceded by JSR 173
     */
    public XMLInputStream newXMLInputStream(XmlOptions options)
    {
        return underlyingXmlObject().newXMLInputStream(options);
    }

    public String xmlText(XmlOptions options)
    {
        return underlyingXmlObject().xmlText(options);
    }

    public InputStream newInputStream(XmlOptions options)
    {
        return underlyingXmlObject().newInputStream(options);
    }

    public Reader newReader(XmlOptions options)
    {
        return underlyingXmlObject().newReader(options);
    }

    public Node newDomNode(XmlOptions options)
    {
        return underlyingXmlObject().newDomNode(options);
    }

    public void save(ContentHandler ch, LexicalHandler lh, XmlOptions options) throws SAXException
    {
        underlyingXmlObject().save(ch, lh, options);
    }

    public void save(File file, XmlOptions options) throws IOException
    {
        underlyingXmlObject().save(file, options);
    }

    public void save(OutputStream os, XmlOptions options) throws IOException
    {
        underlyingXmlObject().save(os, options);
    }

    public void save(Writer w, XmlOptions options) throws IOException
    {
        underlyingXmlObject().save(w, options);
    }

    public SchemaType instanceType()
    {
        return ((SimpleValue)underlyingXmlObject()).instanceType();
    }

    public String stringValue()
    {
        return ((SimpleValue)underlyingXmlObject()).stringValue();
    }

    public boolean booleanValue()
    {
        return ((SimpleValue)underlyingXmlObject()).booleanValue();
    }

    public byte byteValue()
    {
        return ((SimpleValue)underlyingXmlObject()).byteValue();
    }

    public short shortValue()
    {
        return ((SimpleValue)underlyingXmlObject()).shortValue();
    }

    public int intValue()
    {
        return ((SimpleValue)underlyingXmlObject()).intValue();
    }

    public long longValue()
    {
        return ((SimpleValue)underlyingXmlObject()).longValue();
    }

    public BigInteger bigIntegerValue()
    {
        return ((SimpleValue)underlyingXmlObject()).bigIntegerValue();
    }

    public BigDecimal bigDecimalValue()
    {
        return ((SimpleValue)underlyingXmlObject()).bigDecimalValue();
    }

    public float floatValue()
    {
        return ((SimpleValue)underlyingXmlObject()).floatValue();
    }

    public double doubleValue()
    {
        return ((SimpleValue)underlyingXmlObject()).doubleValue();
    }

    public byte[] byteArrayValue()
    {
        return ((SimpleValue)underlyingXmlObject()).byteArrayValue();
    }

    public StringEnumAbstractBase enumValue()
    {
        return ((SimpleValue)underlyingXmlObject()).enumValue();
    }

    public Calendar calendarValue()
    {
        return ((SimpleValue)underlyingXmlObject()).calendarValue();
    }

    public Date dateValue()
    {
        return ((SimpleValue)underlyingXmlObject()).dateValue();
    }

    public GDate gDateValue()
    {
        return ((SimpleValue)underlyingXmlObject()).gDateValue();
    }

    public GDuration gDurationValue()
    {
        return ((SimpleValue)underlyingXmlObject()).gDurationValue();
    }

    public QName qNameValue()
    {
        return ((SimpleValue)underlyingXmlObject()).qNameValue();
    }

    public List listValue()
    {
        return ((SimpleValue)underlyingXmlObject()).listValue();
    }

    public List xlistValue()
    {
        return ((SimpleValue)underlyingXmlObject()).xlistValue();
    }

    public Object objectValue()
    {
        return ((SimpleValue)underlyingXmlObject()).objectValue();
    }

    public void set(String obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(boolean v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(byte v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(short v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(int v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(long v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(BigInteger obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(BigDecimal obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(float v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(double v)
    {
        ((SimpleValue)underlyingXmlObject()).set(v);
    }

    public void set(byte[] obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(StringEnumAbstractBase obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(Calendar obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(Date obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(GDateSpecification obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(GDurationSpecification obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(QName obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public void set(List obj)
    {
        ((SimpleValue)underlyingXmlObject()).set(obj);
    }

    public String getStringValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getStringValue();
    }

    public boolean getBooleanValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getBooleanValue();
    }

    public byte getByteValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getByteValue();
    }

    public short getShortValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getShortValue();
    }

    public int getIntValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getIntValue();
    }

    public long getLongValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getLongValue();
    }

    public BigInteger getBigIntegerValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getBigIntegerValue();
    }

    public BigDecimal getBigDecimalValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getBigDecimalValue();
    }

    public float getFloatValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getFloatValue();
    }

    public double getDoubleValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getDoubleValue();
    }

    public byte[] getByteArrayValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getByteArrayValue();
    }

    public StringEnumAbstractBase getEnumValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getEnumValue();
    }

    public Calendar getCalendarValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getCalendarValue();
    }

    public Date getDateValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getDateValue();
    }

    public GDate getGDateValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getGDateValue();
    }

    public GDuration getGDurationValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getGDurationValue();
    }

    public QName getQNameValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getQNameValue();
    }

    public List getListValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getListValue();
    }

    public List xgetListValue()
    {
        return ((SimpleValue)underlyingXmlObject()).xgetListValue();
    }

    public Object getObjectValue()
    {
        return ((SimpleValue)underlyingXmlObject()).getObjectValue();
    }

    public void setStringValue(String obj)
    {
        ((SimpleValue)underlyingXmlObject()).setStringValue(obj);
    }

    public void setBooleanValue(boolean v)
    {
        ((SimpleValue)underlyingXmlObject()).setBooleanValue(v);
    }

    public void setByteValue(byte v)
    {
        ((SimpleValue)underlyingXmlObject()).setByteValue(v);
    }

    public void setShortValue(short v)
    {
        ((SimpleValue)underlyingXmlObject()).setShortValue(v);
    }

    public void setIntValue(int v)
    {
        ((SimpleValue)underlyingXmlObject()).setIntValue(v);
    }

    public void setLongValue(long v)
    {
        ((SimpleValue)underlyingXmlObject()).setLongValue(v);
    }

    public void setBigIntegerValue(BigInteger obj)
    {
        ((SimpleValue)underlyingXmlObject()).setBigIntegerValue(obj);
    }

    public void setBigDecimalValue(BigDecimal obj)
    {
        ((SimpleValue)underlyingXmlObject()).setBigDecimalValue(obj);
    }

    public void setFloatValue(float v)
    {
        ((SimpleValue)underlyingXmlObject()).setFloatValue(v);
    }

    public void setDoubleValue(double v)
    {
        ((SimpleValue)underlyingXmlObject()).setDoubleValue(v);
    }

    public void setByteArrayValue(byte[] obj)
    {
        ((SimpleValue)underlyingXmlObject()).setByteArrayValue(obj);
    }

    public void setEnumValue(StringEnumAbstractBase obj)
    {
        ((SimpleValue)underlyingXmlObject()).setEnumValue(obj);
    }

    public void setCalendarValue(Calendar obj)
    {
        ((SimpleValue)underlyingXmlObject()).setCalendarValue(obj);
    }

    public void setDateValue(Date obj)
    {
        ((SimpleValue)underlyingXmlObject()).setDateValue(obj);
    }

    public void setGDateValue(GDate obj)
    {
        ((SimpleValue)underlyingXmlObject()).setGDateValue(obj);
    }

    public void setGDurationValue(GDuration obj)
    {
        ((SimpleValue)underlyingXmlObject()).setGDurationValue(obj);
    }

    public void setQNameValue(QName obj)
    {
        ((SimpleValue)underlyingXmlObject()).setQNameValue(obj);
    }

    public void setListValue(List obj)
    {
        ((SimpleValue)underlyingXmlObject()).setListValue(obj);
    }

    public void setObjectValue(Object obj)
    {
        ((SimpleValue)underlyingXmlObject()).setObjectValue(obj);
    }

    public void objectSet(Object obj)
    {
        ((SimpleValue)underlyingXmlObject()).objectSet(obj);
    }
}
