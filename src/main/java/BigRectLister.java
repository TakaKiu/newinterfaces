import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {

        List<Rectangle> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(3, 2));
        rectangles.add(new Rectangle(4, 2));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(5, 2));
        rectangles.add(new Rectangle(2, 5));
        rectangles.add(new Rectangle(4, 3));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(6, 2));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(7, 2));


        List<Rectangle> bigRectangles = collectAll(rectangles, new BigRectangleFilter());


        System.out.println("Big Rectangles:");
        for (Rectangle rect : bigRectangles) {
            System.out.println("Width: " + rect.width + ", Height: " + rect.height);
        }
    }


    public static List<Rectangle> collectAll(List<Rectangle> rectangles, Filter filter) {
        List<Rectangle> acceptedRectangles = new ArrayList<>();
        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                acceptedRectangles.add(rect);
            }
        }
        return acceptedRectangles;
    }
}
