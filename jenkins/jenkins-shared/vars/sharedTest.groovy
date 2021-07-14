import jenk.TestClass
import core.Json
import groovy.transform.*

@TupleConstructor
class Args {
    String first
    List<String> people
    Integer cats
}

def call(Map _args) {
    def args = new Args(_args)

    sh "echo  ${Json.stringify(args)}"
    def tc = new TestClass()
    tc.Foo = "answer this question"
    sh '$BUILD_ENV/default-build.sh'
    sh "echo `date`"
    // tc.yay(true)
    echo "${tc.dump()}"
    // def s = tc.sum(100, 200)

    // def fromjs = TestClass.fromJson('{ "foo": "moo", "mc": { "poo": "hrm" } }')
    def fromjs = core.Json.parse(TestClass, '{ "foo": "moo", "mc": { "poo": "hrm" } }')
    echo "${Json.stringify(fromjs)}"
    echo "end-sharedTest"
    //

    // for (i = 0; i < 10; i++) {
    //     sleep 1
    //     sh "echo ${tc.Foo}"
    // }
}
