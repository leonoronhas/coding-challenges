package LearnByDoing;

/************************************************************
 * CodeSignal - shapeArea challenge
 * Below we will define an n-interesting polygon. Your task
 * is to find the area of a polygon for a given n.
 *
 * A 1-interesting polygon is just a square with a side of
 * length 1. An n-interesting polygon is obtained by taking
 * the n - 1-interesting polygon and appending 1-interesting
 * polygons to its rim, side by side.
 *  URL - https://codesignal.s3.amazonaws.com/tasks/shapeArea/img/area.png?_tm=1582090003453
 ************************************************************
 *
 *  Example
 *
 *  For n = 2, the output should be
 *      shapeArea(n) = 5;
 *  For n = 3, the output should be
 *      shapeArea(n) = 13.
 *
 ************************************************************/

public class ShapeArea {

    public static int shapeArea(int n) {
        int area = 1;

        if (area == n){
            return 1;
        }
        else {
            for(int i = 2; i <= n; i++) area = ((i - 1) * 4) + area;
        }
        return area;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Shape area of n = " + n + " is " + shapeArea(n));
    }
}
