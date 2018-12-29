package com.jwebmp.core.databind;

import com.jwebmp.core.base.ComponentDataBindingBase;

import javax.validation.constraints.NotNull;

/**
 * SPI to do something when on bind is called
 */
public interface IOnDataBind
{
	/**
	 * SPI to do something when on bind is called
	 *
	 * @param component
	 * 		The component to bind
	 * @param bindingValue
	 * 		The binding value to adhere to
	 */
	void onBind(@NotNull ComponentDataBindingBase component, String bindingValue);
}
