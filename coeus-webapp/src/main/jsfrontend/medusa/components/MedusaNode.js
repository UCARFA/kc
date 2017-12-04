import PropTypes from 'prop-types';
import React, { Component } from 'react';
import { Col, Collapse, Row } from 'react-bootstrap';

import AwardMedusaInfo from './modules/AwardMedusaInfo';
import DevelopmentProposalMedusaInfo from './modules/DevelopmentProposalMedusaInfo';
import InstitutionalProposalMedusaInfo from './modules/InstitutionalProposalMedusaInfo';
import NegotiationMedusaInfo from './modules/NegotiationMedusaInfo';
import ProtocolMedusaInfo from './modules/ProtocolMedusaInfo';
import SubAwardMedusaInfo from './modules/SubAwardMedusaInfo';
import { createNodeKey, LoadingStates } from '../utils';

const getComponentForModule = (module, props) => {
    if (module === 'DP') {
        return <DevelopmentProposalMedusaInfo {...props} />;
    } else if (module === 'award') {
        return <AwardMedusaInfo {...props} />
    } else if (module === 'IP') {
        return <InstitutionalProposalMedusaInfo {...props} />;
    } else if (module === 'subaward') {
        return <SubAwardMedusaInfo {...props} />;
    } else if (module === 'neg') {
        return <NegotiationMedusaInfo {...props} />;
    } else if (module === 'irb') {
        return <ProtocolMedusaInfo moduleName="IRB" {...props} />
    } else if (module === 'iacuc') {
        return <ProtocolMedusaInfo moduleName="IACUC" {...props} />
    }
};

class MedusaNode extends Component {
    constructor(props) {
        super(props);
        this.state = {
            expanded: false,
            loadingState: props.loadedNodes[createNodeKey(props.moduleCode, props.moduleId)] ? LoadingStates.LOADED : LoadingStates.PRISTINE
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
                loadingState: this.state.loadingState === LoadingStates.PRISTINE ? LoadingStates.LOADING : this.state.loadingState
            });
            this.props.load(this.props.moduleCode, this.props.moduleId).then(data => {
                this.setState({ ...this.state, expanded: true, loadingState: LoadingStates.LOADED });
            }).catch(error => {
                this.setState({ ...this.state, expanded: false, loadingState: LoadingStates.ERRORED });
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
                        { this.state.expanded && getComponentForModule(this.props.moduleCode, this.props.loadedNodes[createNodeKey(this.props.moduleCode, this.props.moduleId)]) }
                    </Col>
                </Row>
            </Collapse>
        ];
        if (this.props.renderChildren) {
            nodeComponents = nodeComponents.concat(this.props.children.map((node, i) =>
                <MedusaNode depth={this.props.depth + 1} key={`${node.description}-${i}`} loadedNodes={this.props.loadedNodes} load={this.props.load} {...node} >
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
