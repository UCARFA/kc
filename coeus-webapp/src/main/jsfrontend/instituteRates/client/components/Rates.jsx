/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import React from 'react';
import RateStore from '../stores/RateStore';
import RateActions from '../stores/RateActions';
import {RateSelection} from './RateSelection';
import {RateListing} from './RateListing';

export class Rates extends React.Component {
	constructor(props) {
		super(props);
		this.rateStore = RateStore;
		this.state = this.rateStore.getState();
		this.onChange = this.onChange.bind(this);
	}

	componentDidMount() { 
		this.rateStore.listen(this.onChange); 
		RateActions.fetchSupportData();
	}
	componentWillUnmount() { this.rateStore.unlisten(this.onChange); }
	
	render() {
		return (
			<div>
				<h1 style={{padding:'0 30px 0 30px'}}>INSTITUTE RATES for {this.state.selectedUnit.unitName}</h1>
				<hr/>
				{!this.state.editMode && <RateSelection style={{padding:'0 30px 0 30px'}}/>}
				<RateListing style={{padding:'0 30px 0 30px'}}/>
			</div>
		);
	}
	onChange() {
		this.setState(RateStore.getState());
	}
	selectRateClassType(event) {
		RateActions.selectRateClassType(event.target.value);
	}
}
