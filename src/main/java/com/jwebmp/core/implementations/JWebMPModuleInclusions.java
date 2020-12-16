package com.jwebmp.core.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class JWebMPModuleInclusions implements IGuiceScanModuleInclusions<JWebMPModuleInclusions>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.core");
		return strings;
	}
}
