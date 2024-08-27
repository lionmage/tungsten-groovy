package tungsten.examples

import tungsten.types.Matrix
import tungsten.types.matrix.impl.BasicMatrix
import tungsten.types.numerics.ComplexType
import tungsten.types.numerics.RealType
import tungsten.types.numerics.impl.ComplexRectImpl
import tungsten.types.numerics.impl.Pi
import tungsten.types.numerics.impl.RealImpl
import tungsten.types.util.MathUtils
import tungsten.types.util.UnicodeTextEffects

import java.math.MathContext

Pi pi = Pi.getInstance(MathContext.DECIMAL64)
RealType two = new RealImpl("2", MathContext.DECIMAL64)
RealType three = new RealImpl("3", MathContext.DECIMAL64)
RealType five = new RealImpl("5", MathContext.DECIMAL64)
RealType six = two.multiply(three) as RealType

RealType piOver3 = pi.divide(three) as RealType
RealType twoPiOver3 = two.multiply(piOver3) as RealType

RealType piOver6 = pi.divide(six) as RealType
RealType fivePiOver6 = five.multiply(piOver6) as RealType

ComplexType[][] seed = [[new ComplexRectImpl(twoPiOver3), new ComplexRectImpl(piOver3)],
                        [new ComplexRectImpl(piOver6), new ComplexRectImpl(fivePiOver6)]]

Matrix<ComplexType> A = new BasicMatrix<>(seed)

Matrix<ComplexType> result = MathUtils.sin(A)

println "Source matrix is:"
println UnicodeTextEffects.formatMatrixForDisplay(A, null, null)

println()
println "Result of sin(A) is:"
println UnicodeTextEffects.formatMatrixForDisplay(result, null, null)

Matrix<ComplexType> asin = MathUtils.arcsin(result)

println()
println "Arcsin calculated as:"
println UnicodeTextEffects.formatMatrixForDisplay(asin, null, null)

// sinOfArcsin should be essentially identical with result (above)
Matrix<ComplexType> sinOfArcsin = MathUtils.sin(asin)

println()
println("Sin of arcsin value:")
println UnicodeTextEffects.formatMatrixForDisplay(sinOfArcsin, null, null)
