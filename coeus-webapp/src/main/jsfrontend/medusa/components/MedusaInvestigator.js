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
import { Row, Col } from 'react-bootstrap';

const MedusaInvestigator = ({ fullName, pi, units }) => (
    <Row className="medusa-row">
        <Col style={{ textAlign: 'center' }} className="medusa-field" md={6} sm={6} xs={6}>
            {fullName} {pi && '(Principal Investigator)'}
        </Col>
        <Col style={{ textAlign: 'center' }} className="medusa-field" md={6} sm={6} xs={6}>
            {
                units.map(({unitNumber, unitName, leadUnit}, i) => <div key={`${fullName}-${unitNumber}-${i}`}>{`${unitNumber} : ${unitName}${leadUnit ? ' (Lead Unit)' : ''}`}</div>)
            }
        </Col>
    </Row>
);

MedusaInvestigator.propTypes = {
    fullName: PropTypes.string,
    pi: PropTypes.bool,
    units: PropTypes.arrayOf(PropTypes.shape({
        unitNumber: PropTypes.string,
        unitName: PropTypes.string,
        leadUnit: PropTypes.bool
    }))
};

export default MedusaInvestigator;
