import java.util.ArrayList;

class Vending {
    public static void main(String[] args) {

        ArrayList<StockItem> items = new ArrayList<StockItem>();
        int initialQuantityOfItems = 4;

        // Storing names and prices of sweets in the layout specified
        String[] sweetTypes = new String[] {"Chocolate", "Caramel", "French Vanilla" };
        String[] sweetShapes = new String[] {"Jigglepuffs", "Bombs", "French Twists" };
        Double[] prices = new Double[] {1.3, 1.0, 0.8 };
        
        // For each item in the vending machine they're assigned an initial stock, price and its 'shape'
        for (String type : sweetTypes) {
            for (int i=0; i<3;i++) {
                items.add(new StockItem(type + " " + sweetShapes[i], initialQuantityOfItems, prices[i]));
            }
        }

        OurWindow frame = new OurWindow("Stock Manager", items);

        frame.startWindow(true);
    }
}