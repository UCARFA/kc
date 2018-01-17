/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

module.exports = env => ({
	devtool : 'eval',
	entry: {
		instituteRatesClient: './instituteRates/client/index.jsx',
		medusaClient: './medusa/index.js'
	},
	output: {
		path: __dirname + '../../../target/generated-web-sources/jsfrontend-web-sources/client/assets/',
		publicPath: '/client/assets/',
		filename: `[name]-${env.BUILD_TIMESTAMP}.js`,
		sourceMapFilename: '[file].map'
	},
	resolve: {
		extensions: ['', '.jsx', '.css', '.js']
	},
	module: {
		loaders: [
			{test: /\.js/, loader: 'babel-loader', 'exclude': /node_modules/},
			{test: /\.jsx/, loader: 'babel-loader', 'exclude': /node_modules/}
		]
	}
});
