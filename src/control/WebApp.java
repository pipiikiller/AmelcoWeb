package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pabloo99.xmlsoccer.api.dto.GetLiveScoreResultDto;
import com.github.pabloo99.xmlsoccer.api.service.XmlSoccerService;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;
import com.github.pabloo99.xmlsoccer.api.dto.GetAllLeaguesResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetLeagueStandingsResultDto;
import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.model.enums.Leagues;
import com.github.pabloo99.xmlsoccer.model.enums.Seasons;

import model.Countries;
import model.LeaguesDB;
import model.Livescore;


public class WebApp extends HttpServlet{
	
	private Livescore ls;
	private static Countries countryDB;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			Livescore ls= new Livescore();
			
			
		 resp.getWriter().println(new Date());
		 resp.setContentType("text/html");
		 resp.addHeader("Cache-Control", "max-age=60");
		 PrintWriter out = resp.getWriter();
		   
		    
		    if (req.getParameter("Get Country") != null) {
		    	 
				    out.println("<html>");
				    out.println("<head><title>Leagues</title></head>");
				    out.println("<body>");
				    out.println("<center><h1>Leagues</h1>");
				    resp.getWriter().println(ls.getCountries());
				    out.println("</center>");
				    out.println("</body>");
				    out.println("</html>");
	           
	        } else if (req.getParameter("Get Competitions") != null) {
	        	 	out.println("<html>");
				    out.println("<head><title>Leagues</title></head>");
				    out.println("<body>");
				    out.println("<center><h1>Competitions</h1>");
				    
				    String country = req.getParameter("country").toUpperCase(); 
				    int countryId = countryDB.getCountryId(country);
				    resp.getWriter().println(ls.getCompetitions(countryId));
				   
				    
				    out.println("</center>");
				    out.println("</body>");
				    out.println("</html>");
	        	
	        	
	        } else if (req.getParameter("Get Events") != null) {
	        	out.println("<html>");
			    out.println("<head><title>Display Events</title></head>");
			    out.println("<body>");
			    out.println("<center><h1>Events</h1>");
			    
	        	String competitionID = req.getParameter("competition");
	        	resp.getWriter().println(ls.getEvents(competitionID));
	        	
	        	out.println("</center>");
			    out.println("</body>");
			    out.println("</html>");
			    
	        } else if (req.getParameter("Add Country") != null){
	        	String countryName = req.getParameter("countryName");
	        	String countryCode = req.getParameter("countryCode");
	        	int code = Integer.parseInt(countryCode);
	        	ls.addCountry(countryName, code);
	        	resp.getWriter().println("A country is succesfully added!");
	           
	        }else if (req.getParameter("Add Competition") != null){
	        	String competitionName = req.getParameter("competitionName");
	        	String competitionCode = req.getParameter("competitionCode");
	        	int code = Integer.parseInt(competitionCode);
	        	ls.addCompetition(code, competitionName);
	        	resp.getWriter().println("A competition is succesfully added!");
	        	
	        }
		
	}
	
	

}
