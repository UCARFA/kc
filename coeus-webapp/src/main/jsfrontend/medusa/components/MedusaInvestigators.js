import PropTypes from 'prop-types';
import React from 'react';
import { Row, Col } from 'react-bootstrap';

import MedusaInvestigator from './MedusaInvestigator';

const MedusaInvestigators = ({ investigators }) => (
    [
        <Row className="medusa-row">
            <Col className="investigator-label" md={6} sm={6} xs={6}>
                Investigators
            </Col>
            <Col className="investigator-label" md={6} sm={6} xs={6}>
                Units
            </Col>
        </Row>
    ].concat(investigators.map((investigator, i) => <MedusaInvestigator className="medusa-row" {...investigator} />))
);

MedusaInvestigators.propTypes = {
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

export default MedusaInvestigators;
