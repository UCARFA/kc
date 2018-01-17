import PropTypes from 'prop-types';
import React from 'react';
import { Col, Row } from 'react-bootstrap';

const MedusaHeading = ({ text }) => (
    <Row className="medusa-heading">
        <Col md={12} sm={12} xs={12}>
            <span>{text}</span>
        </Col>
    </Row>
);

MedusaHeading.propTypes = {
    text: PropTypes.string.isRequired
};

export default MedusaHeading;
