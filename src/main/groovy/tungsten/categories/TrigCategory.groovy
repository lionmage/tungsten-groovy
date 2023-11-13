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

import tungsten.types.numerics.RealType
import tungsten.types.numerics.impl.RealImpl
import tungsten.types.util.AngularDegrees

class TrigCategory {
    // enhancing BigDecimal
    static def plus(BigDecimal self, AngularDegrees operand) {
        return new AngularDegrees(new RealImpl(self)).add(operand)
    }
    static def minus(BigDecimal self, AngularDegrees operand) {
        return new AngularDegrees(new RealImpl(self)).subtract(operand)
    }
    static def plus(AngularDegrees self, BigDecimal operand) {
        return self.add(new AngularDegrees(new RealImpl(operand)))
    }
    static def minus(AngularDegrees self, BigDecimal operand) {
        return self.subtract(new AngularDegrees(new RealImpl(operand)))
    }
    // enhancement of Number
    static def plus(Number self, AngularDegrees operand) {
        RealType converted = new RealImpl(BigDecimal.valueOf(self.doubleValue()), false)
        return new AngularDegrees(converted).add(operand)
    }
    static def plus(AngularDegrees self, Number operand) {
        RealType converted = new RealImpl(BigDecimal.valueOf(operand.doubleValue()), false)
        return self.add(new AngularDegrees(converted))
    }
    static def minus(Number self, AngularDegrees operand) {
        RealType converted = new RealImpl(BigDecimal.valueOf(self.doubleValue()), false)
        return new AngularDegrees(converted).subtract(operand)
    }
    static def minus(AngularDegrees self, Number operand) {
        RealType converted = new RealImpl(BigDecimal.valueOf(operand.doubleValue()), false)
        return self.subtract(new AngularDegrees(converted))
    }
}
