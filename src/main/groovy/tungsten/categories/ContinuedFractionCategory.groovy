/*
 * The MIT License
 *
 * Copyright © 2025 Robert Poole <Tarquin.AZ@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package tungsten.categories

import org.codehaus.groovy.runtime.StringGroovyMethods
import tungsten.types.numerics.impl.ContinuedFraction
import tungsten.types.numerics.impl.RealImpl

class ContinuedFractionCategory {
    static def asType(List self, Class clazz) {
        final def conversion = List.&asType
        if (clazz == ContinuedFraction) {
            def longList = []
            for (def element : self) {
                longList << element as Long
            }
            return new ContinuedFraction(longList)
        }
        return conversion(self, clazz)
    }

    static def asType(String self, Class clazz) {
        final def conversion = StringGroovyMethods.&asType
        if (clazz == ContinuedFraction) {
            return new ContinuedFraction(self)
        }
        return conversion(self, clazz)
    }

    static def asType(ContinuedFraction self, Class clazz) {
        final def conversion = ContinuedFraction.&asType
        if (clazz == List) {
            if (self.terms() < 0L) throw new IllegalArgumentException("Continued fraction does not terminate")
            def result = []
            for (Long term : self) {
                result << term
            }
            return result
        }
        return conversion(self, clazz)
    }

    /*
     Enhancements for Number
     */

    static def plus(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(self.toLong())
            return converted.add(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.add(operand)
    }

    static def minus(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(self.toLong())
            return converted.subtract(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.subtract(operand)
    }

    static def multiply(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(self.toLong())
            return converted.multiply(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.multiply(operand)
    }

    static def div(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(self.toLong())
            return converted.divide(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.divide(operand)
    }

    /*
     Enhancements to ContinuedFraction
     */

    static def plus(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(operand.toLong())
            return self.add(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.add(cf)
    }

    static def minus(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(operand.toLong())
            return self.subtract(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.subtract(cf)
    }

    static def multiply(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(operand.toLong())
            return self.multiply(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.multiply(cf)
    }

    static def div(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(operand.toLong())
            return self.divide(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.divide(cf)
    }
}
