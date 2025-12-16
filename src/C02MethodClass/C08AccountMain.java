package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C08AccountMain {
    public static void main(String[] args) {
        // TODO 1) 계좌 개설(객체 생성)
        Account account_a = new Account("jiyean", "12345", 0);
        Account account_b = new Account("bradkim", "54321", 0);

        // TODO 2) List를 계좌 객체 담는 자료구조로 사용
        List<Account> account_list = new ArrayList<>();
        account_list.add(account_a);
        account_list.add(account_b);

        // TODO 3) 계좌 1("12345") -> 계좌 2("54321") 송금: 50000원
        for (Account a : account_list) {
            // 1) 12345 계좌에 5만원 먼저 이체
            if (a.getAccountNumber().equals("12345")) {
                a.setBalance(a.getBalance() + 50000);
                System.out.println(a.getAccountNumber() + " 계좌 내 이체 성공, 현재 잔고 :  " + a.getBalance());
            }
            // 2) 12345 계좌의 5만원을 54231 계좌에 송금
            if (a.getAccountNumber().equals("12345")) {
                a.setBalance(a.getBalance() - 50000);
                System.out.println(a.getAccountNumber() + " 계좌 내 이체 성공, 현재 잔고 :  " + a.getBalance());
            }
            if (a.getAccountNumber().equals("54321")) {
                a.setBalance(a.getBalance() + 50000);
                System.out.println(a.getAccountNumber() + " 계좌 내 이체 성공, 현재 잔고 :  " + a.getBalance());
            }
        }

    }
}

// TODO Account 클래스 생성
// 요구사항 : 계좌주명(name), 계좌번호(accountNumber-String), 잔고(balance-long)
class Account {
    private String name;
    private String accountNumber;
    private long balance;

    // 생성자(메서드오버라이딩)
    public Account(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //기본생성자
    public Account() {

    }

    // getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    //setter
    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}