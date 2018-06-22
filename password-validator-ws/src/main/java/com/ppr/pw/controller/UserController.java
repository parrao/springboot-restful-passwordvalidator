package com.ppr.pw.controller;

import java.util.Arrays;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppr.pw.bean.ResBody;
import com.ppr.pw.constraint.CharSequenceRule;
import com.ppr.pw.constraint.CharacterData;
import com.ppr.pw.constraint.CharacterRule;
import com.ppr.pw.constraint.LengthRule;
import com.ppr.pw.constraint.PasswordValidator;
import com.ppr.pw.constraint.RuleResult;
import com.ppr.pw.constraint.ValidCharacterRule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * User Controller class for users services endpoints
 *  @author Parthi
 */
@Controller
public class UserController {
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Password Validation endpoints
	 * 
	 * @param password
	 * @return responsecode and message
	 */
	
	 @PostMapping("/services/v1/user/pwvalidate")
	    @ResponseBody
	    public ResBody passwordValidate(@RequestParam(name="password", required=true) String password) {
	       
		 			 		
		 		 PasswordValidator validator = new PasswordValidator(Arrays.asList(
		 				 new LengthRule(5, 12),new CharacterRule(CharacterData.LowerCase, 1),new CharacterRule(CharacterData.Digit, 1), new CharSequenceRule(), new ValidCharacterRule() ));
		         RuleResult result = validator.validate(password);

		         if (result.isValid()) {
		        	 logger.info("The given Password is valid");
		        	 return new ResBody("valid", "200");
		         } else {
		        	 logger.info("The given password is invalid reason: "+result.getDetails().toString());
		        	 return new ResBody(result.getDetails().toString(), "422");
		         }
		 		
	    }

}
