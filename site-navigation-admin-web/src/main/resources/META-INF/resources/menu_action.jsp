<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

SiteNavigationMenu siteNavigationMenu = (SiteNavigationMenu)row.getObject();

PortletURL portletURL = renderResponse.createRenderURL();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= SiteNavigationMenuPermission.contains(permissionChecker, siteNavigationMenu, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editMenuURL">
			<portlet:param name="mvcPath" value="/edit_menu.jsp" />
			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="siteNavigationMenuId" value="<%= String.valueOf(siteNavigationMenu.getSiteNavigationMenuId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editMenuURL %>"
		/>
	</c:if>

	<c:if test="<%= SiteNavigationMenuPermission.contains(permissionChecker, siteNavigationMenu, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= SiteNavigationMenu.class.getName() %>"
			modelResourceDescription="<%= siteNavigationMenu.getName() %>"
			resourcePrimKey="<%= String.valueOf(siteNavigationMenu.getSiteNavigationMenuId()) %>"
			var="permissionsMenuURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			message="permissions"
			method="get"
			url="<%= permissionsMenuURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>

	<c:if test="<%= SiteNavigationMenuPermission.contains(permissionChecker, siteNavigationMenu, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/navigation_menu/delete_menu" var="deleteMenuURL">
			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="siteNavigationMenuId" value="<%= String.valueOf(siteNavigationMenu.getSiteNavigationMenuId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete trash="<%= false %>" url="<%= deleteMenuURL %>" />
	</c:if>
</liferay-ui:icon-menu>