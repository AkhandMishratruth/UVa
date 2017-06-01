import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);

        ArrayList<Books> library;
        ArrayList<Books> allBooks = new ArrayList<Books>();
        ArrayList<Books> borrowed = new ArrayList<Books>();
        ArrayList<Books> returned = new ArrayList<Books>();

        while(true){
            String book = in.nextLine();
            if(book.equals("END"))
                break;
            else {
                String[] a = book.split(" by ");
                allBooks.add(new Books(a[0], a[1]));
            }
        }

        allBooks.sort(Books.thecom);
        library = (ArrayList) allBooks.clone();

        while(true) {
            String query = in.nextLine();
            if (query.equals("END"))
                break;
            if (query.contains("BORROW")) {
                String title = query.split("\"")[1];
                title = "\"" + title + "\"";
                Iterator it = allBooks.iterator();
                while(it.hasNext()){
                    Books temp = (Books)it.next();
                    if(temp.Title.equals(title)){
                        library.remove(temp);
                        borrowed.add(temp);
                    }
                }
            }
            if(query.contains("RETURN")){
                String title = query.split("\"")[1];
                title = "\"" + title + "\"";
                Iterator it = allBooks.iterator();
                while(it.hasNext()){
                    Books temp = (Books)it.next();
                    if(temp.Title.equals(title)){
                        borrowed.remove(temp);
                        returned.add(temp);
                    }
                }
            }
            if(query.contains("SHELVE")){
                //System.out.println(returned.size());
                returned.sort(Books.thecom);
                while(returned.size()!=0){
                    Books temp = returned.remove(0);
                    library.add(temp);
                    library.sort(Books.thecom);
                    int index = library.indexOf(temp);
                    if(index==0)
                        System.out.println("Put "+temp.Title+" first");
                    else{
                        System.out.println("Put "+temp.Title+" after "+library.get(index-1).Title);
                    }
                }
                System.out.println("END");
            }
        }
    }
}
class Books implements Comparable<Books>{
    String Author;
    String Title;
    String forComaprison;
    Books(String title, String author){
        Author = author;
        Title = title;
        //System.out.print(Author+Title+"end");
        forComaprison = Author.toUpperCase()+" "+Title.toUpperCase().split("\"")[1];
    }

    @Override
    public int compareTo(Books toCompare) {
        return this.forComaprison.compareTo(toCompare.forComaprison);
    }

    public static Comparator<Books> thecom = new Comparator<Books>() {
        @Override
        public int compare(Books a, Books b) {
            return a.forComaprison.toUpperCase().compareTo(b.forComaprison.toUpperCase());
        }
    };
}
/*
class BookComparator implements Comparator<Books> {

    public int compare(Books a, Books b) {
        return a.forComaprison.toUpperCase().compareTo(b.forComaprison.toUpperCase());
    }
}*/
