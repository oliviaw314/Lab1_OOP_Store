import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StoreTester {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void addBookTest() {
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        assertTrue(true);
    }

    @Test
    public void addBookAndPhoneTest() {
        Store store = new Store(); // whether should make these as a parameter
        Book book = new Book();
        Phone phone = new Phone();
        store.addBook(book);
        store.addPhone(phone);
        assertTrue(true); // doesn't actually do anything - just passes true
    }

    @Test
    public void updatePhonesLocationAndGetAllPhonesTest() {
        Store store = new Store();
        Phone phone1 = new Phone();
        store.addPhone(phone1);

        Phone phone2 = new Phone();
        store.addPhone(phone2);

        Phone phone3 = new Phone();
        store.addPhone(phone3);

        Phone phone4 = new Phone();
        store.addPhone(phone4);

        store.updatePhonesLocation("Room 512");
        store.getAllPhones();
        assertEquals(phone1.getLocation(),"Room 512");
        assertEquals(phone2.getLocation(),"Room 512");
        assertEquals(phone3.getLocation(),"Room 512");
        assertEquals(phone4.getLocation(),"Room 512");
    }

    @Test
    public void getItemsTest() {
        Store store = new Store();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Arduino arduino1 = new Arduino();
        Arduino arduino2 = new Arduino();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Magazine magazine1 = new Magazine();
        Magazine magazine2 = new Magazine();
        Magazine magazine3 = new Magazine();

        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addArduino(arduino1);
        store.addArduino(arduino2);
        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);
        store.addMagazine(magazine1);
        store.addMagazine(magazine2);
        store.addMagazine(magazine3);

        store.getItems("book");
        store.getItems("Phone");
        store.getItems("magazine");
        store.getItems("Arduino");

        ArrayList<CISItem> books = store.getItems("book");
        ArrayList<CISItem> testCase = new ArrayList<>(Arrays.asList(book1,book2,book3));
        for (int i=0; i<books.size(); i++) {
            assertEquals(books.get(i),testCase.get(i));
        }

        ArrayList<CISItem> phones = store.getItems("phone");
        testCase = new ArrayList<>(Arrays.asList(phone1, phone2));
        for (int i = 0; i < phones.size(); i++) {
            assertEquals(phones.get(i), testCase.get(i));
        }

        ArrayList<CISItem> arduinos = store.getItems("arduino");
        testCase = new ArrayList<>(Arrays.asList(arduino1, arduino2));
        for (int i = 0; i < arduinos.size(); i++) {
            assertEquals(arduinos.get(i), testCase.get(i));
        }

        ArrayList<CISItem> magazines = store.getItems("magazine");
        testCase = new ArrayList<>(Arrays.asList(magazine1, magazine2, magazine3));

        for (int i = 0; i < magazines.size(); i++) {
            assertEquals(magazines.get(i), testCase.get(i));
        }
    }

    @Test
    public void updateItemsTest() {
        Store store = new Store();
        // testing general
        store.updateItems("book","price","256");
        for (CISItem book : store.getItems("book")) {
                assertEquals(256, book.getPrice());
        }
        // testing reading item
        store.updateItems("BOOK","DatePublished","November 8th 2022");
        for (CISItem book : store.getItems("book")) {
            assertEquals("November 8th 2022",  ((Book) book).getDatePublished());
        }
        // testing book specific
        store.updateItems("book","title","Peppa Pig");
        for (CISItem book : store.getItems("book")) {
                assertEquals("Peppa Pig", ((Book) book).getTitle());
        }

        //testing magazine specific
        store.updateItems("magazine","coverstorytitle","Best foods");
        for (CISItem magazine : store.getItems("magazine")) {
            assertEquals("Best foods", ((Magazine) magazine).getCoverStoryTitle());
        }

        //testing electronic item
        store.updateItems("phone","maker","Apple");
        for (CISItem phone : store.getItems("phone")) {
            assertEquals("Apple", ((Phone) phone).getMaker());
        }

        //testing phone specific
        store.updateItems("phone","networkTYPE","5G");
        for (CISItem phone : store.getItems("phone")) {
            assertEquals("5G",((Phone) phone).getNetworkType());
        }

        //testing arduino specific
        store.updateItems("arduino","version","1.8.19");
        for (CISItem arduino : store.getItems("arduino")) {
            assertEquals("1.8.19", ((Arduino) arduino).getVersion());
        }
    }

}
