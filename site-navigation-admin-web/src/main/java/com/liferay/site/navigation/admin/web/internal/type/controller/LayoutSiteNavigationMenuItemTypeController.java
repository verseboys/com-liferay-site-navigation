/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.site.navigation.admin.web.internal.type.controller;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.site.navigation.constants.SiteNavigationMenuItemTypeControllerConstants;
import com.liferay.site.navigation.model.SiteNavigationMenuItem;
import com.liferay.site.navigation.type.controller.SiteNavigationMenuItemTypeController;
import com.liferay.site.navigation.type.controller.impl.BaseSiteNavigationMenuItemTypeControllerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {"site.navigation.menu.item.type=" + SiteNavigationMenuItemTypeControllerConstants.LAYOUT},
	service = SiteNavigationMenuItemTypeController.class
)
public class LayoutSiteNavigationMenuItemTypeController
	extends BaseSiteNavigationMenuItemTypeControllerImpl {

	@Override
	public JSONObject getEditContext(
			HttpServletRequest request, HttpServletResponse response,
			SiteNavigationMenuItem siteNavigationMenuItem)
		throws Exception {

		return null;
	}

	@Override
	public String getIcon() {
		return "page";
	}

	@Override
	public String getType() {
		return "layout";
	}

	@Override
	public JSONObject getViewContext(
			HttpServletRequest request, HttpServletResponse response,
			SiteNavigationMenuItem siteNavigationMenuItem)
		throws Exception {

		return null;
	}

}