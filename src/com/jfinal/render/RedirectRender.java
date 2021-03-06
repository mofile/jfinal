/**
 * Copyright (c) 2011-2012, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jfinal.render;

import java.io.IOException;

/**
 * RedirectRender with status: 302 Found.
 */
public class RedirectRender extends Render {
	
	private static final long serialVersionUID = -3120354341585834890L;
	private String url;
	private boolean withQueryString;
	
	public RedirectRender(String url) {
		this.url = url;
		this.withQueryString = false;
	}
	
	public RedirectRender(String url, boolean withQueryString) {
		this.url = url;
		this.withQueryString =  withQueryString;
	}
	
	public void render() {
		if (withQueryString) {
			String queryString = request.getQueryString();
			if (queryString != null)
				url = url + "?" + queryString;
		}
		
		try {
			response.sendRedirect(url);	// always 302
		} catch (IOException e) {
			throw new RenderException(e);
		}
	}
}

