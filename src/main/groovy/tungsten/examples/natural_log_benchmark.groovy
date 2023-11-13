package tungsten.examples

import tungsten.types.numerics.IntegerType
import tungsten.types.numerics.RealType
import tungsten.types.numerics.impl.IntegerImpl
import tungsten.types.numerics.impl.RealImpl
import tungsten.types.util.MathUtils

import java.math.MathContext

RealType fiftyGrand = new RealImpl(50000.0, MathContext.DECIMAL64)
IntegerType fiftyGrandInt = new IntegerImpl("50000")

println "Computing ln with real argument"
long begin = System.currentTimeMillis()
println MathUtils.ln(fiftyGrand)
long end = System.currentTimeMillis()
println "Time elapsed: " + (end - begin) + "\u2009ms"

println "Computing ln with integer argument"
begin = System.currentTimeMillis()
println MathUtils.ln(fiftyGrandInt, MathContext.DECIMAL64)
end = System.currentTimeMillis()
println "Time elapsed: " + (end - begin) + "\u2009ms"
