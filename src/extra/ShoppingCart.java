package extra;

public class ShoppingCart {
    static Book b = new Book();


    public static void main(String[] args) {
        b.code = 69;
        b.title = "Funny numbers for funny people";
        printInfo(b);
        //nicht gleich!
        System.out.println(b.title);


    }

    public static void printInfo(Article a){
        a.showinfo();
    }
}
