import PropTypes from 'prop-types';
import React from 'react';

import MedusaEntry from '../MedusaEntry';
import MedusaHeading from '../MedusaHeading';
import MedusaInvestigators from '../MedusaInvestigators';
import MedusaLinks from '../MedusaLinks';
import MedusaRow from '../MedusaRow';
import { concat, formatUSD, linkTo } from '../../utils';

const openAwardLinkFor = docId => linkTo(`awardHome.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true`);
const openAwardNotesLinkFor = docId => linkTo(`awardNotesAndAttachments.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true&tabStates(Notes)=OPEN#Notes`);
const openAwardHierarchyLinkFor = docId => linkTo(`awardActions.do?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&medusaOpenedDoc=true&tabStates(HierarchyActions)=OPEN#Hierarchy Actions`);

const getAwardLinks = docId => [
    { text: 'Open Award', href: openAwardLinkFor(docId) },
    { text: 'Open Award Notes', href: openAwardNotesLinkFor(docId) },
    { text: 'Open Award Hierarchy', href: openAwardHierarchyLinkFor(docId) }
];

const AwardMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getAwardLinks(props.documentNumber)} />
        <MedusaHeading text="Summary" />
        <MedusaRow>
            <MedusaEntry label="Award ID" value={props.awardNumber} striped />
            <MedusaEntry label="Award Type" value={props.awardType} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Sponsor Award ID" value={props.sponsorAwardNumber} striped />
            <MedusaEntry label="Activity Type" value={props.activityType} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Modification ID" value={props.sponsorAwardNumber} striped />
            <MedusaEntry label="Award Status" value={props.awardStatus} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Account ID" value={props.accountNumber} striped />
            <MedusaEntry label="Account Type" value={props.accountTypeDescription} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Title" value={props.title} striped />
        </MedusaRow>
        <MedusaHeading text="Dates & Amounts" />
        <MedusaRow>
            <MedusaEntry label="Sponsor" value={concat(props.sponsorCode, props.sponsorName, ' ')} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Project Dates" value={concat(props.awardEffectiveDate, props.awardAmountInfo.finalExpirationDate, ' - ')} />
            <MedusaEntry label="Obligation Dates" value={concat(props.awardAmountInfo.currentFundEffectiveDate, props.awardAmountInfo.obligationExpirationDate, ' - ')} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Anticipated Cumulative" value={formatUSD(props.awardAmountInfo.anticipatedTotalAmount)} />
            <MedusaEntry label="Obligated Cumulative" value={formatUSD(props.awardAmountInfo.amountObligatedToDate)} striped />
        </MedusaRow>
        <MedusaHeading text="Award Details Recorded" />
        <MedusaRow>
            <MedusaEntry label="Approved Subaward?" value={props.approvedSubaward} striped />
            <MedusaEntry label="Payment Schedule?" value={props.paymentSchedule ? 'Yes' : 'No'} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Approved Equipment?" value={props.approvedEquipment} striped />
            <MedusaEntry label="Sponsor Funding Transferred?" value={props.sponsorFundingTransferred} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Approved Foreign Travel?" value={props.approvedForeignTravel} striped />
            <MedusaEntry label="Cost Share?" value={props.costShare} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="F & A?" value={props.awardFandA} striped />
        </MedusaRow>
        <MedusaInvestigators investigators={props.investigators} />
    </div>
);

AwardMedusaInfo.propTypes = {
    documentNumber: PropTypes.string,
    awardNumber: PropTypes.string,
    awardType: PropTypes.string,
    sponsorAwardNumber: PropTypes.string,
    activityType: PropTypes.string,
    modificationNumber: PropTypes.string,
    awardStatus: PropTypes.string,
    accountNumber: PropTypes.string,
    accountTypeDescription: PropTypes.string,
    title: PropTypes.string,
    sponsorCode: PropTypes.string,
    sponsorName: PropTypes.string,
    awardEffectiveDate: PropTypes.string,
    approvedSubaward: PropTypes.bool,
    paymentSchedule: PropTypes.bool,
    approvedEquipment: PropTypes.bool,
    sponsorFundingTransferred: PropTypes.bool,
    approvedForeignTravel: PropTypes.bool,
    costShare: PropTypes.bool,
    awardFandA: PropTypes.bool,
    awardAmountInfo: PropTypes.shape({
        currentFundEffectiveDate: PropTypes.string,
        finalExpirationDate: PropTypes.string,
        obligationExpirationDate: PropTypes.string,
        anticipatedTotalAmount: PropTypes.number,
        amountObligatedToDate: PropTypes.number
    }),
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

export default AwardMedusaInfo;
