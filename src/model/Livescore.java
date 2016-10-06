package model;

import com.github.pabloo99.xmlsoccer.api.dto.GetLiveScoreResultDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;
import com.github.pabloo99.xmlsoccer.api.dto.GetAllLeaguesResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetLeagueStandingsResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetOddsResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.model.enums.Leagues;
import com.github.pabloo99.xmlsoccer.model.enums.Seasons;

import java.util.ArrayList;
import java.util.List;


 
public class Livescore {
	
	private static Countries country;
	private static LeaguesDB league;
	private static Competitions competitions;
	private static ArrayList<FixturesDB> FixturesDBList;
	private static ArrayList<LeaguesDB> LeaguesDBList;
	private static ArrayList<String> stringArray;
	private static FixturesDB fixture;
	
	public Livescore(){
		
	}
    public static ArrayList<LeaguesDB> getLeagues()
    {
        XmlSoccerService xmlSoccerService = new XmlSoccerServiceImpl();
        xmlSoccerService.setApiKey("GQUIATIWEXPZTKPDDUFDONYRKXKTBKDMVGONEMFVFKMKWPSMCO");

        // demo access
        xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");

        // full access
        //xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballData.asmx");

        List <GetAllLeaguesResultDto> getAllLeagues = xmlSoccerService.getAllLeagues();
      // System.out.println(getAllLeagues.toString());
        
        try{
       //convert all objects into array
        String [] allLeaguesList = new String[getAllLeagues.size()];
        int index = 0;
        for (Object value : getAllLeagues) {
          allLeaguesList[index] =  value.toString();
          index++;
        }
        
        //convert the array into string
        int count=0;
        LeaguesDBList = new ArrayList<LeaguesDB>();
      
        for(String s: allLeaguesList){
        	stringArray = new ArrayList<String>();
        	int countryId=0;
        	 s = allLeaguesList[count];
        	 String [] leagueArray = new String [10];
             leagueArray = s.split(",");
             String search ="GetAllLeaguesResultDto(";
             
             //clean the data
             if(leagueArray[0].contains(search)){
             	String s2 =leagueArray[0].replace(search, "");
             	leagueArray[0] = s2;
             }
             //remove spaces 
             for(int i =0; i< leagueArray.length;i++){
          	   
          	   	String string = leagueArray[i];
             	string = string.replaceAll("\\s+","");
             	string = string.substring(string.lastIndexOf("=") + 1);
             	
             	
             	stringArray.add(string);
             	
             	if(i == 2){
             		string = string.toUpperCase();
             		countryId = country.getCountryId(string);
             		
             	}
             	
             }
            //add data to an object
             league = new LeaguesDB(stringArray.get(0),stringArray.get(1),countryId,stringArray.get(2),
           			stringArray.get(3), stringArray.get(4),stringArray.get(5), stringArray.get(6),stringArray.get(7));
             
            //store objects into arraylist
            LeaguesDBList.add(league);
             count++;
             
        }
       
       //System.out.println(LeaguesDBList.size());
        /**
       for(Object v: LeaguesDBList){
    	   System.out.println(v.toString());
    	   
       }
       */
        
        }catch(Exception e){
        	e.printStackTrace();
        	
        }
      
		return LeaguesDBList;

    }
    //end GET ALL LEAGUES
    
    /**
     * GET COUNTRIES Method
     * @return countries
     */
    public ArrayList<Countries> getCountries(){
    	
    	Countries[] country = Countries.values();
    	
		ArrayList<Countries> countries = new ArrayList<>();
		
		for(int i=0;i<country.length;i++){
			
			Countries c= country[i];
			countries.add(c);
		}
    	return countries;
    }
    
    //end GET COUNTRIES
    
    /**
     * GET COMPETITIONS
     * @param countryId
     * @return competitionList
     */
    public ArrayList<String> getCompetitions(int countryId){
    	
    	ArrayList<LeaguesDB> competitionsDBList= getLeagues();
    	ArrayList<String> competitionList = new ArrayList<>();
    	
    
    	//error message
    	if(countryId == 0){
    		String error = "This country is not found in the database";
    		competitionList.add(error);
    		return competitionList;
    	}
    	
    	//storing data into the arrayList
    	for(int i=0;i<competitionsDBList.size();i++){
    	if(countryId == competitionsDBList.get(i).getCountryId()){
    		
    		String leagueId = "LeagueID: "+competitionsDBList.get(i).getLeagueId();
    		String leagueName = "League Name: "+competitionsDBList.get(i).getLeagueName();
    		
    		competitionList.add(leagueId);
    		competitionList.add(leagueName);
    		
    		}
    	//System.out.println(competitionsDBList.get(i).getLeagueName()+""+ competitionList.size());
    	}
    	return competitionList;
    } 
    //END GET COMPETITIONS
    
    
    /**
     * GET EVENTS Method
     * @param competitionId
     * @return 
     */
    
    public static ArrayList<FixturesDB> getEvents(String competitionId){
      	 XmlSoccerService xmlSoccerService = new XmlSoccerServiceImpl();
           xmlSoccerService.setApiKey("GQUIATIWEXPZTKPDDUFDONYRKXKTBKDMVGONEMFVFKMKWPSMCO");
           xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
           
           int id= Integer.parseInt(competitionId);
           
           String CompetitionName = competitions.getCompetitionName(id);
           System.out.println(CompetitionName);
           List<GetLeagueStandingsResultDto> getLeagueStandingsResultDtoList = xmlSoccerService.getLeagueStandingsBySeason(Leagues.valueOf(CompetitionName).getParam(), Seasons.valueOf("SEASON_2014_2015").getParam());
           //System.out.println(getLeagueStandingsResultDtoList.toString());
          
           try{
               //convert all objects into array
                String [] allLeaguesList = new String[getLeagueStandingsResultDtoList.size()];
                int index = 0;
                for (Object value : getLeagueStandingsResultDtoList) {
                  allLeaguesList[index] =  value.toString();
                  
                  index++;
                }
                
                //convert the array into string
                int count=0;
                FixturesDBList = new ArrayList<FixturesDB>();
              
                for(String s: allLeaguesList){
                	stringArray = new ArrayList<String>();
                	
                	 s = allLeaguesList[count];
             
                	 String [] leagueArray = new String [20];
                     leagueArray = s.split(",");
                     String search ="GetLeagueStandingsResultDto(";
                     
                     //clean the data
                     if(leagueArray[0].contains(search)){
                     	String s2 =leagueArray[0].replace(search, "");
                     	leagueArray[0] = s2;
                     }
                     ;
                     //remove spaces 
                     for(int i =0; i< leagueArray.length;i++){
                   	  
                  	   	String string = leagueArray[i];
                     	string = string.replaceAll("\\s+","");
                     	string = string.substring(string.lastIndexOf("=") + 1);
                     	
                     	
                     	stringArray.add(string);
                   	
                     }
                     
                    //add data to an object 
                    
                     fixture = new FixturesDB(stringArray.get(0), stringArray.get(1), stringArray.get(2),
                  		   stringArray.get(3), stringArray.get(4), stringArray.get(5), stringArray.get(6),
                  		   stringArray.get(7), stringArray.get(8), stringArray.get(9), stringArray.get(10),
                  		   stringArray.get(11), stringArray.get(12), stringArray.get(13), stringArray.get(14),
                  		   stringArray.get(15), stringArray.get(16), stringArray.get(17));
                     
                    //store objects into arraylist
                    FixturesDBList.add(fixture);
                     count++;
                    
                }
               
                }catch(Exception e){
                	e.printStackTrace();
                	
                }
           return FixturesDBList;
                
      }
    
    /**
     * add Country
     * @param name
     * @param code
     */
    public static void addCountry(final String name, final int code){
    	
    	 
		 Countries.addNewFont(new tempEnum() {
			
			@Override
			public int getCode() {
				
				return code;
			}
			
			@Override
			public String getLable() {
				// TODO Auto-generated method stub
				return name;
			}
			
			public String toString(){
				return getLable() ;
				
			}
			});
		
		 System.out.println(Countries.fonts());
    }
    
    /**
     * Add Competitions
     * @param code
     * @param name
     */
    
    public static void addCompetition(final int code, final String name){
    	Competitions.addNewFont(new tempEnum() {
			
			@Override
			public int getCode() {
				
				return code;
			}
			
			@Override
			public String getLable() {
				// TODO Auto-generated method stub
				return name;
			}
			
			public String toString(){
				return getLable() ;
				
			}
			});
		
		 System.out.println(Competitions.fonts());
    	
    }
    
    public static void getOddResults(){
    	 XmlSoccerService xmlSoccerService = new XmlSoccerServiceImpl();
         xmlSoccerService.setApiKey("GQUIATIWEXPZTKPDDUFDONYRKXKTBKDMVGONEMFVFKMKWPSMCO");
         xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
    	
         List<GetOddsResultDto> oddResults = xmlSoccerService.getNextMatchOddsByLeague("SCOTLAND_SCOTTISH_PREMIER_LEAGUE");
         System.out.println(oddResults.toString());
         
    }
    public static void main(String args[]){
    	getLeagues();
    	//getOddResults();
    	//System.out.print(getEvents("3"));
    }
}
    

