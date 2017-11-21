import PropTypes from 'prop-types';
import React from 'react';
import { Checkbox, Form, FormGroup, FormControl, Radio, Col, Row } from 'react-bootstrap';

const controlStyles = {
    marginRight: '20px'
};

const MedusaControls = ({ filterText, onFilter, isContextPreserved, setContextPreserved, preferredModule, setPreferredModule }) => (
    <Row className="medusa-controls">
        <Col md={12} sm={12} xs={12}>
            <Form inline>
                <FormControl style={controlStyles} bsSize="sm" type="text" value={filterText} placeholder="Filter..." onChange={onFilter} />
                <Checkbox readOnly style={controlStyles} value={isContextPreserved} onChange={setContextPreserved} >
                    Preserve Context
                </Checkbox>
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
    isContextPreserved: PropTypes.bool,
    setContextPreserved: PropTypes.func,
    preferredModule: PropTypes.string,
    setPreferredModule: PropTypes.func
};

export default MedusaControls;
