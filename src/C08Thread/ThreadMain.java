package C08Thread;

import C07ExceptionFileParsing.MyThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        /// * ************ 스레드 기본 개념 ************ *///
        // 스레드(thread)란 프로세스(process) 내에서 실제로 작업을 수행하는 주체를 의미
        // CPU의 코어 1개당 1개의 Processor가 동작
        // 모든 프로세스에는 한 개 이상의 스레드가 존재하며, 자바 프로그램은 main 스레드에서 시작됨
        // 프로세서는 주어진 task(thread)를 빠르게 동작하며 순차적으로 처리 (처리 속도가 빠르기에 multi tasking이라고 봐도 무방)
        // java에서 기본적으로 프로그램이 실행되면 1개의 스레드가 동작 (main함수를 통해 thread 시작, 신규로 추가 스레드를 만들려면 별도로 생성해야 함)
        // 두 개 이상의 스레드를 가지는 프로세스를 멀티스레드 프로세스라고 하고, 멀티스레드는 비동기적으로 동작함
        // - 하나의 스레드가 작업을 할 때 다른 스레드가 독립적으로 작업을 수행 (두 개 이상의 스레드가 동시에 동작하는 것처럼 보임)

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
        // 자바에서는 기본 스레드 외에 스레드를 추가 생성하는 방법에는 Thread 상속 또는 Runnable 구현 두 가지 방법이 존재
        // 상속을 쓰면 다른 클래스를 상속받기 어려우므로 실무에서는 Runnable 구현 방식 선호
        // Thread 클래스에 이미 구현되어 있는 run 메서드는 아무 작업도 수행하지 않는 빈 메서드이므로, 작업하고 싶은 내용을 run() 메소드에 작성하고 start()를 통해 스레드 생성
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
        /// 멀티스레드 프로그래밍 특징
        /// - 컴퓨터에서 동시에 처리할 수 있는 최대 작업 수는 CPU의 코어(core) 수와 같다
        /// - 멀티 스레드 실행시 코어가 정해진 시간 동안 여러 작업을 번갈아가며 수행
        /// - 실행 대상인 각 스레드가 교체될 때 프로세스내의 스레드 문맥교환 발생 (현재까지의 작업 상태 저장)
        /// - 그래서 단순한 계산의 경우엔 싱글 스레드로 동작하는 것이 더 효율적
        /// - 또한 동시에 실행되는 2개 이상의 쓰레드 때문에, 데이터의 동시성 문제가 필연적으로 발생
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
        // 멀티스레드의 동시성문제 해결 : java에서는 join() 또는 synchronized를 통해 동시성 이슈 해결
        // join() : 한 스레드가 완료될때까지 다른 스레드의 start를 하지 않도록 할 때 사용 (사실상 비동기가 아닌 동기처럼 움직이므로 주의해서 사용해야함)
        // synchronized : 경쟁 조건(race condition)이 발생할 수 있는 코드 영역을 보호할때 사용 (synchronized 블록의 메서드는 한 번에 하나의 스레드만 실행)
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

        /// * ************ 스프링과 DB에서의 멀티스레드 동시성문제 ************ *///
        // 멀티스레드의 동시성 문제 및 스레드 관리의 어려움
        // 실제 웹서비스에서는 멀티스레드를 직접 생성하기 보다는 spring을 사용 (스프링은 기본적으로 멀티스레드이나 spring이 쓰레드를 관리)
        // DB데이터에 대한 동시성 이슈 : 여러 스레드가 data를 조회, 수정 함으로서 발생 (쇼핑몰 재고 1개일 때 여러 스레드가 동시에 구매시 재고 마이너스 등)
        // 스프링에서는 pessimistic read vs optimistic read 등을 활용하여 동시성 이슈 관리
        // DB에서는 read committed, repeatable read 등의 isolation level로 관리
        // 📍 pessimistic read(비관적 읽기) : 동시성 이슈가 발생할것이라고 비관적으로 보고 데이터 읽을 때 락을 걸어 다른 트랜잭션이 수정/삭제 못하게 함
        // 📍 optimistic read(낙관적 읽기) : 락을 걸지 않고 업데이트할때 데이터가 변경됐는지를 check (변경되었다면 트랜잭션 재시도/오류 반환)
        // 📍 read committed : 다른 트랜잭션이 커밋된 데이터만 읽을 수 있고, read하는 동안 다른 주체에 lock 안 걸림
        // 📍 repeatable read : 한 트랜잭션이 데이터 조회 시작하면 다른 트랜잭션은 해당 데이터 변경 불가
        // * DB데이터에 대한 동시성 이슈는 추후 spring 수업 또는 DB수업을 듣게 되면 이해할 수 있는 내용이므로, 여기서는 이론적인 이해만

    }
}
