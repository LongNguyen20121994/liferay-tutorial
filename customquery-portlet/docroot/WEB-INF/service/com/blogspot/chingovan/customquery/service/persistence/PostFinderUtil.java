/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.blogspot.chingovan.customquery.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author chinv
 */
public class PostFinderUtil {
	public static java.util.List<com.blogspot.chingovan.customquery.model.Post> findByAuthors(
		long[] authorIds, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAuthors(authorIds, begin, end);
	}

	public static java.util.List<com.blogspot.chingovan.customquery.model.Post> findByTitleContentAuthor(
		java.lang.String title, java.lang.String content,
		java.lang.String author, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByTitleContentAuthor(title, content, author, begin, end);
	}

	public static PostFinder getFinder() {
		if (_finder == null) {
			_finder = (PostFinder)PortletBeanLocatorUtil.locate(com.blogspot.chingovan.customquery.service.ClpSerializer.getServletContextName(),
					PostFinder.class.getName());

			ReferenceRegistry.registerReference(PostFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(PostFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PostFinderUtil.class, "_finder");
	}

	private static PostFinder _finder;
}