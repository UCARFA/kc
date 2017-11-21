import axios from 'axios';
import cookies from 'cookies-js';
import formatCurrency from 'format-currency';

export const MEDUSA_API_ROOT = '../research-common/api/v1/medusa';

export const authorizedFetch = (endpoint, params) =>
    axios.get(`${MEDUSA_API_ROOT}/${endpoint}`, {
        params,
        headers: { 'Authorization': `Bearer ${cookies.get('authToken')}` }
    });

export const LoadingStates = {
    PRISTINE: 0,
    LOADING: 1,
    LOADED: 2,
    ERRORED: 3
};

export const concat = (arg1, arg2, separator) => {
    if (arg1 && arg2) {
        return `${arg1}${separator}${arg2}`;
    }
    return '';
};

export const convertToYesNo = booleanValue => booleanValue ? 'Yes' : 'No';

export const createNodeKey = (moduleCode, moduleId) => `${moduleCode}-${moduleId}`;

export const formatUSD = currencyValue => formatCurrency(currencyValue, { format: '%s%v', symbol: '$' });
