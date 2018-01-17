/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.training;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.api.document.impl.CommonApiServiceImpl;
import org.kuali.coeus.common.api.training.dto.PersonTrainingDto;
import org.kuali.coeus.common.framework.person.attr.PersonTraining;
import org.kuali.kra.bo.TrainingModule;

import java.util.ArrayList;
import java.util.List;

public class TrainingControllerTest {

    @Test
    public void testTrainingModuleFilter() {

        TrainingController trainingControllerMock = new TrainingController() {
            @Override
            protected List<TrainingModule> getTrainingModules(String moduleCode) {
                List<TrainingModule> trainingModules = new ArrayList<>();
                trainingModules.add(getTrainingModule(1, "2"));
                trainingModules.add(getTrainingModule(2, "2"));
                return trainingModules;
            }

        };


        List<PersonTraining> personTrainings = new ArrayList<>();
        personTrainings.add(getPersonTraining(1, "101"));
        personTrainings.add(getPersonTraining(2, "101"));
        personTrainings.add(getPersonTraining(3, "101"));
        personTrainings.add(getPersonTraining(4, "101"));

        List<PersonTraining> trainings = trainingControllerMock.getPersonTrainingsForModule("101", personTrainings);
        Assert.assertTrue(trainings.size() == 2);
        Assert.assertTrue(trainings.get(0).getPersonId().equalsIgnoreCase("101"));
        Assert.assertTrue(trainings.get(1).getPersonId().equalsIgnoreCase("101"));
        Assert.assertTrue(trainings.get(0).getTrainingCode().equals(1));
        Assert.assertTrue(trainings.get(1).getTrainingCode().equals(2));

        trainings = trainingControllerMock.getPersonTrainingsForModule("102", personTrainings);

    }

    @Test
    public void testTrainingModuleFilterNoTrainings() {

        TrainingController trainingControllerMock = new TrainingController() {
            @Override
            protected List<TrainingModule> getTrainingModules(String moduleCode) {
                List<TrainingModule> trainingModules = new ArrayList<>();
                trainingModules.add(getTrainingModule(1, "2"));
                trainingModules.add(getTrainingModule(2, "2"));
                return trainingModules;
            }
        };

        List<PersonTraining> trainings = trainingControllerMock.getPersonTrainingsForModule("101", new ArrayList<>());
        Assert.assertTrue(trainings.size() == 0);

    }

    @Test
    public void testTrainingModuleFilterNoModuleCode() {

        TrainingController trainingControllerMock = new TrainingController() {
            @Override
            protected List<TrainingModule> getTrainingModules(String moduleCode) {
                List<TrainingModule> trainingModules = new ArrayList<>();
                trainingModules.add(getTrainingModule(1, "2"));
                trainingModules.add(getTrainingModule(2, "2"));
                return trainingModules;
            }

            @Override
            protected List<PersonTraining> getPersonTrainings(String personId) {
                List<PersonTraining> personTrainings = new ArrayList<>();
                personTrainings.add(getPersonTraining(1, "101"));
                personTrainings.add(getPersonTraining(2, "101"));
                personTrainings.add(getPersonTraining(3, "101"));
                personTrainings.add(getPersonTraining(4, "101"));
                return personTrainings;
            }
        };

        trainingControllerMock.setCommonApiService(new CommonApiServiceImpl());
        List<PersonTrainingDto> trainings = trainingControllerMock.getTrainingForPerson("101", null);
        Assert.assertTrue(trainings.size() == 4);

    }

    private TrainingModule getTrainingModule(Integer trainingCode, String moduleCode) {
        TrainingModule tm1 = new TrainingModule();
        tm1.setTrainingCode(trainingCode);
        tm1.setModuleCode(moduleCode);
        return tm1;
    }

    private PersonTraining getPersonTraining(Integer trainingCode, String personId) {
        PersonTraining pt1 = new PersonTraining();
        pt1.setTrainingCode(trainingCode);
        pt1.setPersonId(personId);
        return pt1;
    }


}
