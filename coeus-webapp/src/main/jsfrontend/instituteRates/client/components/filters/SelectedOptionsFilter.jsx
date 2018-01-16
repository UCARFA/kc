/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import React from 'react';
import {find} from 'lodash';
import RateActions from '../../stores/RateActions';
import { SelectedOption } from '../shared/SelectedOption';
import {StyledSelect} from '../shared/StyledSelect';
import SharedStyles from '../shared/Styles';

export class SelectedOptionsFilter extends React.Component {
	constructor(props) {
		super(props);
		this.onChange = this.onChange.bind(this);
		this.removeSelected = this.removeSelected.bind(this);
	}
	render() {
		let style = {
			select : {
				width: 300,
				display: 'block',
			}
		}
		let options = this.props.options.filter((option) => {
			return this.props.selectedOptionCodes.indexOf(option[this.props.optionCodeProp]) == -1;
		}).map((option) => {
			return (
				<option value={option[this.props.optionCodeProp]} key={option[this.props.optionCodeProp]}>{option[this.props.optionDescProp]}</option>
			);
		});
		options.splice(0, 0, (<option value='' key=''>select...</option>));
		let selectedOptions = this.props.selectedOptionCodes.map((optionId) => {
			let option = find(this.props.options, this.props.optionCodeProp, optionId);
			return (
				<SelectedOption id={option[this.props.optionCodeProp]} text={option[this.props.optionDescProp]} callback={this.removeSelected}/>
			);
		});

		return (
			<span style={this.props.style}>
				<label style={SharedStyles.filterLabels} htmlFor="rateClass">{this.props.label}</label>
				<StyledSelect style={style.select} id="rateClass" name="rateClass" onChange={this.onChange}>{options}</StyledSelect>
				{selectedOptions}
			</span>
		);
	}
	onChange(event) {
    if (event.target.value) {
		  this.props.onSelect(event.target.value);
    }
	}
	removeSelected(id) {
		this.props.onRemove(id);
	}
};
SelectedOptionsFilter.defaultProps = { optionCodeProp : 'code', optionDescProp : 'description' };
