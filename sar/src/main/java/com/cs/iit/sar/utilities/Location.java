package com.cs.iit.sar.utilities;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public class Location {

	public static URI getUri(UriInfo uriInfo, String aidStr) {
		UriBuilder uri = uriInfo.getRequestUriBuilder();
		uri.path(aidStr);
		return uri.build();
	}
}
