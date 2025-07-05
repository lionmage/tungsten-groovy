package tungsten.categories

import tungsten.types.numerics.impl.ContinuedFraction

class ContinuedFractionCategory {
    static def asType(List self, Class clazz) {
        final  def conversion = List.&asType
        if (clazz == ContinuedFraction) {
            def longList = []
            for (def element : self) {
                longList << element as Long
            }
            return new ContinuedFraction(longList)
        }
        return conversion(self, clazz)
    }
}
