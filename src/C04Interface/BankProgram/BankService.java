package C04Interface.BankProgram;

// 핵심 로직을 수행하는 프로그램 계층
// 이 때 핵심로직으로는 개발자가 판단하여 결정하고 예를들어 잔고검증, 금액합산 기능등이 있다.

public class BankService {
    public void deposit(long money, BankAccount ba){
//        현재 얼마있는 조회
        long current = ba.getBalance();
//        그 금액과 money를 합산하여 새로운 balance update
        long newBalance = current + money;
        ba.updateBalance(newBalance);
    };

    public boolean withdraw(long money, BankAccount ba){
//        현재 얼마있는 조회 && 가능한 잔고인지 체크
        long current = ba.getBalance();
        if(current < money){
            return false;
        }else {
//        그 금액에서 money를 차감하여 새로운 balance update
            long newBalance = current - money;
            ba.updateBalance(newBalance);
            return true;
        }
    }
}
