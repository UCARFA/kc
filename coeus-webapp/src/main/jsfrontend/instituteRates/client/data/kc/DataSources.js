/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import axios from 'axios';
import cookies from 'cookies-js';
import {assign} from 'lodash';

class RestFetcher {
	constructor(endpoint) {
		this.endpoint = endpoint;
	}
	fetch(query) {
		return axios.get(this.endpoint, {
			params: assign({}, this.sharedQuery),
			headers: this.getAuthHeader(),
		}).catch((response) => {
			console.log(this.endpoint);
			console.log(response);
			throw response;
		}).then((response) => { return response.data; });
	}
	put(data) {
		console.log(data);
		return axios.put(this.endpoint, data, {
			headers: this.getAuthHeader(),
		}).catch(function(response) {
			console.log(response);
			throw response;
		}).then(function(response) { return response.data });
	}
	getAuthHeader() {
		return {'Authorization' : 'Bearer ' + cookies.get('authToken')};
	}
}

const apiRoot = '../research-common/api/v1/';

module.exports = {
	rateClassType : new RestFetcher(apiRoot + 'rate-class-types/'), 
	rateClass : new RestFetcher(apiRoot + 'rate-classes/'),
	rateType : new RestFetcher(apiRoot + 'rate-types/'),
	activityType : new RestFetcher(apiRoot + 'activity-types/'),
	unit : new RestFetcher(apiRoot + 'units/'),
	topUnit : new RestFetcher(apiRoot + 'units/top-unit'),
	rate : new RestFetcher(apiRoot + 'institute-rates/'),
};