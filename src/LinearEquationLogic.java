import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner scan = new Scanner(System.in);
    private LinearEquation coordinates;
    private boolean repeat = true;


    public LinearEquationLogic () {}


    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (repeat) {
            getCoordinates();
            if (!coordinates.getZero())
                mid();
            end();
        }
        System.out.println("Thank you for using the slope calculator, Goodbye!");
    }

    //Helpers
    private void getCoordinates() {
        System.out.print("Enter your first coordinate (eg. (5, 7)) : ");
        String c1 = scan.nextLine();
        System.out.print("Enter your second coordinate (eg. (5, 7)) : ");
        String c2 = scan.nextLine();
        coordinates = new LinearEquation(c1, c2);
        System.out.println(coordinates.lineInfo());
    }
    private void mid() {
        System.out.println("");
        System.out.print("Enter a x value: ");
        double xVal = scan.nextDouble();
        System.out.println(coordinates.coordinateForX(xVal));
    }
    private void end() {
        System.out.println("");
        System.out.print("Would you like to enter another pair of coordinates? (y/n) : ");
        scan.nextLine();
        String yN = scan.nextLine();
        repeat = yN.equals("y");
    }
}
