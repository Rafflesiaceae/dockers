package core

import groovy.transform.*
import groovy.json.*

@Field
static private JsonSlurper slurper = new JsonSlurper()

// @Field
// static private JsonBuilder builder = new JsonBuilder()

@CompileStatic
static def to(Object obj) {
    JsonOutput.toJson(obj)
}

@CompileStatic
static def from(Class clazz, String str) {
    return clazz.newInstance(slurper.parseText(str))
}

// println(".......")
// def o = fromJson('{"QWE": 1}')
// println("aaaa ${o.dump()}")
