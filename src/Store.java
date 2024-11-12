import org.junit.Test;

import java.util.ArrayList;

public class Store {
    private ArrayList<CISItem> cisItems;
    private ArrayList<CISItem> phones;
    private ArrayList<CISItem> books;
    private ArrayList<CISItem> magazines;
    private ArrayList<CISItem> arduinos;

    public Store() {
        cisItems = new ArrayList<>();
        phones = new ArrayList<>();
        books = new ArrayList<>();
        magazines = new ArrayList<>();
        arduinos = new ArrayList<>();
    }

    public void addBook(Book book) {
        cisItems.add(book);
        books.add(book);
    }

    public void addPhone(Phone phone) {
        cisItems.add(phone);
        phones.add(phone);
    }

    public void addMagazine(Magazine magazine) {
        cisItems.add(magazine);
        magazines.add(magazine);
    }

    public void addArduino(Arduino arduino) {
        cisItems.add(arduino);
        arduinos.add(arduino);
    }

    public void updatePhonesLocation(String location) {
        for(CISItem phone:cisItems){
            if(phone instanceof Phone){
                phone.setLocation(location);
            }
        }
    }

    public ArrayList<CISItem> getAllPhones() {
        return phones;
    }

    public ArrayList<CISItem> getItems(String itemType) {
        if (itemType.equalsIgnoreCase("book")) {
            return books;
        }
        else if (itemType.equalsIgnoreCase("phone")) {
            return phones;
        }
        else if (itemType.equalsIgnoreCase("magazine")) {
            return magazines;
        }
        else if (itemType.equalsIgnoreCase("arduino")) {
            return arduinos;
        }
        return cisItems;
    }

    public void updateItems(String itemType, String property, String value) {
        for (CISItem cisItem : cisItems) {
            if (cisItem.getClass().getSimpleName().equals(itemType)) {
                // only alter items that have the same itemType as the parameter

                if (property.equalsIgnoreCase("name")) {
                    cisItem.setName(value);
                }
                else if (property.equalsIgnoreCase("location")) {
                    cisItem.setLocation(value);
                }
                else if (property.equalsIgnoreCase("price")) {
                    cisItem.setPrice(Integer.parseInt(value));
                }
                else if (property.equalsIgnoreCase("description")) {
                    cisItem.setDescription(value);
                }

                //specific to reading item (includes books and magazines)
                if (cisItem instanceof ReadingItem) {
                    if (property.equalsIgnoreCase("wordcount")) {
                        ((ReadingItem) cisItem).setWordCount(Integer.parseInt(value));
                    }
                    if (property.equalsIgnoreCase("datepublished")) {
                        ((ReadingItem) cisItem).setDatePublished(value);
                    }
                    if (property.equalsIgnoreCase("author")) {
                        ((ReadingItem) cisItem).setAuthor(value);
                    }
                }

                // specific to books
                if (cisItem instanceof Book) {
                    // using instanceof also lets the computer know what type it is, so can access its parameters
                    if (property.equalsIgnoreCase("isbn")) {
                        ((Book) cisItem).setIsbn(value);
                    }
                    if (property.equalsIgnoreCase("edition")) {
                        ((Book) cisItem).setEdition(value);
                    }
                    if (property.equalsIgnoreCase("title")) {
                        ((Book) cisItem).setTitle(value);
                    }
                }

                //specific to magazines
                if (cisItem instanceof Magazine) {
                    if (property.equalsIgnoreCase("coverstorytitle")) {
                        ((Magazine) cisItem).setCoverStoryTitle(value);
                    }
                    if (property.equalsIgnoreCase("printdate")) {
                        ((Magazine) cisItem).setPrintDate(value);
                    }
                }

                //specific to electronic items
                if (cisItem instanceof ElectronicItem) {
                    if (property.equalsIgnoreCase("storagecapacity")) {
                        ((ElectronicItem) cisItem).setStorageCapacity(Integer.parseInt(value));
                    }
                    if (property.equalsIgnoreCase("model")) {
                        ((ElectronicItem) cisItem).setModel(value);
                    }
                    if (property.equalsIgnoreCase("maker")) {
                        ((ElectronicItem) cisItem).setMaker(value);
                    }
                    if (property.equalsIgnoreCase("operatingsystem")) {
                        ((ElectronicItem) cisItem).setOperatingSystem(value);
                    }
                }

                //specific to phones
                if (cisItem instanceof Phone) {
                    if (property.equalsIgnoreCase("networktype")) {
                        ((Phone) cisItem).setNetworkType(value);
                    }
                    if (property.equalsIgnoreCase("screensize")) {
                        ((Phone) cisItem).setScreenSize(Integer.parseInt(value));
                    }
                }

                // specific to arduinos
                if (cisItem instanceof Arduino) {
                    if (property.equalsIgnoreCase("version")) {
                        ((Arduino) cisItem).setVersion(value);
                    }
                }

            }
        }

    }

    public void showAllInfo() {
        for (CISItem cisItem : cisItems) {
            System.out.println(cisItem);
        }
    }

}
