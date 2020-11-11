package com.jwebmp.core.databind;

import com.jwebmp.core.base.ComponentDataBindingBase;
import com.guicedee.guicedinjection.interfaces.IDefaultService;

import jakarta.validation.constraints.NotNull;

/**
 * SPI to do something when on bind is called
 */
public interface IOnDataBind<J extends IOnDataBind<J>>
		extends IDefaultService<J>
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
