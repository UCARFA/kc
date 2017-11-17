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
