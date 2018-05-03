public class Golfer implements Comparable<Golfer> 
{
	// Invariant of the Golfer class:
	//  1. Implements Comparable interface - must have compareTo() mehtod. 
	//  2. Overrides compareTo method  in such a way that last names are compared by their ASCII values.
	private String lastname;    
	private int numberOfRounds;
	private double averageScore;
	private int handicap;
	
	// constructor which assigns lastName only
	public Golfer(String lastname) 
	{
		this.lastname=lastname;
	}
	
	// constructor which assigns all fields.
	public Golfer(String lastname, int numberOfRounds, double averageScore, int handicap) 
	{
		this.lastname = lastname;
		this.numberOfRounds = numberOfRounds;
		this.averageScore = averageScore;
		this.handicap = handicap;
	}
	/**
	   * updates averageScore property.
	   * @param double score.
	   * @postcondition averageScore updated.
	   * 
	   **/

	public void addScore(double score ) 
	{	
		averageScore = (numberOfRounds*averageScore+score)/++numberOfRounds;
	}
	/**
	   * accessor for lastName field 
	   * @param 
	   *   none
	   * @return lastName
	   * 
	   **/
	public String getLastname() 
	{
		return lastname;
	}
	/**
	   * modifier  for lastName field 
	   * @param String lastName 
	   * @return none
	   **/
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	/**
	   * accessor for numberOfRounds field 
	   * @param 
	   *   none
	   * @return numberOfRounds
	   * 
	   **/
	public int getNumberOfRounds() 
	{
		return numberOfRounds;
	}
	/**
	   * mutator for numberOfRounds field 
	   * @param 
	   *   int numberOfRounds
	   * @return none
	   * 
	   **/
	public void setNumberOfRounds(int numberOfRounds)
	{
		this.numberOfRounds = numberOfRounds;
	}
	/**
	   * accassor for averageScore field 
	   * @param 
	   *  none
	   * @return averageScore;
	   **/
	public double getAverageScore() 
	{
		return averageScore;
	}
	/**
	   * mutator for averageScore field 
	   * @param 
	   *   int averageScore
	   * @return none
	   * 
	   **/
	public void setAverageScore(double averageScore) 
	{
		this.averageScore = averageScore;
	}
	/**
	   * accassor for handicap field 
	   * @param 
	   *  none
	   * @return handicap;
	   **/
	public int getHandicap() 
	{
		return handicap;
	}
	/**
	   * mutator for handicap field 
	   * @param 
	   *   int handicap
	   * @return none
	   * 
	   **/
	public void setHandicap(int handicap) 
	{
		this.handicap = handicap;
	}

	/**
   *toString converts an Golfer object into a string 
   *@param -none
   *@precondition
   *  an Golfer object must be called upon 
   *@return
   *  a string that contains the variables of the a Golfer object
   *@postcondition
   *  converts a Golfer object into a string
   **/
	@Override
	public String toString() 
	{
		return lastname + " " + numberOfRounds + " " + handicap + " " + averageScore;
	}
	/**
   *compareTo determines which node in a tree is picked
   *@param obj
   *  obj is must be a Golfer object
   *@precondition
   *  an Golfer object must be called upon and another must be passed in as parameter
   *@return
   *  returns -1 if obj should be moved to the left and 1 if the obj must be moved to the right
   *@postcondition
   *  figures out where the node should end up(left or right)
   **/
	@Override
	public int compareTo(Golfer obj) {
		   int position = 0;
         int size = lastname.length();
         if(size > obj.lastname.length()) size = obj.lastname.length();//to find the size of the shorter lastname
         for(int i = 0; i < size; i++){
            if(lastname.charAt(i) < obj.lastname.charAt(i))//move to left
               return -1;
            else if(lastname.charAt(i) > obj.lastname.charAt(i))//move to right
               return 1;
            //for lastnames that contain same letters to end of one name 
            if((i+1) == size){
               if(obj.lastname.length() < lastname.length())//larger name is the right of the smaller name 
                 return 1;
               else if(obj.lastname.length() == lastname.length())
                  return 0;
               else return -1;     
            }   
            
         }
   return position;
	}

	

}