/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.persistence;

import org.apache.ojb.broker.metadata.ClassDescriptor;
import org.apache.ojb.broker.metadata.FieldDescriptor;
import org.apache.ojb.broker.metadata.ObjectReferenceDescriptor;
import org.kuali.coeus.sys.framework.persistence.KcPersistenceStructureService;
import org.kuali.rice.krad.bo.DataObjectRelationship;
import org.kuali.rice.krad.exception.ClassNotPersistableException;
import org.kuali.rice.krad.service.PersistenceStructureService;
import org.kuali.rice.krad.service.impl.PersistenceStructureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("kcPersistenceStructureService")
public class KcPersistenceStructureServiceImpl extends PersistenceStructureServiceImpl implements KcPersistenceStructureService {

    @Override
    public Map<String, String> getDBColumnToObjectAttributeMap(Class<?> clazz) throws ClassNotPersistableException {
        Map<String, String> fieldMap = new HashMap<>();
        if(isPersistable(clazz)) {
            ClassDescriptor classDescriptor = getClassDescriptor(clazz);
            FieldDescriptor fieldDescriptors[] = classDescriptor.getFieldDescriptions();
            for(FieldDescriptor fieldDescriptor : fieldDescriptors) {
                fieldMap.put(fieldDescriptor.getColumnName(), fieldDescriptor.getAttributeName());
            }
            return fieldMap;
        } 
        
        throw new ClassNotPersistableException(clazz.getName() + " is not Persistable");
    }

    @Override
    public List<String> listFieldNames(Class<?> clazz, boolean mapAnonymousFields) {
        if (!mapAnonymousFields) {
            return listFieldNames(clazz);
        } else {
            final ClassDescriptor classDescriptor = getClassDescriptor(clazz);
            final List<String> fieldNames = Stream.of(classDescriptor.getFieldDescriptions())
                    .filter(fd -> !fd.isAnonymous()).map(FieldDescriptor::getAttributeName)
                    .collect(Collectors.toList());

            final List<String> anonFields = Stream.of(classDescriptor.getFieldDescriptions())
                    .filter(FieldDescriptor::isAnonymous).map(FieldDescriptor::getAttributeName)
                    .collect(Collectors.toList());

            ((List<ObjectReferenceDescriptor>) classDescriptor.getObjectReferenceDescriptors()).forEach(desc -> {
                if (anonFields.containsAll(desc.getForeignKeyFields())) {
                    fieldNames.addAll(((List<String>) desc.getForeignKeyFields()).stream()
                            .map(field -> desc.getAttributeName() + "." + field)
                            .collect(Collectors.toList()));
                    anonFields.removeAll(desc.getForeignKeyFields());
                }
            });
            return fieldNames;
        }
    }

    @Override
    public Map<String, String> getPersistableAttributesColumnMap(Class<?> clazz) throws ClassNotPersistableException {
        Map<String, String> fieldMap = new HashMap<>();
        if(isPersistable(clazz)) {
            ClassDescriptor classDescriptor = getClassDescriptor(clazz);
            FieldDescriptor fieldDescriptors[] = classDescriptor.getFieldDescriptions();
            for(FieldDescriptor fieldDescriptor : fieldDescriptors) {
                fieldMap.put(fieldDescriptor.getAttributeName(), fieldDescriptor.getColumnName());
            }
            return fieldMap;
        } 
        
        throw new ClassNotPersistableException(clazz.getName() + " is not Persistable");
     }

    @Override
    public List<DataObjectRelationship> getRelationshipsTo(Class<?> persistableClass) throws ClassNotPersistableException {
        if(!isPersistable(persistableClass)) {
            throw new ClassNotPersistableException(persistableClass.getName() + " is not persistable");
        }

        final List<DataObjectRelationship> relationships = new ArrayList<>();

        @SuppressWarnings("unchecked")
        final Set<Map.Entry<String, ClassDescriptor>> entries = (Set<Map.Entry<String, ClassDescriptor>>) getDescriptorRepository().getDescriptorTable().entrySet();
        for (Map.Entry<String, ClassDescriptor> entry : entries) {
            @SuppressWarnings("unchecked")
            final Collection<ObjectReferenceDescriptor> references = entry.getValue().getObjectReferenceDescriptors();
            if (references != null) {
                for (ObjectReferenceDescriptor reference : references) {
                    if (reference.getItemClass().equals(persistableClass)) {
                        final DataObjectRelationship relationship = new DataObjectRelationship(entry.getValue().getClassOfObject(), reference.getAttributeName(), reference.getItemClass());
                        final Map<String, String> pToC = new HashMap<>();
                        for (int i = 0; i < reference.getForeignKeyFields().size(); i++) {
                            final String fkField = reference.getForeignKeyFields().get(i).toString();
                            pToC.put(fkField, getDescriptorRepository().getDescriptorFor(reference.getItemClass()).getPkFields()[i].getAttributeName());
                        }
                        relationship.setParentToChildReferences(pToC);
                        relationships.add(relationship);
                    }
                }
            }
        }

        return relationships;
    }

    @Autowired
    @Qualifier("persistenceStructureServiceOjb")
    @Override
    public void setPersistenceStructureServiceOjb(PersistenceStructureService persistenceStructureServiceOjb) {
        super.setPersistenceStructureServiceOjb(persistenceStructureServiceOjb);
    }
}
