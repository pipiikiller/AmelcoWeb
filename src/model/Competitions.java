package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public enum Competitions implements tempEnum {
	 	ENGLAND_ENGLISH_PREMIER_LEAGUE(1,"ENGLAND_ENGLISH_PREMIER_LEAGUE"),
	    ENGLAND_ENGLISH_LEAGUE_CHAMPIONSHIP(2,"ENGLAND_ENGLISH_LEAGUE_CHAMPIONSHIP"),
	    SCOTLAND_SCOTTISH_PREMIER_LEAGUE(3,"SCOTLAND_SCOTTISH_PREMIER_LEAGUE"),
	    GERMANY_BUNDESLIGA(4,"GERMANY_BUNDESLIGA"),
	    ITALY_SERIE_A(5,"ITALY_SERIE_A"),
	    ITALY_SERIE_B(6,"ITALY_SERIE_B"),
	    FRANCE_LIGUE_1(7,"FRANCE_LIGUE_1"),
	    SPAIN_LA_LIGA(8,"SPAIN_LA_LIGA"),
	    GREECE_SUPERLEAGUE_GREECE(9,"GREECE_SUPERLEAGUE_GREECE"),
	    HOLLAND_EREDIVISIE(10,"HOLLAND_EREDIVISIE"),
	    BELGIUM_JUPILER_LEAGUE(11,"BELGIUM_JUPILER_LEAGUE"),
	    TURKEY_SUPER_LIG(12,"TURKEY_SUPER_LIG"),
	    DENMARK_SUPERLIGA(13,"DENMARK_SUPERLIGA"),
	    EUROPE_EURO_2012(14,"EUROPE_EURO_2012"),
	    EUROPE_CHAMPIONS_LEAGUE(15,"EUROPE_CHAMPIONS_LEAGUE"),
	    EUROPE_EUROPE_LEAGUE(16,"EUROPE_EUROPE_LEAGUE"),
	    PORTUGAL_PRIMEIRA_LIGA(17,"PORTUGAL_PRIMEIRA_LIGA"),
	    SCOTLAND_SCOTTISH_FIRST_DIVISION(18,"SCOTLAND_SCOTTISH_FIRST_DIVISION"),
	    USA_MAJOR_LEAGUE_SOCCER(19,"USA_MAJOR_LEAGUE_SOCCER"),
	    SWEDEN_ALLSVENSKAN(20,"SWEDEN_ALLSVENSKAN"),
	    ENGLAND_FA_CUP(21,"ENGLAND_FA_CUP"),
	    ENGLAND_LEAGUE_CUP(22," ENGLAND_LEAGUE_CUP"),
	    MEXICO_MEXICAN_PRIMERA_LEAGUE(23,"MEXICO_MEXICAN_PRIMERA_LEAGUE"),
	    BRAZIL_BRASILEIRAO(24,"BRAZIL_BRASILEIRAO"),
	    ENGLAND_ENGLISH_LEAGUE_1(25,"ENGLAND_ENGLISH_LEAGUE_1"),
	    ENGLAND_ENGLISH_LEAGUE_2(26,"ENGLAND_ENGLISH_LEAGUE_2"),
	    UKRAINE_UKRAINIAN_PREMIER_LEAGUE(27,"UKRAINE_UKRAINIAN_PREMIER_LEAGUE"),
	    RUSSIA_RUSSIAN_FOOTBALL_PREMIER_LEAGUE_(28,"RUSSIA_RUSSIAN_FOOTBALL_PREMIER_LEAGUE_"),
	    AUSTRALIA_AUSTRALIAN_A_LEAGUE(29,"AUSTRALIA_AUSTRALIAN_A_LEAGUE"),
	    INTERNATIONAL_WORLD_CUP_2014(30,"INTERNATIONAL_WORLD_CUP_2014")
	    ;
	 
	 private int code;
	 private String label;
	 
	 private static Map<Integer, String> codeToCountryMapping;
	 private Competitions(int c,String l) {
	   code = c;
	   label = l;
	 }
	 
	 
	 public String getLable(){
		 
		 return label;
	 }
	 
	 public int getCode() {
		 
	   return code;
	   
	 }
	 public static String getCompetitionName(int id) {
	        if (codeToCountryMapping == null) {
	            initMapping();
	        }
	        if (codeToCountryMapping.get(id) == null){
	        	
	        	return null;
	        }
	        return codeToCountryMapping.get(id);
	    }
	
	 
	 private static void initMapping() {
	        codeToCountryMapping = new HashMap<Integer,String>();
	        for (Competitions s : values()) {
	            codeToCountryMapping.put(s.code,s.label);
	        }
	    }
	 /**
	  * add more competitions
	  */
	 
	 private static Map< String, tempEnum > map = 
		      new TreeMap < String, tempEnum > ();
	 
	
	 static {
		 
		    for (tempEnum font : values()) {
		      map.put(font.getLable(), font);
		    }
		  }
	 
	 public static tempEnum monoFontFor(String fontName) {

	    return map.get(fontName);
	  }
	 
	
	 public static void addNewFont(tempEnum font) {
		    if (!map.containsKey(font.getLable())) {
		      map.put(font.getLable(), font);
		    }
		  }
	 
	 public static Collection<tempEnum> fonts() {
		 
		 return map.values();
		 }
}
