package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {
    public static void main(String[] args) {
        /// * ************ 개요 ************ *///
        // - 시간에 대한 라이브러리가 왜 필요한가?(캘린더클래스에 대한 이해도가 왜 필요한가?)
        // * 사용자가 회원가입 버튼을 클릭 시 이 정보는 서버로 이동하고, 문제가 없으면 DB로 이동한다. (게시판 작성도 마찬가지)
        // * 이 때 가입시간, 작성시간 등 사용자가 어떠한 액션을 취했을 때 사용자가 시간을 입력하는것이 아니고 서버 혹은 DB에서 만든다.

        //📍 라이브러리별 클래스 : Calendar 클래스 vs LocalDateTime 클래스
        // * java.util 패키지 - Calendar 클래스
        // * java.time 패키지 - LocalDateTime, LocalDate, LocalTime 클래스

        /// * ************ Calendar 클래스 ************ *///
        //📍 Calendar 클래스
        // - 날짜를 처리하기 위한 다양한 기능을 제공해주는 추상 클래스
        // - Calendar 클래스의 모든 필드는 클래스 변수(static variable)이므로, 객체생성 없이 사용
        // - 그러나 Calendar의 문제점으로 인해, java.time 패키지 사용이 대세
        Calendar myCalendar = Calendar.getInstance(); // new가 없지만 Calendar.getInstance() 내부적으로 객체를 만들어줌
        System.out.println("getTime === " + myCalendar.getTime()); // 현재 시간정보 (Tue Dec 23 09:38:46 KST 2025)
        System.out.println("get YEAR === " + myCalendar.get(Calendar.YEAR)); //2025
        System.out.println("get MONTH === " + (myCalendar.get(Calendar.MONTH) + 1)); //(0부터 세기 떄문에 +1) 12
        System.out.println("get DAY_OF_WEEK === " + myCalendar.get(Calendar.DAY_OF_WEEK)); //요일 3
        System.out.println("get DAY_OF_MONTH === " + myCalendar.get(Calendar.DAY_OF_MONTH)); //23
        System.out.println("get HOUR === " + myCalendar.get(Calendar.HOUR)); //9
        System.out.println("get MINUTE === " + myCalendar.get(Calendar.MINUTE)); //48
        System.out.println("get SECOND === " + myCalendar.get(Calendar.SECOND)); //45
        // cf) Calendar.YEAR -> static 변수처럼 보이는 enum 타입의 변수(스테틱변수 맞음)

        /// * ************ LocalDate 클래스 ************ *///
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate); //2025-12-23
        System.out.println(myLocalDate.getYear()); //2025
        System.out.println(myLocalDate.getMonth()); //DECEMBER
        System.out.println(myLocalDate.getMonthValue()); //12
        System.out.println(myLocalDate.getDayOfMonth()); //23
        System.out.println(myLocalDate.getDayOfWeek()); //TUESDAY

        /// * ************ LocalTime 클래스 ************ *///
        LocalTime myLocalTime = LocalTime.now();
        System.out.println(myLocalTime); //09:48:01.818244400
        System.out.println(myLocalTime.getHour()); //9
        System.out.println(myLocalTime.getMinute()); //48
        System.out.println(myLocalTime.getSecond()); //1

        /// * ************ LocalDateTime 클래스 ************ *///
        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println(myLocalDateTime); //2025-12-23T09:48:45.717461800
        System.out.println(myLocalDateTime.getYear()); //2025
        // 기타 등등
        //📍 ChronoField 매개변수로 다양한 형식의 날짜/시간정보 조회
        System.out.println(myLocalDateTime.get(ChronoField.YEAR)); //2025
        System.out.println(myLocalDateTime.get(ChronoField.MONTH_OF_YEAR)); //12
        System.out.println(myLocalDateTime.get(ChronoField.AMPM_OF_DAY)); //0:오전, 1:오후
        System.out.println(myLocalDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY)); //24시 체계

        //📍 .of : 임의로 특정 시간 정보 객체를 만들어 내고싶을 때 사용
        LocalDate birthDay = LocalDate.of(2000, 11, 12);
        System.out.println("birthDay === " + birthDay);

        LocalDateTime birthDayTime = LocalDateTime.of(2000, 11, 12, 15, 14, 10);
        System.out.println("birthDayTime === " + birthDayTime); //2000-11-12T15:14:10, T 구분자가 있음(잘라야할수 있음)

    }
}
