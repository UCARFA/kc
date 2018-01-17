/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
const React = require ('react');
const ReactDOM = require('react-dom');
const {Rates} = require('./components/Rates');

class App extends React.Component {
	render() {
		let styles = {
			container : {
				fontSize: '1.1em',
				margin:0,
				padding:0,
			}
		};

		return (
			<div style={styles.container}>
				<Rates/>
			</div>
		);
	}
}

ReactDOM.render(<App/>, document.body);
