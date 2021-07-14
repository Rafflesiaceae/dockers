package core

import groovy.transform.*
import groovy.json.*

@Field
static private JsonSlurper slurper = new JsonSlurper()

@CompileStatic
static def stringify(Object obj) {
    JsonOutput.toJson(obj)
}

@CompileStatic
static def parse(String str, Class clazz) {
    return clazz.newInstance(slurper.parseText(str))
}

// println(".......")
// def o = fromJson('{"QWE": 1}')
// println("aaaa ${o.dump()}")

