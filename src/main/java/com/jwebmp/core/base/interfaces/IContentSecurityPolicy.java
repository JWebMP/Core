package com.jwebmp.core.base.interfaces;

import java.util.Set;

public interface IContentSecurityPolicy<J extends IContentSecurityPolicy<J>> {

    J registerSelf();

    Set<String> getDefaultSrc();

    Set<String> getScriptSrc();

    Set<String> getStyleSrc();

    Set<String> getImgSrc();

    Set<String> getConnectSrc();

    Set<String> getFontSrc();

    Set<String> getObjectSrc();

    Set<String> getMediaSrc();

    Set<String> getFrameSrc();

    Set<String> getSandbox();

    Set<String> getReportUi();

    Set<String> getChildSrc();

    Set<String> getFormAction();

    Set<String> getFrameAncestors();
}
