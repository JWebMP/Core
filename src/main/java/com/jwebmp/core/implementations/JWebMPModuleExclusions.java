package com.jwebmp.core.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JWebMPModuleExclusions
		implements IGuiceScanModuleExclusions<JWebMPModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.core");

		strings.add("uadetector.core");
		strings.add("uadetector.resources");
		strings.add("uadetector.json");

		strings.add("org.apache.commons.io");
		strings.add("org.apache.commons.lang3");
		strings.add("org.apache.commons.text");
		return strings;
	}
}
