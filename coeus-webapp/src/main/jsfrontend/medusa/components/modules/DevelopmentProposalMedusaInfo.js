import PropTypes from 'prop-types';
import React from 'react';

import MedusaEntry from '../MedusaEntry';
import MedusaHeading from '../MedusaHeading';
import MedusaInvestigators from '../MedusaInvestigators';
import MedusaLinks from '../MedusaLinks';
import MedusaRow from '../MedusaRow';
import { concat } from '../../utils';

const openPropDevLinkFor = docId =>  `../kc-pd-krad/proposalDevelopment?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}`;
const openNotesLinkFor = docId => `../kc-pd-krad/proposalDevelopment?methodToCall=docHandler&command=displayDocSearchView&docId=${docId}&navigateToPageId=PropDev-AttachmentsPage&defaultOpenTab=PropDev-AttachmentsPage-NotesSection`;

const getPropDevLinks = docId => [
  { text: 'Open Proposal', href: openPropDevLinkFor(docId) },
  { text: 'Open Proposal Notes', href: openNotesLinkFor(docId) }
];

const DevelopmentProposalMedusaInfo = (props) => (
    <div>
        <MedusaLinks links={getPropDevLinks(props.documentNumber)} />
        <MedusaHeading text="Summary" />
        <MedusaRow>
            <MedusaEntry label="Proposal Number" value={props.proposalNumber} />
            <MedusaEntry label="Proposal State" value={props.proposalState} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Lead Unit" value={concat(props.leadUnitNumber, props.leadUnitName, ' : ')} />
            <MedusaEntry label="Research Dates" value={concat(props.requestedStartDateInitial, props.requestedEndDateInitial, ' - ')} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Title" value={props.title} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Proposal Type" value={props.proposalType} striped />
            <MedusaEntry label="NSF Code" value={props.nsfCode} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Sponsor" value={concat(props.sponsorCode, props.sponsorName, ' ')} striped />
            <MedusaEntry label="Prime Sponsor" value={concat(props.primeSponsorCode, props.primeSponsorName, ' ')} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Sponsor Proposal Number" value={props.sponsorProposalNumber} striped />
            <MedusaEntry label="Activity Type" value={props.activityType} />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Program Title" value={props.programTitle} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Notice of Opportunity" value={props.noticeOfOpportunity} />
            <MedusaEntry label="Program Number" value={props.programNumber} striped />
        </MedusaRow>
        <MedusaRow>
            <MedusaEntry label="Attachments" value={props.attachmentsStatus} />
            <MedusaEntry label="Budget" value={-props.budgetStatus} striped />
        </MedusaRow>
        <MedusaInvestigators investigators={props.investigators} />
    </div>
);

DevelopmentProposalMedusaInfo.propTypes = {
    documentNumber: PropTypes.string,
    proposalNumber: PropTypes.string,
    proposalState: PropTypes.string,
    leadUnitNumber: PropTypes.string,
    leadUnitName: PropTypes.string,
    requestedStartDateInitial: PropTypes.string,
    requestedEndDateInitial: PropTypes.string,
    title: PropTypes.string,
    proposalType: PropTypes.string,
    nsfCode: PropTypes.string,
    sponsorCode: PropTypes.string,
    sponsorName: PropTypes.string,
    primeSponsorCode: PropTypes.string,
    primeSponsorName: PropTypes.string,
    sponsorProposalNumber: PropTypes.string,
    activityType: PropTypes.string,
    programTitle: PropTypes.string,
    programNumber: PropTypes.string,
    noticeOfOpportunity: PropTypes.string,
    attachmentsStatus: PropTypes.string,
    budgetStatus: PropTypes.string,
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

export default DevelopmentProposalMedusaInfo;
