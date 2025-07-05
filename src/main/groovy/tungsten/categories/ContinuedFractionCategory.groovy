package tungsten.categories

import org.codehaus.groovy.runtime.StringGroovyMethods
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

    static def asType(String self, Class clazz) {
        final def conversion = StringGroovyMethods.&asType
        if (clazz == ContinuedFraction) {
            return new ContinuedFraction(self)
        }
        return conversion(self, clazz)
    }
}
