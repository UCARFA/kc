/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.attr.CitizenshipType;

import static org.junit.Assert.assertEquals;

public class CitizenshipTypeServiceTest {

	@Test(expected = UnsupportedOperationException.class)
	public void testGetPersonCitizenshipTypeExternal() {
		ProposalPerson person = new ProposalPerson();
		CitizenshipTypeServiceImpl service = new CitizenshipTypeServiceImpl() {
			@Override 
			protected Boolean isCitizenshipTypeSourceInternal() {
				return false;
			}
		};
		service.getPersonCitizenshipType(person);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetPersonCitizenshipNullPerson() {
		CitizenshipTypeServiceImpl service = new CitizenshipTypeServiceImpl();
		service.getPersonCitizenshipType(null);
	}

	@Test
	public void testGetPersonCitizenshipRolodexPerson() {
		CitizenshipTypeServiceImpl service = new CitizenshipTypeServiceImpl() {
			@Override
			protected Boolean isCitizenshipTypeSourceInternal() {
				return true;
			}
			@Override
			protected Boolean isAllowCitizenshipTypeOverride() {
				return true;
			}
			@Override
			protected org.kuali.coeus.common.api.person.attr.CitizenshipType getCitizenshipTypeFromCode(String citizenShipCode) {
				if (StringUtils.equals(citizenShipCode, "1")) {
					return org.kuali.coeus.common.api.person.attr.CitizenshipType.PERMANENT_RESIDENT_OF_US;
				} else {
					return null;
				}
			}
		};
		ProposalPerson proposalPerson = new ProposalPerson();
		proposalPerson.setRolodexId(5);
		assertEquals(org.kuali.coeus.common.api.person.attr.CitizenshipType.NOT_AVAILABLE, service.getPersonCitizenshipType(proposalPerson));
	}
	
	@Test
	public void testGetPersonCitizenshipTypeFromProposal() {
		CitizenshipTypeServiceImpl service = new CitizenshipTypeServiceImpl() {
			@Override 
			protected Boolean isCitizenshipTypeSourceInternal() {
				return true;
			}
			@Override
			protected Boolean isAllowCitizenshipTypeOverride() {
				return true;
			}
			@Override
			protected org.kuali.coeus.common.api.person.attr.CitizenshipType getCitizenshipTypeFromCode(String citizenShipCode) {
				if (StringUtils.equals(citizenShipCode, "1")) {
					return org.kuali.coeus.common.api.person.attr.CitizenshipType.PERMANENT_RESIDENT_OF_US;
				} else {
					return null;
				}
			}
		};
		CitizenshipType newType = new CitizenshipType();
		newType.setCode(1);
		ProposalPerson person = new ProposalPerson();
		person.setCitizenshipType(newType);
		assertEquals(org.kuali.coeus.common.api.person.attr.CitizenshipType.PERMANENT_RESIDENT_OF_US, service.getPersonCitizenshipType(person));
	}
	
	@Test
	public void testGetPersonCitizenshipTypeFromPerson() {
		CitizenshipTypeServiceImpl service = new CitizenshipTypeServiceImpl() {
			@Override 
			protected Boolean isCitizenshipTypeSourceInternal() {
				return true;
			}
			@Override
			protected Boolean isAllowCitizenshipTypeOverride() {
				return false;
			}
			@Override
			protected org.kuali.coeus.common.api.person.attr.CitizenshipType getCitizenshipTypeFromCode(String citizenShipCode) {
				if (StringUtils.equals(citizenShipCode, "1")) {
					return org.kuali.coeus.common.api.person.attr.CitizenshipType.PERMANENT_RESIDENT_OF_US;
				} else {
					return null;
				}
			}
		};
		CitizenshipType newType = new CitizenshipType();
		newType.setCode(2);
		ProposalPerson person = new ProposalPerson() {
			@Override
			public KcPerson getPerson() {
				return new KcPerson() {
					@Override
					public Integer getCitizenshipTypeCode() {
						return 1;
					}
				};
			}
		};
		person.setCitizenshipType(newType);
		assertEquals(org.kuali.coeus.common.api.person.attr.CitizenshipType.PERMANENT_RESIDENT_OF_US, service.getPersonCitizenshipType(person));
	}
	
}
