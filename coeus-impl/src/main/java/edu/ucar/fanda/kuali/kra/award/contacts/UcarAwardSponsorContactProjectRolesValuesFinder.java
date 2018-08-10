package edu.ucar.fanda.kuali.kra.award.contacts;

import org.kuali.kra.award.contacts.AwardContactsProjectRoleValuesFinder;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.award.home.ContactType;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UcarAwardSponsorContactProjectRolesValuesFinder  extends AwardContactsProjectRoleValuesFinder {

    @Override
    @SuppressWarnings("unchecked")
    public List getKeyValues() {
        boolean limitContactRoles = true;
        boolean adminModifyAward = true;
        List<KeyValue> returnKeys = new ArrayList<KeyValue>();
        List<KeyValue> keyValues = buildKeyValues(getKeyValuesService().findAllOrderBy(getRoleType(), "description", true));
        if (1==2 && limitContactRoles && adminModifyAward) {
            String contactRoleString = "1,10";
            List<String> contactRoleList = Arrays.asList((contactRoleString.split("\\s*,\\s*")));
            for (KeyValue keyValue : keyValues) {
                System.out.println("Key Value: " + keyValue.getKey());
                for (String contactRole : contactRoleList) {
                    if(keyValue.getKey().equals(contactRole)) {
                        System.out.println(">>> Key Value for return: " + keyValue.getKey());
                        returnKeys.add(keyValue);
                        break;
                    }
                }
            }
        } else {
            returnKeys = keyValues;
        }
        return returnKeys;
    }

    @Override
    protected Class<? extends ContactRole> getRoleType() {
        return ContactType.class;
    }
}
