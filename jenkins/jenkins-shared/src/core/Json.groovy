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

// @CompileStatic
// static boolean isSerializableAndEquals(Object o, Class clazz) {
//     // Class clazz = o.getClass()

//     // serialize
//     OutputStream baos = new ByteArrayOutputStream();
//     def oos = new ObjectOutputStream(baos)
//     oos << o
//     oos.close()

//     // deserialize
//     InputStream bais = new ByteArrayInputStream(baos.toByteArray());
//     def ois = new ObjectInputStream(bais)
//     def no = ois.readObject().asType(clazz)
//     ois.close()
//     bais.close()

//     return o == no
// }

// println(".......")
// def o = fromJson('{"QWE": 1}')
// println("aaaa ${o.dump()}")

