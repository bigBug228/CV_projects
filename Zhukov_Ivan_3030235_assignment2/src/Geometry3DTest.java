import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class Geometry3DTest {
    public double epsilon = 0.1;
@Test
    void TestCuboidVolume(){
    assertEquals(27,Geometry3D.CuboidVolume(3,3,3),epsilon);
    assertEquals(8,Geometry3D.CuboidVolume(2,2,2),epsilon);
    assertEquals(1,Geometry3D.CuboidVolume(1,1,1),epsilon);
}
@Test
    void TestSurfaceAreaOfCuboid(){
    assertEquals(54,Geometry3D.surfaceAreaOfCuboid(3,3,3),epsilon);
    assertEquals(96,Geometry3D.surfaceAreaOfCuboid(4,4,4),epsilon);
    assertEquals(24,Geometry3D.surfaceAreaOfCuboid(2,2,2),epsilon);
}
@Test
    void TestVolumeOfSquareBasedPyramid(){
    assertEquals(37.3,Geometry3D.volumeOfSquareBasedPyramid(7,4),epsilon);
    assertEquals(4.0,Geometry3D.volumeOfSquareBasedPyramid(3,2),epsilon);
    assertEquals(2.01,Geometry3D.volumeOfSquareBasedPyramid(6,1),epsilon);
}
@Test
    void TestSurfaceAreaOfSquareBasedPyramid(){
    assertEquals(180,Geometry3D.surfaceAreaOfSquareBasedPyramid(6,12),epsilon);
    assertEquals(33,Geometry3D.surfaceAreaOfSquareBasedPyramid(3,4),epsilon);
    assertEquals(95,Geometry3D.surfaceAreaOfSquareBasedPyramid(5,7),epsilon);
}
@Test
    void TestVolumeOfTetrahedron(){
    assertEquals(3.1,Geometry3D.volumeOfTetrahedron(3),epsilon);
    assertEquals(0.9,Geometry3D.volumeOfTetrahedron(2),epsilon);
    assertEquals(7.5,Geometry3D.volumeOfTetrahedron(4),epsilon);
}
@Test
    void TestSurfaceAreaOfTetrahedron(){
    assertEquals(27.7,Geometry3D.surfaceAreaOfTetrahedron(4),epsilon);
    assertEquals(15.5,Geometry3D.surfaceAreaOfTetrahedron(3),epsilon);
    assertEquals(6.9,Geometry3D.surfaceAreaOfTetrahedron(2),epsilon);
}

}