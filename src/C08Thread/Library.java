package C08Thread;

public class Library {
    private static int bookCount = 100;

    // 개선 전 코드
    /*
    public static void borrow() {
        if (bookCount > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount -= 1;
            System.out.println("대출완료");
        } else {
            System.out.println("대출불가");
        }
    }
    */

    // synchronized 코드 : 메서드 내에서 한개의 스레드만을 실행되도록 보장
    public synchronized static void borrow() {
        if (bookCount > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount -= 1;
            System.out.println("대출완료");
        } else {
            System.out.println("대출불가");
        }
    }

    public static int getBookCount(){
        return bookCount;
    }
}
