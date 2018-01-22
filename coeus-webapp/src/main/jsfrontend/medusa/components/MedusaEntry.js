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
import { Col } from 'react-bootstrap';

import { convertToYesNo } from '../utils';

const MedusaEntry = ({ label, value, span = false, striped = false }) => {
    const labelBreakpoints = { md: 3, sm: 6, xs: 6 };
    const valueBreakpoints = span ? { md: 9, sm: 6, xs: 6 } : labelBreakpoints;
    const convertedValue = typeof(value) === 'boolean' ? convertToYesNo(value) : value;
    return [
        <Col className={`medusa-field medusa-label ${striped && 'medusa-striped'}`} {...labelBreakpoints}>
            {`${label}:`}
        </Col>,
        <Col className={`medusa-field ${striped && 'medusa-striped'}`} {...valueBreakpoints}>
            {convertedValue || '-'}
        </Col>
    ];
};

MedusaEntry.propTypes = {
    label: PropTypes.string.isRequired,
    value: PropTypes.any,
    span: PropTypes.bool,
    striped: PropTypes.bool
};

export default MedusaEntry;
