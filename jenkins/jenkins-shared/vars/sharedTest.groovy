import jenk.TestClass

def call() {
    def tc = new TestClass()
    tc.Foo = "answer this question"
    sh '$BUILD_ENV/default-build.sh'
    sh "echo `date`"
    for (i = 0; i < 100; i++) {
        sleep 1
        sh "echo ${tc.Foo}"
    }
}
