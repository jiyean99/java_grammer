package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C07Constructor {
    public static void main(String[] args) {
        // TODO 캘린더 객체 생성
        Calendar c1 = new Calendar();
        c1.setYear("2025");
        c1.setMonth("12");
        c1.setDay("16");

        // TODO 캘린더 객체 출력
        System.out.println(c1.getNowInfo());

        // 메서드 오버라이딩된 생성자를 이용한 경우 -> 객체 생성 시 변수 세팅
        Calendar c2 = new Calendar("2025", "12", "16");
        System.out.println(c2.getNowInfo());
        System.out.println(c2);

        /// * ************ Java 자료구조 내 직접 만든 객체를 담아 관리 ************ *///
        // cf) <> : 제네릭구조로 클래스 자료형이면 뭐든 담을 수 있음
        List<Calendar> c_list = new ArrayList<>();
        c_list.add(c1);
        c_list.add(new Calendar("2024", "01", "12"));
        System.out.println("리스트 : " + c_list);
        // c_list 안에는 Calendar 객체 주소들이 들어있음

    }
}

// TODO 클래스명 : Calendar
// 요구사항 : (변수) year, month, day 모두 String
class Calendar {
    private String year;
    private String month;
    private String day;

    // 생성자 사용 전에는 아래의 setter가 있어야하지만, 생성자를 사용하면 setter가 불필요해짐 (setter는 변수의 안정성을 헤침)
    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    /// * ************ 생성자 ************ *///
    // 객체가 만들어지는(new) 시점에 호출되는 메서드(기본생성자는 숨어있음)
    //📍 생성자의 특징
    // - 클래스명과 메서드명이 동일
    // - 반환타입 없음(void 키워드 역시 사용 X)
    // - 메서드 오버로딩 가능
    //📍 생성자의 사용목적
    // - 객체 생성 시점에 객체 변수 값들을 초기화(세팅).
    // - 변수의 안정성을 위해 setter 사용을 지양하고, 생성자를 사용.
    public Calendar(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 직접 생성자를 1개라도 추가할 경우, 초기(기본)생성자는 무시가 되므로, 필요시 별도로 추가해야함
    public Calendar() {

    }

    public String getNowInfo() {
        return "현재 날짜는 " + this.year + "-" + this.month + "-" + this.day + "입니다.";
    }


    //📍 toString() 메서드는 객체명으로 출력 시 자동으로 메서드가 호출
    @Override
    public String toString() {
        return "{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}