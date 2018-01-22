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
import { Form, FormGroup, FormControl, Radio, Col, Row } from 'react-bootstrap';

const controlStyles = {
    marginRight: '20px'
};

const MedusaControls = ({ filterText, onFilter, preferredModule, setPreferredModule }) => (
    <Row className="medusa-controls">
        <Col md={12} sm={12} xs={12}>
            <Form inline>
                <FormControl style={controlStyles} bsSize="sm" type="text" value={filterText} placeholder="Filter..." onChange={onFilter} />
                <FormGroup style={{...controlStyles, paddingBottom: '3px'}} className="">
                    <Radio name="preferredModule" checked={preferredModule !== 'award'} value="DP" onChange={setPreferredModule} inline>
                        Proposal > Award
                    </Radio>
                    <Radio name="preferredModule" checked={preferredModule === 'award'} value="award" onChange={setPreferredModule} inline>
                        Award > Proposal
                    </Radio>
                </FormGroup>
            </Form>
        </Col>
    </Row>
);

MedusaControls.propTypes = {
    filterText: PropTypes.string,
    onFilter: PropTypes.func,
    preferredModule: PropTypes.string,
    setPreferredModule: PropTypes.func
};

export default MedusaControls;
