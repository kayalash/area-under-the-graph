// Kayalash Vimalan & Allen Lam
// April 11, 2016
// ICS4U
// this is the Area Under the Graph program
// The "AreaUnderTheGraph" class.
import java.awt.*;
import hsa.Console;
import java.io.*;
import java.awt.geom.*;
public class AreaUnderTheGraph
{
    static Console c;           // The output console

    public static void main (String[] args) throws IOException
    {
	c = new Console ();
	int choice = 0, trig = 0;
	double abc[] = new double [3];
	double deltax[] = new double [4];
	double mb[] = new double [2];
	choice = function (); // calls function method
	if (choice == 1) // excutes if choice is linear (1)
	{
	    mb = linearequation ();
	    deltax = rectangles ();
	    clear ();
	    graphlinear (mb, deltax);
	    clear ();
	    double info[] [] = new double [(int) (deltax [0])] [3];
	    info = calculatelinear (mb, deltax);
	    printer (info, deltax); // calls printer method to print out info to area.txt
	}
	else if (choice == 2) // excutes if choice is quadratic (2)
	{
	    abc = quadraticequation ();
	    deltax = rectangles ();
	    clear ();
	    graphquadratic (abc, deltax);
	    clear ();
	    double info[] [] = new double [(int) (deltax [0])] [3];
	    info = calculatequadratic (abc, deltax);
	    printer (info, deltax); // calls printer method to print out info to area.txt
	}
	else if (choice == 3) // excutes if choice is trigonometric (3)
	{
	    trig = trigonmetricequation ();
	    deltax = rectangles ();
	    clear ();
	    graphtrigonometric (trig, deltax);
	    clear ();
	    double info[] [] = new double [(int) (deltax [0])] [3];
	    info = calculatetrigonometric (trig, deltax);
	    printer (info, deltax); // calls printer method to print out info to area.txt
	}
    } // main method


    public static int function ()  // function method reads in type of equation
    {
	c.println ("Welcome to the Area Under the Curve Program!");
	c.println (" ");
	c.println ("1. Linear");
	c.println ("2. Quadratic");
	c.println ("3. Trigonometric");
	c.println (" ");
	c.print ("Choose an equation type: ");
	int choice;
	choice = c.readInt ();
	if (choice == 1)
	{
	    c.println ("You have chosen Linear");
	}
	else if (choice == 2)
	{
	    c.println ("You have chosen Quadratic");
	}
	else if (choice == 3)
	{
	    c.println ("You have chosen Trigonmetric");
	}
	return choice;
    } //function method


    public static double[] linearequation ()  // linearequation method reads in 'm' and 'b'
    {
	double[] mb = new double [2];
	c.println (" ");
	c.println ("The equation for a linear function is y = mx + b ");
	c.print ("Enter 'm': ");
	mb [0] = c.readInt ();
	c.print ("Enter 'b': ");
	mb [1] = c.readInt ();
	c.println ("Your equation is y = " + mb [0] + "x + " + mb [1]);
	return mb;
    } // linearequation method


    public static double[] quadraticequation ()  // quadraticequation method reads in 'a', 'b' and 'c'
    {
	double abc[] = new double [3];
	c.println ("A quadratic equation takes the form of ax^2 + bx + c");
	c.print ("Enter the value for 'a': ");
	abc [0] = c.readDouble ();
	c.print ("Enter the value for 'b': ");
	abc [1] = c.readDouble ();
	c.print ("Enter the value for 'c': ");
	abc [2] = c.readDouble ();
	c.println ("The quadratic equation is " + abc [0] + "x^2 + " + abc [1] + "x + " + abc [2]);
	return abc;
    } // quadraticequation method


    public static int trigonmetricequation ()  // trigonometricequation method reads in choice of sinx, cosx, and tanx
    {
	int trig;
	c.println ("There are 3 trigonmetric functions to choose from: ");
	c.println ("1. sinx");
	c.println ("2. cosx");
	c.println ("3. tanx");
	c.print ("Enter your choice: ");
	trig = c.readInt ();
	if (trig == 1)
	{
	    c.println ("You chose sinx");
	}
	else if (trig == 2)
	{
	    c.println ("You chose cosx");
	}
	else if (trig == 3)
	{
	    c.println ("You chose tanx");
	}
	return trig;
    } // trigonometricequation method


    public static double[] rectangles ()  // rectangles method reads in # of rectangles and left & right boundries
    {
	double deltax[] = new double [4];
	c.println ();
	c.print ("Enter the number of rectangles you wish to use: ");
	deltax [0] = c.readDouble ();
	c.print ("Enter the left boundary: ");
	deltax [1] = c.readDouble ();
	c.print ("Enter the right boundary: ");
	deltax [2] = c.readDouble ();
	deltax [3] = (deltax [2] - deltax [1]) / deltax [0];
	c.println ();
	c.println ("The number of rectangles is " + deltax [0]);
	c.println ("The left boundry is " + deltax [1]);
	c.println ("The right boundry is " + deltax [2]);
	c.println ("The width of each rectangle is " + deltax [3]);
	return deltax;
    } // rectangles method


    public static void clear ()  // clear method clears screen
    {
	c.print ("Press enter if you would like to move on to the next step: ");
	char x = c.readChar ();
	c.clear ();
    } // clear method


    public static void graphlinear (double[] mb, double[] deltax)  // graphlinear method draws linear graph and rectangles
    {
	double lin, e, a, l;
	int b, x, y;
	axis ();
	for (int i = 0 ; i <= 65 ; i++)
	{
	    lin = mb [0] * i + mb [1];
	    b = (int) lin;
	    x = (10 * i) + 10;
	    y = 250 - (10 * b);
	    c.drawOval (x, y, 1, 1);
	}
	for (double z = deltax [1] ; z < deltax [2] ; z += deltax [3])
	{
	    e = mb [0] * z + mb [1];
	    a = (10 * z) + 10;
	    l = 250 - (10 * Math.abs (e));
	    if (e > 0)
	    {
		c.drawRect ((int) a, (int) l, (int) (deltax [3] * 10), (int) (250 - l));
	    }
	    else if (e < 0)
	    {
		c.drawRect ((int) a, 250, (int) (deltax [3] * 10), (int) (250 - l));
	    }
	}
	c.println ("Every line is one unit.");
    } // graphlinear method


    public static void graphquadratic (double[] abc, double[] deltax)  // graphquadratic method draws quadratic graph and rectangles
    {
	axis ();
	double quad, e, a, l;
	int b, x, y;
	for (int i = 0 ; i <= 65 ; i++)
	{
	    quad = (abc [0] * Math.pow (i, 2)) + (abc [1] * i) + abc [2];
	    b = (int) quad;
	    x = (10 * i) + 10;
	    y = 250 - (10 * b);

	    c.drawOval (x, y, 1, 1);
	}
	for (double z = deltax [1] ; z < deltax [2] ; z += deltax [3])
	{
	    e = abc [0] * Math.pow (z, 2) + abc [1] * z + abc [2];
	    a = (10 * z) + 10;
	    l = 250 - (10 * Math.abs (e));
	    if (e > 0)
	    {
		c.drawRect ((int) a, (int) l, (int) (deltax [3] * 10), (int) (250 - l));
	    }
	    else
	    {
		c.drawRect ((int) a, 250, (int) (deltax [3] * 10), (int) Math.abs (250 - l));
	    }
	}
	c.println ("Every line is one unit.");
    } // graphquadratic method


    public static void axis ()  // axis method draws axis for graphlinear and graphquadratic methods
    {
	c.drawLine (10, 250, 650, 250);
	c.drawLine (10, 10, 10, 600);
	for (int y = 10 ; y <= 650 ; y += 10)
	{
	    c.drawLine (8, y, 12, y);
	}
	for (int x = 10 ; x <= 650 ; x += 10)
	{
	    c.drawLine (x, 248, x, 252);
	}
    } // axis method


    public static void graphtrigonometric (int trig, double[] deltax)  // graphtrigonometric method selects which graph to draw
    {
	if (trig == 1)
	{
	    graphsin (deltax);
	}
	else if (trig == 2)
	{
	    graphcos (deltax);
	}
	else if (trig == 3)
	{
	    graphtan (deltax);
	}
    } // graphquadratic method


    public static void graphsin (double[] deltax)  // graphsin method draws sin graph and rectangles
    {
	double sinvalue, e;
	int b;
	for (int x = 0 ; x <= 360 ; x = x + 1)
	{
	    sinvalue = Math.sin (x * Math.PI / 180.0);
	    b = (int) (sinvalue * 100);
	    c.drawOval (100 + x, 200 - b, 1, 1);
	}
	c.drawLine (100, 200, 600, 200);
	c.drawLine (100, 100, 100, 300);
	for (double z = deltax [1] ; z < deltax [2] ; z += deltax [3])
	{
	    e = (Math.sin (z * Math.PI / 180.0)) * 100;
	    if (e > 0)
	    {
		c.drawRect ((int) (100 + z), (int) (200 - e), (int) (deltax [3]), (int) e);
	    }
	    else
	    {
		c.drawRect ((int) (100 + z), 200, (int) (deltax [3]), (int) (Math.abs (e)));
	    }
	}
    } // graphsin method


    public static void graphcos (double[] deltax)  // graphcos method draws cos graph and rectangles
    {
	double cosvalue, e;
	int b;
	for (int x = 0 ; x <= 360 ; x = x + 1)
	{
	    cosvalue = Math.cos (x * Math.PI / 180.0);
	    b = (int) (cosvalue * 100);
	    c.drawOval (100 + x, 200 - b, 1, 1);
	}
	c.drawLine (100, 200, 600, 200);
	c.drawLine (100, 100, 100, 300);
	for (double z = deltax [1] ; z < deltax [2] ; z += deltax [3])
	{
	    e = (Math.cos (z * Math.PI / 180.0)) * 100;
	    if (e > 0)
	    {
		c.drawRect ((int) (100 + z), (int) (200 - e), (int) (deltax [3]), (int) e);
	    }
	    else
	    {
		c.drawRect ((int) (100 + z), 200, (int) (deltax [3]), (int) (Math.abs (e)));
	    }
	}
    } // graphcos method


    public static void graphtan (double[] deltax)  // graphtan method draws tan graph and rectangles
    {
	double tanvalue, e;
	int b;
	for (int x = 0 ; x <= 360 ; x = x + 1)
	{
	    tanvalue = Math.tan (x * Math.PI / 180.0);
	    b = (int) (tanvalue * 100);
	    c.drawOval (100 + x, 200 - b, 1, 1);
	}
	c.drawLine (100, 200, 600, 200);
	c.drawLine (100, 100, 100, 300);
	for (double z = deltax [1] ; z < deltax [2] ; z += deltax [3])
	{
	    e = (Math.tan (z * Math.PI / 180.0)) * 100;
	    c.drawRect ((int) (100 + z), (int) (200 - e), (int) (deltax [3]), (int) e);
	}
    } // graphtan method


    public static double[] [] calculatelinear (double[] mb, double[] deltax)  // calculatelinear method caculates rectangles under linear graph
    {
	int num = (int) deltax [0];
	double rect[] [] = new double [num] [3];
	double sum = 0;
	int x = 0, y = 0, z = 0;
	for (double i = deltax [1] ; i < deltax [2] ; i += deltax [3])
	{
	    rect [x] [0] = i;
	    rect [y] [1] = mb [0] * i + mb [1];
	    rect [z] [2] = rect [y] [1] * deltax [3];
	    sum += rect [z] [2];
	    x++;
	    y++;
	    z++;
	}
	c.println ("The area is " + sum);
	return (rect);
    } // calculatequadratic method


    public static double[] [] calculatequadratic (double[] abc, double[] deltax)  // calculatequadratic method calculates rectangles under quadratic graph
    {
	int num = (int) deltax [0];
	double rect[] [] = new double [num] [3];
	double sum = 0;
	int x = 0, y = 0, z = 0;
	for (double i = deltax [1] ; i < deltax [2] ; i += deltax [3])
	{
	    rect [x] [0] = i;
	    rect [y] [1] = ((abc [0] * Math.pow (i, 2)) + ((abc [1] * i)) + (abc [2]));
	    rect [z] [2] = rect [y] [1] * deltax [3];
	    sum += rect [z] [2];
	    x++;
	    y++;
	    z++;
	}
	c.println ("The area is " + sum);
	return rect;
    } // calculatequadratic method


    public static double[] [] calculatetrigonometric (int trig, double[] deltax)  // calculatetrigonometric method calculates rectangles under trigonometric graph
    {
	int num = (int) deltax [0];
	double rect[] [] = new double [num] [3];
	double sum = 0;
	int x = 0, y = 0, z = 0;
	for (double i = deltax [1] ; i < deltax [2] ; i += deltax [3])
	{
	    rect [x] [0] = i;
	    if (trig == 1)
	    {
		rect [y] [1] = Math.sin (i);
	    }
	    else if (trig == 2)
	    {
		rect [y] [1] = Math.cos (i);
	    }
	    else if (trig == 3)
	    {
		rect [y] [1] = Math.tan (i);
	    }
	    rect [z] [2] = rect [y] [1] * deltax [3];
	    sum += rect [z] [2];
	    x++;
	    y++;
	    z++;
	}
	c.println ("The area is " + sum);
	return rect;
    } // calculatequadratic method


    public static void printer (double[] [] info, double[] deltax) throws IOException // prints out calculation to area.txt file
    {
	String[] title = new String [3];
	title [0] = "x       ";
	title [1] = "f(x)    ";
	title [2] = "xf(x)";
	PrintWriter output;
	output = new PrintWriter (new FileWriter ("area.txt"));
	for (int count = 0 ; count <= 2 ; count++)
	{
	    output.print (title [count]);
	}
	output.println ("");
	for (int row = 0 ; row < (int) deltax [0] ; row++)
	{
	    for (int column = 0 ; column < 3 ; column++)
	    {
		output.print (info [row] [column] + "     ");
	    }
	    output.println ("");
	}
	output.close ();
    }
} // AreaUnderTheGraph class
