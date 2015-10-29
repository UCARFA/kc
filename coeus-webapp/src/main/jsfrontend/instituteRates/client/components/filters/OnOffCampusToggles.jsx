/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2015 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import React from 'react/addons';
import ReactRouter from 'react-router';
import RateActions from '../../stores/RateActions';

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
				<label style={styles.label}><input type="checkbox" id="onCampus" name="onCampus" checked={this.props.showOnCampus} onChange={this.toggleOnCampus}/>On Campus</label>
				<label style={styles.label}><input type="checkbox" id="offCampus" name="offCampus" checked={this.props.showOffCampus} onChange={this.toggleOffCampus}/>Off Campus</label>
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