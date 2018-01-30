/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

import PropTypes from 'prop-types';
import React from 'react';

import MedusaEntry from '../MedusaEntry';
import MedusaHeading from '../MedusaHeading';
import MedusaLinks from '../MedusaLinks';
import MedusaRow from '../MedusaRow';
import { concat, linkTo } from '../../utils';

const openNegotiationLinkFor = docId => linkTo(`negotiationNegotiation.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true`);

const getNegotiationLinksFor = docId => [
    { text: 'Open Negotiation', href: openNegotiationLinkFor(docId) }
];

const NegotiationMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getNegotiationLinksFor(props.documentNumber)} />
        <MedusaHeading text="Summary" />
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

NegotiationMedusaInfo.propTypes = {
    documentNumber: PropTypes.string,
    negotiationId: PropTypes.number,
    negotiationStatus: PropTypes.string,
    negotiator: PropTypes.string,
    negotiationStartDate: PropTypes.string,
    negotiationEndDate: PropTypes.string,
    agreementType: PropTypes.string,
    negotiationAge: PropTypes.number
};

export default NegotiationMedusaInfo;
