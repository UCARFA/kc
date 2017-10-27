import PropTypes from 'prop-types';
import React from 'react';

import MedusaEntry from '../MedusaEntry';
import MedusaLinks from '../MedusaLinks';
import MedusaRow from '../MedusaRow';
import { concat } from '../../utils';

const openNegotiationLinkFor = docId => `../negotiationNegotiation.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&docTypeName=NegotiationDocument`;

const getNegotiationLinksFor = docId => [
    { text: 'Open Negotiation', href: openNegotiationLinkFor(docId) }
];

const NegotiationMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getNegotiationLinksFor(props.documentNumber)} />
        <MedusaRow>
            <MedusaEntry label="Negotiation ID" value={props.negotiationId} striped />
            <MedusaEntry label="Negotiation Status" value={props.negotiationStatus} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Negotiator" value={props.negotiator} striped />
            <MedusaEntry label="Negotiation Dates" value={concat(props.negotiationStartDate, props.negotiationEndDate, ' - ')} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Agreement Type" value={props.agreementType} striped />
            <MedusaEntry label="Negotiation Age" value={props.negotiationAge} />
        </MedusaRow>
    </div>
);

SubAwardMedusaInfo.propTypes = {
    documentNumber: PropTypes.string,
    negotiationId: PropTypes.number,
    negotiationStatus: PropTypes.string,
    negotiator: PropTypes.string,
    negotiationStartDate: PropTypes.string,
    negotiationEndDate: PropTypes.string,
    agreementType: PropTypes.agreementType,
    negotiationAge: PropTypes.number
};

export default SubAwardMedusaInfo;
