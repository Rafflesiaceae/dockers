import jenk.TestClass
import core.Json

def call() {
    def tc = new TestClass()
    tc.Foo = "answer this question"
    sh '$BUILD_ENV/default-build.sh'
    sh "echo `date`"
    // tc.yay(true)
    echo "${tc.dump()}"
    // def s = tc.sum(100, 200)

    // def fromjs = TestClass.fromJson('{ "foo": "moo", "mc": { "poo": "hrm" } }')
    def fromjs = Json.from(TestClass, '{ "foo": "moo", "mc": { "poo": "hrm" } }')
    echo "${Json.to(fromjs)}"
    //

    // for (i = 0; i < 10; i++) {
    //     sleep 1
    //     sh "echo ${tc.Foo}"
    // }
}
