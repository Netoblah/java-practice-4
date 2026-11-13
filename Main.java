package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Main {

    static class Book {
        private String title;
        private String author;
        private int pages;
        private boolean isRead;

        public Book(String title, String author, int pages, boolean isRead) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.isRead = isRead;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getPages() {
            return pages;
        }

        public boolean isRead() {
            return isRead;
        }

        public void setRead(boolean read) {
            isRead = read;
        }

        public String describe() {
            return "Книга: " + title + " автор " + author
                    + ", " + pages + " стр., прочитана: " + isRead;
        }
    }

    static class Reader {
        private String name;
        private String favoriteGenre;
        private Book lastBook;

        public Reader(String name, String favoriteGenre) {
            this.name = name;
            this.favoriteGenre = favoriteGenre;
        }

        public void readBook(Book book) {
            lastBook = book;
            book.setRead(true);
        }

        public String getLastBookInfo() {
            if (lastBook == null) {
                return "Пока ничего не читал";
            }

            return lastBook.describe();
        }
    }

    static class Library {
        private List<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public List<Book> findByAuthor(String author) {
            List<Book> result = new ArrayList<>();

            for (Book book : books) {
                if (Objects.equals(book.getAuthor(), author)) {
                    result.add(book);
                }
            }

            return result;
        }

        public int getTotalPages() {
            int totalPages = 0;

            for (Book book : books) {
                totalPages += book.getPages();
            }

            return totalPages;
        }

        public List<Book> getUnreadBooks() {
            List<Book> unreadBooks = new ArrayList<>();

            for (Book book : books) {
                if (!book.isRead()) {
                    unreadBooks.add(book);
                }
            }

            return unreadBooks;
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("1984", "Джордж Оруэлл", 328, false);
        Book book2 = new Book("Скотный двор", "Джордж Оруэлл", 144, true);
        Book book3 = new Book("Мастер и Маргарита", "Михаил Булгаков", 480, false);

        System.out.println("Задание 1:");
        System.out.println(book1.describe());
        System.out.println(book2.describe());
        System.out.println(book3.describe());




        Reader reader1 = new Reader("Лера", "Фантастика");
        Reader reader2 = new Reader("Мейси", "Классика");

        reader1.readBook(book1);
        reader2.readBook(book3);

        System.out.println("\nЗадание 2:");
        System.out.println("Последняя книга Леры: " + reader1.getLastBookInfo());
        System.out.println("Последняя книга Мейси: " + reader2.getLastBookInfo());




        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(new Book("Путь к рабству", "Фридрих Хайек", 280, false));
        library.addBook(new Book("Колыбель для кошки", "Курт Воннегут", 320, false));
        library.addBook(new Book("Дни в Бирме", "Джордж Оруэлл", 300, false));

        System.out.println("\nЗадание 3:");
        System.out.println("Всего страниц в библиотеке: " + library.getTotalPages());

        System.out.println("Книги Джорджа Оруэлла:");

        for (Book book : library.findByAuthor("Джордж Оруэлл")) {
            System.out.println(book.describe());
        }

        System.out.println("Непрочитанные книги:");
        for (Book book : library.getUnreadBooks()) {
            System.out.println(book.describe());
        }
    }
}



