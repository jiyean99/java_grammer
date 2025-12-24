package C07ExceptionFileParsing;

public class MyThread extends Thread {
    // 스레드를 실행(start)하면 Thread 클래스 내 run 메서드가 호출된다.
    // 그런데 Thread 클래스의 run 메서드는 비어있으므로, 상속받아 오버라이딩함
    @Override
    public void run (){
        System.out.println("스레드 실행");
    }
}
