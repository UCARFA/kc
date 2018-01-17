/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
// This function is called when a traveler is picked from the look-up, but then
// the user makes a traveler selection from the known travelers drop-down list.
// This will help reduce confusion from the look-up traveler name being shown at
// the same time a different name is shown selected from the list  

function clearApprovedForeignTravelerTravelerName() {
    document.getElementById('ApprovedForeignTravel_TravelerName').innerHTML='';
}
