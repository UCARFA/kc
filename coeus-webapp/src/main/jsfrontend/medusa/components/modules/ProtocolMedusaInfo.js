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
import { linkTo } from '../../utils';

const openProtocolLinkFor = (action, docId) => linkTo(`${action}?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true`);

const getProtocolLinksFor = (moduleName, docId) => {
    const action = moduleName === 'IRB' ? 'protocolProtocol.do' : 'iacucProtocolProtocol.do';
    return [
        { text: `Open ${moduleName} Protocol`, href: openProtocolLinkFor(action, docId) }
    ];
};

const ProtocolMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getProtocolLinksFor(props.moduleName, props.documentNumber)} />
        <MedusaHeading text="Summary" />
        <MedusaRow>
            <MedusaEntry label="Protocol Number" value={props.protocolNumber} striped />
            <MedusaEntry label="Protocol Type" value={props.protocolType} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Protocol Status" value={props.protocolStatus} striped />
            <MedusaEntry label="Submission Status" value={props.submissionStatus} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Title" value={props.title} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Approval Date" value={props.approvalDate} />
            <MedusaEntry label="Last Approval Date" value={props.lastApprovalDate} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Initial Submission Date" value={props.initialSubmissionDate} />
            <MedusaEntry label="Expiration Date" value={props.expirationDate} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Reference Number 1" value={props.referenceNumber1} />
            <MedusaEntry label="Reference Number 2" value={props.referenceNumber2} striped />
        </MedusaRow>
    </div>
);

ProtocolMedusaInfo.propTypes = {
    moduleName: PropTypes.string.isRequired,
    documentNumber: PropTypes.string,
    protocolId: PropTypes.number,
    protocolNumber: PropTypes.string,
    protocolStatus: PropTypes.string,
    submissionStatus: PropTypes.string,
    protocolType: PropTypes.string,
    title: PropTypes.string,
    approvalDate: PropTypes.string,
    lastApprovalDate: PropTypes.string,
    initialSubmissionDate: PropTypes.string,
    expirationDate: PropTypes.string,
    referenceNumber1: PropTypes.string,
    referenceNumber2: PropTypes.string
};

export default ProtocolMedusaInfo;
