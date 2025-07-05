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

    /*
     Enhancements for Number
     */

    static def plus(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(self.toLong()))
            return converted.add(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.add(operand)
    }

    static def minus(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(self.toLong()))
            return converted.subtract(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.subtract(operand)
    }

    static def multiply(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(self.toLong()))
            return converted.multiply(operand)
        }
        def decConverted = self.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, operand.getMathContext(), false))
        return cf.multiply(operand)
    }

    static def div(Number self, ContinuedFraction operand) {
        if (self instanceof Integer || self instanceof Long || self instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(self.toLong()))
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
            ContinuedFraction converted = new ContinuedFraction(List.of(operand.toLong()))
            return self.add(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.add(cf)
    }

    static def minus(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(operand.toLong()))
            return self.subtract(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.subtract(cf)
    }

    static def multiply(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(operand.toLong()))
            return self.multiply(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.multiply(cf)
    }

    static def div(ContinuedFraction self, Number operand) {
        if (operand instanceof Integer || operand instanceof Long || operand instanceof BigInteger) {
            ContinuedFraction converted = new ContinuedFraction(List.of(operand.toLong()))
            return self.divide(converted)
        }
        def decConverted = operand.toBigDecimal()
        ContinuedFraction cf = new ContinuedFraction(new RealImpl(decConverted, self.getMathContext(), false))
        return self.divide(cf)
    }
}
