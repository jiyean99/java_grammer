package C08Thread;

import C07ExceptionFileParsing.MyThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        /// * ************ 스레드 기본 개념 ************ *///
        // 스레드(thread)란 프로세스(process) 내에서 실제로 작업을 수행하는 주체를 의미
        // 모든 프로세스에는 한 개 이상의 스레드가 존재하며, 자바 프로그램은 main 스레드에서 시작됨
        // 두 개 이상의 스레드를 가지는 프로세스를 멀티스레드 프로세스라고 하고, 멀티스레드는 비동기적으로 동작함

        /// * ************ 단일 스레드 실행 실습 ************ *///
        /*
        for (int i = 0; i < 1000; i++) {
            Library.borrow();
        }
        System.out.println(Library.getBookCount());
        */

        /// * ************ 멀티 스레드 실행 실습 - 스레드 생성(가상의 스레드) ************ *///
        /// 방법(1) 스레드 클래스 상속 방식
        /*
        Thread t1 = new Thread();
        t1.start(); // start 실행 시 깡통 메서드인 run()가 함께 실행됨 -> 클래스를 만들어서 상속받은 후 재정의 해서 사용하면 됨
        */
        // 각 스레드는 코드의 실행순서가 보장되지 않는 비동기적 실행(main에 할당된 thread도 포함됨)
        /*
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println("hello");
        //스레드 실행
        //스레드 실행
        //스레드 실행
        //hello
        //스레드 실행
        //스레드 실행
        // -> 비동기적으로 실행되는 모습을 확인 할 수 있다.
        */

        /// 방법(2) : Runnable을 구현한 객체를 Thread 클래스 생성자에 주입하는 방식 - 구현 객체의 run 메서드를 Thread 객체가 가져다 사용함
        // 여러 스레드가 동일 자원에 접근할 때 race condition을 막기 위한 동기화 기법
        // 상속을 쓰면 다른 클래스를 상속받기 어려우므로 실무에서는 Runnable 구현 방식 선호
        /*
        new Thread(() -> System.out.println("스레드 실행1")).start();
        new Thread(() -> System.out.println("스레드 실행2")).start();
        new Thread(() -> System.out.println("스레드 실행3")).start();
        new Thread(() -> System.out.println("스레드 실행4")).start();
        new Thread(() -> System.out.println("스레드 실행5")).start();
        //스레드 실행1
        //스레드 실행5
        //스레드 실행4
        //스레드 실행3
        //스레드 실행2
        // -> 마찬가지로 실행순서 뒤죽박죽
        */

        /// * ************ 멀티 스레드 동시성 이슈 테스트 ************ *///
        /// 개선 전 코드
        /*
        for (int i = 0; i < 1000; i++) {
            new Thread(Library::borrow).start();
        }
        Thread.sleep(2000);
        System.out.println(Library.getBookCount()); //-891
        */

        /// synchronized 코드 사용 : 메서드 내에서 한개의 스레드만을 실행되도록 보장
        /*
        for (int i = 0; i < 1000; i++) {
            new Thread(Library::borrow).start();
        }
        Thread.sleep(30000);
        System.out.println(Library.getBookCount()); //0
        */

        /// join 코드 사용 : 한 스레드의 작업이 모두 완료될 때 까지, 다른 스레드를 실행하지 않는것
        // 사실상 단일스레드처럼 동작하므로 성능저하(선택지로 고려X)
        /*
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> Library.borrow());
            t1.start();
            t1.join();
        }
        Thread.sleep(30000);
        System.out.println(Library.getBookCount()); //0
        */

        /// * ************ synchronized를 통한 동시성 제어 예시 ************ *///
        // 실전에선 크게 고려할 문제는 아니고 알고리즘 문제에서 build를 쓰는것이 더 좋다고 생각하는 정도로만 ㄱㄱ
        // 또한 static으로 변수를 관리하기보다는 그냥 redis에 담아라
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello"); // synchronized가 있어 성능은 떨어질 수 있으나 동시성 문제가 발생 X
        StringBuilder builder = new StringBuilder();
        builder.append("hello"); // 동시성 문제 발생 가능성 O(일반메서드)

        // ConcurrentHashMap의 put메서드는 putVal에서 구현하고있고, putVal은 synchronized 메서드(동시성 제어 O)
        Map<String, String> myMap1 = new ConcurrentHashMap<>();
        myMap1.put("java","자바");
        // HashMap의 put메서드는 putVal에서 구현하고있고, putVal은 synchronized 메서드가 X(동시성 제어 X)
        Map<String, String> myMap2 = new HashMap<>();
        myMap2.put("java","자바");
        // -> 멀티스레드 환경의 공유 데이터는 보통 redis, DB 락, JPA 낙관적/비관적 락 등으로 관리


    }
}
