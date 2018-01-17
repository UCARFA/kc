/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import React from 'react';
import {assign} from 'lodash';
import RateActions from '../../stores/RateActions';
import {StyledSelect} from '../shared/StyledSelect';
import SharedStyles from '../shared/Styles';

export class FiscalYearFilter extends React.Component {
	constructor(props) {
		super(props);
	}
	render() {
		let styles = {
			fieldSet : {
				border: 0,
				padding: 0,
				margin: 0,
				textAlign: 'left',
			},
			label : {
				textTransform: 'uppercase',
			},
		}
		let yearOptions = [];
		for ( let i = this.props.validStartYear; i <= this.props.validEndYear; i++) {
			yearOptions.push(<option value={i} key={i}>{i}</option>);
		}
		return (
			<fieldset style={assign({}, styles.fieldSet, this.props.style)}>
				<legend style={SharedStyles.filterLabels}>Fiscal Year Span:</legend>
				<label htmlFor="startYear" style={{display: "none"}}>Start Year</label>
				<StyledSelect id="startYear" name="startYear" value={this.props.startYear} onChange={this.onChangeStart}>{yearOptions}</StyledSelect>
				<span style={{margin : 5}}>TO</span>
				<label htmlFor="endYear" style={{display: "none"}}>End Year</label>
				<StyledSelect id="endYear" name="endYear" value={this.props.endYear} onChange={this.onChangeEnd}>{yearOptions}</StyledSelect>
			</fieldset>
		);
	}
	onChangeStart(event) {
		RateActions.selectStartYear(event.target.value);
	}
	onChangeEnd(event) {
		RateActions.selectEndYear(event.target.value);
	}
};	
