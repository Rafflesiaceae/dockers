package jenk
// [RUN] groovy % ".."

import groovy.transform.*
import hudson.model.*

import core.*

public class MyCustomException extends Exception {MyCustomException(String msg){super(msg)}}

@TupleConstructor
class TestClass implements Serializable {
    String Foo
    Map<String, Integer> Bar = [qwe: 10]
    MestClass mc = new MestClass(Poo: "ewww")

    @TupleConstructor
    static class MestClass implements Serializable {
        String Poo
        List<Integer> Tar = [10, 20, 10, 30]

        @CompileStatic
        def pay(forever = false) {
            // def out = hudson.model.getBinding().out;
            // while (forever) {
            for (def i = 0; i < 2; i++) {
                if (i == 1) {
                    throw new MyCustomException("wat")
                }
                sleep(1 * 1000)
            }
        }

    }

    // @CompileStatic
    // static def fromJson(String str) {
    //     return new TestClass(Json.fromJson(str))
    // }

    @CompileStatic
    def yay(forever = false) {
        // def out = hudson.model.getBinding().out;
        // while (forever) {
        for (def i = 0; i < 5; i++) {
            sleep(1 * 1000)
            Bar.qwe += 1
            // println(Bar.dump())
            // "notify-send info ${Bar.dump()}".execute()
            // out.println("${Bar.dump()}")
        }
        mc.pay()
    }

    int sum(int n1, int n2) {
        echo "$n1 + $n2 = ${n1 + n2}"
        return n1 + n2
    }

    static void main(String... args) {
        def tc = new TestClass()
        println("${tc.dump()} ${tc.mc.dump()}")
        def mtc = new TestClass.MestClass()
        println("${mtc.dump()}")
    }
}
