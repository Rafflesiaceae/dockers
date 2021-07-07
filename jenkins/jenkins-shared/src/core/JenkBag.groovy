package core

import groovy.transform.*

// @NonCPS
// @CompileStatic

@CompileStatic
@AutoExternalize
@ToString(includeNames = true, includeFields = true)
@CompileStatic
@AnnotationCollector()
@interface JenkBag { }

// @ToString(includeNames = true, includeFields = true)
// @AutoExternalize
// @TupleConstructor
// @EqualsAndHashCode
