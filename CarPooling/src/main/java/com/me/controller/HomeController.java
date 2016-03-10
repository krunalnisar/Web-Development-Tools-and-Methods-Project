package com.me.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.CardDao;
import com.me.dao.MessageDao;
import com.me.dao.PlacesDao;
import com.me.dao.TripDao;
import com.me.dao.UserDao;
import com.me.pojo.Address;
import com.me.pojo.Car;
import com.me.pojo.CardDetails;
import com.me.pojo.DriverDetails;
import com.me.pojo.Message;
import com.me.pojo.Places;
import com.me.pojo.Trip;
import com.me.pojo.User;
import com.me.validator.AddressValidator;
import com.me.validator.CarValidator;
import com.me.validator.CardValidator;
import com.me.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PlacesDao placesDao; 
	
	
	
	@Autowired
	private TripDao tripDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CardDao cardDao;
	
	@Autowired
	private UserValidator userValidator; 
	
	@Autowired
	private CarValidator carValidator; 
	
	@Autowired
	private CardValidator cardValidator;
	
	@Autowired
	private AddressValidator addressValidator;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@InitBinder("user")
	private void userinitBinder (WebDataBinder binder){
		binder.setValidator(userValidator);
	}
	
	@InitBinder("car")
	private void carinitBinder (WebDataBinder binder){
		binder.setValidator(carValidator);
	}
	
	@InitBinder("carddetails")
	private void cardinitBinder (WebDataBinder binder){
		binder.setValidator(cardValidator);
	}
	
	@InitBinder("address")
	private void addressinitBinder (WebDataBinder binder){
		binder.setValidator(addressValidator);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(HttpServletRequest request,Model model,HttpSession session)
	{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userDao.isValid(String.valueOf(request.getAttribute("username")),String.valueOf(request.getAttribute("password")));
		//User user = userDao.isValid(username,password);
		if(user != null)
		{
		session = request.getSession();
		session.setAttribute("user", user);
		
		if(user.getName().equals("iamadmin") && user.getPassword().equals("iamadmin"))
		{
			List<User> userList = userDao.getListOfUser();
			int size = userList.size();
			model.addAttribute("userList", userList);
			model.addAttribute("size", size);
			return "admin";
		}
		else
		{
			return "header";
		}
		
		}
		return "error";
	}
	
	@RequestMapping(value = "/search.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request,Model model,HttpSession session)
	{
		session = request.getSession();
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);
		System.out.println("hi");
		
		String slat = request.getParameter("slat");
		String slon = request.getParameter("slon");
		String dlat = request.getParameter("dlat");
		String dlon = request.getParameter("dlon");
		int radius =  Integer.parseInt(request.getParameter("radius"));
		
		System.out.println(radius);
		System.out.println("slat"+slat);
		System.out.println("slon"+slon);
		System.out.println("dlat"+dlat);
		System.out.println("dlon"+dlon);
		
		
		
		List<Trip> tripList = placesDao.populateTrips(slat,slon,radius);
		int size = (tripList.size())-1;
		model.addAttribute("tripList", tripList);
		model.addAttribute("size", size);
		model.addAttribute("tripList", tripList);
		return "search";
		
	}
	
	
	
	@RequestMapping(value = "/viewTripDetails.html", method = RequestMethod.GET)
	public String viewTripDetails(HttpServletRequest request,Model model,HttpSession session)
	{
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
			return "error";
		}
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		Trip trip =  tripDao.getTrip(tripId);
		model.addAttribute("trip",trip);
		return "viewTripDetails";
		
	}
	
	@RequestMapping(value = "/searcharide.html", method = RequestMethod.GET)
	public String searcharide(HttpServletRequest request,Model model)
	{
		return "search";
		
	}
	
	@RequestMapping(value = "/messages.html", method = RequestMethod.GET)
	public String messages(HttpServletRequest request,Model model,HttpSession session)
	{
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
			return "error";
		}
		model.addAttribute("user", user);
		
		List<Message> messageList = messageDao.listMessageByUsername(user.getName());
		model.addAttribute("messageList", messageList);
		model.addAttribute("count", messageList.size());
		model.addAttribute("username",user.getName());
		for(Message m : messageList)
		{System.out.println(m.getTrip().getTripId());}
		return "messages";
		
	}
	
	@RequestMapping(value = "/approve.html", method = RequestMethod.GET)
	public ModelAndView approve(HttpServletRequest request,Model model)
	{
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		System.out.println(messageId);
	
		System.out.println("before");
		boolean result  = messageDao.statusApproved(messageId);
		System.out.println("after");
		return new ModelAndView("redirect:messages.html");
		
	}
	
	@RequestMapping(value = "/reject.html", method = RequestMethod.GET)
	public String reject(HttpServletRequest request,Model model)
	{
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		
		boolean result  = messageDao.statusReject(messageId);
		
		return "messages";
		
	}
	
	@RequestMapping(value = "/confirmpayment.html", method = RequestMethod.GET)
	public String confirmpayment(HttpServletRequest request,Model model,HttpSession session)
	{
		
		System.out.println("into payment");
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = userDao.getUser(userId);
		System.out.println(user.getName());
		model.addAttribute("user", user);
		
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		Trip trip = tripDao.getTrip(tripId);
		model.addAttribute("trip",trip );
		
		CardDetails cardDetails = cardDao.getCardDetails(userId);
		model.addAttribute("card", cardDetails);
		
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		Message message = messageDao.getMessage(messageId);
		
		model.addAttribute("message",message );
		return "confirmpayment";
		//open payment open;
		
	}
	

	@RequestMapping(value = "/payment.html", method = RequestMethod.GET)
	public String payment(HttpServletRequest request,Model model)
	{
		//take the payment details from reqest.getparameter
		
	
	
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		
		System.out.println(tripId);
		System.out.println(userId);
		boolean result = messageDao.statusChanged(tripId,userId,messageId);
		
		// return back to home page of the user
		return "header";
		
	}
	
	@RequestMapping(value = "/mytrips.html", method = RequestMethod.GET)
	public String mytrips(HttpServletRequest request,Model model,HttpSession session)
	{
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
			return "redirect:/";
		}
		List<Trip> tripList =  tripDao.getMyTrips(user.getUserId());
		for(Trip t : tripList)
		{
			System.out.println(t.getTripId());
		}
		model.addAttribute("user", user);
		model.addAttribute("tripList", tripList);
		return "mytrips";
		
	}
	
	@RequestMapping(value = "/postATrip.html", method = RequestMethod.GET)
	public String postATrip(HttpServletRequest request,Model model,HttpSession session)
	{
		return "postATrip";
	}
	@RequestMapping(value = "/submittrip.html", method = RequestMethod.POST)
	public String submittrip(HttpServletRequest request,Model model,HttpSession session)
	{
		//take the payment details from reqest.getparameter
try{
			
			User u=(User) session.getAttribute("user");
			
			String slat = (request.getParameter("slat"));
			String slong = (request.getParameter("slong"));
			String dlat = (request.getParameter("dlat"));
			String dlong = (request.getParameter("dlong"));
			String sourceaddr = request.getParameter("sourceid");
			String destaddr = request.getParameter("destid");
			
			// AUTO FILL PLACE TABLE
			placesDao.feedPlacetable(slat, slong, sourceaddr, dlat, dlong, destaddr);

			// Retrieve PLACE OBJECT FOR SOURCE
			Places start = placesDao.returnPlaceByCoords(slat, slong);

			// Retrieve PLACE OBJECT FOR DESTINATION
			Places end = placesDao.returnPlaceByCoords(dlat, dlong);	
			
		java.sql.Date sqlStartDate = java.sql.Date.valueOf((request.getParameter("startdate")));
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-dd-MM");
//		java.util.Date date1 = sdf1.parse(sd);
//		java.sql.Date sqlStartDate = (java.sql.Date) new Date(date1.getTime());
		
		

		java.sql.Date sqlEndDate =java.sql.Date.valueOf(request.getParameter("enddate"));
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-dd-MM");
//		java.util.Date date2 = sdf2.parse(ed);
//		java.sql.Date sqlEndDate = (java.sql.Date) new Date(date2.getTime());
		
		java.sql.Time sqlTripTime = java.sql.Time.valueOf(request.getParameter("triptime"));
//		SimpleDateFormat sdf3 = new SimpleDateFormat("hh:mm:ss");
//		java.util.Date time1 = sdf3.parse(triptime);
//		java.sql.Time sqlTripTime = (java.sql.Time) new Date(time1.getTime());
		
		float cost = Float.parseFloat(request.getParameter("cost"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		
		//FOR DISTANCE CALCULATION
		StringBuffer begcoords= new  StringBuffer();
		begcoords.append(slat);
		begcoords.append(",");
		begcoords.append(slong);
		StringBuffer endcoords= new  StringBuffer();
		endcoords.append(dlat);
		endcoords.append(",");
		endcoords.append(dlong);
		
		float distance=PlacesDao.calcDistance(begcoords, endcoords);
		System.out.println(distance);
		
		String comments = request.getParameter("comments");
		
		tripDao.postTrip(start, end, sqlStartDate, sqlEndDate, sqlTripTime, cost, distance,	capacity, comments,u);
		}
		catch(Exception e)
		{
			System.out.println("Error in processing values"+e);
			
		}
		
		
	
		return "search";
		
	}
	
	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public String register(Model model) throws IllegalStateException, IOException
	{
		User user = new User();
		model.addAttribute("user",user);
		return "userform";
		
	}
	
	@RequestMapping(value = "/userform.html", method = RequestMethod.POST)
	public String userform(Model model, @Validated User user, BindingResult result,HttpSession session) throws IllegalStateException, IOException
	{
		
		model.addAttribute("user",user);
		
		if (result.hasErrors()){
			System.out.println("inside error");
			return "userform";
		}else{
			
			
	        //resolve this error 
			//userDao.addUser(user);
			User u = userDao.saveCar(user);
	        session.setAttribute("user", u);
	        
	   
			//boolean result1 = userDao.saveImage(user);
			Address address = new Address();
			model.addAttribute("address",address);
			return "addressform";
	        
		}
		
	}
	
	@RequestMapping(value = "/addressform.html", method = RequestMethod.POST)
	public String addressform(Model model, @Validated Address address, BindingResult result,HttpSession session) throws IllegalStateException, IOException
	{
		
		model.addAttribute("address",address);
		
		if (result.hasErrors()){
			System.out.println("inside error");
			return "addressform";
		}else{
			
			
	        //resolve this error 
	      // userDao.addUser(user);
	        session.setAttribute("address", address);
	        
	   
			//boolean result1 = userDao.saveImage(user);
			Car c = new Car();
			model.addAttribute("car",c);
			return "carform";
	        
		}
		
	}
	
	
	@RequestMapping(value = "/car.html", method = RequestMethod.POST)
	public String car(Model model, @Validated Car car, BindingResult result,HttpSession session) throws IllegalStateException, IOException
	{
		System.out.println("inside submit");
		model.addAttribute("car",car);
		
		if (result.hasErrors()){
			System.out.println("inside error");
			return "carform";
		}else{
			
			Car c =  userDao.addCarImage(car);
			System.out.println("inside image save");
			 session.setAttribute("car", c);
			//boolean result1 = userDao.saveImage(user);
			DriverDetails driverdetails = new DriverDetails();
			model.addAttribute("driverdetails",driverdetails);
			return "driverform";
	        
		}
	}
		
		
		@RequestMapping(value = "/driver.html", method = RequestMethod.POST)
		public String carddetails(Model model, @Validated DriverDetails driverdetails, BindingResult result,HttpSession session) throws IllegalStateException, IOException
		{
			System.out.println("inside submit");
			model.addAttribute("driverdetails",driverdetails);
			
			if (result.hasErrors()){
				System.out.println("inside error");
				return "driverform";
			}else{
				session.setAttribute("driverdetails", driverdetails);

				System.out.println("inside image save");
				//boolean result1 = userDao.saveImage(user);
				CardDetails cardDetails = new CardDetails();
				model.addAttribute("cardDetails", cardDetails);
				return "cardDetailsform";
		        
			}
		
	}
		
		@RequestMapping(value = "/cardDetails.html", method = RequestMethod.POST)
		public String payment(Model model, @Validated CardDetails cardDetails, BindingResult result,HttpSession session) throws IllegalStateException, IOException
		{
			System.out.println("inside submit");
			model.addAttribute("cardDetails",cardDetails);
			
			if (result.hasErrors()){
				System.out.println("inside error");
				return "cardDetailsform";
			}else{
				User u = (User) session.getAttribute("user");
				Car c = (Car) session.getAttribute("car");
				DriverDetails d = (DriverDetails) session.getAttribute("driverdetails");
				Address add = (Address) session.getAttribute("address");
				userDao.saveUser(u,c,d,cardDetails,add);
				System.out.println("inside image save");
				//boolean result1 = userDao.saveImage(user);
				return "redirect:/";
		        
			}
		
	}
		@RequestMapping(value = "/requestaride.html", method = RequestMethod.GET)
		public String requestaride(HttpServletRequest request,Model model,HttpSession session)
		{
			session = request.getSession();
			User user = (User)session.getAttribute("user");
			String reciever = request.getParameter("reciever");
			int tripId = Integer.parseInt(request.getParameter("tripId"));
		//	String message = request.getParameter("message");
			//List<Trip> tripList =  tripDao.getMyTrips(user.getUserId());
			String source = request.getParameter("source");
			String destination = request.getParameter("destination"); 
			Trip trip = tripDao.getTrip(tripId);
			messageDao.requestARide(tripId,trip,user,reciever,source,destination);
			
			
			return "mytrips";
			
		}
		
		
		@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
		public String logout(HttpServletRequest request,Model model,HttpSession session)
		{
			session = request.getSession();
			session.invalidate();
			return "redirect:/";
			
		}
		
		@RequestMapping(value = "/guest.html", method = RequestMethod.GET)
		public String guest(HttpServletRequest request,Model model,HttpSession session)
		{
			return "guestsearch";
			
		}
	
		@RequestMapping(value = "/ajaxservice.html", method = RequestMethod.GET)
		public void ajaxservice(HttpServletRequest request,Model model,HttpSession session,PrintWriter out)
		{
			System.out.println("hi");
			String user = request.getParameter("user");
			boolean result = userDao.getUserName(user);
			if(result)
			{
				out.println("Username Available");
			}
			else{
				out.println("Username Not Available");
			}
			
		}
		
		
		
		@RequestMapping(value = "/userstatus.html", method = RequestMethod.GET)
		public String userstatus(HttpServletRequest request,Model model,HttpSession session)
		{
			System.out.println("enter status");
			
		//	int  userId = Integer.parseInt(request.getParameter("delete"));
			String[] userId = request.getParameterValues("delete");
			System.out.println(userId);
			boolean result = userDao.changeUserStatus(userId);
			List<User> userList = userDao.getListOfUser();
			int size = userList.size();
			model.addAttribute("userList", userList);
			model.addAttribute("size", size);
			return "admin";
			
		}
		
		
		
	}
	
	
	

