package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {
        // 자바에서 왜 enum 클래스를 사용해야하는가?
        // 아래의 비교 예시를 보고 이해해라

        // enum(열거체) 클래스
        // - 서로 연관되거나 또는 관련이 있는 상수들의 집합인 클래스
        // - 특정한 값들만을 가질 수 있는 제한된 데이터 타입
        // - 이를 통해 무효한 값이 할당되는 것을 방지
        // 사용 이유:
        // - 구현의도가 열거임을 내포
        // - 코드가 간략해지며 가독성 향상
        // - 열거체를 비교할 때 실제 값뿐만 아니라 타입까지도 체크

        //📍 ChronoField 열거체(enum)
        // - 날짜와 시간을 나타낼 때 사용하는 열거체
        //   - 특정한 숫자값을 get함수의 input값으로 주는데 사용
        //   - 열거체에 대해서는 추후 학습
        // - 주요 열거체
        //   - YEAR, MONTH_OF_YEAR, DAY_OF_MONTH, DAY_OF_WEEK
        //   - AMPM_OF_DAY (오전/오후: 0/1)
        //   - HOUR_OF_DAY (시: 0~23)
        //   - CLOCK_HOUR_OF_DAY (시: 1~24)
        //   - CLOCK_HOUR_OF_AMPM (시: 1~12)
        //   - DAY_OF_YEAR (해당 연도의 몇 번째 날: 1~365, 윤년 366)

        // (1) classGrade를 일반 문자열로 설계했을 경우
        // - 데이터 종류에 대한 통제 불가
//        Student s1 = new Student("hong1", "FIRST_GRADE");
//        Student s2 = new Student("hong2", "first_grade");`
//        Student s3 = new Student("hong3", "1학년");

        // 중간 개선 - static final 변수로 설계했을 경우
        // - 여전히 방어(데이터 제한)가 되지 않음(에러발생 X)
//        Student s1 = new Student("hong1", ClassGrade.c1);
//        Student s2 = new Student("hong2", ClassGrade.c2);
//        Student s3 = new Student("hong3", "1학년");

        // (2) classGrade를 Enum 클래스로 설계했을 경우
        Student s1 = new Student("hong1", ClassGrade.FIRST_GRADE);
        Student s2 = new Student("hong2", ClassGrade.FIRST_GRADE);
        Student s3 = new Student("hong3", ClassGrade.SECOND_GRADE);
    }
}

// 중간 개선 - static final 변수로 설계했을 경우
/*
class ClassGrade {
    static final String c1 = "FIRST_GRADE";
    static final String c2 = "SECOND_GRADE";
    static final String c3 = "THIRD_GRADE만";
}
*/

// (1) classGrade를 일반 문자열로 설계했을 경우
/*
class Student {
    private String name;
    private String classGrade; // 학년정보 : FIRST_GRADE, SECOND_GRADE, THIRD_GRADE만 있다고 가정

    public Student(String name, String classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", classGrade='" + classGrade + '\'' +
                '}';
    }
}
*/

//📍 enum 클래스는 데이터의 종류를 하나의 enum 명 아래 묶는 것
// - enum의 변수값은 static final 변수처럼 사용
enum ClassGrade {
    FIRST_GRADE, SECOND_GRADE, THIRD_GRADE
}
// (2) classGrade를 Enum 클래스로 설계했을 경우
class Student {
    private String name;
    private ClassGrade classGrade;

    public Student(String name, ClassGrade classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", classGrade='" + classGrade + '\'' +
                '}';
    }
}
