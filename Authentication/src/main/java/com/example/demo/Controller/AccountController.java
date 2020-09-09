package com.example.demo.Controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.AuthDAO.ConfirmationTokenRepository;
import com.example.demo.AuthDAO.UserRepository;
import com.example.demo.EmailService.EmailService;
import com.example.demo.Usermodal.ConfirmationToken;
import com.example.demo.Usermodal.User;

import lombok.Data;

@Data
@Controller
public class AccountController {
	
	private UserRepository userRepository;
    private ConfirmationTokenRepository confirmationTokenRepository;
    private EmailService emailService;
    
    @GetMapping("/login")
    public ModelAndView displaylogin(ModelAndView modelAndView, User user) {
    	modelAndView.addObject("user", user);
    	modelAndView.setViewName("login");
    	return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView registerlogin(ModelAndView modelAndView, User user) 
    {
    	User existingUser = userRepository.findByEmailIdIgnoreCase(user.getEmail());
    	if(existingUser == null)
        {
            modelAndView.addObject("message","No email found check email or register!");
            modelAndView.setViewName("error");
        }
    	else
    	{
    		if(user.getPassword() != existingUser.getPassword())
    			{
    				modelAndView.addObject("message","Wrong Password");
    				modelAndView.setViewName("error");
    			}
    		else
    		{
    			modelAndView.setViewName("successfulLogin");
    		}
    	}
    	return modelAndView;
    	
    }
    
    
    @GetMapping("/register")
    public ModelAndView displayRegistration(ModelAndView modelAndView, User user)
    {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }
    
    
    @PostMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView, User user)
    {

        User existingUser = userRepository.findByEmailIdIgnoreCase(user.getEmail());
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else
        {
            userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("chand312902@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailId", user.getEmail());

            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByEmailIdIgnoreCase(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
    

}
