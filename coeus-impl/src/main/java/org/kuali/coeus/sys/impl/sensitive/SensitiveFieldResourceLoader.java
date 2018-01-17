/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.sensitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to load sensitive fields resource file and store each
 * field in String ArrayList. Also, uses thread safe singleton pattern. 
 */
@Component("sensitiveFieldResourceLoader")
public class SensitiveFieldResourceLoader implements SensitiveFields {
    
    private List<String> listOfFields = new ArrayList<String>();

    @Autowired
    public SensitiveFieldResourceLoader(@Value("classpath:org/kuali/coeus/sys/impl/sensitive/sensitive-fields.txt") Resource fileResource) {
        buildList(fileResource);
    }

    private void buildList(Resource resource) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                listOfFields.add(line);
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method provides list of sensitive fields. 
     * @return
     */
    @Override
    public List<String> getSensitiveFields() {
        return listOfFields;
    }
}
