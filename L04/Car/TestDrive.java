import java.awt.Color;
import java.util.Scanner;
/**
 * TestDrive demonstrates creating and calling 
 * methods on Car  object. 
 *
 * @author Laboratory Team
 */
public class TestDrive 
{
    Car cars[];
    /**
     * Default number of cars in a test drive
     */
    public static final int NUM_CARS=5;
    /**
     * Constuctor for class TestDrive
     * makes a test drive for NUM_CARS cars
     */
    TestDrive()
    {
        this(NUM_CARS);
    }

    /**
     * Constuctor for class TestDrive
     * makes a test drive for numCars cars
     * @param numCars number of cars in atest drive
     */

    TestDrive(int numCars)
    {
        if (numCars > 0)
            cars = new Car[numCars];
        else
            cars = new Car[NUM_CARS];
    }
    
    public Color getColor(String s)
    {
    	Color color;
    	switch(s.toLowerCase())
    	{
    	case "black": 
    		color = Color.BLACK;
    		break;
    	case "blue":
            color = Color.BLUE;
            break;
        case "gray":
            color = Color.GRAY;
            break;
        case "green":
            color = Color.GREEN;
            break;
        case "yellow":
            color = Color.YELLOW;
            break;
        case "orange":
            color = Color.ORANGE;
            break;
        case "red":
            color = Color.RED;
            break;
        default:
            color = Color.WHITE;
            break;
    	}
    	return color;
    }
    
    public static Scanner read()
    {
    	Scanner in = new Scanner(System.in);
    	return in;
    }
    
    public static void main(String []args) 
    {
    //	Scanner in = new Scanner(System.in);
    	System.out.println("Input the maximum number of cars you want in your test drive:");
    	int numCars = read().nextInt();
    	
        TestDrive td = new TestDrive(numCars);
        td.start(numCars);
        
        read().close();
    }
    
    public void start(int numCars)
    {
    	int k = 2;
    	boolean continueTest = true;
    	
    	cars[0] = new Car("Volskwagen Beetle", Color.orange, 80, 160, 20, 40, 6, 70);
        cars[1] = new Car("Ferrari Testarosa", Color.red, 300, 280, 30, 50, 7, 100);
    	
    	System.out.println("Welcome to your test drive!");
    	
    	while(continueTest)
    	{
    		
    	   	System.out.println("Please select your next action:");
            System.out.println("1. Create a new car");
            System.out.println("2. Select an existing car to take for a test drive");
            
           
            int i = read().nextInt();
        	if(i > 2 || i <= 0)
        		while(i > 2 || i <= 0)
    	    	{
    	    		System.out.println("Select a valid action! ");
    	    		i = read().nextInt();
    	    	}
        	
        	if(i == 1)
        		if(k < numCars)
        			cars[k++] = createCar();
        		else
        			{
        				System.out.println("The maximum number of cars for this test drive has been reached. Please choose one of the existing cars");
        				i = 2;
        			}
        	
        	if(i == 2)
        			selectCar(k);
        	
        	System.out.println("Type 'yes' if you want to continue your test drive");
        	
        	String action = read().nextLine();
        	
        	if(!(action.equals("yes")))
        		continueTest = false;
        	
    	}
    	
    	System.out.println("Your test drive is over!");
    }
    
	private Car createCar()
	{
		System.out.println("To create a new car, input a brand, color, power, max Speed, acceleration Step, breaking Step, Number of Gears and Tank capacity");
		
		String brand = read().nextLine();
		if(brand.length() == 0)
		{
			System.out.println("input a valid name brand");
			while(brand.length() == 0)
			{
				brand = read().nextLine();
			}
		}
		Color color = getColor(read().nextLine());
		int power = read().nextInt();
		int maxSpeed = read().nextInt();
		int accelerationStep = read().nextInt();
		int breakingStep = read().nextInt();
		int nrOfGears = read().nextInt();
		int cap = read().nextInt();
		
		Car c = new Car(brand, color, power, maxSpeed, accelerationStep, breakingStep, nrOfGears, cap);
		return c;
	}
    
    private void selectCar(int k)
    {
    	for(int i = 0; i < k; i++)
    	{
    		System.out.println(i+1 + ". Car is a " + cars[i].getBrandName());
    	}
    	System.out.println("select the car you want to take for a drive: ");
 
    	int i = read().nextInt();
    	if(i > k)
    		while(i > k)
	    	{
	    		System.out.println("Select an existing car! ");
	    		i = read().nextInt();
	    	}
    	
    	System.out.println("Starting " + cars[i-1].getBrandName() + " test drive!");
    	driveCar(cars[i-1]);
    	
    }
    
    private void driveCar(Car c) 
    {
        System.out.print("Car is a " + c.getBrandName());
        System.out.println(" colored  " + c.getColor());
        System.out.println(" maximum speed is " +c.getMaxSpeed());
        System.out.println(" number of gears is " +c.getGears());
        System.out.println(" capacity is " +c.getCapacity());
        
        //press the accelerator 15 "times"
        for(int i = 0; i < 15; i++) 
        {
            int speed = c.accelerate();
        	System.out.println("accelerating: " + speed + "\t\tgear: " + c.getCurrentGear());
            if(speed == c.getMaxSpeed())
            	break;
        }
        
        //release the accelerator 5 "times"
        for(int i = 0; i < 5; i++)
        {
            System.out.println("decelerating: " + c.decelerate() + "\t\tgear: " + c.getCurrentGear());
        }
        
        //press break 5 times
        for(int i = 0; i < 5; i++)
        {
        	int speed = c.breaking();
        	System.out.println("breaking: " + speed + "\t\tgear: " + c.getCurrentGear());
        	if(speed == 0)
            	break;
        }
        
        System.out.println("final cruising speed: " + c.getSpeed());
        System.out.println("final fuel in tank: " + c.getFuel());
    }
    
}
