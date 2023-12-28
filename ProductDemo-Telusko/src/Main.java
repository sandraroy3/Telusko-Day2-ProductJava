import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // w/o delegation
//        System.out.println("Hello world!");
//        Product p = new Product();
//        System.out.println(p);

        //with delegation and main calling service class
        ProductService service = new ProductService();

        Product p1 = new Product("Asus", "Laptop", "Brown table", 2024);
        service.addProduct(p1);
        service.addProduct(new Product("Black keyboard", "keyboard", "drawer", 2023));
        service.addProduct(new Product("lenovo Mouse", "Mouse", "white table", 2022));
        service.addProduct(new Product("Black Macbook", "Laptop", "white table", 2025));

        //print all products as a list
        List<Product> products = service.getAllProducts();
        System.out.println(products); // obj after obj
        System.out.println("__________");
        for(Product p: products) //enhanced for loop to print in good format
            System.out.println(p);

        System.out.println("__________");
        System.out.println("A particular product");
        Product p = service.getProduct("lenovo Mouse");
        System.out.println(p);

        //search black products
        System.out.println("__________");
        System.out.println("A particular text");
        List<Product> prods = service.getProductWithText("Black");
        for(Product p2: prods) {
            System.out.println(p2);
        }

        //search products in drawer(particular place)
        System.out.println("__________");
        System.out.println("A particular place");
        List<Product> prodsplace = service.getProductInPlace("Drawer");
        for(Product p3: prodsplace){
            System.out.println(p3);
        }

        //search products out of warranty(after expiry)
        System.out.println("__________");
        System.out.println("Out of expiry products");
        List<Product> prodsexpired = service.getExpiredProducts();
        for(Product p4: prodsexpired){
            System.out.println(p4);
        }

        //implement stream api
    }
}