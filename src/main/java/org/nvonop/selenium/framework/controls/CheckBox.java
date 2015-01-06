/*
The MIT License (MIT)

Copyright (c) 2015 Nicholas Oppersdorff

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package org.nvonop.selenium.framework.controls;

import org.nvonop.selenium.framework.controls.interfaces.Clickable;
import org.nvonop.selenium.framework.controls.interfaces.Readable;
import org.nvonop.selenium.framework.controls.interfaces.Selectable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class comprises of functionality that would be used when interacting
 * with a typical checkbox control.
 * 
 * @author nvonop
 * 
 */
public class CheckBox extends BaseControl implements Clickable, Selectable,
		Readable {

	/**
	 * Constructor that takes a WebDriver object and By object. These are then
	 * set in the base class.
	 * 
	 * @param driver
	 * @param locator
	 */
	public CheckBox(WebDriver driver, By locator) {
		this.driver = driver;
		setLocator(locator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.controls.interfaces.Readable#read()
	 */
	@Override
	public Boolean read() {
		return new Boolean(getUnderlyingWebElement().isSelected());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.controls.interfaces.Clickable#click()
	 */
	@Override
	public void click() {
		getUnderlyingWebElement().click();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.controls.interfaces.Selectable#select()
	 */
	@Override
	public void select() {
		if (!getUnderlyingWebElement().isSelected()) {
			getUnderlyingWebElement().click();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.controls.interfaces.Selectable#deSelect()
	 */
	@Override
	public void deSelect() {
		if (getUnderlyingWebElement().isSelected()) {
			getUnderlyingWebElement().click();
		}
	}

}
