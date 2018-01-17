/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
import {assign} from 'lodash';

const colors = {
	secondaryColor: 'rgb(66, 117, 136)',
};
const styles = {
	filterLabels : {
		display: 'block',
		color: colors.secondaryColor,
		textTransform: 'uppercase',
	}
};

export default assign({}, styles, colors);