package tungsten.examples

import tungsten.types.Matrix
import tungsten.types.Numeric
import tungsten.types.matrix.impl.BasicMatrix
import tungsten.types.numerics.RealType
import tungsten.types.numerics.impl.Pi
import tungsten.types.numerics.impl.RealImpl
import tungsten.types.util.MathUtils
import static tungsten.types.util.UnicodeTextEffects.formatMatrixForDisplay

import java.math.MathContext

RealType zero = new RealImpl("0.00", MathContext.DECIMAL128)
Pi pi = Pi.getInstance(MathContext.DECIMAL128)
RealType[][] sample = [
        [zero, pi.negate()],
        [pi, zero]
]

Matrix<RealType> P = new BasicMatrix<>(sample)

println "Initial matrix:"
println formatMatrixForDisplay(P, null, null)

Matrix<? extends Numeric> R = MathUtils.exp(P)

println "exp of matrix:"
println formatMatrixForDisplay(R, null, null)

