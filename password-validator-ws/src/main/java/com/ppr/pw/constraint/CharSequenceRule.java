package com.ppr.pw.constraint;

import java.util.HashMap;

/**
 * ValidationRule for determining if a password contains any sequence of characters immediately followed by the same sequence
 * @author Parthi
 */
public class CharSequenceRule implements ValidationRule {
	

 /** Default constructor. */
 public CharSequenceRule(){  }
 
 
 /**
  * Validates the input password for Sequence of Characters.
  *
  * @param  passwordData  to validate
  *
  * @return  rule result
  */ 
@Override
public RuleResult validate(String passwordData) {
final RuleResult result = new RuleResult();
		 
		    final boolean isSeqValid = isCharSeqValid(passwordData);
		    if (isSeqValid) {
		      result.setValid(true);
		    } else {
		      result.setValid(false);
		     
		        result.getDetails().add(new String("Repeated Sequence of Characters"));
		     
		    }
		   
		    return result;
	}
	
	/**
	 * check for sequence of characters immediately followed by the same sequence
	 *@param  pwd password data to seq check
	 *
	 * @return  true/false boolean value
	 */
	public static boolean isCharSeqValid(String pwd){
		
		HashMap<String,Integer> stridxMap = null;
		int len = pwd.length();
		
		for(int i = 1; i< len ; i++){
			stridxMap = new HashMap<String,Integer>();
			for(int j = 0; j+i <= len;j++){
				String sub = pwd.substring(j,j+i);
				if(stridxMap.get(sub) == null){
					stridxMap.put(sub, j + i -1);
				}
				else{
					int prevlastIndex = stridxMap.get(sub);
					if(prevlastIndex == j - 1) return false;
				}
		}
		}
		return true;
	}

}
