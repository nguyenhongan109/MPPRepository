package com.mpp.library.controller;

import java.time.LocalDate;
import java.util.Collection;

import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import com.mpp.library.entity.CheckoutRecord;
import com.mpp.library.entity.CheckoutRecordEntry;
import com.mpp.library.entity.Person;

public final class CheckoutBookController extends Controller<CheckoutRecord> {

	private static CheckoutBookController instance = new CheckoutBookController();

	private CheckoutBookController() {
		super();
	}

	public static CheckoutBookController getInstance() {
		return instance;
	}
	
	public CheckoutRecord getCheckoutRecordByMemberID(String memberID) {
		Person member = new Person(memberID);
		Collection<CheckoutRecord> checkoutRecords = getAll();
		for (CheckoutRecord checkoutRecord : checkoutRecords) {
			if (member.equals(checkoutRecord.getMember())){
				return checkoutRecord;
			}
		}
		return null;
	}

	public CheckoutRecord checkoutBooks(String memberID, String isbn) throws Exception {
//		System.out.println("controller checkoutBooks");
		UserController userController = UserController.getInstance();
		Person member = userController.searchMember(memberID);
		
		if (member == null){
			throw new Exception("Libray Member not found with ID= "+ memberID);
		}
		
		BookController bookController = BookController.getInstance();
		Book book = bookController.searchBook(isbn);
		
		if (book== null){
			throw new Exception("Book not found with ISBN= "+ isbn);
		}
		if (!book.isAvailabile()){
			throw new Exception("BookCopy not available with ISBN= "+ isbn);
		}
		

		String uniqueID = null;
		CheckoutRecord checkoutRecord = getCheckoutRecordByMemberID(memberID);
		if (checkoutRecord == null){
			uniqueID = getUniqueID();
			checkoutRecord = new CheckoutRecord(uniqueID, member);
		}
		else {
			uniqueID = checkoutRecord.getID();
		}
		
		member.addCheckoutRecord(checkoutRecord);
		BookCopy bookCopy = book.getNextAvailableCopy();
		
		LocalDate checkoutDate = LocalDate.of(2016,9,14);
		LocalDate dueDate = checkoutDate.plusDays(book.getBorrowDuration());
		checkoutRecord.addRecordEntry(new CheckoutRecordEntry(
				bookCopy, 
				checkoutDate, 
				dueDate
		));
		
		
		reserveBookCopy(bookCopy);
		
		save(checkoutRecord);
		
		// search
		checkoutRecord = get(uniqueID);
		return checkoutRecord;
	}

	private void reserveBookCopy(BookCopy bookCopy) {
		bookCopy.setAvailability(false);
	}
}
