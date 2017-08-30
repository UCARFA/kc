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
package edu.ucar.fanda.kuali.kra.award;

import org.kuali.kra.award.detailsdates.AwardDetailsAndDatesSaveEvent;
import org.kuali.rice.krad.rules.rule.BusinessRule;



/**
 * This interface declares the rule methods associated with <code>AwardDetailsAndDates</code> functionality.
 *  NOTE: Add additional rules by adding new process methods by award section to keep
 *  each rule checking method to one area of responsibility.
 *  
 * @author Kuali Coeus development team (kc.dev@kuali.org)
 */

public interface UcarAwardRule extends BusinessRule {
    
    /**
     * Check UCAR custom rule to check award anticipated total is valid (example)
     * <code>{@link org.kuali.kra.award.document.AwardDocument}</code>
     *
     * @return boolean
     */
  
    boolean processUcarSaveActicipatedTotalValid(AwardDetailsAndDatesSaveEvent awardDetailsAndDatesSaveEvent);
    
}