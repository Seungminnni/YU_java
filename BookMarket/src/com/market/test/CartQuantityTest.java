package com.market.test;

import com.market.bookitem.BookInIt;
import com.market.bookitem.Book;
import com.market.cart.Cart;
import com.market.cart.CartItem;

import java.util.ArrayList;

public class CartQuantityTest {
    public static void main(String[] args) {
        BookInIt.init();
        Cart cart = new Cart();
        ArrayList<Book> books = BookInIt.getmBookList();
        System.out.println("Loaded books: " + (books == null ? 0 : books.size()));
        if (books == null || books.size() == 0) {
            System.out.println("No books available to test.");
            return;
        }

        Book b = books.get(0);
        cart.insertBook(b, 2); // add qty 2
        cart.insertBook(b, 3); // add qty 3 via another insert -> will be a separate cart item in current implementation

        // Now test addQuantityToExisting
        boolean updated = cart.addQuantityToExisting(b.getBookId(), 5);
        System.out.println("Updated existing: " + updated);

        ArrayList<CartItem> items = cart.getmCartItem();
        System.out.println("Cart items count: " + items.size());
        for (CartItem ci : items) {
            System.out.println("BookID: " + ci.getBookID() + ", qty: " + ci.getQuantity() + ", total: " + ci.getTotalPrice());
        }
    }
}
