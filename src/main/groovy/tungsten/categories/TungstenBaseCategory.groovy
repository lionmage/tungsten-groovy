/*
 * The MIT License
 *
 * Copyright © 2023 Robert Poole <Tarquin.AZ@gmail.com>.
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
 */
package tungsten.categories

import tungsten.types.Numeric
import tungsten.types.numerics.IntegerType
import tungsten.types.numerics.RealType
import tungsten.types.numerics.impl.IntegerImpl
import tungsten.types.numerics.impl.RealImpl
import tungsten.types.util.MathUtils

import java.math.MathContext

class TungstenBaseCategory {
    // enhancing BigDecimal
    static def plus(BigDecimal self, Numeric operand) {
        return new RealImpl(self, operand.getMathContext()).add(operand)
    }
    static def minus(BigDecimal self, Numeric operand) {
        return new RealImpl(self, operand.getMathContext()).subtract(operand)
    }
    static def multiply(BigDecimal self, Numeric operand) {
        return new RealImpl(self, operand.getMathContext()).multiply(operand)
    }
    static def div(BigDecimal self, Numeric operand) {
        return new RealImpl(self, operand.getMathContext()).divide(operand)
    }
    static def power(BigDecimal self, Numeric operand) {
        if (operand instanceof IntegerType) {
            int exponent = ((IntegerType) operand).asBigInteger().intValueExact()
            return new RealImpl(self.pow(exponent), MathContext.DECIMAL128)
        }
        return MathUtils.generalizedExponent(new RealImpl(self), operand, operand.getMathContext())
    }
    // enhancing BigInteger
    static def plus(BigInteger self, Numeric operand) {
        return new IntegerImpl(self).add(operand)
    }
    static def minus(BigInteger self, Numeric operand) {
        return new IntegerImpl(self).subtract(operand)
    }
    static def multiply(BigInteger self, Numeric operand) {
        return new IntegerImpl(self).multiply(operand)
    }
    static def div(BigInteger self, Numeric operand) {
        return new IntegerImpl(self).divide(operand)
    }
    static def mod(BigInteger self, IntegerType operand) {
        return new IntegerImpl(self).modulus(operand)
    }
    static def power(BigInteger self, Numeric operand) {
        if (operand instanceof IntegerType) {
            int exponent = ((IntegerType) operand).asBigInteger().intValueExact()
            return new IntegerImpl(self.pow(exponent))
        }
        RealType upconverted = new RealImpl(new BigDecimal(self))
        return MathUtils.generalizedExponent(upconverted, operand, operand.getMathContext())
    }
    // enhancing MathContext
    static def plus(MathContext self, Number operand) {
        return new MathContext(self.precision + operand.intValue(), self.roundingMode)
    }
    static def minus(MathContext self, Number operand) {
        return new MathContext(self.precision - operand.intValue(), self.roundingMode)
    }
    static def next(MathContext self) {
        return new MathContext(self.precision + 1, self.roundingMode)
    }
    static def previous(MathContext self) {
        return new MathContext(self.precision - 1, self.roundingMode)
    }
    static def plus(MathContext self, IntegerType operand) {
        int increment = operand.asBigInteger().intValueExact()
        return new MathContext(self.precision + increment, self.roundingMode)
    }
    static def minus(MathContext self, IntegerType operand) {
        int decrement = operand.asBigInteger().intValueExact()
        return new MathContext(self.precision - decrement, self.roundingMode)
    }
}
