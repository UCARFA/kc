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
package org.kuali.coeus.propdev.impl.s2s.nih;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.datadictionary.DataDictionary;
import org.kuali.rice.krad.service.DataDictionaryService;
import org.kuali.rice.krad.uif.container.Container;
import org.kuali.rice.krad.uif.container.Group;
import org.kuali.rice.krad.uif.container.PageGroup;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component("pageSectionService")
public class PageSectionServiceImpl implements PageSectionService {

    public static final String PARENT_BEAN = "parentBean";
    @Autowired
    @Qualifier("dataDictionaryService")
    private DataDictionaryService dataDictionaryService;
    private static Map<String, ArrayList<String>> pageToSections;

    static
    {
        pageToSections = new HashMap();
        ArrayList<String> sections = new ArrayList();
        sections.add(Constants.PROP_DEV_OPPORTUNITY_PAGE_FORMS);
        pageToSections.put(Constants.PROP_DEV_SPONSOR_PROGRAM_INFO_PAGE, sections);
        sections = new ArrayList<>();
        sections.add(Constants.PROP_DEV_APPLICANT_ORGANIZATION_PAGE_SECTION);
        sections.add(Constants.PROP_DEV_PERFORMING_ORGANIZATION_PAGE_SECTION);
        sections.add(Constants.PROP_DEV_PERFORMANCE_SITES_PAGE_SECTION);
        sections.add(Constants.PROP_DEV_OTHER_ORGANIZATIONS_PAGE_SECTION);
        pageToSections.put(Constants.PROP_DEV_ORGANIZATION_LOCATIONS_PAGE, sections);
        sections = new ArrayList<>();
        sections.add(Constants.PROP_DEV_CREDIT_ALLOCATION_SECTION);
        pageToSections.put(Constants.PROP_DEV_CREDIT_ALLOCATION_PAGE, sections);
        sections = new ArrayList<>();
        sections.add(Constants.PROP_DEV_SUPPLEMENTAL_SECTION);
        pageToSections.put(Constants.PROP_DEV_SUPPLEMENTAL_PAGE, sections);
    }

    @Override
    public List<String> getSectionsOnPage(String pageId) {
        return getSectionIds(pageId);
    }

    private List<String> getSectionIds(String pageId){
        DataDictionary dd = dataDictionaryService.getDataDictionary();
        List<String> nm = getBeanNamesForNamespace(dd);
        List<String> sectionIds = nm.stream().filter(currentName -> getSectionIds(dd, currentName, pageId)).collect(Collectors.toList());
        return sectionIds;
    }

    protected boolean getSectionIds(DataDictionary dd, String currentName, String pageId) {
        Pattern p = Pattern.compile("Actions|Button|Dialog|parentBean|Confirm|Footer|LowerGroup|Wizard");
        Matcher m = p.matcher(currentName);


        try {
            if ((currentName.contains(pageId) || (pageToSections.containsKey(pageId) && pageToSections.get(pageId).contains(currentName))) && !m.find()) {
                Object bean = dd.getDictionaryBean(currentName);
                if (!(bean instanceof PageGroup) && bean instanceof Group && ((Container)bean).getLayoutManager() != null) {
                    return true;
                }
            }
        } catch (BeanIsAbstractException e) {
            // This is faster than trying to figure out if bean is abstract.
            // If abstract bean do not do anything, ignore.
        }
        return false;
    }

    public List<String> getPageIds() {
        DataDictionary dd = dataDictionaryService.getDataDictionary();
        List<String> nm = getBeanNamesForNamespace(dd);
        List<String> pageIds = nm.stream().filter(currentName -> filterBeansForPages(dd, currentName)).sorted().collect(Collectors.toList());
        return pageIds;
    }

    protected boolean filterBeansForPages(DataDictionary dd, String currentName) {
        try {
            if (!currentName.contains(PARENT_BEAN)) {
                Object bean = dd.getDictionaryBean(currentName);
                if (bean instanceof PageGroup && ((Container)bean).getLayoutManager() != null) {
                    return true;
                }
            }
        } catch(BeanIsAbstractException e) {
            // This is faster than trying to figure out if bean is abstract.
            // If abstract bean do not do anything, ignore.
        }
        return false;
    }

    public List<String> getBeanNamesForNamespace(DataDictionary dd) {
        return dd.getBeanNamesForNamespace(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT);
    }

}
