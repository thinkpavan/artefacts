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

package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.QNameHelper;

public abstract class JavaStringHolderEx extends JavaStringHolder
{
    private SchemaType _schemaType;

    public SchemaType schemaType()
        { return _schemaType; }

    public JavaStringHolderEx(SchemaType type, boolean complex)
        { _schemaType = type; initComplexType(complex, false); }

    protected int get_wscanon_rule()
    {
        return schemaType().getWhiteSpaceRule();
    }

    protected void set_text(String s)
    {
        if (_validateOnSet())
            validateLexical(s, _schemaType, _voorVc);
                 
        super.set_text(s);
    }

    protected boolean is_defaultable_ws(String v) {
        try {
            validateLexical(v, _schemaType, _voorVc);
            return false;
        }
        catch (XmlValueOutOfRangeException e) {
            return true;
        }
    }

    public static void validateLexical(String v, SchemaType sType, ValidationContext context)
    {
        // check against pattern
        if (!sType.matchPatternFacet(v))
        {
            context.invalid( "String: '" + v + "' does not match pattern for " + QNameHelper.readable(sType));
            return;
        }

        // check against length
        XmlObject len = sType.getFacet(SchemaType.FACET_LENGTH);
        if (len != null)
        {
            int m = ((XmlObjectBase)len).bigIntegerValue().intValue();
            if (v.length() != m)
            {
                context.invalid(
                    "String length (" + v.length() + ") does not match " +
                        "length facet (" + m + ") for " + QNameHelper.readable(sType));
                return;
            }
        }

        // check against min length
        XmlObject min = sType.getFacet(SchemaType.FACET_MIN_LENGTH);
        if (min != null)
        {
            int m = ((XmlObjectBase)min).bigIntegerValue().intValue();
            if (v.length() < m)
            {
                context.invalid(
                    "String length (" + v.length() + ") is less than " +
                        "min length facet (" + m + ") for " + QNameHelper.readable(sType));
                return;
            }
        }

        // check against min length
        XmlObject max = sType.getFacet(SchemaType.FACET_MAX_LENGTH);
        if (max != null)
        {
            int m = ((XmlObjectBase)max).bigIntegerValue().intValue();
            if (v.length() > m)
            {
                context.invalid(
                    "String length (" + v.length() + ") is greater than " +
                        "max length facet (" + m + ") for " + QNameHelper.readable(sType));
                return;
            }
        }
    }
    
    protected void validate_simpleval(String lexical, ValidationContext ctx)
    {
        validateLexical(stringValue(), schemaType(), ctx);
    }
    
}
