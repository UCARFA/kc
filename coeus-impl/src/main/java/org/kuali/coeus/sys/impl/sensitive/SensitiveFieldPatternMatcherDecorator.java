/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.sensitive;

import org.kuali.coeus.sys.framework.sensitive.SensitiveFieldMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class is decorated to accommodate Pattern Matching
 */
@Component("sensitiveFieldPatternMatcher")
public class SensitiveFieldPatternMatcherDecorator implements SensitiveFieldMatcher {
    
    public static final String REPEAT_NTIMES = "[\\w\\.]*"; //\w = a-z or A-Z or _ or 0-9
    
    public static final String STAR_CONSTANT = "*";
    
    private List<Pattern> listOfPatterns = new ArrayList<Pattern>();

    private final SensitiveFieldMatcher matcher;

    @Autowired
    public SensitiveFieldPatternMatcherDecorator(@Qualifier("sensitiveFieldSimpleMatcher") SensitiveFieldMatcher matcher,
                                                 @Qualifier("sensitiveFieldResourceLoader") SensitiveFields sensitiveFields) {
        this.matcher = matcher;
        compileToPatterns(sensitiveFields.getSensitiveFields());
    }

    /**
     * Private helper method pre-compiles resource fields into patterns.
     * @param listOfStrings
     */
    private void compileToPatterns(List<String> listOfStrings) {
        for(String regex: listOfStrings) {
            if(!regex.contains(STAR_CONSTANT)) 
                continue;
            listOfPatterns.add(Pattern.compile(REPEAT_NTIMES+regex.substring(0, regex.length() - 1)+REPEAT_NTIMES, Pattern.CASE_INSENSITIVE));
        }
    }
    
    @Override
    public boolean match(String text) {
        //SimpleMatcher
        if(matcher.match(text)) return true;
        //PatternMathcer is used only if SimpleMatcher returns with no match. 
        for(Pattern pattern : listOfPatterns) {
            if(pattern.matcher(text).matches()) {
                return true;
            }
        }
        return false;
    }
    
}
