/**************
*@author Stryder R. Coleman and Roman Kozulia
*This is the class that the stores information about a golfer. 
*It has fields lastName, numberOfRounds, averageScore, and handicap.
*

**************/


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
	   *Overrides toString method.
	   * @param none
	   * @return golfer's fields.
	   * 
	   **/
    

	@Override
	public String toString() 
	{
		return "Golfer lastname " + lastname + ", numberOfRounds= " + numberOfRounds + ", averageScore= " + averageScore
				+ ", handicap= " + handicap;
	}
	/**
	   *Overrides compareTo method.
	   * @param Golfer object
	   * @return integer which represents equality of comparable objects 
	   * 
	   **/
	@Override
	public int compareTo(Golfer o) 
	{
		// Needs to be updated!!!
		return this.lastname.substring(0,1).toLowerCase().compareTo(o.lastname.substring(0,1).toLowerCase());
	}

	

}
