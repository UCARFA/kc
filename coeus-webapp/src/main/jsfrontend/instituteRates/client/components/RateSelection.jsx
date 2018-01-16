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

import {FiscalYearFilter} from './filters/FiscalYearFilter';
import {OnOffCampusToggles} from './filters/OnOffCampusToggles';
import {SelectedOptionsFilter} from './filters/SelectedOptionsFilter';
import {RateListing} from './RateListing';
import {StyledSelect} from './shared/StyledSelect';
import {assign} from 'lodash';
import SharedStyles from './shared/Styles';

export class RateSelection extends React.Component {
	constructor(props) {
		super(props);
		this.rateStore = RateStore;
		this.state = this.rateStore.getState();
		this.onChange = this.onChange.bind(this);
	}

	componentDidMount() { 
		this.rateStore.listen(this.onChange); 
	}
	componentWillUnmount() { this.rateStore.unlisten(this.onChange); }
	
	render() {
		let styles = {
			container : {
				height: '100%',
				width: '100%',
			},
			filterContainer : {
				display: 'flex',
				flexFlow: 'row wrap',
			},
			filterItem : {
				flexGrow : 1,
				width: '25em',
				textAlign: 'left',
			},

		};

		let rateClassTypes = this.state.rateClassTypes.map((rateClass) => {
			return (
				<option value={rateClass.code} key={rateClass.code}>{rateClass.description}</option>
			);	
		});
		rateClassTypes.splice(0, 0, <option value="" key="">Select one...</option>);

		let filters = [];
		if (this.state.selectedRateClassType) {
			filters.push((<FiscalYearFilter style={styles.filterItem} startYear={this.state.startYear} endYear={this.state.endYear}
				validStartYear={this.state.validStartYear} validEndYear={this.state.validEndYear}/>));
			filters.push((<OnOffCampusToggles style={styles.filterItem} showOnCampus={this.state.showOnCampus} showOffCampus={this.state.showOffCampus}/>));
			filters.push(<SelectedOptionsFilter style={styles.filterItem} label="Rate Class:" 
				options={this.state.applicableRateClasses} selectedOptionCodes={this.state.selectedRateClasses} 
				onSelect={RateActions.selectRateClass} onRemove={RateActions.removeSelectedRateClass}/>);
			filters.push((<SelectedOptionsFilter style={styles.filterItem} label="Rate Type:" optionCodeProp="rateTypeCode"
				options={this.state.applicableRateTypes} selectedOptionCodes={this.state.selectedRateTypes}
				onSelect={RateActions.selectRateType} onRemove={RateActions.removeSelectedRateType}/>));
			filters.push((<SelectedOptionsFilter style={styles.filterItem} label="Activity Type:"
				options={this.state.activityTypes} selectedOptionCodes={this.state.selectedActivityTypes}
				onSelect={RateActions.selectActivityType} onRemove={RateActions.removeSelectedActivityType}/>));

		}

		return (
			<span><div style={assign({}, styles.container, this.props.style)}>
				<div style={styles.filterContainer}>
					<span style={styles.filterItem}>
						<label style={SharedStyles.filterLabels}>Rate Class Type:</label>
						<StyledSelect style={{width: 300}} id="rateClassType" name="rateClassType" value={this.state.selectedRateClassType} onChange={this.selectRateClassType}>
							{rateClassTypes}
						</StyledSelect>
					</span>
					{filters}
				</div>
			</div>				
			<hr/></span>
		);
	}
	onChange() {
		this.setState(RateStore.getState());
	}
	selectRateClassType(event) {
		RateActions.selectRateClassType(event.target.value);
	}
}
