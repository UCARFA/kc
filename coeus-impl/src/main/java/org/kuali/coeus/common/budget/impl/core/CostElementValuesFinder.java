/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.util.KRADPropertyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component("costElementValuesFinder")
public class CostElementValuesFinder extends UifKeyValuesFinderBase {

    public static final String BUDGET_CATEGORY_CODE = "budgetCategory.code";
    public static final String BUDGET_CATEGORY_BUDGET_CATEGORY_TYPE_CODE = "budgetCategory.budgetCategoryTypeCode";
    public static final String UNIT_NUMBER = "unitNumber";
    @Autowired
    @Qualifier("dataObjectService")
	DataObjectService dataObjectService;

    @Autowired
    @Qualifier("unitService")
    UnitService unitService;

    private String budgetCategoryTypeCode;
    private String unitNumber;

    /**
     * Constructs the list of COST ELEMENT.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * status code and the "value" is the textual description that is viewed
     * by a user.  
     * via the "KeyValueFinderService".
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        return getKeyValues(getBudgetCategoryTypeCode(), true, null, getUnitNumber());
    }

    public List<KeyValue> getKeyValues(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual, String budgetCategoryCode, String unitNumber) {
        return getCostElementKeyValues(budgetCategoryTypeCode, budgetCategoryTypeCodeEqual, budgetCategoryCode, unitNumber);
    }
    
    protected List<KeyValue> getCostElementKeyValues(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual, String budgetCategoryCode, String unitNumber) {
        List<CostElement> costElements = new ArrayList<>();

        Unit unit = getUnitService().getUnit(unitNumber);
        while (costElements.isEmpty() && unit != null) {
            costElements = getMatchingResults(budgetCategoryTypeCode, budgetCategoryTypeCodeEqual, budgetCategoryCode, unit);
            unit = getUnitService().getUnit(unit.getUnitNumber()).getParentUnit();
        }

        costElements = ifNoUnitsMappedGetAll(budgetCategoryTypeCode, budgetCategoryTypeCodeEqual, budgetCategoryCode, costElements);
        return getDropDownDisplay(costElements);
    }

    protected List<CostElement> getMatchingResults(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual, String budgetCategoryCode, Unit unit) {
        return getDataObjectService().findMatching(CostElement.class,
                QueryByCriteria.Builder.fromPredicates(getPredicates(budgetCategoryTypeCode, budgetCategoryTypeCodeEqual,
                        budgetCategoryCode, unit == null ? null : unit.getUnitNumber()))).getResults();
    }

    private List<CostElement> ifNoUnitsMappedGetAll(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual,
                                                    String budgetCategoryCode, List<CostElement> costElements) {
        if (costElements.isEmpty()) {
            costElements = getMatchingResults(budgetCategoryTypeCode, budgetCategoryTypeCodeEqual, budgetCategoryCode, null);
        }
        return costElements;
    }

    protected List<KeyValue> getDropDownDisplay(List<CostElement> costElements) {
        List<KeyValue> keyValues = new ArrayList<>();
        for (CostElement costElement : costElements) {
            keyValues.add(new ConcreteKeyValue(costElement.getCostElement(), costElement.getDescription()));
        }
        // added comparator below to alphabetize lists on label
        Collections.sort(keyValues, new KeyValueComparator());
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

    protected List<Predicate> getPredicates(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual, String budgetCategoryCode, String unitNumber) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(PredicateFactory.equal(KRADPropertyConstants.ACTIVE, Boolean.TRUE));

        if (!StringUtils.isBlank(budgetCategoryTypeCode)){
	        if (budgetCategoryTypeCodeEqual) {
	            predicates.add(PredicateFactory.equal(BUDGET_CATEGORY_BUDGET_CATEGORY_TYPE_CODE, budgetCategoryTypeCode));
	        } else {
	            predicates.add(PredicateFactory.notEqual(BUDGET_CATEGORY_BUDGET_CATEGORY_TYPE_CODE, budgetCategoryTypeCode));
	        }
        }
        if (StringUtils.isNotEmpty(budgetCategoryCode)) {
            predicates.add(PredicateFactory.equal(BUDGET_CATEGORY_CODE, budgetCategoryCode));
        }
        if (StringUtils.isNotEmpty(unitNumber)) {
            predicates.add(PredicateFactory.equal(UNIT_NUMBER, unitNumber));
        }
        return predicates;
    }
    
    public String getBudgetCategoryTypeCode() {
        return budgetCategoryTypeCode;
    }
    public void setBudgetCategoryTypeCode(String budgetCategoryTypeCode) {
        this.budgetCategoryTypeCode = budgetCategoryTypeCode;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    class KeyValueComparator implements Comparator<KeyValue> {
        @Override
        public int compare(KeyValue o1, KeyValue o2) {
            return o1.getValue().compareToIgnoreCase(o2.getValue());
        }        
    }

	public DataObjectService getDataObjectService() {
		//if this is coming from award budget, the autowiring won't work
		if (dataObjectService == null) {
			dataObjectService = KcServiceLocator.getService(DataObjectService.class);
		}
		return dataObjectService;
	}

    public UnitService getUnitService() {
        //if this is coming from award budget, the autowiring won't work
        if (unitService == null) {
            unitService = KcServiceLocator.getService(UnitService.class);
        }
        return unitService;
    }

    public void setUnitService(UnitService unitService) { this.unitService = unitService; }

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}

}
