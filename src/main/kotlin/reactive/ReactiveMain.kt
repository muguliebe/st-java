package demo.reactive

import rx.Observable
import rx.Subscriber
import java.util.concurrent.Executors

class ReactiveMain

fun main(args: Array<String>) {

    //==============================================================================
    val observerImpl = Observable.OnSubscribe<String> { t ->
        t.onNext("Hello")
        t.onCompleted()
    }

    val observable = Observable.create(observerImpl)
            .subscribe(System.out::println,
                    System.err::println
            ) { println("Done") }

    val subscriber = object : Subscriber<String>() {
        override fun onNext(s: String) {
            println(s)
        }

        override fun onCompleted() {
            println("Done!")
        }

        override fun onError(e: Throwable) {
            System.err.println(e)
        }
    }

//    observable.subscribe(subscriber)

    //==============================================================================
    //
    //==============================================================================
    val hello = Observable.fromCallable { "Hello " }
    val future = Executors.newCachedThreadPool().submit<String> { "World" }
    val world = Observable.from(future)

    Observable.concat(hello, world, Observable.just("!"))
            .forEach(System.out::print)
}
