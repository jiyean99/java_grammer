package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardPractice {
    public static void main(String[] args) {
        List<AuthorP> authorPList = new ArrayList<>();
        List<PostP> postPList = new ArrayList<>();

//        // === 더미 회원 4명 ===
//        AuthorP a1 = new AuthorP("홍길동", "hong@test.com", "1111");
//        AuthorP a2 = new AuthorP("김영희", "kim@test.com", "2222");
//        AuthorP a3 = new AuthorP("이철수", "lee@test.com", "3333");
//        AuthorP a4 = new AuthorP("박민수", "park@test.com", "4444");
//
//        authorPList.add(a1);
//        authorPList.add(a2);
//        authorPList.add(a3);
//        authorPList.add(a4);
//
//        // === 더미 게시글 4개 ===
//        PostP p1 = new PostP("첫 글", "첫 번째 더미 내용입니다.", a1);
//        PostP p2 = new PostP("둘째 글", "두 번째 더미 내용입니다.", a2);
//        PostP p3 = new PostP("셋째 글", "세 번째 더미 내용입니다.", a3);
//        PostP p4 = new PostP("넷째 글", "네 번째 더미 내용입니다.", a4);
//
//        postPList.add(p1);
//        postPList.add(p2);
//        postPList.add(p3);
//        postPList.add(p4);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("사용하실 서비스 번호를 입력해주세요\n" + "1.회원가입, " + "2.회원 전체 목록 조회, " + "3.회원 상세 조회, " + "4.게시글 작성, " + "5.게시물 목록 조회, " + "6.게시물 상세 조회");
            int num = Integer.parseInt(sc.nextLine());

            if (num == 1) {
                System.out.println("회원가입 서비스입니다.");
                System.out.println("이름을 입력하세요.");
                String userName = sc.nextLine();
                System.out.println("이메일을 입력하세요.");
                String userEmail = sc.nextLine();
                System.out.println("비밀번호를 입력하세요.");
                String userPw = sc.nextLine();

                AuthorP user = new AuthorP(userName, userEmail, userPw);
                authorPList.add(user);

            } else if (num == 2) {
                System.out.println("회원 전체 목록 조회 서비스입니다.");

                for (AuthorP a : authorPList) {
                    System.out.println("id:" + a.getId() + ", user_email: " + a.getUserEmail());
                }

            } else if (num == 3) {
                System.out.println("회원 상세 조회 서비스입니다.");
                System.out.println("조회할 회원의 이메일주소를 입력하세요.");
                String email = sc.nextLine();
                AuthorP authorP = null;
                for (AuthorP a : authorPList) {
                    if (a.getUserEmail().equals(email)) {
                        authorP = a;
                        System.out.println("id:" + authorP.getId() + ", user_email: " + authorP.getUserEmail() + ", password: " + authorP.getUserPw() + ", 작성글 수: " + authorP.getPostP().size());
                    }
                }

            } else if (num == 4) {
                System.out.println("게시글 작성 서비스입니다.");
                System.out.println("작성자의 email을 입력하세요.");
                String email = sc.nextLine();
                AuthorP authorP = null;
                for (AuthorP a : authorPList) {
                    if (a.getUserEmail().equals(email)) {
                        authorP = a;
                        break;
                    }
                }
                System.out.println("제목을 입력하세요.");
                String title = sc.nextLine();
                System.out.println("내용을 입력하세요.");
                String contents = sc.nextLine();

                PostP p = new PostP(title, contents, authorP);
                postPList.add(p);
            } else if (num == 5) {
                System.out.println("게시물 목록 조회 서비스입니다.");
                for (PostP p : postPList) {
                    System.out.println("id:" + p.getId() + ", title: " + p.getTitle());
                }
            } else if (num == 6) {
                System.out.println("게시물 상세 조회 서비스입니다. postId를 입력하세요.");
                Long postId = Long.parseLong(sc.nextLine());
                PostP p = null;
                for (PostP postP : postPList) {
                    if (postP.getId() == postId) {
                        p = postP;
                        break;
                    }
                }
                System.out.println("제목: " + p.getTitle() + ", 내용: " + p.getContents() + ", 작성자: " + p.getAuthorP().getUseName());
            } else {
                System.out.println("없는 서비스 입니다.");
            }
        }
    }
}

class AuthorP {
    private Long id;
    private static long st_id;
    private String useName;
    private String userEmail;
    private String userPw;
    private List<PostP> postP;

    // 생성자
    public AuthorP() {
    }

    public AuthorP(String useName, String userEmail, String userPw) {
        st_id++;
        this.id = st_id;
        this.useName = useName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.postP = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public static long getSt_id() {
        return st_id;
    }

    public String getUseName() {
        return useName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPw() {
        return userPw;
    }

    public List<PostP> getPostP() {
        return postP;
    }
}

class PostP {
    private Long id;
    private static long st_id;
    private String title;
    private String contents;
    private AuthorP authorP;

    // 생성자
    public PostP() {
    }

    public PostP(String title, String contents, AuthorP authorP) {
        st_id++;
        this.id = st_id;
        this.title = title;
        this.contents = contents;
        this.authorP = authorP;
        authorP.getPostP().add(this);
    }

    public Long getId() {
        return id;
    }

    public static long getSt_id() {
        return st_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public AuthorP getAuthorP() {
        return this.authorP;
    }
}