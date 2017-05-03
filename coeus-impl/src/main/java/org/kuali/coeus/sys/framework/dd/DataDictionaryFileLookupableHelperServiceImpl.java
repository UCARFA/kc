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
package org.kuali.coeus.sys.framework.dd;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kns.lookup.AbstractLookupableHelperServiceImpl;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.UrlFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.util.InMemoryResource;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataDictionaryFileLookupableHelperServiceImpl extends AbstractLookupableHelperServiceImpl {

    private static final String ID = "id";
    private static final String DOWNLOAD = "download";
    private static final String VIEW = "View";
    private static final String DATA_DICTIONARY_FILE_DO = "../dataDictionaryFile.do";
    private static final String MODULE = "module";
    private static final String NAME = "name";
    private static final String PATH = "path";

    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        final String idSearch = fieldValues.get(ID);
        final String moduleSearch = fieldValues.get(MODULE);
        final String nameSearch = fieldValues.get(NAME);
        final String pathSearch = fieldValues.get(PATH);

        return getDataDictionaryService().getDataDictionary().getModuleDictionaryFiles()
                .entrySet()
                .stream()
                .map(entry -> entry.getValue().stream()
                        .map(r -> {
                    final DataDictionaryFile file = new DataDictionaryFile();
                    file.setModule(entry.getKey());

                    final String id;
                    final String path;
                    final String name;

                    if (r instanceof ClassPathResource) {
                        final ClassPathResource classPathResource = (ClassPathResource) r;
                        path = "classpath:" + classPathResource.getPath();
                        id = path;
                        name = classPathResource.getFilename();
                    } else if (r instanceof InMemoryResource) {
                        final InMemoryResource inMemoryResource = (InMemoryResource) r;

                        final DataDictionaryOverride override = getBusinessObjectService().findBySinglePrimaryKey(DataDictionaryOverride.class, inMemoryResource.getDescription());
                        path = "<a href=\"inquiry.do?businessObjectClassName=" + DataDictionaryOverride.class.getName() + "&" + ID + "=" + inMemoryResource.getDescription() + "&methodToCall=start\">" + DataDictionaryOverride.class.getName() + "</a>";
                        id = inMemoryResource.getDescription();
                        name = override.getFileName();
                    } else {
                        throw new RuntimeException("unknown resource type " + r.getClass().getName());
                    }

                    file.setId(id);
                    file.setPath(path);
                    file.setName(name);
                    try {
                        file.setContent(IOUtils.toByteArray(r.getInputStream()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return file;
                }).collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .filter(file -> StringUtils.isBlank(idSearch) || (StringUtils.isNotBlank(idSearch) && file.getId().equals(idSearch)))
                .filter(file -> StringUtils.isBlank(moduleSearch) || (StringUtils.isNotBlank(moduleSearch) && matches(file.getModule(), moduleSearch)))
                .filter(file -> StringUtils.isBlank(nameSearch) || (StringUtils.isNotBlank(nameSearch) && matches(file.getName(), nameSearch)))
                .filter(file -> StringUtils.isBlank(pathSearch) || (StringUtils.isNotBlank(pathSearch) && matches(file.getPath(), pathSearch)))
                .collect(Collectors.toList());
    }

    private boolean matches(String val, String search) {
        return val.matches(search.replace("*", ".*"));
    }

    @Override
    public List<HtmlData> getCustomActionUrls(BusinessObject businessObject, List pkNames) {
        List<HtmlData> htmlDataList = new ArrayList<>();
        addViewHtmlData(htmlDataList, businessObject);
        return htmlDataList;

    }
    protected void addViewHtmlData(List<HtmlData> htmlDataList, BusinessObject businessObject) {
        htmlDataList.add(getViewLink((DataDictionaryFile) businessObject));
    }

    protected HtmlData.AnchorHtmlData getViewLink(DataDictionaryFile businessObject) {
        Properties parameters = new Properties();
        parameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, DOWNLOAD);
        parameters.put(ID, businessObject.getId());
        String href = UrlFactory.parameterizeUrl(DATA_DICTIONARY_FILE_DO, parameters);

        return new HtmlData.AnchorHtmlData(href, DOWNLOAD, VIEW);
    }
}
