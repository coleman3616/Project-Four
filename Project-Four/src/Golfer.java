
public class Golfer implements Comparable<Golfer> {
	
	private String lastname;
	private int numberOfRounds;
	private double averageScore;
	private int handicap;
	
	
	public Golfer(String lastname) {
		this.lastname=lastname;
		numberOfRounds=0;
		averageScore=0;
		handicap = 0;
	}
	

	public Golfer(String lastname, int numberOfRounds, double averageScore, int handicap) {
		this.lastname = lastname;
		this.numberOfRounds = numberOfRounds;
		this.averageScore = averageScore;
		this.handicap = handicap;
	}




	

	public void addScore(double score ) {
		
		averageScore = (numberOfRounds*averageScore+score)/++numberOfRounds;
	
	
	}
   
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}




	@Override
	public String toString() {
		return "Golfer lastname " + lastname + ", numberOfRounds= " + numberOfRounds + ", averageScore= " + averageScore
				+ ", handicap= " + handicap;
	}

	@Override
	public int compareTo(Golfer o) {
		
		
		return this.lastname.substring(0,1).toLowerCase().compareTo(o.lastname.substring(0,1).toLowerCase());
//	    int temp=0;
//	    int size = this.lastname.length();
//	    if(this.lastname.length()>o.lastname.length()) {
//	    	this.lastname.length();
//	    }
//	    
//	    for(int i=0; i<size;i++) {
//	    	
//	    	if (i==--size) {
//	    		temp= this.lastname.substring(i, i++).toLowerCase().compareTo(o.lastname.substring(i, i++).toLowerCase());
//	    		if(temp==0) {
//	    			if(this.lastname.length()==o.lastname.length()) {
//	    				return -1;
//	    			}else {
//	    				return 1;
//	    			}
//	    		}
//	    	}
//	    		
//	    	else {
//	    		temp= this.lastname.substring(i).toLowerCase().compareTo(o.lastname.substring(i).toLowerCase());
//	    	}
//	    	if(temp!=0)
//	    		return temp;
//	    }
//	    	
//	    
//	    
//	    
//	    
//		return temp ;
	}

	

}
