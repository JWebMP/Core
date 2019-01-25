package com.jwebmp.core.databind;

import com.jwebmp.core.base.ComponentDataBindingBase;

import javax.validation.constraints.NotNull;

/**
 * SPI to do something when on bind is called
 */
@FunctionalInterface
public interface IOnDataBindCloak
{
	/**
	 * SPI to do something when on bind is called
	 *
	 * @param component
	 * 		The component to bind
	 */
	void onCloak(@NotNull ComponentDataBindingBase component);
}
