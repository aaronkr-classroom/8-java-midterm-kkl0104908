public class LibrarySystem {
    private Book[] booklist; // Book 배열 정의
    private int bookCount; // 책의 수

    // 생성자
    public LibrarySystem(int maxSize) {
        booklist = new Book[maxSize];
        bookCount = 0;
    }

    public void addBook(Book book) {
        // 책 추가
        if (bookCount < booklist.length) {
            booklist[bookCount++] = book;
            System.out.println("'" + book.getTitle() + "' 책이 추가되었습니다.");
        } else {
            System.out.println("더 이상 책을 추가할 수 없습니다. 라이브러리가 꽉 찼습니다.");
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                // 찾은 책부터 시작하여 모든 요소를 왼쪽으로 이동합니다.
                for (int j = i; j < bookCount - 1; j++) {
                    booklist[j] = booklist[j + 1];
                }

                // 마지막 요소를 null로 설정하고 bookCount를 줄입니다.
                booklist[--bookCount] = null;
                System.out.println("'" + title + "' 책이 삭제되었습니다.");
                return; // 책 제거 후 종료
            }
        }
        System.out.println("# 오류: '" + title + "' 책을 찾을 수 없습니다.");
    }

    public void borrowBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (booklist[i].isAvailable()) {
                    booklist[i].setAvailable(false);
                    System.out.println("'" + title + "' 책을 대출했습니다.");
                } else {
                    System.out.println("'" + title + "' 책은 이미 대출 중입니다.");
                }
                return;
            }
        }
        System.out.println("# 오류: '" + title + "' 책을 찾을 수 없습니다.");
    }

    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (!booklist[i].isAvailable()) {
                    booklist[i].setAvailable(true);
                    System.out.println("'" + title + "' 책을 반납했습니다.");
                } else {
                    System.out.println("'" + title + "' 책은 이미 반납되었습니다.");
                }
                return;
            }
        }
        System.out.println("# 오류: '" + title + "' 책을 찾을 수 없습니다.");
    }

    public void displayAllBooks() {
        System.out.println("책 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(booklist[i].toString());
        }
    }
}

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private boolean available;

    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.available = true; // 초기에는 책이 대출 가능합니다.
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        String availability = available ? "Available" : "Out";
        return ISBN + " | " + title + " | " + author + " | " + publicationYear + " | " + availability;
    }
}


