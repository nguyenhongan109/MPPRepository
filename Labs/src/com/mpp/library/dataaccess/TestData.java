package com.mpp.library.dataaccess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.mpp.library.entity.Address;
import com.mpp.library.entity.Author;
import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import com.mpp.library.entity.CheckoutRecord;
import com.mpp.library.entity.CheckoutRecordEntry;
import com.mpp.library.entity.Person;
import com.mpp.library.entity.UserAccount;
import com.mpp.library.entity.UserRole;

public class TestData {
	
	@SuppressWarnings("serial")
	public final List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};
	
	@SuppressWarnings("serial")
	public final List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("Joe", "Thomas", "A happy man is he."));
			add(new Author("Sandra", "Thomas", "A happy wife is she."));
			add(new Author("Nirmal", "Pugh", "Thinker of thoughts."));
			add(new Author("Andrew", "Cleveland", "Author of childrens' books."));
			add(new Author("Sarah", "Connor", "Known for her clever style."));
		}
	};
	
	//create library members
	@SuppressWarnings("serial")
	public List<Person> persons = new ArrayList<Person>(){
		{
			Person person = new Person("1001", "Andy", "Rogers", addresses.get(4), "641-223-2211");
//			person.addCheckoutRecord(allEntries.get(0));
//			person.addCheckoutRecord(allEntries.get(4));
	        person.getRoles().add(UserRole.ADMINISTRATOR);
	        person.getRoles().add(UserRole.LIBRARYAN);
			add(person);
			
			person = new Person("1002", "Drew", "Stevens", addresses.get(5), "702-998-2414");
//			person.addCheckoutRecord(allEntries.get(2));
//			person.addCheckoutRecord(allEntries.get(5));
	        person.getRoles().add(UserRole.ADMINISTRATOR);
			add(person);
			
			person = new Person("1003", "Sarah", "Eagleton", addresses.get(6), "451-234-8811");
//			person.addCheckoutRecord(allEntries.get(1));
//			person.addCheckoutRecord(allEntries.get(3));
	        person.getRoles().add(UserRole.LIBRARYAN);
			add(person);
			
			person = new Person("1004", "Ricardo", "Montalbahn", addresses.get(7), "641-472-2871");
//			person.addCheckoutRecord(allEntries.get(2));
//			person.addCheckoutRecord(allEntries.get(5));
	        person.getRoles().add(UserRole.MEMBER);
			add(person);
		}
	};
    
    // User
	@SuppressWarnings("serial")
	public final ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>() {
		{
			add(new UserAccount(persons.get(0), "adminlib", "123"));
			add(new UserAccount(persons.get(1), "admin", "123"));
			add(new UserAccount(persons.get(2), "lib", "123"));
			add(new UserAccount(persons.get(3), "mem", "123"));
		}
	};
	
	//Book(int id, String isbn, String title, int maxCheckoutLength, List<Author> authors)
	@SuppressWarnings("serial")
	public final List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("11-12345", "The Big Fish", 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book("12-23456", "Antartica", 7, Arrays.asList(allAuthors.get(2))));
			add(new Book("13-34567", "Thinking Java", 21, Arrays.asList(allAuthors.get(3))));
			add(new Book("14-45678", "Jimmy's First Day of School", 7, Arrays.asList(allAuthors.get(4))));
			
		}
	};
	
	//create book copies
	public void bookData() {
		Random copyNumberGenerator = new Random();
		int copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(0).addBookCopy(new BookCopy(allBooks.get(0), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(0).addBookCopy(new BookCopy(allBooks.get(0), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(0).addBookCopy(new BookCopy(allBooks.get(0), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(1).addBookCopy(new BookCopy(allBooks.get(1), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(1).addBookCopy(new BookCopy(allBooks.get(1), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(1).addBookCopy(new BookCopy(allBooks.get(1), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(2).addBookCopy(new BookCopy(allBooks.get(2), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(2).addBookCopy(new BookCopy(allBooks.get(2), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(3).addBookCopy(new BookCopy(allBooks.get(3), String.valueOf(copyNumber)));
		copyNumber = copyNumberGenerator.nextInt(100);
		allBooks.get(3).addBookCopy(new BookCopy(allBooks.get(3), String.valueOf(copyNumber)));
	}
	
	//CheckoutRecordEntry(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate)
	@SuppressWarnings("serial")
	public final List<CheckoutRecordEntry> allEntries = new ArrayList<CheckoutRecordEntry>() {
		{
			add(new CheckoutRecordEntry(
				allBooks.get(0).getNextAvailableCopy(), LocalDate.of(2011,12,1), LocalDate.of(2011,12,22)));
			add(new CheckoutRecordEntry(
				allBooks.get(0).getNextAvailableCopy(), LocalDate.of(2015,6,22), LocalDate.of(2015,7,13)));
			add(new CheckoutRecordEntry(
				allBooks.get(1).getNextAvailableCopy(), LocalDate.of(2015,6,27), LocalDate.of(2015,7,18)));
			add(new CheckoutRecordEntry(
				allBooks.get(2).getNextAvailableCopy(), LocalDate.of(2015,6,27), LocalDate.of(2015,7,18)));
			add(new CheckoutRecordEntry(
				allBooks.get(2).getNextAvailableCopy(), LocalDate.of(2015,6,20), LocalDate.of(2015,6,27)));
			add(new CheckoutRecordEntry(
				allBooks.get(3).getNextAvailableCopy(), LocalDate.of(2015,6,22), LocalDate.of(2015,6,29)));
			
		}
	};
	
	@SuppressWarnings("serial")
	public final List<CheckoutRecord> allRecords = new ArrayList<CheckoutRecord>() {
		{
			add(new CheckoutRecord());
			add(new CheckoutRecord());
			add(new CheckoutRecord());
			add(new CheckoutRecord());
			add(new CheckoutRecord());
			add(new CheckoutRecord());
			add(new CheckoutRecord());
		}
	};
}
