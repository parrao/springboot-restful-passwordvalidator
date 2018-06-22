package com.ppr.pw.constraint;


/**
 * ValidationRule for determining if a password contains only lowercare and numerical digit only
 * @author Parthi
 */
public class ValidCharacterRule implements ValidationRule {

	
	 /** Default constructor. */
	 public ValidCharacterRule(){  }
	 
	 /**
	  * Validates the input password for valid Characters.
	  *
	  * @param  passwordData  to validate
	  *
	  * @return  rule result
	  */  
	 
	@Override
	public RuleResult validate(String passwordData) {
		final RuleResult result = new RuleResult();
		 final boolean isCharValid = isCharValid(passwordData);
		    if (isCharValid) {
		      result.setValid(true);
		    } else {
		      result.setValid(false);
		     
		        result.getDetails().add(new String("Password Should contain Lowercase letters and numerical digits"));
		     
		    }
		   
		    return result;
	}

	/**
	 * check for lowercare letter a-z and numerical 0-9
	 *@param  pwd password data
	 *
	 * @return  true/false boolean value
	 */ 
	private static boolean isCharValid(String pwd) {
		char[] chars = pwd.toCharArray();
		boolean valid_flag = false;
		
		for (int i = 0; i < chars.length; i++) {
			if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z'))  {
				valid_flag = true;
			}else {
				valid_flag = false;
				break;
			}
		
		}
		if (valid_flag) {
			return true;
		}
		return false;
	}

	
	
	
}
