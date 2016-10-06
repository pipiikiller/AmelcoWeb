package model;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public enum Countries implements tempEnum{
	
		 ENGLAND("ENGLAND",1), SPAIN("SPAIN",2), ITALY("ITALY",3), FRANCE("FRANCE",4), GERMANY("GERMANY",5), 
		 TURKEY("TURKEY",6), SWEDEN("SWEDEN",7), SCOTLAND("SCOTLAND",8),GREECE("GREECE",9),
		 HOLLAND("HOLLAND",10), BELGIUM("BELGIUM",11),DENMARK("DENMARK",12), EUROPE("EUROPE",13),
		 PORTUGAL("PORTUGAL",14), USA("USA",15), MEXICO("MEXICO",16), BRAZIL("BRAZIL",17),
		 UKRAINE("UKRAINE",18), RUSSIA("RUSSIA",19), AUSTRALIA("AUSTRALIA",20), INTERNATIONAL("INTERNATIONAL",21), 
		 NORWAY("NORWAY",22), CHINA("CHINA",23), POLAND("POLAND",24), ARGENTINA("ARGENTINA",25) ;
		 
		 private int code;
		 private String label;
		 
		 private static Map<String, Integer> codeToCountryMapping;
		 private Countries(String l,int c) {
		   code = c;
		   label = l;
		 }
		 
		 
		 public String getLable(){
			 
			 return label;
		 }
		 
		 public int getCode() {
			 
		   return code;
		   
		 }
		 public static int getCountryId(String name) {
		        if (codeToCountryMapping == null) {
		            initMapping();
		        }
		        if (codeToCountryMapping.get(name) == null){
		        	
		        	return 0;
		        }
		        return codeToCountryMapping.get(name);
		    }
		 
		 private static void initMapping() {
		        codeToCountryMapping = new HashMap<String,Integer>();
		        for (Countries s : values()) {
		            codeToCountryMapping.put(s.label,s.code);
		        }
		    }
		 
		 /**
		  * adding elements to enum
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
