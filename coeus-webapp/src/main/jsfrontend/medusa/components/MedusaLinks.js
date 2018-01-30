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
import { Button, ButtonToolbar, Col, Row } from 'react-bootstrap';

const MedusaLinks = ({ links }) => (
    <Row className="medusa-links">
        <Col md={12}>
            <ButtonToolbar>
                { links.map(link => <Button key={link.href} bsSize="xs" href={link.href} target="_blank">{link.text}</Button>) }
            </ButtonToolbar>
        </Col>
    </Row>
);

MedusaLinks.propTypes = {
    links: PropTypes.arrayOf(PropTypes.shape({
        text: PropTypes.string,
        href: PropTypes.string
    }))
};

export default MedusaLinks;
