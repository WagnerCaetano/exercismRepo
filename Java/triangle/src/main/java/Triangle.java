class Triangle {

    private double[] sides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        sides = new double[] {side1, side2, side3};
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] == 0 || sides[i] + sides[(i+1) % sides.length] < sides[(i+2) % sides.length]) {
                throw new TriangleException();
            }
        }
    }

    boolean isEquilateral() {
        for (int i = 0; i < 2; i++) {
            if(sides[i] != sides[i+1])
                return false;
        }
        return sides[0] == sides[2];
    }

    boolean isIsosceles() {
        return (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]);
    }

    boolean isScalene() {
        return (sides[0] != sides[1] && sides[0] != sides[2] && sides[1] != sides[2]);
    }

}
