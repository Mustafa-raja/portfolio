package com.example.demo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class start {
//	HttpSession session;
	String baseURL;
	@Autowired
	CredsRepo db;
	@Autowired
	Emailsender sender;
	@RequestMapping("/")
	public ModelAndView sess(HttpServletRequest request)
	{
	
		ModelAndView mv = new ModelAndView();
		
//        session = request.getSession(false);
//        if(session != null)
//        {
//            mv.setViewName("finalpage.jsp");
//            return mv;
//        }
        
		
		mv.setViewName("login.jsp");
		return mv;
	}
	
	
	
	@RequestMapping("/reg")
	public ModelAndView reg (creds c )
	{
		ModelAndView mv = new ModelAndView();
		c.setUsername(c.getUsername().toLowerCase().trim());
		c.setEmail(c.getEmail().toLowerCase().trim());
		c.setPassword(encryptThisString(c.getPassword().trim()));
		c.setURL(encryptThisString(c.getUsername().trim()));
		System.out.println(c.getUsername() + c.getEmail() + c.getPassword());
		List<creds> n =  db.findAll();
		Iterator<creds> i =n.iterator();
		while(i.hasNext())
		{
			creds check = i.next();
			System.out.println(check.getUsername());
			System.out.println(c.getUsername()+" og");
			
			if(check.getUsername().trim().equals(c.getUsername().toLowerCase().trim()) || check.getEmail().toLowerCase().trim().equals(c.getEmail().toLowerCase().trim()) )
			{
				mv.addObject("val", "<div class=\"alert alert-danger\">\n"
						+ "    <strong>Warning!</strong> An account with such credentials already exists! \n"
						+ "  </div>");
				mv.setViewName("register.jsp");
				return mv;
			}
		}
		baseURL = "https://mustafaraja.herokuapp.com/Verify?username="+ encryptThisString(c.getUsername().trim());
		sender.sendEmail(c.getEmail().trim(), "Congrats!", "You have successfully registered yourself at my first webapp. Click on the below URL to get yourself verified " + baseURL);
		db.save(c);
		mv.addObject("val", "<div class=\"alert alert-success\">\n"
				+ "    <strong>Success!</strong> Account created. Check your Email to get verified! \n"
				+ "  </div>");
		mv.setViewName("register.jsp");
		return mv;
	}
	
	
	
	@RequestMapping("/login")
	public ModelAndView log (creds c,HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();

//		HttpSession session1 = request.getSession(false);
//        if(session1 != null)
//        {
//            mv.setViewName("finalpage.jsp");
//            return mv;
//        }
		c.setPassword(encryptThisString(c.getPassword().trim()));
		List<creds> n =  db.findAll();
		Iterator<creds> i =n.iterator();
		while(i.hasNext())
		{
			creds check = i.next(); 
			if( ( (check.getUsername().trim().equals(c.getUsername().toLowerCase().trim()) && check.getPassword().trim().equals(c.getPassword().trim())) || (check.getUsername().trim().equals(c.getEmail().toLowerCase().trim())) && check.getPassword().trim().equals(c.getPassword().trim()) )&& check.isVerify()==true )
			{
				
//				session = request.getSession();
//                session.setMaxInactiveInterval(600);
				mv.setViewName("finalpage.jsp");
				return mv;
			}
			
			else if ( ( check.getUsername().trim().equals(c.getUsername().toLowerCase().trim()) && check.getPassword().trim().equals(c.getPassword().trim()) || (check.getUsername().trim().equals(c.getEmail().toLowerCase().trim())) && check.getPassword().trim().equals(c.getPassword().trim()) ) && check.isVerify()== false )
			{
				mv.addObject("val", "<div class=\"alert alert-warning\">\n"
						+ "    <strong>Alert!</strong> Your account has not been verified yet!\n"
						+ "  </div>");
				mv.setViewName("login.jsp");
				return mv;
			}
		}
		mv.addObject("val", "<div class=\"alert alert-danger\">\n"
				+ "    <strong>Warning!</strong> Wrong credentials.\n"
				+ "  </div>");
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping("/Verify")
	public ModelAndView verify (@RequestParam String username)
	{
		ModelAndView mv = new ModelAndView();
		List<creds> n =  db.findAll();
		Iterator<creds> i =n.iterator();
		while(i.hasNext())
		{
			creds check =i.next();
			if(check.getURL().trim().equals(username.trim()))
			{
				if(check.isVerify()==false)
				{
				username = check.getUsername().trim();
				creds update =  db.getReferenceById(username);
				update.setVerify(true);
				db.save(update);
				mv.addObject("val", "<div class=\"alert alert-success\">\n"
						+ "    <strong>Success!</strong> Account Verified. Enter your credentials to GET STARTED \n"
						+ "  </div>");
				mv.setViewName("login.jsp");
				return mv;
				}
				else
				{
				mv.addObject("val", "<div class=\"alert alert-warning\">\n"
						+ "    <strong>Alert!</strong> Stop annoying! We have already verified you. \n"
						+ "  </div>");
				mv.setViewName("login.jsp");
				return mv;
					
				}
				
			}
		}
		
		
		mv.addObject("val", "<div class=\"alert alert-danger\">\n"
				+ "    <strong>Warning!</strong>No account found."
				+ "  </div>");
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping("/forgot")
	public ModelAndView forgot(@RequestParam String Email)
	{
		ModelAndView mv = new ModelAndView();
		List<creds> n = db.findAll();
		Iterator<creds> i = n.iterator();
		while(i.hasNext())
		{
			creds check = i.next();
			if(check.getEmail().trim().equals(Email.toLowerCase().trim()) || check.getUsername().trim().equals(Email.toLowerCase().trim()) )
			{
				Email = check.getUsername();
				check = db.getReferenceById(Email);
				String rand = java.util.UUID.randomUUID().toString();
				check.setPassword(encryptThisString(rand));
				db.save(check);
				sender.sendEmail(check.getEmail().trim(), "Reset!", "Your password has been successfully changed as follows.\nPassword : " + rand);
				mv.addObject("val", "<div class=\"alert alert-success\">\n"
						+ "    <strong>Success!</strong> Password changed. Check your Email to access your new password \n"
						+ "  </div>");
				mv.setViewName("forgot.jsp");
				return mv;
			}
		}
		mv.addObject("val", "<div class=\"alert alert-danger\">\n"
				+ "    <strong>Warning!</strong> No such Email/Username exists! \n"
				+ "  </div>");
		mv.setViewName("forgot.jsp");
		return mv;
	}
	
	
	 public static String encryptThisString(String input) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	            byte[] messageDigest = md.digest(input.getBytes());
	            BigInteger no = new BigInteger(1, messageDigest);
	            String hashtext = no.toString(16);
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        }


	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }

}

