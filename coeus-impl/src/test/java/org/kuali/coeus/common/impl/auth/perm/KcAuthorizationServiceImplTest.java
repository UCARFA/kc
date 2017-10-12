package org.kuali.coeus.common.impl.auth.perm;

import com.google.common.collect.Comparators;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;
import org.kuali.coeus.common.permissions.impl.PermissionableKeys;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.kuali.rice.kim.api.role.RoleService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

public class KcAuthorizationServiceImplTest {

    private static final String AUTHORIZED_UNIT = "IN-CARD";
    private static final String UNAUTHORIZED_UNIT = "BL-BL";
    private static final String DOC_NUMBER_PREFIX = "D";
    private static final String PERM_NAMSPACE = "KC-PD";
    private static final String PERM_NAME = "View Proposal";
    private static final String USER_ID = "user";

    @Mock
    private PermissionService permissionService;

    @Mock
    private RoleService roleService;

    @Mock
    private UnitAuthorizationService unitAuthorizationService;

    @InjectMocks
    private KcAuthorizationServiceImpl kcAuthorizationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(unitAuthorizationService.hasPermission(eq(USER_ID), eq(AUTHORIZED_UNIT), eq(PERM_NAMSPACE), eq(PERM_NAME))).thenReturn(true);
        when(unitAuthorizationService.hasPermission(eq(USER_ID), eq(UNAUTHORIZED_UNIT), eq(PERM_NAMSPACE), eq(PERM_NAME))).thenReturn(false);
    }

    @Test
    public void testFilterForPermissionCorrectlyFiltersPermissionables() {
        mockAuthorizedPermissionServiceQualifier(KcKimAttributes.DOCUMENT_NUMBER, DOC_NUMBER_PREFIX + 7);
        mockAuthorizedPermissionServiceQualifier(PermissionableKeys.PROPOSAL_KEY, "8");
        List<ProposalDevelopmentDocument> permissionables = setupPermissionables();

        Collection<ProposalDevelopmentDocument> filteredPermissionables = kcAuthorizationService.filterForPermission(USER_ID, permissionables, PERM_NAMSPACE, PERM_NAME);
        assertEquals(7, filteredPermissionables.size());
        verify(unitAuthorizationService, times(2)).hasPermission(eq(USER_ID), anyString(), eq(PERM_NAMSPACE), eq(PERM_NAME));
        verify(permissionService, times(5)).isAuthorized(eq(USER_ID), eq(PERM_NAMSPACE), eq(PERM_NAME), anyMap());
    }

    @Test
    public void testFilterForPermissionPreservesCollectionOrder() {
        mockAuthorizedPermissionServiceQualifier(KcKimAttributes.DOCUMENT_NUMBER, DOC_NUMBER_PREFIX + 9);
        mockAuthorizedPermissionServiceQualifier(PermissionableKeys.PROPOSAL_KEY, "1");
        Comparator<ProposalDevelopmentDocument> reverseDocNumberComparator = Comparator.comparing(ProposalDevelopmentDocument::getDocumentNumber).reversed();
        List<ProposalDevelopmentDocument> permissionables = setupPermissionables(10, Arrays.asList(4, 5, 6));
        permissionables.sort(reverseDocNumberComparator);

        Collection<ProposalDevelopmentDocument> filteredPermissionables = kcAuthorizationService.filterForPermission(USER_ID, permissionables, PERM_NAMSPACE, PERM_NAME);
        assertTrue(Comparators.isInOrder(filteredPermissionables, reverseDocNumberComparator));
    }

    private List<ProposalDevelopmentDocument> setupPermissionables() {
        return setupPermissionables(10, Arrays.asList(0, 1, 2, 3, 4));
    }

    private List<ProposalDevelopmentDocument> setupPermissionables(int numberPermissionables, List<Integer> authorizedIndices) {
        List<ProposalDevelopmentDocument> permissionables = new ArrayList<>();
        for (int i = 0; i < numberPermissionables; i++) {
            DevelopmentProposal proposal = new DevelopmentProposal();
            proposal.setProposalNumber(String.valueOf(i));
            if (authorizedIndices.contains(i)) {
                proposal.setOwnedByUnitNumber(AUTHORIZED_UNIT);
            } else {
                proposal.setOwnedByUnitNumber(UNAUTHORIZED_UNIT);
            }
            ProposalDevelopmentDocument document = new ProposalDevelopmentDocument();
            document.setDocumentNumber(DOC_NUMBER_PREFIX + i);
            document.setDevelopmentProposal(proposal);
            permissionables.add(document);
        }
        return permissionables;
    }

    @SuppressWarnings("unchecked")
    private void mockAuthorizedPermissionServiceQualifier(String key, String entry) {
        when(permissionService.isAuthorized(eq(USER_ID), eq(PERM_NAMSPACE), eq(PERM_NAME), (Map<String, String>) argThat(hasEntry(key, entry)))).thenReturn(true);
    }

}
