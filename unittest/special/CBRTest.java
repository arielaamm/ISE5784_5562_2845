//package special;
//
//import static java.awt.Color.BLUE;
//import static java.awt.Color.RED;
//
//
//import org.junit.jupiter.api.Test;
//
//import primitives.*;
//import geometries.*;
//
//class CBRTest {
//
//	@Test
//	void test1() {
//		Sphere sphere = new Sphere(new Point(1, 1, 1), 2);
//		Triangle triangle = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
//		Plane pln = new Plane(new Point(1, 1, 0), new Vector(0, 0, 1));
//		Geometries geo = new Geometries(sphere, triangle, pln);
//		geo.minMaxPoints();
//	}
//
//	@Test
//	void test2() {
//		Triangle triangle = new Triangle(new Point(1, -3, 0), new Point(2, 5, 0), new Point(0, 0, 1));
//		CBR cbr1 = new CBR(triangle);
//		new CBR(cbr1, triangle);
//		cbr1.findGeoIntersections(new Ray(new Point(-0.1, 0, 0), new Vector(1, 1, 1)));
//	}
//
//	@Test
//	void test3() {
//
//		double MINIMIZER = 0.2;
//
//		Geometries geos = new CBR( //
//				new Plane(new Point(0, 0, 0), new Vector(0, 0, 1)).setEmission(new Color(249, 237, 176).scale(MINIMIZER)),
//				new Triangle(new Point(0, 0, 0), new Point(2, 0, 0), new Point(1, 1, 1.5)).setEmission(new Color(232, 196, 19).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.8).setKs(0.3).setShininess(100)), //
//				new Triangle(new Point(0, 0, 0), new Point(0, 2, 0), new Point(1, 1, 1.5)).setEmission(new Color(232, 196, 19).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setShininess(100)), //
//				new Triangle(new Point(0, 2, 0), new Point(2, 2, 0), new Point(1, 1, 1.5)).setEmission(new Color(232, 196, 19).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setShininess(100)), //
//				new Triangle(new Point(2, 2, 0), new Point(2, 0, 0), new Point(1, 1, 1.5)).setEmission(new Color(232, 196, 19).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setShininess(100)), //
//				new Sphere(new Point(-1, 1, 2), 0.5).setEmission(new Color(RED)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setShininess(100).setKt(0.3)),
//				new Polygon(new Point(1, -1, 0.001), new Point(1, -4, 0.001), new Point(-1, -4, 0.001), new Point(-1, -1, 0.001)).setEmission(new Color(BLUE).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.8).setKs(0.3).setShininess(500).setKr(0.8)),
//				new Polygon(new Point(-2, -2, 0), new Point(-2.3, -2, 0), new Point(-2.3, -2, 0.8), new Point(-2, -2, 0.8)).setEmission(new Color(153, 76, 0).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.8).setKs(0.3).setShininess(500)),
//				new Polygon(new Point(-2.3, -2, 0), new Point(-2.3, -2, 0.8), new Point(-2.3, -1.7, 0.8), new Point(-2.3, -1.7, 0)).setEmission(new Color(153, 76, 0).scale(MINIMIZER)) //
//						.setMaterial(new Material().setKd(0.8).setKs(0.3).setShininess(500))
//		);
//
//		geos.findGeoIntersections(new Ray(new Point(-0.1, 0, 0), new Vector(1, 1, 1)));
//
//	}
//
//	@Test
//	void test4() {
//		Sphere sphere1 = new Sphere(new Point(1, 1, 1), 2);
//		Sphere sphere2 = new Sphere(new Point(3, 2, 3), 1);
//		Triangle triangle = new Triangle(new Point(1, -3, 0), new Point(2, 5, 0), new Point(0, 0, 1));
//		new CBR(triangle, sphere1, sphere2);
//	}
//}


package special;

import geometries.*;
import lighting.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.SimpleRayTracer;
import scene.Scene;

public class CBRTest {
	private Scene scene = new Scene("Test scene");

	@Test
	public void TestCombo() {
		final Camera.Builder cameraBuilder = Camera.getBuilder()
				.setDirection(new Vector(0, 1, 0), new Vector(0, 0, 1))
				.setRayTracer(new SimpleRayTracer(scene))
				.setLocation(new Point(0, -100, 0))
				.setVpDistance(100)
				.setVpSize(200, 200)
				.setImageWriter(new ImageWriter("ComboWithBlur", 500, 500))
				.setMultithreading(0)
				.setDebugPrint(0.1);

		scene.setAmbientLight(new AmbientLight(new Color(10, 10, 10), 0.1));

		scene.geometries.add(new CBR(
				new Triangle(new Point(-0.0, -0.0, -8.886552), new Point(1.8, -0.745585, -7.335572), new Point(0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071067, -7.071069, -0.269999), new Point(1.8, -0.745585, -7.335572), new Point(0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, -0.0, -8.886552), new Point(0.745584, -1.8, -7.335572), new Point(-0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, -0.0, -8.886552), new Point(-0.745584, -1.8, -7.335572), new Point(-1.8, -0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, -7.071068, -0.269999), new Point(-0.745584, -1.8, -7.335572), new Point(-1.8, -0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-1e-06, -10.0, -0.269999), new Point(0.745584, -1.8, -7.335572), new Point(-0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, 0.0, -8.886552), new Point(-1.8, -0.745584, -7.335572), new Point(-1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.0, 1e-06, -0.269999), new Point(-1.8, -0.745584, -7.335572), new Point(-1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 0.0, -8.886552), new Point(-1.8, 0.745584, -7.335572), new Point(-0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, 7.071068, -0.269999), new Point(-1.8, 0.745584, -7.335572), new Point(-0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, -0.0, -8.886552), new Point(-0.745584, 1.8, -7.335572), new Point(0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 10.0, -0.269999), new Point(-0.745584, 1.8, -7.335572), new Point(0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, -0.0, -8.886552), new Point(0.745584, 1.8, -7.335572), new Point(1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, 7.071068, -0.269999), new Point(0.745584, 1.8, -7.335572), new Point(1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, 0.0, -8.886552), new Point(1.8, 0.745584, -7.335572), new Point(1.799999, -0.745584, -7.335573)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.000006, -1e-06, -0.269994), new Point(1.8, 0.745584, -7.335572), new Point(1.799999, -0.745584, -7.335573)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071067, -7.071069, -0.269999), new Point(3.947157, -9.529282, 0.005913), new Point(0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, -7.071068, -0.269999), new Point(-3.947159, -9.529282, 0.005913), new Point(-0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, -7.071068, -0.269999), new Point(-9.529282, -3.947157, 0.005913), new Point(-1.8, -0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.0, 1e-06, -0.269999), new Point(-9.529282, -3.947157, 0.005913), new Point(-1.8, -0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.0, 1e-06, -0.269999), new Point(-9.529282, 3.947158, 0.005913), new Point(-1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, 7.071068, -0.269999), new Point(-9.529282, 3.947158, 0.005913), new Point(-1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, 7.071068, -0.269999), new Point(3.947158, 9.529282, 0.005913), new Point(0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, -7.071069, 0.269999), new Point(9.529282, -3.947159, 0.005913), new Point(6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, -7.071069, 0.269999), new Point(3.947157, -9.529282, 0.005913), new Point(2.849999, -6.88051, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-1e-06, -10.000001, 0.269999), new Point(3.947157, -9.529282, 0.005913), new Point(2.85, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-1e-06, -10.000001, 0.269999), new Point(-3.947159, -9.529282, 0.005913), new Point(-2.850001, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071069, -7.071068, 0.269999), new Point(-3.947159, -9.529282, 0.005913), new Point(-2.85, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071069, -7.071068, 0.269999), new Point(-9.529282, -3.947157, 0.005913), new Point(-6.880509, -2.849999, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.000001, 1e-06, 0.269999), new Point(-9.529282, -3.947157, 0.005913), new Point(-6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, -7.071068, -0.269999), new Point(9.529282, -3.947159, 0.005913), new Point(1.8, -0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, -10.0, -0.269999), new Point(3.947157, -9.529282, 0.005913), new Point(0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-0.0, -10.0, -0.269999), new Point(-3.947159, -9.529282, 0.005913), new Point(-0.745584, -1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, 7.071068, -0.269999), new Point(-3.947158, 9.529282, 0.005913), new Point(-0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 10.0, -0.269999), new Point(-3.947158, 9.529282, 0.005913), new Point(-0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 10.0, -0.269999), new Point(3.947158, 9.529282, 0.005913), new Point(0.745584, 1.8, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, 7.071068, -0.269999), new Point(9.529282, 3.947158, 0.005913), new Point(1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.000006, -1e-06, -0.269994), new Point(9.529282, 3.947158, 0.005913), new Point(1.8, 0.745584, -7.335572)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.000006, -1e-06, -0.269994), new Point(9.529282, -3.947159, 0.005913), new Point(1.799999, -0.745584, -7.335573)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.000001, 1e-06, 0.269999), new Point(-9.529282, 3.947158, 0.005913), new Point(-6.880509, 2.850001, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, 7.071069, 0.269999), new Point(-9.529282, 3.947158, 0.005913), new Point(-6.880509, 2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, 7.071069, 0.269999), new Point(-3.947158, 9.529282, 0.005913), new Point(-2.849999, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 10.000001, 0.269999), new Point(-3.947158, 9.529282, 0.005913), new Point(-2.850001, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 10.000001, 0.269999), new Point(3.947158, 9.529282, 0.005913), new Point(2.850001, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071069, 7.071068, 0.269999), new Point(3.947158, 9.529282, 0.005913), new Point(2.85, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071069, 7.071068, 0.269999), new Point(9.529282, 3.947158, 0.005913), new Point(6.880509, 2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.000002, -1e-06, 0.269999), new Point(9.529282, 3.947158, 0.005913), new Point(6.880509, 2.850001, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.000002, -1e-06, 0.269999), new Point(9.529282, -3.947159, 0.005913), new Point(6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071068, -7.071069, 0.269999), new Point(2.849999, -6.88051, 2.413967), new Point(6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(4.030508, -4.030509, 3.225308), new Point(2.849999, -6.88051, 2.413967), new Point(6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(1e-06, -10.000001, 0.269999), new Point(-2.850001, -6.880509, 2.413967), new Point(2.85, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, -5.7, 3.225308), new Point(-2.850001, -6.880509, 2.413967), new Point(2.85, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071069, -7.071068, 0.269999), new Point(-6.880509, -2.849999, 2.413967), new Point(-2.85, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-4.030509, -4.030508, 3.225308), new Point(-6.880509, -2.849999, 2.413967), new Point(-2.85, -6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.000001, 1e-06, 0.269999), new Point(-6.880509, 2.850001, 2.413967), new Point(-6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-5.7, 0.0, 3.225308), new Point(-6.880509, 2.850001, 2.413967), new Point(-6.880509, -2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-7.071068, 7.071069, 0.269999), new Point(-2.849999, 6.880509, 2.413967), new Point(-6.880509, 2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-4.030508, 4.030509, 3.225308), new Point(-2.85, 6.880509, 2.413967), new Point(-6.880508, 2.85, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 10.000001, 0.269999), new Point(2.850001, 6.880509, 2.413967), new Point(-2.850001, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(0.0, 5.7, 3.225308), new Point(2.850001, 6.880509, 2.413967), new Point(-2.850001, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.071069, 7.071068, 0.269999), new Point(6.880509, 2.85, 2.413967), new Point(2.85, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(4.030509, 4.030509, 3.225308), new Point(6.880509, 2.85, 2.413967), new Point(2.85, 6.880509, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.000002, -1e-06, 0.269999), new Point(6.880509, -2.85, 2.413967), new Point(6.880509, 2.850001, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(5.7, -0.0, 3.225308), new Point(6.880509, -2.85, 2.413967), new Point(6.880509, 2.850001, 2.413967)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(2.849999, -6.880509, 2.413967), new Point(-0.0, -5.7, 3.225308), new Point(4.030508, -4.030509, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-2.85, -6.880508, 2.413967), new Point(-4.030509, -4.030508, 3.225308), new Point(-0.0, -5.7, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.880509, -2.849999, 2.413967), new Point(-5.7, 0.0, 3.225308), new Point(-4.030509, -4.030508, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.880508, 2.85, 2.413967), new Point(-4.030508, 4.030509, 3.225308), new Point(-5.7, 0.0, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-2.85, 6.880509, 2.413967), new Point(0.0, 5.7, 3.225308), new Point(-4.030508, 4.030509, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(2.85, 6.880508, 2.413967), new Point(4.030509, 4.030509, 3.225308), new Point(0.0, 5.7, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(6.880508, 2.85, 2.413967), new Point(5.7, -0.0, 3.225308), new Point(4.030509, 4.030509, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(6.880509, -2.85, 2.413967), new Point(4.030508, -4.030509, 3.225308), new Point(5.7, -0.0, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Polygon(new Point(5.7, -0.0, 3.225308), new Point(4.030509, 4.030509, 3.225308), new Point(0.0, 5.7, 3.225308), new Point(-4.030509, 4.030509, 3.225308), new Point(-5.7, 0.0, 3.225308), new Point(-4.030509, -4.030508, 3.225308), new Point(-0.0, -5.7, 3.225308), new Point(4.030508, -4.030509, 3.225308)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-14.749139, -14.937441, -7.500958), new Point(-15.803555, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478072, -21.262924, -0.435386), new Point(-14.749139, -14.937441, -7.500958), new Point(-15.803555, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-15.803555, -15.991856, -7.500958), new Point(-17.294724, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-17.294724, -15.991856, -7.500958), new Point(-18.349138, -14.937439, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -21.262924, -0.435386), new Point(-17.294724, -15.991856, -7.500958), new Point(-18.349138, -14.937439, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549141, -24.191856, -0.435386), new Point(-15.803555, -15.991856, -7.500958), new Point(-17.294724, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-18.349138, -14.937439, -7.500958), new Point(-18.349138, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-26.549139, -14.191854, -0.435386), new Point(-18.349138, -14.937439, -7.500958), new Point(-18.349138, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-18.349138, -13.446272, -7.500958), new Point(-17.294724, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -7.120788, -0.435386), new Point(-18.349138, -13.446272, -7.500958), new Point(-17.294724, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-17.294724, -12.391855, -7.500958), new Point(-15.803555, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -4.191855, -0.435386), new Point(-17.294724, -12.391855, -7.500958), new Point(-15.803555, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-15.803555, -12.391855, -7.500958), new Point(-14.749139, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -7.120788, -0.435386), new Point(-15.803555, -12.391855, -7.500958), new Point(-14.749139, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -14.191855, -9.051939), new Point(-14.749139, -13.446272, -7.500958), new Point(-14.74914, -14.937439, -7.50096)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.549133, -14.191856, -0.435381), new Point(-14.749139, -13.446272, -7.500958), new Point(-14.74914, -14.937439, -7.50096)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478072, -21.262924, -0.435386), new Point(-12.601982, -23.721138, -0.159474), new Point(-15.803555, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -21.262924, -0.435386), new Point(-20.496298, -23.721138, -0.159474), new Point(-17.294724, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -21.262924, -0.435386), new Point(-26.078421, -18.139011, -0.159474), new Point(-18.349138, -14.937439, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-26.549139, -14.191854, -0.435386), new Point(-26.078421, -18.139011, -0.159474), new Point(-18.349138, -14.937439, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-26.549139, -14.191854, -0.435386), new Point(-26.078421, -10.244698, -0.159474), new Point(-18.349138, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -7.120788, -0.435386), new Point(-26.078421, -10.244698, -0.159474), new Point(-18.349138, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -7.120788, -0.435386), new Point(-12.601981, -4.662574, -0.159474), new Point(-15.803555, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -21.262924, 0.104612), new Point(-7.019857, -18.139015, -0.159474), new Point(-9.668631, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -21.262924, 0.104612), new Point(-12.601982, -23.721138, -0.159474), new Point(-13.699141, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549141, -24.191856, 0.104612), new Point(-12.601982, -23.721138, -0.159474), new Point(-13.699139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549141, -24.191856, 0.104612), new Point(-20.496298, -23.721138, -0.159474), new Point(-19.399139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620209, -21.262924, 0.104612), new Point(-20.496298, -23.721138, -0.159474), new Point(-19.399139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620209, -21.262924, 0.104612), new Point(-26.078421, -18.139011, -0.159474), new Point(-23.429647, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-26.549141, -14.191854, 0.104612), new Point(-26.078421, -18.139011, -0.159474), new Point(-23.429647, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -21.262924, -0.435386), new Point(-7.019857, -18.139015, -0.159474), new Point(-14.749139, -14.937439, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -24.191856, -0.435386), new Point(-12.601982, -23.721138, -0.159474), new Point(-15.803555, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -24.191856, -0.435386), new Point(-20.496298, -23.721138, -0.159474), new Point(-17.294724, -15.991856, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -7.120788, -0.435386), new Point(-20.496298, -4.662574, -0.159474), new Point(-17.294724, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -4.191855, -0.435386), new Point(-20.496298, -4.662574, -0.159474), new Point(-17.294724, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -4.191855, -0.435386), new Point(-12.601981, -4.662574, -0.159474), new Point(-15.803555, -12.391855, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -7.120788, -0.435386), new Point(-7.019857, -10.244698, -0.159474), new Point(-14.749139, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.549133, -14.191856, -0.435381), new Point(-7.019857, -10.244698, -0.159474), new Point(-14.749139, -13.446272, -7.500958)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.549133, -14.191856, -0.435381), new Point(-7.019857, -18.139015, -0.159474), new Point(-14.74914, -14.937439, -7.50096)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-26.549141, -14.191854, 0.104612), new Point(-26.078421, -10.244698, -0.159474), new Point(-23.429647, -11.341854, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -7.120787, 0.104612), new Point(-26.078421, -10.244698, -0.159474), new Point(-23.429647, -11.341856, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -7.120787, 0.104612), new Point(-20.496298, -4.662574, -0.159474), new Point(-19.399137, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -4.191854, 0.104612), new Point(-20.496298, -4.662574, -0.159474), new Point(-19.399139, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -4.191854, 0.104612), new Point(-12.601981, -4.662574, -0.159474), new Point(-13.699138, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.47807, -7.120788, 0.104612), new Point(-12.601981, -4.662574, -0.159474), new Point(-13.699139, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.47807, -7.120788, 0.104612), new Point(-7.019857, -10.244698, -0.159474), new Point(-9.668631, -11.341856, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.549137, -14.191856, 0.104612), new Point(-7.019857, -10.244698, -0.159474), new Point(-9.668631, -11.341854, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.549137, -14.191856, 0.104612), new Point(-7.019857, -18.139015, -0.159474), new Point(-9.668631, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.478071, -21.262924, 0.104612), new Point(-13.699141, -21.072365, 2.24858), new Point(-9.668631, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-12.518631, -18.222364, 3.059921), new Point(-13.699141, -21.072365, 2.24858), new Point(-9.668631, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549137, -24.191856, 0.104612), new Point(-19.399139, -21.072365, 2.24858), new Point(-13.699139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -19.891855, 3.059921), new Point(-19.399139, -21.072365, 2.24858), new Point(-13.699139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620209, -21.262924, 0.104612), new Point(-23.429647, -17.041855, 2.24858), new Point(-19.399139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-20.579647, -18.222363, 3.059921), new Point(-23.429647, -17.041855, 2.24858), new Point(-19.399139, -21.072365, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-26.549141, -14.191854, 0.104612), new Point(-23.429647, -11.341854, 2.24858), new Point(-23.429647, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-22.249138, -14.191855, 3.059921), new Point(-23.429647, -11.341854, 2.24858), new Point(-23.429647, -17.041855, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.620207, -7.120787, 0.104612), new Point(-19.399137, -7.311347, 2.24858), new Point(-23.429647, -11.341856, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-20.579647, -10.161346, 3.059921), new Point(-19.399139, -7.311347, 2.24858), new Point(-23.429647, -11.341856, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -4.191854, 0.104612), new Point(-13.699138, -7.311347, 2.24858), new Point(-19.399139, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-16.549139, -8.491856, 3.059921), new Point(-13.699138, -7.311347, 2.24858), new Point(-19.399139, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.47807, -7.120788, 0.104612), new Point(-9.668631, -11.341856, 2.24858), new Point(-13.699139, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-12.51863, -10.161346, 3.059921), new Point(-9.668631, -11.341856, 2.24858), new Point(-13.699139, -7.311347, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-6.549137, -14.191856, 0.104612), new Point(-9.668631, -17.041855, 2.24858), new Point(-9.668631, -11.341854, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-10.849139, -14.191855, 3.059921), new Point(-9.668631, -17.041855, 2.24858), new Point(-9.668631, -11.341854, 2.24858)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-13.699141, -21.072365, 2.24858), new Point(-16.549139, -19.891855, 3.059921), new Point(-12.518631, -18.222364, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-19.399139, -21.072363, 2.24858), new Point(-20.579647, -18.222363, 3.059921), new Point(-16.549139, -19.891855, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.429647, -17.041855, 2.24858), new Point(-22.249138, -14.191855, 3.059921), new Point(-20.579647, -18.222363, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-23.429647, -11.341856, 2.24858), new Point(-20.579647, -10.161346, 3.059921), new Point(-22.249138, -14.191855, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-19.399139, -7.311347, 2.24858), new Point(-16.549139, -8.491856, 3.059921), new Point(-20.579647, -10.161346, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-13.699139, -7.311347, 2.24858), new Point(-12.51863, -10.161346, 3.059921), new Point(-16.549139, -8.491856, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.668631, -11.341856, 2.24858), new Point(-10.849139, -14.191855, 3.059921), new Point(-12.51863, -10.161346, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(-9.668631, -17.041855, 2.24858), new Point(-12.518631, -18.222364, 3.059921), new Point(-10.849139, -14.191855, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Polygon(new Point(-10.849139, -14.191855, 3.059921), new Point(-12.51863, -10.161346, 3.059921), new Point(-16.549139, -8.491856, 3.059921), new Point(-20.579647, -10.161346, 3.059921), new Point(-22.249138, -14.191855, 3.059921), new Point(-20.579647, -18.222363, 3.059921), new Point(-16.549139, -19.891855, 3.059921), new Point(-12.518631, -18.222364, 3.059921)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(11.178186, -14.937441, -7.970675), new Point(10.284786, -15.991856, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.397022, -21.262924, -4.783639), new Point(11.178186, -14.937441, -7.970675), new Point(10.284786, -15.991856, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(10.284786, -15.991856, -7.410651), new Point(9.021326, -15.991856, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(9.021326, -15.991856, -6.618657), new Point(8.127926, -14.937439, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.414467, -21.262924, 2.727574), new Point(9.021326, -15.991856, -6.618657), new Point(8.127926, -14.937439, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.405743, -24.191856, -1.028031), new Point(10.284786, -15.991856, -7.410651), new Point(9.021326, -15.991856, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(8.127926, -14.937439, -6.058632), new Point(8.127926, -13.446272, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(4.932798, -14.191854, 4.283198), new Point(8.127926, -14.937439, -6.058632), new Point(8.127926, -13.446272, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(8.127926, -13.446272, -6.058632), new Point(9.021326, -12.391855, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.414467, -7.120788, 2.727574), new Point(8.127926, -13.446272, -6.058632), new Point(9.021326, -12.391855, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(9.021326, -12.391855, -6.618657), new Point(10.284786, -12.391855, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.405745, -4.191855, -1.028032), new Point(9.021326, -12.391855, -6.618657), new Point(10.284786, -12.391855, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(10.284786, -12.391855, -7.410651), new Point(11.178186, -13.446272, -7.970675)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.397022, -7.120788, -4.783639), new Point(10.284786, -12.391855, -7.410651), new Point(11.178186, -13.446272, -7.970675)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(8.829294, -14.191855, -8.328792), new Point(11.178186, -13.446272, -7.970675), new Point(11.178185, -14.937439, -7.970676)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(21.878698, -14.191856, -6.339262), new Point(11.178186, -13.446272, -7.970675), new Point(11.178185, -14.937439, -7.970676)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.397022, -21.262924, -4.783639), new Point(16.896692, -23.721138, -2.890679), new Point(10.284786, -15.991856, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.414467, -21.262924, 2.727574), new Point(10.207882, -23.721138, 1.302174), new Point(9.021326, -15.991856, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.414467, -21.262924, 2.727574), new Point(5.478178, -18.139011, 4.266968), new Point(8.127926, -14.937439, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(4.932798, -14.191854, 4.283198), new Point(5.478178, -18.139011, 4.266968), new Point(8.127926, -14.937439, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(4.932798, -14.191854, 4.283198), new Point(5.478178, -10.244698, 4.266968), new Point(8.127926, -13.446272, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.414467, -7.120788, 2.727574), new Point(5.478178, -10.244698, 4.266968), new Point(8.127926, -13.446272, -6.058632)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.397022, -7.120788, -4.783639), new Point(16.896694, -4.662574, -2.89068), new Point(10.284786, -12.391855, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.683826, -21.262924, -4.326102), new Point(21.626398, -18.139015, -5.855474), new Point(20.661077, -17.041855, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.683826, -21.262924, -4.326102), new Point(16.896692, -23.721138, -2.890679), new Point(17.246048, -21.072365, -0.267622)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.692548, -24.191856, -0.570494), new Point(16.896692, -23.721138, -2.890679), new Point(17.246052, -21.072365, -0.267623)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.692548, -24.191856, -0.570494), new Point(10.207882, -23.721138, 1.302174), new Point(12.41647, -21.072365, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.701269, -21.262924, 3.185114), new Point(10.207882, -23.721138, 1.302174), new Point(12.41647, -21.072365, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.701269, -21.262924, 3.185114), new Point(5.478178, -18.139011, 4.266968), new Point(9.001442, -17.041855, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(5.219601, -14.191854, 4.740737), new Point(5.478178, -18.139011, 4.266968), new Point(9.001442, -17.041855, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.397022, -21.262924, -4.783639), new Point(21.626398, -18.139015, -5.855474), new Point(11.178186, -14.937439, -7.970675)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.405745, -24.191856, -1.028032), new Point(16.896692, -23.721138, -2.890679), new Point(10.284786, -15.991856, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.405745, -24.191856, -1.028032), new Point(10.207882, -23.721138, 1.302174), new Point(9.021326, -15.991856, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.414467, -7.120788, 2.727574), new Point(10.207882, -4.662574, 1.302174), new Point(9.021326, -12.391855, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.405745, -4.191855, -1.028032), new Point(10.207882, -4.662574, 1.302174), new Point(9.021326, -12.391855, -6.618657)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.405745, -4.191855, -1.028032), new Point(16.896694, -4.662574, -2.89068), new Point(10.284786, -12.391855, -7.410651)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.397022, -7.120788, -4.783639), new Point(21.626398, -10.244698, -5.855474), new Point(11.178186, -13.446272, -7.970675)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(21.878698, -14.191856, -6.339262), new Point(21.626398, -10.244698, -5.855474), new Point(11.178186, -13.446272, -7.970675)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(21.878698, -14.191856, -6.339262), new Point(21.626398, -18.139015, -5.855474), new Point(11.178185, -14.937439, -7.970676)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(5.219601, -14.191854, 4.740737), new Point(5.478178, -10.244698, 4.266968), new Point(9.001442, -11.341854, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.701271, -7.120787, 3.185112), new Point(5.478178, -10.244698, 4.266968), new Point(9.001442, -11.341856, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.701271, -7.120787, 3.185112), new Point(10.207882, -4.662574, 1.302174), new Point(12.416471, -7.311347, 2.759777)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.69255, -4.191854, -0.570495), new Point(10.207882, -4.662574, 1.302174), new Point(12.41647, -7.311347, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.69255, -4.191854, -0.570495), new Point(16.896694, -4.662574, -2.89068), new Point(17.246052, -7.311347, -0.267624)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.683828, -7.120788, -4.326102), new Point(16.896694, -4.662574, -2.89068), new Point(17.246052, -7.311347, -0.267623)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.683828, -7.120788, -4.326102), new Point(21.626398, -10.244698, -5.855474), new Point(20.661077, -11.341856, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(22.165499, -14.191856, -5.881726), new Point(21.626398, -10.244698, -5.855474), new Point(20.661077, -11.341854, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(22.165499, -14.191856, -5.881726), new Point(21.626398, -18.139015, -5.855474), new Point(20.661077, -17.041855, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.683826, -21.262924, -4.326102), new Point(17.246048, -21.072365, -0.267622), new Point(20.661077, -17.041855, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(18.67721, -18.222364, -0.207172), new Point(17.246048, -21.072365, -0.267622), new Point(20.661077, -17.041855, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.692552, -24.191856, -0.570496), new Point(12.41647, -21.072365, 2.759778), new Point(17.246052, -21.072365, -0.267623)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(15.262182, -19.891855, 1.933523), new Point(12.41647, -21.072365, 2.759778), new Point(17.246052, -21.072365, -0.267623)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.701269, -21.262924, 3.185114), new Point(9.001442, -17.041855, 4.900475), new Point(12.41647, -21.072365, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(11.847155, -18.222363, 4.074219), new Point(9.001442, -17.041855, 4.900475), new Point(12.41647, -21.072365, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(5.219601, -14.191854, 4.740737), new Point(9.001442, -11.341854, 4.900475), new Point(9.001442, -17.041855, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(10.432604, -14.191855, 4.960924), new Point(9.001442, -11.341854, 4.900475), new Point(9.001442, -17.041855, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(7.701271, -7.120787, 3.185112), new Point(12.416471, -7.311347, 2.759777), new Point(9.001442, -11.341856, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(11.847155, -10.161346, 4.074219), new Point(12.41647, -7.311347, 2.759778), new Point(9.001442, -11.341856, 4.900475)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(13.69255, -4.191854, -0.570495), new Point(17.246052, -7.311347, -0.267624), new Point(12.41647, -7.311347, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(15.262182, -8.491856, 1.933523), new Point(17.246052, -7.311347, -0.267624), new Point(12.41647, -7.311347, 2.759778)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(19.683828, -7.120788, -4.326102), new Point(20.661077, -11.341856, -2.408319), new Point(17.246052, -7.311347, -0.267623)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(18.677212, -10.161346, -0.207173), new Point(20.661077, -11.341856, -2.408319), new Point(17.246052, -7.311347, -0.267623)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(22.165499, -14.191856, -5.881726), new Point(20.661077, -17.041855, -2.408319), new Point(20.661077, -11.341854, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(20.091763, -14.191855, -1.093878), new Point(20.661077, -17.041855, -2.408319), new Point(20.661077, -11.341854, -2.408319)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(17.246048, -21.072365, -0.267622), new Point(15.262182, -19.891855, 1.933523), new Point(18.67721, -18.222364, -0.207172)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(12.41647, -21.072363, 2.759778), new Point(11.847155, -18.222363, 4.074219), new Point(15.262182, -19.891855, 1.933523)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(9.001442, -17.041855, 4.900475), new Point(10.432604, -14.191855, 4.960924), new Point(11.847155, -18.222363, 4.074219)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(9.001442, -11.341856, 4.900475), new Point(11.847155, -10.161346, 4.074219), new Point(10.432604, -14.191855, 4.960924)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(12.41647, -7.311347, 2.759778), new Point(15.262182, -8.491856, 1.933523), new Point(11.847155, -10.161346, 4.074219)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(17.246052, -7.311347, -0.267623), new Point(18.677212, -10.161346, -0.207173), new Point(15.262182, -8.491856, 1.933523)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(20.661077, -11.341856, -2.408319), new Point(20.091763, -14.191855, -1.093878), new Point(18.677212, -10.161346, -0.207173)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Triangle(new Point(20.661077, -17.041855, -2.408319), new Point(18.67721, -18.222364, -0.207172), new Point(20.091763, -14.191855, -1.093878)).setMaterial(new Material().setKd(0.1).setKs(1d).setnShininess(10).setKt(0.6).setKr(0.5)).setEmission(new Color(0.6,1,0.6)),
				new Plane(new Point(0, 0, -9), new Vector(0, 0, 1)).setMaterial(new Material().setKd(0.2).setKs(0.2d).setnShininess(60).setKt(0.0).setKr(0.5)).setEmission(new Color(100,100,100))
		));

		scene.lights.add(
				new PointLight(new Color(100, 200, 100), new Point(-10, -1, 2)));
		scene.lights.add(
				new PointLight(new Color(200, 100, 100), new Point(10, -1, 2)));
		scene.lights.add(
				new SpotLight(new Color(150, 50, 100), new Point(-5, 10, 10), new Vector(1, -2, -2)));
		scene.lights.add(
				new SpotLight(new Color(50, 150, 100), new Point(5, 10, 10), new Vector(-1, -2, -2)));
		scene.lights.add(
				new DirectionalLight(new Color(100, 100, 100), new Vector(0, 0, -1))
		);
		cameraBuilder
				.build()
				.renderImage()
				.writeToImage();
	}
}
