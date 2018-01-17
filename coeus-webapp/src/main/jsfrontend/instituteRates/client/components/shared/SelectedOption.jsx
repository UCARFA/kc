/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import React from 'react';

export class SelectedOption extends React.Component {
	constructor(props) {
		super(props);
		this.onClick = this.onClick.bind(this);
	}
	render() {
		let style = {
			button : {
				background : 'rgb(66,117, 136)',
				borderRadius: 6,
				padding: '5px 15px',
				color: 'white',
			},
			icon : {
				paddingLeft: 10,
			}
		}
		return (
			<button style={style.button} onClick={this.onClick}>{this.props.text}<span style={style.icon} className="fa fa-times"/></button>
		);
	}
	onClick(event) {
		this.props.callback(this.props.id);
	}
};
