import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();
    public void addProduct(Product p) {
        // for now data ie multiple products can be stored in a data struct in our app itself like array.
        // rather than in db
        products.add(p);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String name) {
        for(Product p: products){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();
        for(Product p: products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str)) {
                prods.add(p);
            }
        }
        return prods;
    }

    public List<Product> getProductInPlace(String place) {
        List<Product> prodsplace= new ArrayList<>();
        for(Product p: products){
            if(p.getPlace().equalsIgnoreCase(place))
                prodsplace.add(p);
        }
        return prodsplace;
    }

    public List<Product> getExpiredProducts() {
        List<Product> prodsexpired = new ArrayList<>();
        for(Product p: products){
            if(p.getWarranty()<2023)
                prodsexpired.add(p);
        }
        return prodsexpired;
    }
}
