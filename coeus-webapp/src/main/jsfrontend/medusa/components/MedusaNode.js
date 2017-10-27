import PropTypes from 'prop-types';
import React, { Component } from 'react';
import { Col, Collapse, Row } from 'react-bootstrap';

import AwardMedusaInfo from './modules/AwardMedusaInfo';
import DevelopmentProposalMedusaInfo from './modules/DevelopmentProposalMedusaInfo';
import InstitutionalProposalMedusaInfo from './modules/InstitutionalProposalMedusaInfo';
import SubAwardMedusaInfo from './modules/SubAwardMedusaInfo';
import { authorizedFetch, LoadingStates } from '../utils';

const getComponentForModule = (module, props) => {
    if (module === 'DP') {
        return <DevelopmentProposalMedusaInfo {...props} />;
    } else if (module === 'award') {
        return <AwardMedusaInfo {...props} />
    } else if (module === 'IP') {
        return <InstitutionalProposalMedusaInfo {...props} />;
    } else if (module === 'subaward') {
        return <SubAwardMedusaInfo {...props} />;
    } else {
        return null;
    }
};

class MedusaNode extends Component {
    constructor(props) {
        super(props);
        this.state = {
            documentState: {},
            expanded: false,
            loadingState: LoadingStates.PRISTINE
        };

        this.collapse = this.collapse.bind(this);
        this.expand = this.expand.bind(this);
        this.toggle = this.toggle.bind(this);
    }

    collapse() {
        this.setState({ ...this.state, expanded: false });
    }

    expand() {
        if (this.state.loadingState !== LoadingStates.LOADED) {
            this.setState({
                ...this.state,
                documentState: {},
                loadingState: this.state.loadingState === LoadingStates.PRISTINE ? LoadingStates.LOADING : this.state.loadingState
            });
            authorizedFetch('node', { module: this.props.moduleCode, moduleId: this.props.moduleId }).then(response => {
                this.setState({
                    ...this.state,
                    documentState: response.data,
                    expanded: true,
                    loadingState: LoadingStates.LOADED
                });
            }).catch(response => {
                this.setState({
                    ...this.state,
                    documentState: {},
                    expanded: false,
                    loadingState: LoadingStates.ERRORED
                });
                console.error(response);
            });
        } else {
            this.setState({ ...this.state, expanded: true });
        }
    }

    toggle() {
        if (this.state.expanded) {
            this.collapse();
        } else {
            this.expand();
        }
    }

    render() {
        const expandedIconClass = this.state.expanded ? 'fa-caret-down' : 'fa-caret-right';
        let nodeComponents = [
            <Row key="1" className="medusa-node" onClick={this.toggle}>
                <Col md={12}>
                    <Row className="medusa-description-container">
                        <Col className="medusa-description" md={4} sm={5} xs={12}>
                            <span className="medusa-indent" style={{ width: this.props.depth * 20 }}/>
                            <i style={{ width: '0.6em' }} className={`fa fa-lg ${expandedIconClass}`}></i>
                            <span>{this.props.description}</span>
                            { this.state.loadingState === LoadingStates.LOADING && <i className={'fa fa-spinner fa-pulse'}></i> }
                        </Col>
                        <Col className="medusa-extended-description" md={8} sm={7} xs={12}>{this.props.detailedDescription}</Col>
                    </Row>
                </Col>
            </Row>,
            <Collapse key="2" in={this.state.expanded}>
                <Row>
                    <Col className="medusa-node-container" md={12}>
                        { this.state.expanded && getComponentForModule(this.props.moduleCode, { ...this.state.documentState }) }
                    </Col>
                </Row>
            </Collapse>
        ];
        if (this.props.renderChildren) {
            nodeComponents = nodeComponents.concat(this.props.children.map((node, i) =>
                <MedusaNode depth={this.props.depth + 1} key={`${node.description}-${i}`} {...node} >
                    {node.children}
                </MedusaNode>
            ));
        }
        return nodeComponents;
    }
}

MedusaNode.defaultProps = {
    renderChildren: true
};

MedusaNode.propTypes = {
    children: PropTypes.arrayOf(PropTypes.object),
    description: PropTypes.string.isRequired,
    depth: PropTypes.number.isRequired,
    moduleCode: PropTypes.string.isRequired,
    moduleId: PropTypes.number.isRequired,
    detailedDescription: PropTypes.string,
    renderChildren: PropTypes.bool
};

export default MedusaNode;
