class Point
{
    double x,y;     
    public Point(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }
}
 
class PointOfIntersection
{    
    public Point lineLineIntersection(Point A, Point B, Point C, Point D)
    {
        // Line AB represented as a1x + b1y = c1
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1*(A.x) + b1*(A.y);
      
        // Line CD represented as a2x + b2y = c2
        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2*(C.x)+ b2*(C.y);
      
        double determinant = a1*b2 - a2*b1;
      
        if (determinant == 0)
        {
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;
            return new Point(x, y);
        }
    }
}
