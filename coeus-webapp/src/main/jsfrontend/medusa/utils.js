/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

import axios from 'axios';
import cookies from 'cookies-js';
import formatCurrency from 'format-currency';

export const MEDUSA_API_ROOT = '/research-common/api/v1/medusa';

export const authorizedFetch = (endpoint, params) => {
    const medusaApiUri = reactContext.appContext ? `/${reactContext.appContext}${MEDUSA_API_ROOT}` : MEDUSA_API_ROOT;
    return axios.get(`${medusaApiUri}/${endpoint}`, {
        params,
        headers: { 'Authorization': `Bearer ${cookies.get('authToken')}` }
    });
};

export const linkTo = link => reactContext.appContext ? `/${reactContext.appContext}/${link}` : link;

export const LoadingStates = {
    PRISTINE: 0,
    LOADING: 1,
    LOADED: 2,
    ERRORED: 3
};

export const concat = (arg1, arg2, separator) => {
    if (arg1 && arg2) {
        return `${arg1}${separator}${arg2}`;
    } else if (arg1) {
        return arg1;
    }
    return '';
};

export const convertToYesNo = booleanValue => booleanValue ? 'Yes' : 'No';

export const createNodeKey = (moduleCode, moduleId) => `${moduleCode}-${moduleId}`;

export const formatUSD = currencyValue => formatCurrency(currencyValue, { format: '%s%v', symbol: '$' });
