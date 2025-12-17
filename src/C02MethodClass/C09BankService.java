package C02MethodClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* TODO <계좌개설 및 입출금 서비스>
1.계좌객체 : id(auto_increment Long), name(String), accountNumber(String), balance(long)
2.자료구조 :  계좌객체를 담아둘 자료구조는 Map
3.서비스 기능 :
    3-0)서비스 선택 : 사용하실 서비스 번호를 입력하세요. -> 1~5 중 작업사항 선택
    3-1)계좌개설 : "이름"과 사용하실 "계좌번호"와 현재 "가지고있는돈"을 입력하세요. -> 자동으로 id값 증가되어 객체 생성
    3-2)계좌조회 : 계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요. -> 계좌주명, 계좌번호번호, 잔고를 보기좋게 출력
    3-3)입금 : 계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요. -> 입금전 잔액, 입금후 잔액 출력
    3-4)출금 : 계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요. -> 잔액검증 -> "출금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력
    3-5)송금 : 송금서비스입니다. 본인의 계좌번호, 상대방의 계좌번호, 송금금액을 입력해 주세요. -> 잔액검증 -> "송금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력.
4.주의사항
    4-1)프로그램은 상시적 실행될수 있도록 전체코드를 while(true)처리
    4-2)main메서드에서 입출력 처리를 하고, 입금(deposit), 출금(withdraw), 송금(transfer)기능에 대한 핵심 메서드는 BankAccount클래스에 생성.
 */
// TODO 사용자와 인터페이싱 하는 클래스(BankService)만 생성하는 과제

public class C09BankService {
    public static void main(String[] args) throws IOException {
        Map<String, BankAccount> accountMap = new HashMap<>();
        accountMap.put("1234", new BankAccount("lee", "1234", 50000));
        accountMap.put("4321", new BankAccount("kim", "1234", 50000));
        System.out.println(accountMap);
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("======= start =======");
            System.out.println("사용하실 서비스의 번호를 입력하세요.\n1:계좌 개설, 2: 계좌 조회, 3: 입금, 4: 출금, 5:송금");
            int service_num = Integer.parseInt(br.readLine());

            switch (service_num) {
                case 1:
                    // 계좌개설
                    System.out.println("이름을 입력해주세요.");
                    String name_1 = br.readLine();
                    System.out.println("사용하실 계좌번호를 입력해주세요.");
                    String account_1 = br.readLine();
                    if (accountMap.containsKey(account_1)) {
                        System.out.println("이미 사용중인 계좌번호입니다. 다른 번호를 입력해주세요.");
                        account_1 = br.readLine();
                    }
                    System.out.println("입금하실 금액을 입력해주세요.");
                    Long balance_1 = Long.parseLong(br.readLine());
                    accountMap.put(account_1, new BankAccount(name_1, account_1, balance_1));
                    break;
                case 2:
                    // 계좌조회
                    System.out.println("계좌조회 서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요.");
                    String account_2 = br.readLine();
                    if (!accountMap.containsKey(account_2)) {
                        System.out.println("없는 계좌번호입니다. 다시 입력해주세요.");
                        account_2 = br.readLine();
                    }
                    System.out.println("계좌주명: " + accountMap.get(account_2).getName());
                    System.out.println("계좌번호: " + accountMap.get(account_2).getAccountNumber());
                    System.out.println("잔고: " + accountMap.get(account_2).getBalance());

                    break;
                case 3:
                    // 입금
                    System.out.println("계좌입금 서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요.");
                    System.out.println("계좌번호를 입력하세요.");
                    String account_3 = br.readLine();
                    System.out.println("현재 잔액: " + accountMap.get(account_3).getBalance() + "원\n" + "입금 금액을 입력하세요.");
                    long money_3 = Long.parseLong(br.readLine());
                    accountMap.get(account_3).deposit(money_3);
                    System.out.println("입금 완료되었습니다. 잔액: " + accountMap.get(account_3).getBalance() + "원");
                    break;
                case 4:
                    // 출금
                    System.out.println("계좌출금 서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요.");
                    System.out.println("계좌번호를 입력해주세요.");
                    String account_4 = br.readLine();
                    System.out.println("현재 잔액: " + accountMap.get(account_4).getBalance() + "원\n" + "출금 금액을 입력해주세요.");
                    long money_4 = Long.parseLong(br.readLine());
                    if (!accountMap.get(account_4).checkBalance(money_4)) {
                        System.out.println("잔액이 부족합니다. 출금 금액을 다시 입력해주세요.");
                        money_4 = Long.parseLong(br.readLine());
                    }
                    accountMap.get(account_4).withdraw(money_4);
                    System.out.println("출금 완료되었습니다. 잔액: " + accountMap.get(account_4).getBalance() + "원");
                    break;
                case 5:
                    // 송금
                    System.out.println("송금서비스 입니다. 본인 계좌번호, 송금할 계좌번호, 송금 금액을 입력해주세요.");
                    System.out.println("내 계좌번호를 입력해주세요.");
                    String my_account = br.readLine();
                    if (!accountMap.containsKey(my_account)) {
                        System.out.println("없는 계좌번호입니다. 다시 입력해주세요.");
                        my_account = br.readLine();
                    } else {
                        System.out.println("내 계좌 현재 잔액 :" + accountMap.get(my_account).getBalance() + "원");
                    }
                    System.out.println("송금할 계좌번호를 입력해주세요.");
                    String target_account = br.readLine();
                    if (!accountMap.containsKey(my_account)) {
                        System.out.println("없는 계좌번호입니다. 다시 입력해주세요.");
                        target_account = br.readLine();
                    }
                    System.out.println("송금 금액을 입력해주세요.");
                    long transfer_money = Long.parseLong(br.readLine());
                    if (!accountMap.get(my_account).checkBalance(transfer_money)) {
                        System.out.println("잔액이 부족합니다. 송금 금액을 다시 입력해주세요.");
                        transfer_money = Long.parseLong(br.readLine());
                    }
                    accountMap.get(my_account).transferService(accountMap.get(target_account), transfer_money);
                    System.out.println("송금 완료되었습니다. 잔액: " + accountMap.get(my_account).getBalance() + "원");

                    break;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    break;
            }
            System.out.println(accountMap);
        }

    }
}

// id(auto_increment Long), name(String), accountNumber(String), balance(long)
class BankAccount {
    private Long id;
    private static long staticId;
    private String name;
    private String accountNumber;
    private long balance;

    // 기본 생성자
    public BankAccount() {

    }

    // 생성자 오버라이딩
    public BankAccount(String name, String accountNumber, long balance) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    // 잔액검증(boolean)
    public boolean checkBalance(long money) {
        if (this.balance < money) {
            return false;
        } else {
            return true;
        }
    }

    //입금
    public void deposit(long money) {
        this.balance += money;
    }

    //출금
    public void withdraw(long money) {
        if (this.balance < money) return;
        this.balance -= money;
    }

    //송금
    public void transferService(BankAccount targetAccount, long money) {
        if (money > this.balance) {
            return;
        }
        this.balance -= money;
        targetAccount.balance += money;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
