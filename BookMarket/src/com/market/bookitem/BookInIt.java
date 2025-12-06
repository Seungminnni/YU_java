package com.market.bookitem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BookInIt {
	private static ArrayList<Book> mBookList;
	private static int mTotalBook = 0;

	public static void init() {
		mTotalBook = totalFileToBookList();
		mBookList = new ArrayList<Book>();
		setFileToBookList(mBookList);
	}

	public static int totalFileToBookList() {
		try {
			BufferedReader reader = openBookReader();
			if (reader == null) {
				System.out.println("book.txt을 찾을 수 없습니다 (경로: book.txt, BookMarket/book.txt 등)");
				return 0;
			}

			String str;
			int num = 0;
			while ((str = reader.readLine()) != null) {
				if (str.contains("ISBN"))
					++num;
			}
			reader.close();
			return num;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public static void setFileToBookList(ArrayList<Book> booklist) {
		try {
			BufferedReader reader = openBookReader();
			if (reader == null) {
				System.out.println("book.txt을 찾을 수 없습니다 (경로: book.txt, BookMarket/book.txt 등)");
				return;
			}

			String str2;
			while ((str2 = reader.readLine()) != null) {
				if (str2.contains("ISBN")) {
					String[] readBook = new String[7];
					readBook[0] = str2;
					boolean ok = true;
					for (int i = 1; i < 7; i++) {
						String line = reader.readLine();
						if (line == null) {
							ok = false; // incomplete record
							break;
						}
						readBook[i] = line;
					}
					if (!ok)
						break;

					try {
						Book bookitem = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]),
								readBook[3], readBook[4], readBook[5], readBook[6]);
						booklist.add(bookitem);
					} catch (NumberFormatException nfe) {
						System.out.println("가격 파싱 에러: " + nfe.getMessage());
					}
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static BufferedReader openBookReader() {
		try {
			// try current dir
			if (Files.exists(Paths.get("book.txt"))) {
				return Files.newBufferedReader(Paths.get("book.txt"), StandardCharsets.UTF_8);
			}
			// try BookMarket/book.txt
			if (Files.exists(Paths.get("BookMarket/book.txt"))) {
				return Files.newBufferedReader(Paths.get("BookMarket/book.txt"), StandardCharsets.UTF_8);
			}
			// try resources on classpath
			InputStream in = BookInIt.class.getResourceAsStream("/book.txt");
			if (in != null) {
				return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
			}
		} catch (Exception e) {
			System.out.println("openBookReader error: " + e.getMessage());
		}
		return null;
	}

	public static ArrayList<Book> getmBookList() {
		return mBookList;
	}

	public static void setmBookList(ArrayList<Book> mBookList) {
		BookInIt.mBookList = mBookList;
	}

	public static int getmTotalBook() {
		return mTotalBook;
	}

	public static void setmTotalBook(int mTotalBook) {
		BookInIt.mTotalBook = mTotalBook;
	}
}