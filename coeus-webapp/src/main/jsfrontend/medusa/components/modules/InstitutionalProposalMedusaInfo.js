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
import MedusaInvestigators from '../MedusaInvestigators';
import MedusaLinks from '../MedusaLinks';
import MedusaRow from '../MedusaRow';
import { concat, formatUSD, linkTo } from '../../utils';

const openIPLinkFor = docId => linkTo(`institutionalProposalHome.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true`);
const openNotesLinkFor = docId => linkTo(`institutionalProposalHome.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true&tabStates(Notes)=OPEN#Notes`);

const getIPLinksFor = docId => [
    { text: 'Open Proposal', href: openIPLinkFor(docId) },
    { text: 'Open Proposal Notes', href: openNotesLinkFor(docId) }
];

const InstitutionalProposalMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getIPLinksFor(props.documentNumber)} />
        <MedusaHeading text="Summary" />
        <MedusaRow>
            <MedusaEntry label="Proposal Number" value={props.proposalNumber} striped />
            <MedusaEntry label="Proposal Status" value={props.proposalStatus} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Lead Unit" value={concat(props.leadUnitNumber, props.leadUnitName, ' : ')} striped />
            <MedusaEntry label="Proposal Type" value={props.proposalType} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Title" value={props.title} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="NSF Code" value={props.nsfCode} />
            <MedusaEntry label="Activity Type" value={props.nsfCode} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Account Number" value={props.currentAccountNumber} />
            <MedusaEntry label="Notice of Opportunity" value={props.noticeOfOpportunity} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Sponsor Proposal Number" value={props.sponsorProposalNumber} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Sponsor" value={concat(props.sponsorCode, props.sponsorName, ' ')} striped />
            <MedusaEntry label="Prime Sponsor" value={concat(props.primeSponsorCode, props.primeSponsorName, ' ')} />
        </MedusaRow>
        <MedusaHeading text="Initial Period" />
        <MedusaRow>
            <MedusaEntry label="Requested Dates" value={concat(props.requestedStartDateInitial, props.requestedEndDateInitial, ' - ')} striped />
            <MedusaEntry label="Total Direct Cost" value={formatUSD(props.totalDirectCostInitial)} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Total F & A Cost" value={formatUSD(props.totalIndirectCostInitial)} striped />
            <MedusaEntry label="Total All Cost" value={formatUSD(props.totalInitialCost)} />
        </MedusaRow>
        <MedusaHeading text="Total Period" />
        <MedusaRow>
            <MedusaEntry label="Requested Dates" value={concat(props.requestedStartDateTotal, props.requestedEndDateTotal, ' - ')} striped />
            <MedusaEntry label="Total Direct Cost" value={formatUSD(props.totalDirectCostTotal)} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Total F & A Cost" value={formatUSD(props.totalIndirectCostTotal)} striped />
            <MedusaEntry label="Total All Cost" value={formatUSD(props.totalCost)} />
        </MedusaRow>
        <MedusaHeading text="Other Details" />
        <MedusaRow>
            <MedusaEntry label="Cost Sharing" value={props.costSharing} striped />
            <MedusaEntry label="Unrecovered F & A" value={props.unrecoveredFandA} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Special Review" value={props.specialReview} striped />
        </MedusaRow>
        <MedusaInvestigators investigators={props.investigators} />
    </div>
);

InstitutionalProposalMedusaInfo.propTypes = {
    documentNumber: PropTypes.string,
    proposalNumber: PropTypes.string,
    leadUnitNumber: PropTypes.string,
    leadUnitName: PropTypes.string,
    proposalStatus: PropTypes.string,
    title: PropTypes.string,
    proposalType: PropTypes.string,
    currentAccountNumber: PropTypes.string,
    nsfCode: PropTypes.string,
    noticeOfOpportunity: PropTypes.string,
    sponsorCode: PropTypes.string,
    sponsorName: PropTypes.string,
    primeSponsorCode: PropTypes.string,
    primeSponsorName: PropTypes.string,
    sponsorProposalNumber: PropTypes.string,
    costSharing: PropTypes.bool,
    unrecoveredFandA: PropTypes.bool,
    specialReview: PropTypes.bool,
    requestedStartDateInitial: PropTypes.string,
    requestedStartDateTotal: PropTypes.string,
    requestedEndDateInitial: PropTypes.string,
    requestedEndDateTotal: PropTypes.string,
    totalDirectCostInitial: PropTypes.number,
    totalDirectCostTotal: PropTypes.number,
    totalIndirectCostInitial: PropTypes.number,
    totalIndirectCostTotal: PropTypes.number,
    totalInitialCost: PropTypes.number,
    totalCost: PropTypes.number,
    activityType: PropTypes.string,
    noticeOfOpportunity: PropTypes.string,
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

export default InstitutionalProposalMedusaInfo;
