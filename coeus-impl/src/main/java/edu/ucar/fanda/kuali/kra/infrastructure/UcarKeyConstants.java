/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.ucar.fanda.kuali.kra.infrastructure;


/**
 * This class contains constants.
 */
public final class UcarKeyConstants {
    
   
    // Award Details and Dates
	
	
    public static final String ERROR_INVALID_UNIT_NUMBER = "ucar.error.award.unitNumber";
    public static final String ERROR_INVALID_SPONSOR_CODE = "ucar.error.award.sponsorCode";
    public static final String ERROR_INVALID_ACCOUNT_NUMBER = "ucar.error.award.accountNumber";
   


    
    /**
     * private utility class ctor.
     * @throws UnsupportedOperationException if called.
     */
    private UcarKeyConstants() {
        throw new UnsupportedOperationException("do not call me");
    }
}
