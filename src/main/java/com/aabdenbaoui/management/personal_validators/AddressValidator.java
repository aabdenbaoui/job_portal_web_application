package com.aabdenbaoui.management.personal_validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.aspectj.lang.annotation.AfterReturning;

import com.aabdenbaoui.management.entity.*;
import com.aabdenbaoui.management.entity.enums.State;
import com.aabdenbaoui.management.entity.managingusers.Address;

import net.bytebuddy.asm.Advice.Return;

public class AddressValidator implements ConstraintValidator<AddressConstraint, Address> {
    
	
	
	@Override
	public boolean isValid(Address address, ConstraintValidatorContext context) {
        State state =  address.getState();
//		if(address.getState().equals("Alaska") && (Integer.parseInt(address.getZipCode()) >= 99501 || Integer.parseInt(address.getZipCode()) <= 99950)){
		int zipcode = Integer.valueOf(address.getZipCode());
		if ((zipcode >= 35000 && zipcode <= 36999) && (state == State.AL)){
               return true;
		} else if ((zipcode >= 99500 && zipcode <= 99999) && (state == State.AK)){
		       return true;
		} else if ((zipcode >= 85000 && zipcode <= 86999) && (state == State.AZ)){
			   return true;
		} else if ((zipcode >= 71600 && zipcode <= 72999) && (state ==  State.AR)){
			return true;
		} else if ((zipcode >= 90000 && zipcode <= 96699) && (state == State.CA)){
			return true;
		} else if ((zipcode >= 80000 && zipcode <= 81999) && (state == State.CO)){
		     return true;
		} else if (((zipcode >= 6000 && zipcode <= 6389) || (zipcode >= 6391 && zipcode <= 6999)) && (state == State.CT)) {
		    return true;
		} else if ((zipcode >= 19700 && zipcode <= 19999) && (state == State.DE)){
		    return true;
		} else if ((zipcode >= 32000 && zipcode <= 34999) && (state == State.FL)){
		      return true;
		} else if (((zipcode >= 30000 && zipcode <= 31999) || (zipcode >= 39800 && zipcode <= 39999)) && (state == State.GA)) {
		     return true;
		} else if ((zipcode >= 96700 && zipcode <= 96999) && (state == State.HI)) {
		     return true;
		} else if ((zipcode >= 83200 && zipcode <= 83999) && (state == State.ID)){
		     return true;
		} else if ((zipcode >= 60000 && zipcode <= 62999) && (state == State.IL)){
		     return true;
		} else if ((zipcode >= 46000 && zipcode <= 47999) && (state == State.IN)){
		      return true;
		} else if ((zipcode >= 50000 && zipcode <= 52999) && (state == State.IA)) {
		      return true;
		} else if ((zipcode >= 66000 && zipcode <= 67999) && (state == State.KS)){
		      return true;
		} else if ((zipcode >= 40000 && zipcode <= 42999) && (state == State.KY)){
		     return true;
		} else if ((zipcode >= 70000 && zipcode <= 71599) && (state == State.LA)){
		     return true;
		} else if ((zipcode >= 3900 && zipcode <= 4999) && (state == State.ME)) {
		     return true;
		} else if ((zipcode >= 20600 && zipcode <= 21999) && (state == State.MD)) {
		      return true;
		} else if (((zipcode >= 1000 && zipcode <= 2799) || (zipcode == 5501) || (zipcode == 5544 )) && (state == State.MA)){
		      return true;
		} else if ((zipcode >= 48000 && zipcode <= 49999) && (state == State.MI)){
		      return true;
		} else if ((zipcode >= 38600 && zipcode <= 39999) && (state == State.MS)) {
		      return true;
		} else if ((zipcode >= 63000 && zipcode <= 65999) && (state == State.MO)) {
		      return true;
		} else if ((zipcode >= 59000 && zipcode <= 59999) && (state == State.MT)){
		      return true;
		} else if ((zipcode >= 27000 && zipcode <= 28999)  && (state == State.NC)){
		      return true;
		} else if ((zipcode >= 58000 && zipcode <= 58999)  && (state == State.ND)) {
		      return true;
		} else if ((zipcode >= 68000 && zipcode <= 69999)  && (state == State.NE)) {
		      return true;
	    } else if ((zipcode >= 88900 && zipcode <= 89999)  && (state == State.NV)) {
		      return true;
		} else if ((zipcode >= 3000 && zipcode <= 3899)  && (state == State.NH)){
		      return true;
		} else if ((zipcode >= 7000 && zipcode <= 8999) && (state == State.NJ)){
		     return true;
		} else if ((zipcode >= 87000 && zipcode <= 88499)  && (state == State.NM)){
		      return true;
		} else if (((zipcode >= 10000 && zipcode <= 14999) || (zipcode == 6390) || (zipcode == 501) || (zipcode == 544))  && (state == State.NY)) {
		      return true;
		} else if ((zipcode >= 43000 && zipcode <= 45999)  && (state == State.OH)){
		      return true;
	    } else if (((zipcode >= 73000 && zipcode <= 73199) || (zipcode >= 73400 && zipcode <= 74999))  && (state == State.OK)){
		      return true;
		} else if ((zipcode >= 97000 && zipcode <= 97999)  && (state == State.OR)){
		     return true;
		} else if ((zipcode >= 15000 && zipcode <= 19699)  && (state == State.PA)) {
		      return true;
		} else if ((zipcode >= 2800 && zipcode <= 2999)  && (state == State.RI)) {
		      return true;
		} else if ((zipcode >= 29000 && zipcode <= 29999)  && (state == State.SC)){
		      return true;
		} else if ((zipcode >= 57000 && zipcode <= 57999)  && (state == State.SD)) {
		     return true;
		} else if ((zipcode >= 37000 && zipcode <= 38599)  && (state == State.TN)) {
		    return true;
		} else if (((zipcode >= 75000 && zipcode <= 79999) || (zipcode >= 73301 && zipcode <= 73399) ||  (zipcode >= 88500 && zipcode <= 88599))  && (state == State.TX)){
		      return true;
		} else if ((zipcode >= 84000 && zipcode <= 84999)  && (state == State.UT)){
		      return true;
		} else if ((zipcode >= 5000 && zipcode <= 5999)  && (state == State.VT)) {
		     return true;
		} else if (((zipcode >= 20100 && zipcode <= 20199) || (zipcode >= 22000 && zipcode <= 24699) || (zipcode == 20598))  && (state == State.VA)){
		      return true;
		} else if (((zipcode >= 20000 && zipcode <= 20099) || (zipcode >= 20200 && zipcode <= 20599) || (zipcode >= 56900 && zipcode <= 56999))  && (state == State.DC)) {
		      return true;
		} else if ((zipcode >= 98000 && zipcode <= 99499)  && (state == State.WA)){
		      return true;
		} else if ((zipcode >= 24700 && zipcode <= 26999)  && (state == State.WV)) {
		      return true;
		} else if ((zipcode >= 53000 && zipcode <= 54999)  && (state == State.WI)){
		      return true;
		} else if ((zipcode >= 82000 && zipcode <= 83199)  && (state == State.WY)) {
		      return true;
		}

		return false;
	}

}
