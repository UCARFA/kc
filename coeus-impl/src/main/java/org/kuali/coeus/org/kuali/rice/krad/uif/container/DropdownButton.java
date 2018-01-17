/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.org.kuali.rice.krad.uif.container;

import java.util.ArrayList;
import java.util.List;

import org.kuali.rice.krad.uif.component.Component;
import org.kuali.rice.krad.uif.container.Group;
import org.kuali.rice.krad.uif.container.GroupBase;
import org.kuali.rice.krad.uif.element.Action;

public class DropdownButton extends GroupBase {

	private Action buttonPrototype;
	private Group listPrototype;
	
	@Override
    public void performInitialization(Object model) {
		List<Component> newItems = new ArrayList<Component>();
		newItems.add(buttonPrototype);
		newItems.add(listPrototype);
		setItems(newItems);
		super.performInitialization(model);
	}
	
	public Action getButtonPrototype() {
		return buttonPrototype;
	}
	public void setButtonPrototype(Action buttonPrototype) {
		this.buttonPrototype = buttonPrototype;
	}
	public Group getListPrototype() {
		return listPrototype;
	}
	public void setListPrototype(Group listPrototype) {
		this.listPrototype = listPrototype;
	}
	
}
