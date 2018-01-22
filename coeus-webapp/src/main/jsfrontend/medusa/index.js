/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

import React from 'react';
import ReactDOM from 'react-dom';
import Medusa from './Medusa';

document.addEventListener("DOMContentLoaded", event => {
  ReactDOM.render(<Medusa />, document.getElementById('medusaRoot'));
});
