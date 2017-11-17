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

package com.liferay.site.navigation.admin.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.navigation.admin.web.internal.constants.SiteNavigationAdminPortletKeys;
import com.liferay.site.navigation.exception.InvalidSiteNavigationMenuItemOrderException;
import com.liferay.site.navigation.service.SiteNavigationMenuItemService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SiteNavigationAdminPortletKeys.SITE_NAVIGATION_ADMIN,
		"mvc.command.name=/navigation_menu/edit_site_navigation_menu_item_parent"
	},
	service = MVCActionCommand.class
)
public class EditSiteNavigationMenuItemParentMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long siteNavigationMenuItemId = ParamUtil.getLong(
			actionRequest, "siteNavigationMenuItemId");

		long parentSiteNavigationMenuItemId = ParamUtil.getLong(
			actionRequest, "parentSiteNavigationMenuItemId");

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		hideDefaultSuccessMessage(actionRequest);

		redirect = _http.setParameter(
			redirect,
			actionResponse.getNamespace() + "selectedSiteNavigationMenuItemId",
			siteNavigationMenuItemId);

		actionRequest.setAttribute(WebKeys.REDIRECT, redirect);

		try {
			_siteNavigationMenuItemService.updateSiteNavigationMenuItem(
				siteNavigationMenuItemId, parentSiteNavigationMenuItemId,
				serviceContext);
		}
		catch (InvalidSiteNavigationMenuItemOrderException isnmioe) {
			SessionErrors.add(actionRequest, isnmioe.getClass());

			sendRedirect(actionRequest, actionResponse);
		}
	}

	@Reference
	private Http _http;

	@Reference
	private SiteNavigationMenuItemService _siteNavigationMenuItemService;

}