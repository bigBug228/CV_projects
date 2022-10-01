//http://gitlab.gcd.ie:8080/ivshuk/assignment_2.git
public class Geometry3D {
    static float CuboidVolume(float a, float b, float c){
        return a*b*c;
    }
    static float surfaceAreaOfCuboid(float a,float b,float c){
        return (a*b+b*c+a*c)*2;
    }
    static float volumeOfSquareBasedPyramid(float h,float a){
        return (a*a*h)/3;
    }
    static float surfaceAreaOfSquareBasedPyramid(float b,float s){
        return 2*b*s+b*b;
    }
    static float volumeOfTetrahedron(float a){
        return (float) (Math.pow(a, 3) / (6 * Math.sqrt(2)));
    }
    static float surfaceAreaOfTetrahedron(float a){
        return (float) (Math.pow(a,2)*Math.sqrt(3));
    }
}
