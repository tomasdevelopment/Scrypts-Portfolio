

    // Method to calculate the area of a rectangle
 
public class rectanglearea {
	
	    // Method to calculate the area of a rectangle
	    public static int calculateArea(int length, int width) {
	        return length * width;
	    }

	    public static void main(String[] args) {
	        // Example rectangle dimensions
	        int length = 10;
	        int width = 5;

	        // Calculate and display the area of the rectangle
	        int area = calculateArea(length, width);
	        System.out.println("The area of the rectangle with length " + length + " and width " + width + " is: " + area);
	    }
	}

