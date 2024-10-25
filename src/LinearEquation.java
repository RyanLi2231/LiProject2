public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean zero = false;


    public LinearEquation (String coord1, String coord2) {
        x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(" ") + 1, coord1.indexOf(")")));
        x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(" ") + 1, coord2.indexOf(")")));
    }

    public double distance() {
        return roundToHundredth(Math.sqrt(Math.abs(Math.pow(x2 - x1, 2)) + Math.abs(Math.pow(y2 - y1, 2))));
    }
    public double yIntercept() {
        return roundToHundredth(y1 - slope() * x1);
    }
    public double slope() {
        if ((y2 - y1) == 0)
            return 0;
        return roundToHundredth((double) (y2 - y1) / (x2 - x1));
    }
    public String equation() {
        String adOrSub;
        String nOrP = "";
        String slope = Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        if ((y2 - y1 == Math.abs(y2 - y1) && x2 - x1 != Math.abs(x2 - x1)) || (y2 - y1 != Math.abs(y2 - y1) && x2 - x1 == Math.abs(x2 - x1))) {
            nOrP = "-";
        }
        if (yIntercept() == Math.abs(yIntercept()))
            adOrSub = " + ";
        else
            adOrSub = " - ";
        if (slope() == -1 || slope() == 1)
            slope = "";
        else if ((y2 - y1) % (x2 - x1) == 0)
            slope = Math.abs((y2 - y1) / (x2 - x1)) + "";


        if (slope() == 0)
            return "y = " + yIntercept();
        if (yIntercept() == 0)
            return "y = " + slope + "x";


        return "y = " + nOrP + (slope) + "x" + adOrSub + Math.abs(yIntercept());
    }
    public String coordinateForX(double x) {
        return "(" + x + ", " + roundToHundredth(slope() * x + yIntercept()) + ")";
    }
    public String lineInfo() {
        if (x2 - x1 == 0) {
            zero = true;
            return "These points are on a vertical line: x = " + x1;
        }
        return "The two points are: (" + x1 + ", " + y1 + ") and " + "(" + x2 + ", " + y2 + ") " +
                "\nThe equation of the line between these points is: " + equation() +
                "\nThe slope of this line is: " + slope() +
                "\nThe y-intercept of this line is: " + yIntercept() +
                "\nThe distance between these points is " + distance();
    }
    private double roundToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }


    //Getter
    public boolean getZero() {
        return zero;
    }
}
