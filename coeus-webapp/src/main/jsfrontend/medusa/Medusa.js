import React, { Component } from 'react';

import MedusaControls from './components/MedusaControls';
import MedusaNode from './components/MedusaNode';
import { authorizedFetch, createNodeKey, LoadingStates } from './utils';

const DOCUMENT_PARAMS = { 'module': reactContext.module, 'moduleId': reactContext.moduleId };

class Medusa extends Component {
    constructor(props) {
        super(props);
        this.state = {
            childNodes: [],
            filterText: '',
            filteredNodes: [],
            loadedNodes: {},
            loadingState: LoadingStates.PRISTINE,
            preferredModule: 'DP',
            isContextPreserved: false
        };

        this.loadMedusaNode = this.loadMedusaNode.bind(this);
        this.loadMedusaTree = this.loadMedusaTree.bind(this);
        this.filter = this.filter.bind(this);
        this.preferModule = this.preferModule.bind(this);
        this.preserveContext = this.preserveContext.bind(this);
    }

    componentDidMount() {
        this.loadMedusaTree(this.state.preferredModule);
    }

    filter(e) {
        const filterText = e.target.value;
        let filteredNodes = [];
        let nodesToCheck = [].concat(this.state.childNodes);
        while (nodesToCheck.length > 0) {
            const node = nodesToCheck.pop();
            if (filterText.length === 0 || node.description.toLowerCase().includes(filterText.toLowerCase())
                    || (node.detailedDescription && node.detailedDescription.toLowerCase().includes(filterText.toLowerCase()))) {
                filteredNodes.push(node);
            }
            nodesToCheck = nodesToCheck.concat(node.children);
        }
        this.setState({ ...this.state, filteredNodes, filterText });
    }

    loadMedusaTree(preferredModule) {
        this.setState({ ...this.state, loadingState: LoadingStates.LOADING, preferredModule });
        authorizedFetch('tree', { ...DOCUMENT_PARAMS, preferredModule }).then(response => {
            this.setState({
                ...this.state,
                childNodes: response.data,
                loadingState: LoadingStates.LOADED
             });
        }).catch(response => {
            this.setState({
                ...this.state,
                childNodes: [],
                loadingState: LoadingStates.ERRORED
            });
            console.error(response);
        });
    }

    loadMedusaNode(moduleCode, moduleId) {
        return authorizedFetch('node', { module: moduleCode, moduleId }).then(response => {
            this.setState({
                ...this.state,
                loadedNodes: { ...this.state.loadedNodes, [createNodeKey(moduleCode, moduleId)]: response.data }
            });
            return response.data;
        }).catch(response => {
            console.error(response);
            throw response;
        });
    }

    preferModule(e) {
        this.loadMedusaTree(e.target.value);
    }

    preserveContext(e) {
        this.setState({ ...this.state, isContextPreserved: !this.state.isContextPreserved });
    }

    render() {
        const filteredElements = this.state.filterText.length === 0 ?
            this.state.childNodes.map((node, i) => <MedusaNode depth={0} key={`${node.description}-${i}`} loadedNodes={this.state.loadedNodes} load={this.loadMedusaNode} {...node} />) :
            this.state.filteredNodes.map((node, i) => <MedusaNode depth={0} key={`${node.description}-${i}`} renderChildren={this.state.isContextPreserved} loadedNodes={this.state.loadedNodes} load={this.loadMedusaNode} {...node} />);
        const loadingIndicator = <h4><i className={'fa fa-spinner fa-pulse'}></i> Loading...</h4>;
        return (
            <div className="container-fluid medusa">
                <h2>Medusa</h2>
                <MedusaControls filterText={this.state.filterText} onFilter={this.filter} isContextPreserved={this.state.isContextPreserved} setContextPreserved={this.preserveContext} preferredModule={this.state.preferredModule} setPreferredModule={this.preferModule} />
                { this.state.loadingState === LoadingStates.LOADING ? loadingIndicator : filteredElements }
            </div>
        );
    }
}

export default Medusa;
