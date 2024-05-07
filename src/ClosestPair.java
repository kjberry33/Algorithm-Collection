//iterative, Uses custom point object
public class ClosestPair {
    public static void main(String[] args){
        System.out.println("[CLOSEST PAIR]");
        Point[] points={new Point(2, 3),
                        new Point(12, 30),
                        new Point(40, 50),
                        new Point(5, 1),
                        new Point(12, 10),
                        new Point(3, 4) };
        ClosestPair Test=new ClosestPair();
        System.out.print("The shortest distance is: "+Test.clstPrAlg(points));
    }
    ClosestPair(){
        //default constructor
    }
    //CLOSEST PAIR ALGORITHM
    double clstPrAlg(Point[] points){
        double shortest=Double.POSITIVE_INFINITY;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                double dist=points[i].distance(points[j]);
                if(shortest>dist){
                    shortest=dist;
                }
            }
        }
        return shortest;
    }
}
//POINT CLASS
class Point{
    double x,y;
    //CONSTRUCTOR THAT ALLOWS EACH POINT TO CONTAIN X,Y COORDINATE DATA
    Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    //METHOD THAT CALCULATES THE DISTANCE WITH THIS POINT FROM ANOTHER POINT 'P'
    public double distance(Point p) {
        double dx=this.x - p.x;
        double dy=this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
