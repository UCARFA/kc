/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import React from 'react';
import RateActions from '../../stores/RateActions';
import SharedStyles from '../shared/Styles';
import {assign} from 'lodash';

export class OnOffCampusToggles extends React.Component {
	constructor(props) {
		super(props);
	}
	render() {
		let styles = {
			label : {
				display: 'block',
				margin : '10px 0 10px 0',
			}
		}
		return (
			<div style={this.props.style}>
				<label style={assign({}, styles.label, SharedStyles.filterLabels)}><input type="checkbox" id="onCampus" name="onCampus" checked={this.props.showOnCampus} onChange={this.toggleOnCampus}/>On Campus</label>
				<label style={assign({}, styles.label, SharedStyles.filterLabels)}><input type="checkbox" id="offCampus" name="offCampus" checked={this.props.showOffCampus} onChange={this.toggleOffCampus}/>Off Campus</label>
			</div>
		)
	}
	toggleOnCampus(event) {
		RateActions.toggleOnCampusFlag();
	}
	toggleOffCampus(event) {
		RateActions.toggleOffCampusFlag();
	}
};	
