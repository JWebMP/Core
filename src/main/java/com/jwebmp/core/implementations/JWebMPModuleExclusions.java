package com.jwebmp.core.implementations;

import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JWebMPModuleExclusions
		implements IGuiceScanModuleExclusions<JWebMPModuleExclusions>,
				           IGuiceScanJarExclusions<JWebMPModuleExclusions>
{
	@Override
	public @NotNull Set<String> excludeJars()
	{
		Set<String> strings = new HashSet<>();
		strings.add("jwebmp-core-*");
		strings.add("commons-io-*");
		strings.add("commons-lang3-*");
		strings.add("commons-text-*");


		strings.add("quality-check-*");
		strings.add("uadetector-core-*");
		strings.add("uadetector-json-*");
		strings.add("uadetector-resources-*");
		return strings;
	}

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
