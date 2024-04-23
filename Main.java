public class Main {

    public static void main(String[] args) {
        // 새 LibrarySystem 개체 만들기
        LibrarySystem ls = new LibrarySystem(10); // 최대 책 수를 설정합니다.

        // 새 Book 만들기
        Book book1 = new Book("ISBN1234", "JSP 웹 프로그래밍", "송미영", 2018);
        Book book2 = new Book("ISBN1235", "안드로이드 프로그래밍", "우재남", 2022);
        Book book3 = new Book("ISBN1236", "스크래치 프로그래밍", "고광일", 2019);
        Book book4 = new Book("ISBN1237", "JAVA 마스터", "송미영", 2023);

        // LibrarySystem에 Book을 추가하세요
        ls.addBook(book1);
        ls.addBook(book2);
        ls.addBook(book3);
        ls.addBook(book4);

        // 모든 Book 출력
        ls.displayAllBooks();

        // Book 삭제
        ls.removeBook("스크래치 프로그래밍");

        // Book 빌립니다
        ls.borrowBook("JAVA 마스터");
        ls.borrowBook("안드로이드 프로그래밍");

        // 모든 Book 출력
        ls.displayAllBooks();

        // Book 반납합니다
        ls.returnBook("안드로이드 프로그래밍");

        // 모든 Book 출력
        ls.displayAllBooks();
    }
}