package tungsten.examples

import tungsten.types.Matrix
import tungsten.types.matrix.impl.BasicMatrix
import tungsten.types.numerics.RealType
import tungsten.types.numerics.impl.RealImpl
import tungsten.types.util.MathUtils

import java.math.MathContext

import static tungsten.types.util.UnicodeTextEffects.formatMatrixForDisplay

String[][] srcEntries = [
        ["6", "18", "3"],
        ["2", "12", "1"],
        ["4", "15", "3"]
]

RealType[][] rSrc = new RealType[3][3]
for (int j = 0; j < srcEntries.length; j++) {  // row
    for (int k = 0; k < srcEntries[0].length; k++) { // column
        rSrc[j][k] = new RealImpl(srcEntries[j][k], MathContext.DECIMAL64)
    }
}

BasicMatrix<RealType> R = new BasicMatrix<>(rSrc)

println "Real matrix R:"
println formatMatrixForDisplay(R, null, null)

List<Matrix<RealType>> results = MathUtils.compactLUdecomposition(R)

println "L is:"
println formatMatrixForDisplay(results[0], null, null)

println "U is:"
println formatMatrixForDisplay(results[1], null, null)

// Matrix multiplication using Groovy operators
println "LU is:"
println formatMatrixForDisplay(results[0] * results[1], null, null)


