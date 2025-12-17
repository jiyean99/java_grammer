package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*TODO <게시판서비스>
1.계좌객체 : Author, Post
2.자료구조 : List(authorList, postList)
3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
    3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
    3-2.회원 전체 목록 조회 : id, email
    3-3.회원 상세 조회(id로 조회 -> email로 조회) : id, email, name, password, 작성글수(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
    3-4.게시글 작성 : id, title, contents, 작성자Email(직접 Author 객체를 변수로 갖는것도 가능)
    3-5.게시물 목록 조회 : id(post), title
    3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름
*/
public class C10BoardService {
    public static void main(String[] args) {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("사용하실 서비스 번호를 입력해주세요\n" + "1.회원가입, " + "2.회원 전체 목록 조회, " + "3.회원 상세 조회, " + "4.게시글 작성, " + "5.게시물 목록 조회, " + "6.게시물 상세 조회");
            int num = Integer.parseInt(sc.nextLine());

            switch (num) {
                case 1:
                    System.out.println("회원가입 서비스입니다.");
                    System.out.println("이름을 입력하세요.");
                    String userName = sc.nextLine();
                    System.out.println("이메일을 입력하세요.");
                    String userEmail = sc.nextLine();
                    System.out.println("비밀번호를 입력하세요.");
                    String userPw = sc.nextLine();
                    //이름, 이메일, 비밀번호, id값(auto_increment)
                    Author user = new Author(userName, userEmail, userPw);
                    if (true) { //TODO 검증 코드 추가
                        authorList.add(user);
                        System.out.println("회원가입이 완료되었습니다.");
                    } else {
                        System.out.println("해당 이메일로 이미 가입된 계정입니다.");
                    }
                    break;
                case 2:
                    System.out.println("회원 전체 목록 조회 서비스입니다.");
                    for (Author a : authorList) {
                        System.out.println("id:" + a.getId() + ", user_email: " + a.getUserEmail());
                    }
                    break;
                case 3:
                    // TODO 게시글 수
                    System.out.println("회원 상세 조회 서비스입니다.");
                    // id, email, name, password, 작성글수(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
                    System.out.println("조회할 회원의 이메일주소를 입력하세요.");
                    String authorDetailByEmail = sc.nextLine();
                    Author author = null;
                    for (Author a : authorList) {
                        if (a.getUserEmail().equals(authorDetailByEmail)) {
                            author = a;
                            System.out.println("id:" + author.getId() + ", user_email: " + author.getUserEmail() + ", password: " + author.getUserPw() + ", 작성글 수: " + author.getPostListByAuthor().size());
                        } else {
                            System.out.println("해당 이메일의 회원이 존재하지 않습니다.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("게시글 작성 서비스입니다.");
                    System.out.println("작성자의 email을 입력하세요.");
                    String email = sc.nextLine();
                    Author authorP = null;
                    for (Author a : authorList){
                        if(a.getUserEmail().equals(email)){
                            authorP = a;
                            break;
                        }
                    }
                    System.out.println("제목을 입력하세요.");
                    String title = sc.nextLine();
                    System.out.println("내용을 입력하세요.");
                    String contents = sc.nextLine();

                    Post post = new Post(title, contents, authorP);
                    postList.add(post);
                    // TODO getPostListByAuthor -> 그냥 Post 생성자에서 수행하면 됨

                    break;
                case 5:
                    System.out.println("게시물 목록 조회 서비스입니다.");
                    // id(post), title
                    for (Post p : postList) {
                        System.out.println("id:" + p.getId() + ", title: " + p.getTitle());
                    }
                    break;
                case 6:
                    // TODO 작성자 이름
                    System.out.println("게시물 상세 조회 서비스입니다.");
                    // id, title, contents, 작성자이름(게시글 id로 조회)
                    System.out.println("조회할 작성자를 입력하세요.");
                    String readPostByUser = sc.nextLine();
                    for (Post p : postList) {
                        if (p.getAuthor().getUserEmail().equals(readPostByUser)) {
                            System.out.println("id:" + p.getId() + ", title: " + p.getTitle() + ", contents: " + p.getContents() + "작성자명: ");
                        } else {
                            System.out.println("해당 이름의 작성자가 작성한 글이 없습니다.");
                        }
                    }
                    break;
                default:
                    System.out.println("없는 서비스 입니다.");
                    break;
            }
        }

    }
}


class Author {
    private Long id;
    private static long staticId;
    private String useName;
    private String userEmail;
    private String userPw;
    private List<Post> postListByAuthor; // 작성자 별 post 리스트를 담고있음 TODO 게시글을 쓸 때 마다 더해줘야함

    // 기본생성자
    public Author() {

    }

    // 생성자
    public Author(String useName, String userEmail, String userPw) {
        staticId++;
        this.id = staticId;
        this.useName = useName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.postListByAuthor = new ArrayList<>();
    }

    //getter
    public Long getId() {
        return id;
    }

    public static long getStaticId() {
        return staticId;
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

    public List<Post> getPostListByAuthor() {
        return postListByAuthor;
    }

}

class Post {
    private Long id;
    private static long staticId;
    private String title;
    private String contents;
    private Author author; // 게시글 별 작성자 리스트

    // 기본생성자
    public Post() {
    }
    // 생성자
    public Post(String title, String contents, Author author) {
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.author = author;
        author.getPostListByAuthor().add(this); // 여기서 this는 지금 만들고자 하는 post 객체를 의미
    }

    // getter
    public Long getId() {
        return id;
    }

    public static long getStaticId() {
        return staticId;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return this.author;
    }
}