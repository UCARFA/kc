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
import { concat, formatUSD, linkTo } from '../../utils';

const openSubAwardLinkFor = docId => linkTo(`subAwardHome.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true`);

const getSubAwardLinksFor = docId => [
    { text: 'Open Subaward', href: openSubAwardLinkFor(docId) }
];

const SubAwardMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getSubAwardLinksFor(props.documentNumber)} />
        <MedusaHeading text="Summary" />
        <MedusaRow>
            <MedusaEntry label="Subaward ID" value={props.subAwardId} striped />
            <MedusaEntry label="Status" value={props.status} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Account Number" value={props.accountNumber} striped />
            <MedusaEntry label="Subrecipient Name" value={props.subRecipient} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Subaward Type" value={props.subAwardType} striped />
            <MedusaEntry label="Dates" value={concat(props.startDate, props.endDate, ' - ')} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Requisitioner" value={props.requisitioner} striped />
            <MedusaEntry label="Requisitioner Unit" value={concat(props.requisitionerUnitNumber, props.requisitionerUnitName, ' : ')} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Title" value={props.title} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Vendor ID" value={props.vendorNumber} />
            <MedusaEntry label="Purchase Order ID" value={props.purchaseOrderNum} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Closeout Date" value={props.closeoutDate} />
            <MedusaEntry label="Archive Location" value={props.archiveLocation} striped />
        </MedusaRow>
        <MedusaHeading text="Amounts" />
        <MedusaRow>
            <MedusaEntry label="Anticipated Amount" value={formatUSD(props.totalAnticipatedAmount)} striped />
            <MedusaEntry label="Obligated Amount" value={formatUSD(props.totalObligatedAmount)} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Amount Released" value={formatUSD(props.totalAmountReleased)} striped />
            <MedusaEntry label="Available Amount" value={formatUSD(props.totalAvailableAmount)} />
        </MedusaRow>
    </div>
);

SubAwardMedusaInfo.propTypes = {
    documentNumber: PropTypes.string,
    subAwardId: PropTypes.string,
    requisitioner: PropTypes.string,
    requisitionerUnitNumber: PropTypes.string,
    requisitionerUnitName: PropTypes.string,
    status: PropTypes.string,
    title: PropTypes.string,
    startDate: PropTypes.string,
    endDate: PropTypes.string,
    closeoutDate: PropTypes.string,
    subRecipient: PropTypes.string,
    accountNumber: PropTypes.string,
    subAwardType: PropTypes.string,
    purchaseOrderNum: PropTypes.string,
    vendorNumber: PropTypes.string,
    archiveLocation: PropTypes.string,
    comments: PropTypes.string,
    totalAnticipatedAmount: PropTypes.number,
    totalObligatedAmount: PropTypes.number,
    totalAmountReleased: PropTypes.number,
    totalAvailableAmount: PropTypes.number,
    investigators: PropTypes.arrayOf(PropTypes.shape({
        fullName: PropTypes.string,
        pi: PropTypes.bool,
        units: PropTypes.arrayOf(PropTypes.shape({
            unitNumber: PropTypes.string,
            unitName: PropTypes.string,
            leadUnit: PropTypes.bool
        }))
    }))
};

export default SubAwardMedusaInfo;
