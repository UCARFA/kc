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
