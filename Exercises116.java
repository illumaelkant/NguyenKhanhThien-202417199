import java.util.Scanner;

public class Exercises116 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select equaton to solve:");
        System.out.println("1. First-degree equation (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation (ax^2 + bx + c = 0)");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                solveFirstDegreeEquation(input);
                break;
            case 2:
                solveSystemOfEquations(input);
                break;
            case 3:
                solveSecondDegreeEquation(input);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        
        input.close();
    }

    public static void solveFirstDegreeEquation(Scanner input) {
        System.out.print("Enter the value of a: ");
        double a = input.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = input.nextDouble();

        if (a == 0) {
            System.out.println("Invalid equation, a cannot be 0.");
        } else {
            double x = -b / a;
            System.out.println("The solution is: x = " + x);
        }
    }

   
    public static void solveSystemOfEquations(Scanner input) {
        System.out.println("Enter the coefficients for the system of equations:");
        System.out.print("a11: ");
        double a11 = input.nextDouble();
        System.out.print("a12: ");
        double a12 = input.nextDouble();
        System.out.print("b1: ");
        double b1 = input.nextDouble();
        System.out.print("a21: ");
        double a21 = input.nextDouble();
        System.out.print("a22: ");
        double a22 = input.nextDouble();
        System.out.print("b2: ");
        double b2 = input.nextDouble();

        double D = a11*a22-a12*a21;
        double D1 =a22-b2*a12;
        double D2 = a11*b2-a21*b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solution is: x1 = " + x1 + ", x2 = " + x2);
        }
    }

    public static void solveSecondDegreeEquation(Scanner input) {
        System.out.print("Enter the value of a: ");
        double a = input.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = input.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = input.nextDouble();

        if (a == 0) {
            System.out.println("Invalid equation, a cannot be 0.");
        } else {
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The equation has two distinct roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root: x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}
