/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

import PropTypes from 'prop-types';
import React, { Children, cloneElement } from 'react';
import { Row } from 'react-bootstrap';

const MedusaRow = ({ children }) => {
    const span = Children.count(children) === 1;
    return (
        <Row className="medusa-row">
            { Children.map(children, child => cloneElement(child, { span }, child.children)) }
        </Row>
    );
};

MedusaRow.propTypes = {
    children: PropTypes.node.isRequired
};

export default MedusaRow;
