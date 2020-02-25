import java.awt.Color;

public class Car 
{
  private String brandName; 
  private int speed = 0;  // current car speed
  private Color color;
  private int power;
  private int accelerationStep = 0; // speed increase when gas pedal pushed
  private int maxSpeed;           // maximum speed for this car
  private int breakingStep = 0;
  private int currentGear = 0;
  private int nrOfGears;
  private FuelTank fuelTank;
  private static final int MIN_SPEED = 0; // minimum speed for all cars; km/h
  private static final int MAX_SPEED = 300; // speed limit on all cars; km/h
  private static final int MIN_POWER = 4; // minimum power for all cars; no less than 4 bhp
  private static final int MAX_POWER = 500; // maximum power for all cars.no more than 500 bhp
  private static final int ACCELERATION_MIN_STEP = 1; // minimum speed increase per second when gas pedal pushed
  private static final int ACCELERATION_MAX_STEP = 30; // maximum speed increase per second when gas pedal pushed
  private static final int BREAKING_MIN_STEP = 25;
  private static final int BREAKING_MAX_STEP = 50;
  private static final int NR_GEARS_MIN = 4;
  private static final int NR_GEARS_MAX = 7;
  private static final int[] GEARS_SPEED_MIN = {-1, -1, 30, 60, 100, 140, 200, 250};
  private static final int[] GEARS_SPEED_MAX = {-1, 30, 60, 100, 140, 200, 250, 300};
  private static final float FUEL_CONSUMPTION_ACCELERATION = 3f;
  private static final float FUEL_CONSUMPTION_CRUISING = 0.5f;

  public Car(String brand, Color color, int power, int maxSpeed, int accelerationStep, int breakingStep, int nrOfGears, int capacity) 
  {
     //creates a new Car object with specified brand name
     this.brandName = brand;
     
     this.color = color;
     
     //set max speed
     if (maxSpeed < 0) 
    	 this.maxSpeed = MIN_SPEED; // this car wil never move
     else 
     if (maxSpeed <= MAX_SPEED) 
    	 this.maxSpeed = maxSpeed;
     else maxSpeed = MAX_SPEED;
     
     //set power
     if (power < MIN_POWER) 
    	 this.power = MIN_POWER;
     else 
     if (power > MAX_POWER) 
    	 this.power=MAX_POWER;
     else
    	 this.power = power;
     
     //set acceleration speed
     if (accelerationStep < ACCELERATION_MIN_STEP)
        this.accelerationStep = ACCELERATION_MIN_STEP;
     else
     if (accelerationStep > ACCELERATION_MAX_STEP)
        this.accelerationStep = ACCELERATION_MIN_STEP;
     else
        this.accelerationStep = accelerationStep;
     
     //set breaking step
     if (breakingStep < BREAKING_MIN_STEP)
         this.breakingStep = BREAKING_MIN_STEP;
      else
      if (breakingStep > BREAKING_MAX_STEP)
         this.breakingStep = BREAKING_MIN_STEP;
      else
         this.breakingStep = breakingStep;
     
     //set nr of gears
     if (nrOfGears < NR_GEARS_MIN) 
    	 this.nrOfGears = NR_GEARS_MIN;
     else 
     if (nrOfGears > NR_GEARS_MAX) 
    	 this.nrOfGears = NR_GEARS_MAX;
     else
    	 this.nrOfGears = nrOfGears;
     
     fuelTank = new FuelTank(capacity, 1);
  }

  public int accelerate() 
  {
     int newSpeed = speed + accelerationStep;
     float fuelInCar = fuelTank.getLevel()*fuelTank.getCapacity();
     float fuelConsumedAccelerating = FUEL_CONSUMPTION_ACCELERATION;
     float fuelConsumedCruising = FUEL_CONSUMPTION_CRUISING;
    
     if(fuelInCar >= fuelConsumedAccelerating)
     {
         if(newSpeed <= maxSpeed) 
         {
            speed = newSpeed;
         }
         else 
         {
            speed = maxSpeed;
         }
         fuelTank.releaseFuel(fuelConsumedAccelerating);
     }
     else if(fuelInCar >= fuelConsumedCruising)
     {
    	 System.out.println("Not enough fuel to accelerate");
    	 fuelTank.releaseFuel(fuelConsumedCruising);
     }
     else
     {
    	 System.out.println("No more fuel!");
    	 decelerate();
    	 fuelTank.releaseFuel(1);
     }

     
     changeGear();
     
     return speed;
  }
  
  public int decelerate() 
  {
	 int newspeed = speed - accelerationStep;
     if(newspeed >= MIN_SPEED) 
     {
        speed = newspeed;
     }
     else
     {
    	 speed = MIN_SPEED;
     }
     
     changeGear();
     
     return speed;
  }
  
  public int breaking()
  {
	  int newSpeed = speed - breakingStep;
	  if(newSpeed >= MIN_SPEED) 
	  {
	     speed = newSpeed;
	  }
	  else 
	  {
		  speed = MIN_SPEED;
	  }
	     
	  changeGear();
	     
	  return speed;
  }

  public void changeGear()
  {
	  if(speed < GEARS_SPEED_MIN[currentGear] && currentGear > 0)
		  currentGear--;
	  else if(speed > GEARS_SPEED_MAX[currentGear] && currentGear < nrOfGears)
		  currentGear++;
  }
  
  public int getSpeed() 
  {
     return speed;
  }
  
  public int getMaxSpeed() 
  {
     return maxSpeed;
  }

  public Color getColor() 
  {
     return color;
  }

  public String getBrandName() 
  {
     return brandName;
  }

  public int getAcceleration() 
  {
     return accelerationStep;
  }
  
  public int getBreak() 
  {
     return breakingStep;
  }
 
  public int getPower() 
  {
     return power;
  }
  
  public int getGears() 
  {
     return nrOfGears;
  }
  
  public int getCurrentGear()
  {
	  return currentGear;
  }
  
  public float getFuel()
  {
	  return fuelTank.getLevel()*fuelTank.getCapacity();
  }
  
  public float getCapacity()
  {
	  return fuelTank.getCapacity();
  }
}
