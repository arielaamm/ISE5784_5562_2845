package XMLTool;

import geometries.*;
import lighting.AmbientLight;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

public class xmlTool {
    public static Scene renderFromXmlFile(String str) {
        List<String> list = List.of("sphere","cylinder", "triangle", "plane","polygon","tube");
        try {
            File inputFile = new File(str);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element sceneElement = doc.getDocumentElement();

            // Extracting background color attribute
            String backgroundColorStr = sceneElement.getAttribute("background-color");
            String[] bgColorArray = backgroundColorStr.split(" ");
            Color backgroundColor = new Color(Integer.parseInt(bgColorArray[0]),
                    Integer.parseInt(bgColorArray[1]),
                    Integer.parseInt(bgColorArray[2]));

            // Creating the Scene object
            Scene scene = new Scene("DefaultScene").setBackground(backgroundColor);

            // Extracting ambient light
            NodeList ambientLightList = sceneElement.getElementsByTagName("ambient-light");
            if (ambientLightList.getLength() > 0) {
                Element ambientLightElement = (Element) ambientLightList.item(0);
                String ambientColorStr = ambientLightElement.getAttribute("color");
                String[] ambientColorArray = ambientColorStr.split(" ");
                Color ambientColor = new Color(Integer.parseInt(ambientColorArray[0]),
                        Integer.parseInt(ambientColorArray[1]),
                        Integer.parseInt(ambientColorArray[2]));
                AmbientLight ambientLight = new AmbientLight(ambientColor,1);
                scene.setAmbientLight(ambientLight);
            }

            Element geometriesElement = (Element) doc.getElementsByTagName("geometries").item(0);
            for (String i : list)
            {
                NodeList geometriesList = geometriesElement.getElementsByTagName(i);
                int length = geometriesList.getLength();
                if (length == 0) continue;
                for (int j = 0; j < length; j++) {
                    Element item = (Element) geometriesList.item(j);
                    scene.geometries.add(createGeometry(i, item));
                }
            }
            return scene;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static Geometry createGeometry(String type, Element element) {
        switch (type) {
            case "sphere":
                Point p0Sphere= getPointFromString(element.getAttribute("center"));
                double radiusSphere = getDoubleFromString(element.getAttribute("radius"));
                return new Sphere(p0Sphere, radiusSphere);
            case "triangle":
                Point p0Triangle = getPointFromString(element.getAttribute("p0"));
                Point p1Triangle = getPointFromString(element.getAttribute("p1"));
                Point p2Triangle = getPointFromString(element.getAttribute("p2"));
                return new Triangle(p0Triangle, p1Triangle, p2Triangle);
            case "cylinder":
                String[] axisCylinder = element.getAttribute("axis").split(" {2}");
                Point p0Cylinder = getPointFromString(axisCylinder[0]);
                Vector v0Cylinder = (Vector)getPointFromString(axisCylinder[1]);
                double radiusCylinder = getDoubleFromString(element.getAttribute("radius"));
                double heightCylinder = getDoubleFromString(element.getAttribute("height"));
                return new Cylinder(radiusCylinder, new Ray(p0Cylinder, v0Cylinder), heightCylinder);
            case "plane":
                if(element.hasAttribute("normal"))
                {
                    Point p0Plane = getPointFromString(element.getAttribute("p0"));
                    Vector v0Plane = (Vector)getPointFromString(element.getAttribute("normal"));
                    return new Plane(p0Plane, v0Plane);
                }
                Point p0Plane = getPointFromString(element.getAttribute("p0"));
                Point p1Plane = getPointFromString(element.getAttribute("p1"));
                Point p2Plane = getPointFromString(element.getAttribute("p2"));
                return new Plane(p0Plane, p1Plane, p2Plane);
            case "polygon":
                Point[] points = new Point[element.getAttributes().getLength()];
                for (int i = 0; i < element.getAttributes().getLength(); i++) {
                    points[i] = getPointFromString(element.getAttribute("p"+i));
                }
                return new Polygon(points);
            case "tube":
                String[] axis = element.getAttribute("axis").split(" {2}");
                Point p0Tube = getPointFromString(axis[0]);
                Vector v0Tube = (Vector)getPointFromString(axis[1]);
                double radiusTube = getDoubleFromString(element.getAttribute("radius"));
                return new Tube(radiusTube, new Ray(p0Tube, v0Tube));
        }
        return null;
    }

    private static double getDoubleFromString(String radius) {
        return Double.parseDouble(radius);
    }

    private static Point getPointFromString(String str) {
        String[] centerArray = str.split("\\s+");
        double x = Double.parseDouble(centerArray[0]);
        double y = Double.parseDouble(centerArray[1]);
        double z = Double.parseDouble(centerArray[2]);
        return new Point(x, y, z);
    }
}