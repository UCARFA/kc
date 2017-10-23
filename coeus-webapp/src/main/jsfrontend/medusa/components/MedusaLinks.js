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
