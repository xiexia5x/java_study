package lianxi;

import java.lang.reflect.Method;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<book1> book1Class = book1.class;
        if(book1Class.isAnnotationPresent(Book.class)){
            Book annotation = book1Class.getAnnotation(Book.class);
            String bookname = annotation.bookname();
            int price = annotation.price();
            String username = annotation.username();
            System.out.println(bookname+":"+price+":"+username);
        }

      Method buy = book1Class.getMethod("buy");
        Book annotation = buy.getAnnotation(Book.class);
        String bookname = annotation.bookname();
        int price = annotation.price();
        String username = annotation.username();
        System.out.println(bookname+":"+price+":"+username);




    }
}
