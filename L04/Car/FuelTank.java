
public class FuelTank
{
    private float capacity; // capacity in litres for this fuel tank object
    private float level; // fuel level between 0 and 1

    public static final float CAPACITY_MIN = 4f;

    public static final float CAPACITY_MAX = 200f;

    public static final float LEVEL_MIN = 0f;

    public static final float LEVEL_MAX = 1f;

    public static final float DEFAULT_CAPACITY = 60f;

    public FuelTank()
    {
        this(DEFAULT_CAPACITY, 1f);
    }

    public FuelTank(float cap, float level)
    {
        this.capacity = cap;
        this.level = level;
        
        if (cap < CAPACITY_MIN || cap > CAPACITY_MAX)
        {
            System.out.println("Invalid capacity  " + cap + 
            " for fuel tank. Adjusted to 60");
            cap = DEFAULT_CAPACITY;
        }
        if (level < LEVEL_MIN || level > LEVEL_MAX)
        {
            System.out.println("Invalid fuel level: " + level + 
            ". Adjusted to 0, i.e. empty");
            this.level = 0f;
        }
    }

    public float fill(float amount)
    {
        float additionFuel = amount/capacity;
        if(level + additionFuel > 1)
        {
        	level = 1;
        	additionFuel = additionFuel + level - 1;
        }
        else
        {
        	level += additionFuel;
        	additionFuel = 0;
        }
        return additionFuel;
    }

    public boolean releaseFuel(float amount)
    {
        float fuelToEmpty = amount/capacity;
        if(level - fuelToEmpty < 0)
        {
        	level = 0;
        	return false;
        }
        else
        {
        	level -= fuelToEmpty;
        	return true;
        }
    }
 
    public float getCapacity()
    {
        return capacity;
    }

    public float getLevel()
    {
        return level;
    }
}
